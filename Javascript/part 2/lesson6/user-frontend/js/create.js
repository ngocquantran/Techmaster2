//     https://provinces.open-api.vn/api/p/
const $addresses = $("#address");
const $createBtn = $("#btn-save");
$createBtn.on("click", async function () {
  try {
    if (
      $("#fullname").val().length == 0 ||
      $("#email").val().length == 0 ||
      $("#phone").val().length == 0 ||
      $("#password").val().length == 0
    ) {
      alert("Bạn cần nhập đầy đủ thông tin");
      return;
    }
    let res = await axios.post("http://localhost:8080/api/v1/users", {
      name: `${$("#fullname").val()}`,
      email: `${$("#email").val()}`,
      phone: `${$("#phone").val()}`,
      address: `${$("#address").val()}`,
      password: `${$("#password").val()}`,
    });

    if (res.data) {
      window.location.href = "/";
    }
  } catch (error) {
    console.log(error);
  }
});

const getProVinces = async () => {
  try {
    let res = await axios.get("https://provinces.open-api.vn/api/p/");
    console.log(res);
    renderProvinces(res.data);
  } catch (error) {
    console.log(error);
  }
};

getProVinces();

function renderProvinces(arr) {
  let html = "";
  arr.forEach((province) => {
    html += `<option value="${province.name}">${province.name}</option>`;
  });
  $addresses.append(html);
}
