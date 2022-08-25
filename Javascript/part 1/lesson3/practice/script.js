let myFamily = {
    father: 55,
    mother: 45,
    son: 28,
    daughter: 21
}

function afterYear(family, years) {
    let clone = {}; 
    for (let key in family) { 
        clone[key] = family[key]+ years;
    }
    return clone; 
}
console.log(myFamily);
console.log(afterYear(myFamily, 1))

let order1 = {
    item1: 25,
    item2: 35
}
let order2 = {
  item1: 20,
  item2: 30,
};

function isFreeShip(order) {
    let sum=0;
    for (let item in order) {
        sum += order[item];
    }
    console.log(sum);
    return (sum > 50);
}

console.log(isFreeShip(order1));
console.log(isFreeShip(order2));



function nameValue(name) {
    const scores = {
      A: 100,
      B: 14,
      C: 9,
      D: 28,
      E: 145,
      F: 12,
      G: 3,
      H: 10,
      I: 200,
      J: 100,
      K: 114,
      L: 100,
      M: 25,
      N: 450,
      O: 80,
      P: 2,
      Q: 12,
      R: 400,
      S: 113,
      T: 405,
      U: 11,
      V: 10,
      W: 10,
      X: 3,
      Y: 210,
      Z: 23,
    };
    let sum = 0;
    for (let i = 0; i < name.length; i++) { 
        let c = name[i].toUpperCase();
        sum += scores[c];
    }
    console.log(sum);
    return sum;
}

nameValue("A");
nameValue("B");
nameValue("C");

let hamthu = {
    a: 1,
    b: 2,
    c:3
}

function reverse(object) { 
    let copy = {};
    for (let key in object) {
        let c = object[key];
        copy[c] = key;  
    }
    return copy;
}
console.log(hamthu);
console.log(reverse(hamthu));


const stolen = {
  tv: 30,
  skate: 20,
  stereo: 50,
};

let lost = {};

function totalAmountLost(stolenitems) {
    let sum = 0;
    for (let item in stolenitems) {
        sum += stolenitems[item];
    }
    if (sum == 0) {
        console.log("Lucky you");
    } else {
        console.log(sum);
    }
}

totalAmountLost(stolen);
totalAmountLost(lost);


const GUEST_LIST = {
  Randy: "Germany",
  Karla: "France",
  Wendy: "Japan",
  Norman: "England",
  Sam: "Argentina",
};

function greeting(name) {
    if (GUEST_LIST[name]) {
        console.log(`Hi! I'm ${name}, and I'm from ${GUEST_LIST[name]}.`);
    } else {
        console.log("Hi! I'm a guest.");
    }
}

greeting("Randy");
greeting("Quân");

let oldest={
	Emma: 71,
	Jack: 45,
	Amy: 15,
	Ben: 29
}

function getMax(oldlist) {
    let max = 0;
    let c;
    for (let key in oldlist) {
        if (oldlist[key] >= max) {
            max = oldlist[key];
            c = key;
        }
    }
    console.log(`${c} - ${oldest[c]}`);
}
getMax(oldest);

let text = "tHE fOX iS cOMING fOR tHE cHICKEN";
function reveser(str) {
    // let copy = str;
    
    // for (let i = 0; i < copy.length; i++){
    //     if (copy.charAt(i)==copy.charAt(i).toUpperCase) {
    //         copy.charAt(i)=copy.charAt(i).toLowerCase();
    //     } else {
    //         copy.charAt(i)=copy.charAt(i).toUpperCase();
    //     }
    // }
    
    const words = str.split(" ");
    const reverseword = words.reverse();
    let text = reverseword.join(" ");
    console.log(text)
}

reveser(text);

