// Khai báo API URL root
const API_URL = "/api/v1";

// Truy cập vào các thành phần
const addressEl = document.getElementById("address");
const nameEl = document.getElementById("name");
const emailEl = document.getElementById("email");
const phoneEl = document.getElementById("phone");
const passwordEl = document.getElementById("password");

const btnSave = document.getElementById("btn-save");
const btnBack = document.querySelector(".btn-back");

const avatarEl = document.getElementById("avatar");
const avatarPreviewEl = document.getElementById("avatar-preview");

const btnModalImage = document.getElementById("btn-modal-image");
const imageContainerEl = document.querySelector(".image-container");
const paginationContainerEl = document.querySelector(".pagination-container");
const btnChoseImage = document.getElementById("btn-chose-image");
const btnDeleteImage = document.getElementById("btn-delete-image");

// Trigger đến modal chọn ảnh
const modalImage = new bootstrap.Modal(document.getElementById('modal-image'), {
    keyboard: false
})

// Lưu lại id của user
let id = user.id;

// Xử lý nút quay lại
btnBack.addEventListener("click", function () {
    window.location.href = "/";
});

// API lấy danh sách tỉnh - thành phố
async function getProvince() {
    try {
        // Gọi API lấy danh sách tỉnh thành phố
        let res = await axios.get("https://provinces.open-api.vn/api/p/");

        // Render tỉnh thành phố
        renderProvince(res.data);
    } catch (error) {
        console.log(error);
    }
}

function renderProvince(arr) {
    for (let i = 0; i < arr.length; i++) {
        const p = arr[i];
        addressEl.innerHTML += `<option value="${p.name}">${p.name}</option>`
    }
}

// *********** Upload file API ***********
const uploadFileAPI = (file) => {
    const formData = new FormData();
    formData.append("file", file);

    return axios.post(`${API_URL}/users/${id}/upload-file`, formData);
};

// *********** Xử lý khi upload file ***********
avatarEl.addEventListener("change", async function (event) {
    try {
        // Lấy file cần upload
        let file = event.target.files[0];

        // Gọi API để upload file
        let res = await uploadFileAPI(file);

        // Thêm ảnh mới upload vào danh sách ảnh của user
        imagesOfUser.unshift(res.data);

        // Render lại giao diện hiển thị ảnh
        renderImageAndPagination(imagesOfUser)
    } catch (error) {
        console.log(error);
    }
});

// *********** Lấy danh sách file của user ***********
const getImage = async () => {
    try {
        let res = await axios.get(`${API_URL}/users/${id}/files`);
        
        // Lưu lại danh sách ảnh của user
        imagesOfUser = res.data;

        // Render image + pagination
        renderImageAndPagination(imagesOfUser);
    } catch (error) {
        console.log(error);
    }
};

// *********** Hiển thị danh sách hình ảnh + phân trang ***********
const renderImageAndPagination = (imagesOfUser) => {
    $('.pagination-container').pagination({
        dataSource: imagesOfUser,
        pageSize: 12,
        callback: function(data) {
            renderImage(data)
        }
    })
}

// *********** Hiển thị danh sách hình ảnh ***********
const renderImage = (arr) => {
    imageContainerEl.innerHTML = "";
    for (let i = 0; i < arr.length; i++) {
        const f = arr[i];
        imageContainerEl.innerHTML += `
            <div class="image-item" onclick="choseImage(this)">
                <img src="${f}" alt="${f}" data-src="${f}">
            </div>
        `
    }
}

// Khi mở modal chọn ảnh thì gọi API để lấy thông tin ảnh và hiển thị
btnModalImage.addEventListener("click", function() {
    getImage();
});

// *********** Xử lý phần chọn ảnh ***********
const choseImage = image => {
    // Lấy danh sách ảnh
    const imagesEl = document.querySelectorAll(".image-item");

    // Xóa hết class "border-primary", "selected" trên tất cả các ảnh
    Array.from(imagesEl).map(el => el.classList.remove("border-primary", "selected"))

    // Thêm class "border-primary", "selected" vào ảnh được chọn
    image.classList.add("border-primary", "selected")

    // Bỏ disabled nút "Chọn ảnh"
    btnChoseImage.disabled = false;

    // Bỏ disabled nút "Xóa ảnh"
    btnDeleteImage.disabled = false;
}

// *********** Xử lý phần chọn ảnh để thay đổi avatar ***********
btnChoseImage.addEventListener("click", async function() {
    try {
        // Lấy ra ảnh đang được chọn
        const imageSelected = document.querySelector(".selected img");

        // Lấy ra đường dẫn ảnh của ảnh đang chọn
        const srcOfImageSelected = imageSelected.dataset.src;

        // Gọi API set lại ảnh cho user
        await axios.put(`${API_URL}/users/${id}/update-avatar`, {
            avatar : srcOfImageSelected
        });

        // Update lại ảnh cho avatar
        avatarPreviewEl.src = `http://localhost:8080${srcOfImageSelected}`

        // Đóng modal lại
        modalImage.hide();
    } catch (error) {
        console.log(error);
    }
})

// *********** Xử lý xóa ảnh ***********
btnDeleteImage.addEventListener("click", async function() {
    try {
        // Lấy ra ảnh đang được chọn
        const imageSelected = document.querySelector(".selected img");

        // Lấy ra đường dẫn ảnh của ảnh đang chọn
        const srcOfImageSelected = imageSelected.src;

        // Gọi API set lại ảnh cho user
        await axios.delete(srcOfImageSelected);

        // Xóa ảnh trong mảng ban đầu
        imagesOfUser = imagesOfUser.filter(img => img != srcOfImageSelected)
        console.log(imagesOfUser)

        // Render lại image + pagination
        renderImageAndPagination(imagesOfUser);
    } catch (error) {
        console.log(error);
    }
})

// Chạy lấy tỉnh thành phố trước, sau đó mới lấy thông tin user
const init = async () => {
    await getProvince();
    addressEl.value = user.address;
};

init();