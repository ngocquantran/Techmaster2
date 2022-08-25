

let users = [];

const URL_API = "http://localhost:8080/api/v1";
const $userRow = $(".table.table-hover tbody");

const getUsersAPI = () => {
  return axios.get(`${URL_API}/users`);
};

const getSearchUsersAPI = (name) => {
  return axios.get(`${URL_API}/users/search?name=${name}`);
};

const getDeleteAPI = (id) => {
  return axios.delete(`${URL_API}/users/${id}`);
};

async function getAllUsers() {
  try {
    let res = await getUsersAPI();

    users = res.data;

    renderUsers(users);
  } catch (error) {
    console.log(error);
  }
}

getAllUsers();

function renderUsers(arr) {
  $userRow.html("");
  let html = "";
  for (let i = 0; i < arr.length; i++) {
    let user = arr[i];
    html += ` <tr>
                                <td>${i + 1}</td>
                                <td>${user.name}</td>
                                <td>${user.email}</td>
                                <td>${user.phone}</td>
                                <td>${user.address}</td>
                                <td>
                                    <a href="./detail.html?id=${
                                      user.id
                                    }" class="btn btn-success">Xem chi tiết</a>
                                    <button class="btn btn-danger" onclick="deleteUser(${
                                      user.id
                                    })">Xóa</button>
                                </td>
                            </tr>`;
  }

  $userRow.html(html);
}

$("#search").on("keyup", function (e) {
  if (e.keyCode == 13) {
    console.log($(this).val());
    if ($(this).val().length == 0) {
      getAllUsers();
    } else {
      searchUsersByName($(this).val());
    }
  }
});

async function searchUsersByName(name) {
  try {
    let res = await getSearchUsersAPI(name);
    renderUsers(res.data);
  } catch (error) {
    console.log(error);
  }
}

async function deleteUser(id) {
  try {
    let warn = confirm("Bạn có chắc chắn muốn xóa?");
    if (warn) {
      await getDeleteAPI(id);
      for (let i = 0; i < users.length; i++) {
        if (users[i].id == id) {
          users.splice(i, 1);
        }
      }
      renderUsers(users);
    } else {
      return;
    }
  } catch (error) {
    console.log(error);
  }
}
