const users = [
  {
    id: 1,
    fullName: "Ba Nguyen",
    gender: "Male",
    age: 29,
    email: "ba@techmaster.vn",
    phone: "0965338283",
  },
  {
    id: 2,
    fullName: "Nam Nguyen",
    gender: "Male",
    age: 28,
    email: "nam@techmaster.vn",
    phone: "0965338568",
  },
  {
    id: 3,
    fullName: "Lan Nguyen",
    gender: "Female",
    age: 27,
    email: "lan@techmaster.vn",
    phone: "0965123283",
  },
  {
    id: 4,
    fullName: "Van Nguyen",
    gender: "Female",
    age: 26,
    email: "van@techmaster.vn",
    phone: "0958968283",
  },
  {
    id: 5,
    fullName: "Hoang Nguyen",
    gender: "Male",
    age: 25,
    email: "hoang@techmaster.vn",
    phone: "0965587283",
  },
  {
    id: 6,
    fullName: "Thuan Nguyen",
    gender: "Male",
    age: 24,
    email: "thuan@techmaster.vn",
    phone: "0969512283",
  },
  {
    id: 7,
    fullName: "Nga Nguyen",
    gender: "Female",
    age: 23,
    email: "nga@techmaster.vn",
    phone: "0965958783",
  },
  {
    id: 8,
    fullName: "Ba Nguyen",
    gender: "Male",
    age: 22,
    email: "ba@techmaster.vn",
    phone: "0961563283",
  },
  {
    id: 9,
    fullName: "Huyen Nguyen",
    gender: "Female",
    age: 21,
    email: "huyen@techmaster.vn",
    phone: "0965339635",
  },
];

function createUserTemplate(user) {
  const $template = $(
    document.querySelector(".user-template").content.firstElementChild
  ).clone();

  // const row = document.getElementsByClassName("user-template").rows[0].cells;
  // row[0].text(user.id);
  // row[1].text(user.fullName);
  // row[2].text(user.gender);
  // row[3].text(user.age);
  // row[4].text(user.email);
  // row[5].text(user.phone);

  $template.find(".id").text(user.id);
  $template.find(".name").text(user.fullName);
  $template.find(".gender").text(user.gender);
  $template.find(".age").text(user.age);
  $template.find(".email").text(user.email);
  $template.find(".mobile").text(user.phone);

  return $template;
}

function createUserList() {
  const list = users.map(function (user) {
    return createUserTemplate(user);
  })
  return list;
  
}

function render() {
  const $list = $('.user-table');
  const list = createUserList();
  $list.append(...list);

}

$(function () {
  render();
})

