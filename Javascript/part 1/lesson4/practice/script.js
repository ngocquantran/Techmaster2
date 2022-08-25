// function getMaxMin(arr) {
//     let max = arr[0];
//     let min = arr[0];
//     let indexMax = 0;
//     let indexMin = 0;
//     for (let i = 0; i < arr.length; i++){
//         if (arr[i] > max) {
//             max = arr[i];
//             indexMax = i;
//         }
//         if (arr[i] < min) {
//             min = arr[i];
//             indexMin = i;
//         }
//     }
//     if (indexMax > indexMin) {
// //         return [min, max];
// //     } else {
// //         return [max, min];
// // //     }
// // // }

// // // let arr = [9, 5, 4, 6, 8];
// // // console.log(getMaxMin(arr));


// // // function societyName(names) {
// // //     let copyName = names.sort();
// // //     let resultName = "";
// // //     for (let i of names) {
// // //         resultName += i[0];
// // //     }
// // //     console.log(resultName);
// // // }

// // // societyName(["Adam", "Sarah", "Malcolm"]);

// // // function chatroomStatus(users) {
// // //     let n = users.length;
// // //     switch (n) {
// // //         case 0:
// // //             console.log("No one online");
// // //             break;
// // //         case 1:
// // //             console.log(users[0], " online");
// // //             break;
// // //         case 2:
// // //             console.log(`${users[0]} and ${users[1]} online`);
// // //             break;
// // //         default:
// // //             console.log(`${users[0]}, ${users[1]} and ${users.length - 2} more online`);
// // //             break;      
// // //     }
// // // }

// // // chatroomStatus([]) // result "No one online"
// // // chatroomStatus(["paRIE"]) // result "paRIE online"
// // // chatroomStatus(["s234f", "mailbox2"]) // result "s234f and mailbox2 online"
// // // chatroomStatus(["pap_ier44", "townieBOY", "panda321", "motor_bike5", "sandwichmaker833", "violinist91"]);


// // // function secondLargest(numbers) {
// // //     let copyNumbers = Object.assign([], numbers);
// // //     let n = copyNumbers.length;
// // //     let secondMax;
// // //     for (let i = n - 1; i >= 0; i--){
// // //         if (copyNumbers[i] < copyNumbers[n - 1]) {
// // //             secondMax = copyNumbers[i];
// // //             break;
// // //         }
// // //     }
// // //     console.log(secondMax);
// // // }

// // // secondLargest([10, 50, 40, 30, 20, 40, 50]);



// // // const arrInput = [
// // //     ["m", "u", "b"],
// // //     ["a", "s", "h"],
// // //     ["i", "r", "1"]
// // // ];

// // // // Chỉ mục tương ứng là
// // // let index = [
// // //     [1, 2, 3],
// // //     [4, 5, 6],
// // //     [7, 8, 9],
// // // ];

// // // const idx = [1, 3, 5, 8]

// // // function indByIndex(arr, idx) {
// // //     let arrays=[];
// // //     for (let i = 0; i < arr.length; i++){
// // //         for (let j = 0; j < arr[0].length; j++){
// // //             arrays.push(arr[i][j]);
// // //         }
// // //     }
// // //     console.log(arrays);
// // //     let result="";
// // //     for (let i of idx) {
// // //         result += arrays[i-1];
// // //     }
// // //     console.log(result);

// // // }

// // // indByIndex(arrInput, idx);


// // // function spelling(word) {
// // //     let result = [];
// // //     let spell = "";
// // //     for (let i = 0; i < word.length; i++){
// // //         spell += word[i];
// // //         result.push(spell);
// // //     }
// // //     console.log(result);
// // // }

// // // spelling("happy");


