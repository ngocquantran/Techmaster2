// function findBMI(w, h) {
//     return w / (h ** 2);
// }

function inputNumber(number, action) {
    while (isNaN(number)) {
        number = prompt(action);
        if (isNaN(number)) {
            console.log("Bạn cần nhập số");
        }
        if (number < 0) {
            console.log("Vui lòng nhập giá trị > 0"); 
            number = NaN;
        }
    }
    return number;
}

// let w, h;

// w = inputNumber(w, "Nhập cân nặng");
// console.log("Cân nặng: ",w);

// h = inputNumber(h, "Nhập chiều cao");
// console.log("Chiều cao: ", h);

// let result = findBMI(w, h);
// console.log("BMI = ", result.toFixed(2));

// if (result > 40) {
//   console.log("Béo phì độ III");
// } else if (result > 35) {
//   console.log("Béo phì độ II");
// } else if (result > 30) {
//   console.log("Béo phì độ I");
// } else if (result > 25) {
//   console.log("Hơi béo");
// } else if (result > 18.5) {
//   console.log("Bình thường");
// } else if (result > 17.5) {
//   console.log("Gầy độ I");
// } else if (result > 16) {
//   console.log("Gầy độ II");
// } else {
//     console.log("Gầy độ III");
// }

// let a, b, c;

// a = inputNumber(a, "Nhập số thứ nhất");
// console.log("Số thứ nhất: ", a);
// b = inputNumber(b, "Nhập số thứ hai");
// console.log("Số thứ hai: ", b);
// c = inputNumber(c, "Nhập số thứ ba");
// console.log("Số thứ ba: ", c);

// let max = a;

// if (b >= max) {
//   max = b;
// }
// if (c >= max) {
//   max = c;
// }

// console.log("Số lớn nhất là", max);


// function isLeafYear(y) {
//     if (y % 4 == 0) {
//         return y % 100 != 0;
//     } else {
//         return false;
//     }
// }

// function isLeafYear2(y) {
//     return y % 4 == 0 && y % 100 != 0;
// }

// console.log(isLeafYear(4000));
// console.log(isLeafYear(20));
// console.log(isLeafYear(120));


// console.log(isLeafYear2(4000));
// console.log(isLeafYear2(20));
// console.log(isLeafYear2(4));

// for (let i = 1; i <= 10; i++) {
//     if (i % 2 == 0) console.log(i, "số chẵn");
//     else console.log(i, "số lẻ");
    
// }

// for (let i = 1; i <= 15; i++) {
//     if (i % 3 == 0 && i % 5 == 0) {
//       console.log(i, "FizzBuzz");
//     } else if (i % 3 == 0) {
//       console.log(i, "Fizz");
//     } else if (i % 5 == 0) {
//       console.log(i, "Buzz");
//     } else {
//       console.log(i);
//     }
// }

// function isPrime(number) {
//     if (number <= 1) {
//         console.log(number," không phải số nguyên tố");
//     }
//     else {
//         let count = 0;
//         for (let i = 2; i < number; i++){
//             if (number % i == 0) {
//                 count++;
//                 break;
//             }
//         }
//         if (count) {
//            console.log(number," không là số nguyên tố ");
//         } else {
//             console.log(number, " là số nguyên tố ");
//         }
//     }

// }

// isPrime(0);
// isPrime(1);
// isPrime(2);
// isPrime(3);
// isPrime(4);
// isPrime(5);

function print(number) {
    let last = number % 10;
    let isContinue = true;
    while (isContinue) {
        number = number / 10;
        if (number < 10) {
            isContinue = false;
        }
    }
    console.log(Math.floor(number),last.toFixed(0));
}

// print(1234);
// print(2345);
// print(34);

// print(868674);
// print(5738595);

function groupName(name) {
    let nameCheck = name.trim();
    let groupName = nameCheck.charAt(0);
    for (let i = 1; i < nameCheck.length; i++){
        if (nameCheck.charAt(i - 1) == " ") {
            groupName += nameCheck.charAt(i);
        }
    }
    console.log(groupName);
}

function countLetter(str) {
    const letters = new Array(123);
    for (let i = 0; i < letters.length; i++){
        letters[i] = 0;
    }
    for (let i = 0; i < str.length; i++){
        if (str[i] != " ") {
            letters[str.charCodeAt(i)]++;
         }  
    }
    let max = letters[0];
    let index;
    for (let i = 0; i < letters.length; i++){
        if (letters[i] >= max) { 
            max = letters[i];
            index = i;
        }
    }
  
    let char = String.fromCharCode(index);
    console.log(char);
}
countLetter("This is a common interview question");





