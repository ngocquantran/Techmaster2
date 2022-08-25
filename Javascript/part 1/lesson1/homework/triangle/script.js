function findArea(a, b, c) {
    let p = (a + b + c) / 2;
    return Math.sqrt(p * (p - a) * (p - b) * (p - c));
}

let a, b, c;

function inputNumber(number, action) {
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

a = parseFloat(inputNumber(a, "Nhập kích thước cạnh thứ nhất"));
console.log("Kích thước cạnh 1: ", a);

b = parseFloat(inputNumber(b, "Nhập kích thước cạnh thứ hai"));
console.log("Kích thước cạnh 2: ", b);

c = parseFloat(inputNumber(c, "Nhập kích thước cạnh thứ ba"));
console.log("Kích thước cạnh 3: ", c);

let isTriangle = a + b > c && a + c > b && b + c > a;

if (isTriangle) {
    let result = findArea(a, b, c);
    console.log("Diện tích tam giác", result.toFixed(2));
} else { 
    console.log("Ba kích thước trên không thỏa mãn điều kiện tạo thành tam giác");
}