// function fruitSalad(fruits) {
//     let result = [];
//     for (let i of fruits) {
//         let half = Math.floor(i.length / 2);
//         result.push(i.slice(0, half), i.slice(half));
//         // let firstHalf = "";
//         // let lastHalf = "";
//         // for (let j = 0; j <= half - 1; j++){
//         //     firstHalf += i[j];
//         // }
//         // for (let j = half; j <i.length; j++) {
//         //   lastHalf += i[j];
//         // }
//         // result.push(firstHalf);
//         // result.push(lastHalf);
//     }

//     result = result.sort();
//     console.log(result.join());
// }

// fruitSalad(["apple", "pear", "grapes"]);

// // // function perimeter(coordinates) {
// // //     let a = coordinates[0];
// // //     let b = coordinates[1];
// // //     let c = coordinates[2];
// // //     console.log(distance(a, b) + distance(a, c) + distance(b, c));

// // // }

// // // function distance(a, b) {
// // //     return Math.sqrt((a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2);
// // // }

// // // perimeter([
// // //   [15, 7],
// // //   [5, 22],
// // //   [11, 1],
// // // ]);


// // function getWin(time) {
// //     let result = [0,0];
// //     if (time[0] == "H") {
// //         if (time[1] == "P") {
// //             result[1]++;
// //         } else {
// //             result[0]++;
// //         }
// //     }
// //     if (time[0] == "P") {
// //       if (time[1] == "S") {
// //         result[1]++;
// //       } else {
// //         result[0]++;
// //       }
// //     }
// //     if (time[0] == "S") {
// //       if (time[1] == "H") {
// //         result[1]++;
// //       } else {
// //         result[0]++;
// //       }
// //     }
// //     return result;
// // }

// // function calculateScore(play) {
// //     let ti = 0;
// //     let teo = 0;
// //     for (let i of play) {
// //         let result = getWin(i);
// //         // console.log(result);
// //         ti += result[0];
// //         // console.log("Điểm Tí: ", ti);
// //         teo += result[1];
// //         // console.log("Điểm Tèo: ", teo);
// //     }

// //     if (ti == teo) {
// //         console.log("tie");
// //     } else if (ti > teo) {
// //         console.log("Tí");
// //     } else {
// //         console.log("Tèo")
// //     }
// // }

// // calculateScore([
// //   ["H", "P"],
// //   ["H", "S"],
// //   ["S", "P"],
// // ]);


// // const order = [
// //   { product: "Milk", quantity: 1, price: 1.5 },
// //   { product: "Eggs", quantity: 12, price: 0.1 },
// //   { product: "Bread", quantity: 2, price: 1.6 },
// //   { product: "Cheese", quantity: 1, price: 4.5 },
// // ];

// // function getTotalPrice(order) {
// //     let total = 0;
// //     for (let i of order) {
// //         total += i["price"]*i["quantity"];
// //     }
// //     console.log(total);
// // }

// // getTotalPrice(order);

// function getAvg(arr) {
//     if (arr.length == 0) {
//         return 0;
//     } else {
//         let sum = 0;
//         for (let i of arr) {
//             sum += i;
//         }
//         return sum / (arr.length);
//     }
// }  

// const arr = [
//     { name: "John", notes: [3, 4] },
//     { name: "Ben", notes: [1, 2, 3, 4] },
//     { name: "Phoebe", notes: [] },
// ];

// function calcAvgNotes(arr) {
//     let result = [];
//     for (let i of arr) {
//         let obj = {
//             name: i["name"],
//             avg: getAvg(i["notes"])
//         };
//         result.push(obj);
//     }
//     console.log(result);
// }

// calcAvgNotes(arr);

// let ar1 = [0, 1, 2, 3];
// let ar2 = [4, 5, 6];
// let ar3 = [7, 8, 9];
// let totalAr = ar1.concat(ar2, ar3);
// for (let i of totalAr) { 
//     console.log(i);
// }
// let str = totalAr.join("");
// console.log(str);

// totalAr.copyWithin(8, 0, 3);
// console.log(totalAr.join(""));

let nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];
// let result = nums.filter(checkEven);
console.log(nums);
let copy=nums.map(function (value,index) {
    return value*2;
});
console.log(copy);





