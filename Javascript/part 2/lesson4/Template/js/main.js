$(function () {
  getTodos();
  filterByStatus();
  $("#btn-add").on("click", createTodo);
  $("#btn-edit").on("click", updateTitle);
});

const URL_API = "http://localhost:8080/api/v1";
let todos = [];

// Danh sách API
const getTodoAPI = (status) => {
  switch (status) {
    case "all": {
      return axios.get(`${URL_API}/todos`);
    }
    case "unactive": {
      return axios.get(`${URL_API}/todos?status=false`);
    }
    case "active": {
      return axios.get(`${URL_API}/todos?status=true`);
    }
    default: {
      return axios.get(`${URL_API}/todos`);
    }
  }
};

const deleteTodoAPI = (id) => {
  return axios.delete(`${URL_API}/todos/${id}`);
};

const updateTodoAPI = (todo) => {
  return axios.put(`${URL_API}/todos/${todo.id}`, {
    title: todo.title,
    status: todo.status,
  });
};

const createTodoAPI = (title) => {
  return axios.post(`${URL_API}/todos`, {
    title: title,
  });
};

const getTodos = async (status = "") => {
  try {
    let res = await getTodoAPI(status);
    todos = res.data;
    console.log(todos);
    renderTodo(todos);
  } catch (error) {
    console.log(error);
  }
};

function renderTodo(arr) {
  const $todoList = $(".todo-list");
  $todoList.html("");

  if (arr.length == 0) {
    $todoList.text("Không có công việc trong danh sách");
    return;
  }
  let html = "";
  for (let i = 0; i < arr.length; i++) {
    const t = arr[i];
    html += `
            <div class="todo-item ${t.status ? "active-todo" : ""}">
                <div class="todo-item-title">
                    <input 
                        type="checkbox" ${t.status ? "checked" : ""}
                        onclick="toggleStatus('${t.id}')"
                    />
                    <p>${t.title}</p>
                </div>
                <div class="option">
                    <button class="btn btn-update" onclick="showEditForm('${
                      t.id
                    }')">
                        <img src="./img/pencil.svg" alt="icon" />
                    </button>
                    <button class="btn btn-delete" onclick="deleteTodo('${
                      t.id
                    }')">
                        <img src="./img/remove.svg" alt="icon" />
                    </button>
                </div>
            </div>
        `;
  }
  $todoList.append(html);
}

const deleteTodo = async (id) => {
  try {
    let isConfirm = confirm("Bạn có chắc chắn muốn xóa không?");
    if (isConfirm) {
      await deleteTodoAPI(id);
      //  frontend
      todos.forEach(function (todo, index) {
        if (todo.id == id) {
          todos.splice(index, 1);
        }
      });
      renderTodo(todos);
    }
  } catch (error) {
    console.log(error);
  }
};

const toggleStatus = async (id) => {
  try {
    // Lấy ra công việc cần update trong mảng todo
    let todo = todos.find((todo) => todo.id == id);
    // Thay đổi trạng thái công việc
    todo.status = !todo.status;
    let res = updateTodoAPI(todo);

    // todos.forEach(function (todo, index) {
    //   if (todo.id == id) {
    //     todo.status = !todo.status;
    //   }
    // });

    renderTodo(todos);
  } catch (error) {
    console.log(error);
  }
};

function showEditForm(id) {
  $("#btn-add").toggleClass("hidden");
  $("#btn-edit").toggleClass("hidden");
  $("#btn-edit").attr("data-id", id);
}

const updateTitle = async (id) => {
  id = $("#btn-edit").attr("data-id");
  try {
    const $input = $("#todo-input");
    if ($input.val().length == 0) {
      alert("Bạn cần nhập nội dung công việc");
      $("#btn-add").toggleClass("hidden");
      $("#btn-edit").toggleClass("hidden");
      return;
    } else {
      // Lấy ra công việc cần update trong mảng todo
      let todo = todos.find((todo) => todo.id == id);
      todo.title = $input.val();

      let res = updateTodoAPI(todo);

      renderTodo(todos);
      $("#btn-add").toggleClass("hidden");
      $("#btn-edit").toggleClass("hidden");
      $input.val("");
    }
  } catch (error) {
    console.log(error);
  }
};

const createTodo = async () => {
  try {
    const $input = $("#todo-input");
    if ($input.val().length == 0) {
      alert("Bạn cần nhập nội dung công việc");
      return;
    }
    let res = await createTodoAPI($input.val());
    todos.push(res.data);
    renderTodo(todos);
  } catch (error) {
    console.log(error);
  }
};

function filterByStatus() {
  const $todoOptionItem = $(".todo-option-item input");
  $todoOptionItem.each(function (index, input) {
    $(input).change(function () {
      let status = $(input).val();
      getTodos(status);
    });
  });
}
