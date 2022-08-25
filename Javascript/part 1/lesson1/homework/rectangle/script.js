function findArea(a, b) {
    return a * b;
}

let a;
let b;

function inputNumber(number,action) {
    while (isNaN(number)) {
        number = prompt(action);
        if (isNaN(number)) {
          console.log("Bạn cần nhập số");
        }
        if (number <= 0) {
            console.log("Vui lòng nhập giá trị > 0");
            number = NaN;
        }
    }
    return number;
}

a = inputNumber(a, "Nhập kích thước cạnh thứ nhất");
console.log(`Cạnh 1: ${a}`);
b = inputNumber(b, "Nhập kích thước cạnh thứ hai");
console.log(`Cạnh 2: ${b}`);

let result = findArea(a, b);
console.log(`Diện tích hình chữ nhật: ${result}`);



