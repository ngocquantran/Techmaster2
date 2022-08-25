$(function () {
  chooseImage();
  switchChangeOption();
});

function chooseImage() {
  const $imageInput = $(".update input");
  $imageInput.change(function () {
    console.log($imageInput.val());
    const reader = new FileReader();
    reader.addEventListener("load", () => {
      let uploaded_image = reader.result;
      $(".info-avatar img").attr("src", `${uploaded_image}`);
    });
    reader.readAsDataURL(this.files[0]);
  });
}

function switchChangeOption() {
  const $options = $(".change-option .option");
    $options.each((index, option) => {
        $(option).on("click", function () {
            $options.each((index, op) => {
                $(op).removeClass("on");
            });
            $(this).addClass("on");
            switch ($(this).text()) {
                case "Thông tin chung":
                    $('.user-info').css({
                        display: "block",
                    });
                    $(".user-pass").css({
                        "display": "none",
                    });
                    break;
                case "Mật khẩu":
                    $('.user-info').css({
                        "display": "none",
                    });
                    $(".user-pass").css({
                        display: "block",
                    });
                    break;
            }
       })
   })
}
