function compoundInterest(P, r, n, t) {
    return P * (1 + r / n) ** (n * t);
}

let P, r, n, t;

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

P = inputNumber(P, "Nhập số tiền gốc ban đầu");
console.log("Số tiền gốc ban đầu: ", P);

r = inputNumber(r, "Nhập lãi suất hàng năm");
console.log("Lãi suất hàng năm: ", r);

n = inputNumber(n, "Nhập số lần ghép lãi 1 năm");
console.log("Số lần ghép lãi 1 năm: ", n);

t = inputNumber(t, "Nhập số năm gửi ngân hàng");
console.log("Số năm gửi ngân hàng: ", t);

let result = compoundInterest(P, r, n, t);
console.log("Tiền lãi: ", result.toFixed(0));