let users = [];


function getRandomId() {                                        //Tạo random id cho học viên mới

  let id;
  let isContinue = true;
  while (isContinue) {
    id = Math.floor(Math.random() * 10000)+1;
    
    let isId=users.findIndex(function (user) {                  //Kiểm tra id đã xuất hiện trong bảng user chưa
      return user.id == id;
    })
    if (isId < 0) {
      isContinue = false;
    }
  }
  return id;
}


function createUserTemplate(user) {
  const $template = $(
    document.querySelector(".user-template").content.firstElementChild
  ).clone();

  $template.find(".id").text(user.id);
  $template.find(".name").text(user.fullName);
  $template.find(".gender").text(user.gender);
  $template.find(".age").text(user.age);
  $template.find(".email").text(user.email);
  $template.find(".phone").text(user.phone);

  $template.data(user);

  return $template;
}

function createUserList() {
  const list = users.map(function (user) {
    return createUserTemplate(user);

  });
  return list;
}

// function render() {  // Không dùng - đổi sang pagination
//   const $list = $(".user-list");
//   const list = createUserList();
//   $list.append(list);
// }

function getUserInput() {                             // Lấy các giá trị hiện có trong bản input thông tin học viên
  const name = $(".name-input").val();
  
  let gender;
  if (document.querySelector("#male").checked) {
    gender = $("#male").val();
  }
  if (document.querySelector("#female").checked) {
    gender = $("#female").val();
  }

  const age = $(".age-select").val(); 
  
  const email = $(".email-input").val();

  const phone = $(".phone-input").val();
  
  return {
    // id: id,
    fullName: name,
    gender: gender,
    age: age,
    email: email,
    phone: phone,
  };

}

function getAddingUser() {                           // Ghép id mới để tạo học viên mới
  let addingUser = getUserInput();
  let id = getRandomId();
  addingUser.id = id;
  return addingUser;
}

function removeInputValue() {                        // Xóa dữ liệu hiện có trong bảng input khi thoát bảng
   $(".name-input").val('');
   
  document.querySelector("#male").checked = false;
  document.querySelector("#female").checked = false;

   $(".age-select").val('');

   $(".email-input").val('');

   $(".phone-input").val('');
   
}

function handleFormAdd() {                        // Xử lý add học viên khi đồng ý add
  const newUser = getAddingUser();

  fetch("http://localhost:3000/users", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(newUser),
  })
    .then(function (response) {
      return response.json();
    })
    .then((data) => {
      console.log("Success:", data);
      users.push(newUser);                         // push data nhận về vào bảng Users chung
      // render();
    })
    .catch((error) => {
      console.error("Error:", error);
    });

}

function getCurrentCheckedUser() {                 // Lấy thông tin các user đang được chọn -> Kết quả trả về mảng
 
  let checkedList = [];

  const userslist = document.querySelectorAll(".user-row");
  
  userslist.forEach(function (user) {
    if (user.querySelector("input").checked) {
      checkedList.push(user.querySelector(".id").innerText);
    }
  })
  // console.log(checkedList);
  return checkedList;

}

