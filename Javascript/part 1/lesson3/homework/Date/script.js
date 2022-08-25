// let d = new Date();
// console.log(d.toDateString());
// console.log(d.toString());
// console.log(d.toUTCString());
// console.log(d.toISOString());

// // let d2 = new Date("2022-03-15");
// // console.log(d2);

// console.log(d.getTime());

function is_date(input) {
    if (Object.prototype.toString.call(input) === "[object Date]") {
        return true;
    }
    else return false;
}

console.log(is_date("October 13, 2014 11:13:00"));
console.log(is_date(new Date(86400000)));
console.log(is_date(new Date(99, 5, 24, 11, 33, 30, 0)));
console.log(is_date([1, 2, 4, 0]));

function curday(format) {
    let date = new Date();
    let day = date.getDate();
    let month = date.getMonth();
    let year = date.getFullYear();

    return day + format + month + format + year;
}

console.log(curday("/"));
console.log(curday("-"));


function getDaysInMonth(month, year) {
    return new Date(year, month, 0).getDate();
 
}
console.log(getDaysInMonth(1, 2012));
console.log(getDaysInMonth(2, 2012));
console.log(getDaysInMonth(9, 2012));
console.log(getDaysInMonth(12, 2012));

function month_name(date) {
    let monthName = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
    let month = date.getMonth();
    return monthName[month];
}

console.log(month_name(new Date("10/11/2009")));
console.log(month_name(new Date("11/13/2014")));

function compare_dates(date1, date2) {
    if (Date.parse(date1) == Date.parse(date2)) {
        return "Date1 = Date2";
    } else {
        if (Date.parse(date1) > Date.parse(date2)) { 
          return  "Date1 > Date2";  
        } else {
            return "Date1 < Date2";
        }
    }
}
console.log(
  compare_dates(new Date("11/14/2013 00:00"), new Date("11/14/2013 00:00"))
);
console.log(
  compare_dates(new Date("11/14/2013 00:01"), new Date("11/14/2013 00:00"))
);
console.log(
  compare_dates(new Date("11/14/2013 00:00"), new Date("11/14/2013 00:01"))
);