$(function () {
    doTask1("Đi làm", function () {
        doTask2("Nghỉ trưa", function () {
            doTask3("Đi nhậu", function () {
                finish();
            })
        })
    })
});

function doTask1(taskName, callback) {
  console.log("Bắt đầu công việc hàng ngày");
  console.log(`Thực hiện công việc ${taskName}`);
  setTimeout(function () {
    console.log(`Thực hiện xong công việc ${taskName}`);
    callback();
  }, 4000);
}

function doTask2(taskName, callback) {

  console.log(`Thực hiện công việc ${taskName}`);
  setTimeout(function () {
    console.log(`Thực hiện xong công việc ${taskName}`);
    callback();
  }, 2000);
}

function doTask3(taskName, callback) {

  console.log(`Thực hiện công việc ${taskName}`);
  setTimeout(function () {
    console.log(`Thực hiện xong công việc ${taskName}`);
    callback();
  }, 3000);
}

function finish(){
    console.log("Kết thúc công việc");
}