function handleDeleteForm() {                      // Xử lý khi đồng ý xóa học viên
  const checkedList = getCurrentCheckedUser();
  if (checkedList.length == 0) {
    alert("Chưa chọn học viên");
    return;
  }

  let isSure = confirm("Bạn chắc chắn muốn xóa?");
  if (isSure) {
    checkedList.forEach(function (id) {
      fetch(`http://localhost:3000/users/${id}`, {
        method: "DELETE",
      })
        .then(function (response) {
          return response.json();
        })
        .then((data) => {
          console.log("Success:", data);
          // render();
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    });
  }

  
}

function showReviseBox() {                        // Hiện bảng sửa thông tin học viên được chọn
  //Lấy ID học viên được chọn
  const checkedId = getCurrentCheckedUser();

  if (checkedId.length == 0) {
    alert("Chưa chọn học viên");
    return;
  }
  if (checkedId.length > 1) {
    alert("Vui lòng chỉ chọn 1 học viên cho mỗi lần chỉnh sửa");
    return;
  }

  $(".info-input").removeClass("hidden");
  $(".continue-revise").removeClass("hidden"); //Hiện nút bấm revise

  let currentUser = getUserById(checkedId[0])[0]; // Lấy thông tin học viên từ ID
  // console.log(currentUser);

  // Hiện thông tin học viên muốn chỉnh sửa trong bảng input

  $(".name-input").val(currentUser.fullName);

  if (currentUser.gender == "Nam") {
    document.querySelector("#male").checked = true;
  }
  if (currentUser.gender == "Nữ") {
    document.querySelector("#female").checked = true;
  }

  $(".age-select").val(currentUser.age);

  $(".email-input").val(currentUser.email);

  $(".phone-input").val(currentUser.phone);

  
}

function handleFormRevise() {                            // Xử lý khi đồng ý sửa học viên
  //Lấy ID học viên được chọn
  const checkedId = getCurrentCheckedUser()[0];
  //Lấy dữ liệu nhập sửa lại
  let userInput = getUserInput();
  userInput.id = checkedId;
  let reviseUser = userInput;
  

  fetch(`http://localhost:3000/users/${checkedId}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(reviseUser),
  })
    .then(function (response) {
      return response.json();
    })
    .then((data) => {
      console.log("Success:", data);
      // render();
    })
    .catch((error) => {
      console.error("Error:", error);
    });

}

function getUserById(id) {                          // Tìm học viên theo ID
  let chosedUser = users.filter(function (user) {
    return user.id == id;
  })
  return chosedUser;
}

function paginate(currentPage,rowsPerPage) {           
  const $listElement = $(".user-list");
  const $pageNumberElement = $(".page-numbers");

  displayList(users, $listElement, rowsPerPage, currentPage);
  setUpPagination(users, $pageNumberElement, rowsPerPage,currentPage);
  
}

function displayList(users, wrapper, rowsPerPage, page) {  //set up hiển thị theo trang, và số dòng 1 trang
  wrapper.html("");
  page--;   // để lấy giá trị start tương ứng do mảng bắt đầu từ 0

  let start = rowsPerPage * page;
  let end = start + rowsPerPage;
  // console.log(start,end)
  let paginatedUsers = users.slice(start, end);
  console.log(paginatedUsers);

  for (let i = 0; i < paginatedUsers.length; i++){
    // console.log(users[i]);
    let userElement = createUserTemplate(paginatedUsers[i]);
    // console.log(userElement.html());
    wrapper.append(userElement);
  }

}

function setUpPagination(users, wrapper, rowsPerPage,currentPage) {   // Tính số trang cần chia
  wrapper.html("");
  let page_count = Math.ceil(users.length / rowsPerPage);
  console.log('page-count: ',page_count);
  for (let i = 1; i <= page_count; i++){
    let button = createPaginateButton(i, users, currentPage, rowsPerPage);
    
    wrapper.append(button);
  }
}


function createPaginateButton(page, users,currentPage,rowsPerPage) {  // Cài đặt chức năng cho từng nút trang
  let button = document.createElement('button');
  button.innerText = page;

  
  if (currentPage == page) {                                          
    $(button).addClass('active');
  }

  $(button).on('click', function () {
    currentPage = page;
    displayList(users, $(".user-list"), rowsPerPage, currentPage);

    let $currentBtn = $('.page-numbers button.active');            // Xóa class active cho trang cũ
    $currentBtn.removeClass('active');

    $(button).addClass("active");                                  // Them class active cho trang mới

  })

  return $(button);
  
}





$(function () {
  
  fetch("http://localhost:3000/users")
    .then(function (response) {
      return response.json();
    })
    .then(function (data) {
      users=users.concat(data);
      // render();
      paginate(1,7);
    });
  
  
  
  $(".info-exit").on('click', function () {  //Tắt bảng nhập thông tin học viên bằng nút X
    $(".info-input").addClass("hidden");
    removeInputValue();                      //Xóa hết dữ liệu hiện tại trong input
    $(".continue").addClass("hidden");
  })
  $(".cancle").on("click", function () {   //Tắt bảng nhập thông tin học viên bằng nút Cancel
    $(".info-input").addClass("hidden");
    removeInputValue();
    $(".continue").addClass("hidden");
  });

  $(".continue-add").on('click', function () {  // Đồng ý thêm học viên
    handleFormAdd();
    $(".continue").addClass("hidden");
  });

  $(".continue-revise").on("click", function () {  //Đồng ý sửa học viên
    handleFormRevise();
    $(".revise").addClass("hidden");
  });

  $(".add-btn").on('click', function () {        // Chọn tính năng thêm học viên
    $(".info-input").removeClass("hidden");
    $(".continue-add").removeClass("hidden");
    
  })

  $(".clear-btn").on('click', handleDeleteForm);  // Chọn tính năng xóa học viên

  $(".revise-btn").on("click", showReviseBox);    // Chọn tính năng sửa học viên

  
  
  
  



})





