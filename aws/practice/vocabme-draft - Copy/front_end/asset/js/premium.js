$(function () {
  choosePackage();
});

function choosePackage() {
  const $packages = $(".package-item");

  $packages.each((index, package) => {
    let $btn = $(package).find(".item-choose a");
    $btn.on("click", function () {

      $packages.each((index, p) => {
        $(p).find(".item-choose a").removeClass("active");
      });
      $btn.addClass("active");
      $(".chosed-item").text(
        `Tài khoản học cao cấp PREMIUM ${$(package)
          .find(".item-header h3")
          .text()}`
      );
    });
  });
}

function order() {
    
}
