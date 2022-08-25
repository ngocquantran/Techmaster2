const heading = document.getElementById("heading");
console.log(heading);

const para2 = document.querySelector(".para");
console.log(para2);

const ul2 = document.querySelector("body > ul");
console.log(ul2);

const ul1 = document.querySelector(".box ul");
console.log(ul1);

const para = document.querySelectorAll("p");
console.log(para);


// xử lý dạng nodeList
// for (let i = 0; i < para.length; i++){
//     para[i].style.color = "blue";
//     para[i].style.backgroundColor = "yellow";
// }

//Xử lý theo Array

Array.from(para).map(e => {
    e.style.color = "red";
    e.style.backgroundColor = "blue";
})

const newA = document.createElement("a");
newA.innerText = "Google.com.vn";
newA.href = "https://www.google.com.vn/";

document.body.replaceChild(newA, para2);
