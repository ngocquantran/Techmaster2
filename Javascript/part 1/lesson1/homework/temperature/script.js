function C2F(c) {
    return c * 1.8 + 32;
}
let input;

function inputNumber(number, action) {
  while (isNaN(number)) {
    number = prompt(action);
    if (isNaN(number)) {
      console.log("Bạn cần nhập số");
    }
  }
  return number;
}

input=inputNumber(input,"Nhập nhiệt độ (độ C)")

let result = C2F(input);

console.log(`${input} độ C = ${result} độ F`);

