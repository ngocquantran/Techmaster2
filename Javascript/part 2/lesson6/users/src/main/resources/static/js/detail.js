// Lấy thông tin id trên URL
const $addresses = $("#address");
// let params = new URLSearchParams(window.location.search);
let id = user.id;
// let imgs = [];

// Lấy danh sách province -------------------------------------------------------------------
const getProVinces = async () => {
  try {
    let res = await axios.get("https://provinces.open-api.vn/api/p/");
    renderProvinces(res.data);
  } catch (error) {
    console.log(error);
  }
};



function renderProvinces(arr) {
  let html = "";
  arr.forEach((province) => {
    html += `<option value="${province.name}">${province.name}</option>`;
  });
  $addresses.append(html);
}

// Update thông tin user --------------------------------------------------------------------------
async function updateUser() {
  try {
    if ($("#fullname").val().length == 0 || $("#phone").val().length == 0) {
      alert("Bạn cần nhập đủ thông tin");
      return;
    }
    let res = await axios.put(`/api/v1/users/${id}`, {
      name: $("#fullname").val(),
      phone: $("#phone").val(),
      address: $addresses.val(),
    });

    if (res.data) {
      window.location.href = "/";
    }
  } catch (error) {
    console.log(error);
  }
}

$("#btn-save").on("click", updateUser);

// Xử lý password -------------------------------------------------------------------
async function updatePassword() {
  try {
    if (
      $("#old-password").val().length == 0 ||
      $("#new-password").val().length == 0
    ) {
      alert("Bạn cần nhập đủ thông tin");
      return;
    }
    let res = await axios.put(
      `/api/v1/users/${id}/update-password`,
      {
        oldPassword: $("#old-password").val(),
        newPassword: $("#new-password").val(),
      }
    );
    alert("Cập nhật mật khẩu thành công");
    $("#btn-change-password").prev().trigger("click");
  } catch (error) {
    console.log(error);
    alert(error.response.data.message);
  }
}

$("#btn-change-password").on("click", updatePassword);

$("#btn-forgot-password").on("click", resetPassword);

async function resetPassword() {
  try {
    let res = await axios.post(
      `/api/v1/users/${id}/forgot-password`
    );
    alert(`Mật khẩu mới của bạn là ${res.data}`);
  } catch (error) {
    console.log(error);
  }
}

// Lấy user-------------------------------------------------------------------------------------------------------

const getUser = async (id) => {
  try {
    let res = await axios.get(`/api/v1/users/${id}`);

    renderUserDetail(res.data);

    console.log($addresses.val());
  } catch (error) {
    console.log(error);
  }
};

function renderUserDetail(user) {
  $("#fullname").val(user.name);
  $("#email").val(user.email);
  $("#phone").val(user.phone);
  $addresses.val(user.address);
  $("#avatar-preview").attr("src", user.avatar);
}

const init = async () => {
  await getProVinces();

  $addresses.val(user.address);
};

init();

// Hiển thị hình ảnh của User ------------------------------------------------------------

// async function getUserImgs() {
//   try {
//     let res = await axios.get(`/api/v1/users/${id}/files`);
//     imgs = res.data;
//     console.log(imgs);
//     loadPage(imgs);
//     chooseImg();
//   } catch (error) {
//     console.log(error);
//   }
// }

function renderUserImgs(arr) {
  const $imgContainer = $(".image-container");
  $imgContainer.html("");
  let html = "";
  arr.forEach(function (img) {
    html += `<div class="image-item">
                  <img
                    src="/${img}"
                    alt="ảnh"
                  />
                </div>`;
  });
  $imgContainer.append(html);
}

// $("#btn-modal-image").on("click", getUserImgs);

let chosedImg = "";

function chooseImg() {

  const imags = $(".image-item");
  console.log(imags);
  imags.each(function (index, img) {
    $(img).on("click", function () {
      if ($(this).hasClass("border-primary")) {
        $(this).toggleClass("border-primary");
        chosedImg = "";
        console.log(chosedImg);
      } else {
        chosedImg = $(img).find("img").attr("src");
        console.log(chosedImg);
        $(".image-item.border-primary").removeClass("border-primary");
        $(img).addClass("border-primary");
      }
      if (chosedImg.length > 0) {
        $("#btn-delete-image").prop("disabled", false);
        $("#btn-chose-image").prop("disabled", false);
      } else {
        $("#btn-delete-image").prop("disabled", true);
        $("#btn-chose-image").prop("disabled", true);
      }
    });
  });
}

async function deleteImg() {
  try {
    if (chosedImg.length == 0) {
      return;
    }
    let index = chosedImg.lastIndexOf("/");
    let imgId = chosedImg.substring(index + 1);
    console.log(imgId);
    let res = await axios.delete(`/api/v1/users/${id}/files/${imgId}`);
    $(".image-item.border-primary").hide();
    $("#btn-delete-image").prop("disabled", true);
    $("#btn-chose-image").prop("disabled", true);
  } catch (error) {
    console.log(error);
  }
}

$("#btn-delete-image").on("click", deleteImg);

$("#btn-chose-image").on("click", updateAvt);

async function updateAvt() {
  try {
    if (chosedImg.length == 0) {
      return;
    }
    let res = await axios.post(
      `/api/v1/users/${id}/files`,
      chosedImg,
      {
        headers: { "Content-Type": "text/plain" },
      }
    );
    getUser(id);
  } catch (error) {
    console.log(error);
  }
}

async function uploadImg() {
  try {
    const formData = new FormData();
    const imgFile = $("#avatar").prop("files")[0];
    formData.append("file", imgFile);
    let res = await axios.post(
      `/api/v1/users/${id}/upload-file`,
      formData,
      {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      }
    );
    getUserImgs();
  } catch (error) {
    console.log(error);
  }
}

$("#upload").on("click", function () {
  if ($("#avatar").prop("files")[0]) {
    uploadImg();
  } else {
    return;
  }
});


function loadPage(arr) {
  $(".pagination-container").pagination({
    dataSource: arr,
    pageSize: 4,
    callback: function (arr, pagination) {
      renderUserImgs(arr);
    },
  });
}
