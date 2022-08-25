// const tasks = [
//   {
//     id: 1,
//     text: "Buy a new gaming laptop",
//   },
//   {
//     id: 2,
//     text: "Compelte previous homework",
//   },
//   {
//     id: 3,
//     text: "Learning javaScript DOM",
//   },
//   {
//     id: 4,
//     text: "Create beautiful Todo App",
//   },
//   {
//     id: 5,
//     text: "Complete all task",
//   },
// ];

const tasks = load();

function load() {
    const data = localStorage.getItem("tasks");

    if (data) {
        return JSON.parse(data);
    } else { 
        return [];

    }
}

function save() {
    localStorage.setItem("tasks", JSON.stringify(tasks));
}

function getNewId() {
    let isContinue = true;
    let id=-1;
    while (isContinue) {
        id = Math.floor(Math.random() * 100 + 1);
        let index = tasks.findIndex(function (task) {
            return (task.id == id);
        });
        if (index < 0) {
            isContinue = false;
        }
    }
    
    return id;
}

function createNewTask(text) {
    tasks.push({
        id: getNewId(),
        text: text,
    })

    return tasks[tasks.length - 1];
}

function addNewTask(e) {
    e.preventDefault();

    const $input = $(".input-task");
    const text = $input.val().trim();

    if (text.length == 0) return;

    const newTask = createNewTask(text);
    const newItem = createItem(newTask);

    $(".task-list").append(newItem);

    $input.val("");
    save();
    getTotalTask();

}

function createItem(task) {
    const $template = $(
      document.querySelector(".task-item-template").content.firstElementChild
    ).clone();

    $template.find(".task-name").text(task.text);
    $template.find(".clear-btn").on('click', function () {
        deleteTask(task.id);
        $template.remove();
        getTotalTask();
    })
    return $template;
}

function createList() {
    const list = tasks.map(function (task) {
        return createItem(task);
    })
    return list;
}

function render() {
    const $list = $('.task-list');
    const list = createList();
    $list.append(...list);
    getTotalTask();
}

function deleteTask(id) {
    const index = tasks.findIndex(function (task) {
        return task.id == id;
    })

    if (index >= 0) { 
        tasks.splice(index, 1);

    }

    save();
}

function getTotalTask() {
    const count = tasks.length;
    $(".task-count").html("<b>"+count+"</b>");
}

function clearAll() {
    tasks.length = 0;
    $(".task-list").html("");
    save();
    getTotalTask();
}

$(function () {
    $(".add-btn").on('click', addNewTask);
    $(".clearAll-btn").on('click', clearAll);
    render();
    
})
