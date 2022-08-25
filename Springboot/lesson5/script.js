$(function () {
    movingInputLabel();
})

function movingInputLabel() {
  const $input = $(".input-moving-lable input");
  const $label = $(".input-moving-lable input + label");
  $input.each(function (index, input) {
    if ($(input).val()) {
      $(input).addClass("focused");
    } else {
      $(input).focus(function () {
        $(input).addClass("focused");
      });
      $(input).focusout(function () {
        if (!$(input).val()) {
          $(input).removeClass("focused");
        }
      });
    }
  });
}