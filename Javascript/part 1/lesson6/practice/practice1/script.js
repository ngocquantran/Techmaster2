const tasks = [
    {
        id: 1,
        text: "Học JQuery",
        completed: false,
    },
    {
        id: 2,
        text: "Học Javacore",
        completed: true,
    },
    {
        id: 3,
        text: "Học Database",
        completed: true,
    }
]

function createTask(task) {
    //id, text, completed
    const $li = $(`<li>${task.text}</li>`);

    const $btn = $('<button>Done</button>');

    $btn.on('click', function () {
        // chuyển task có id tương ứng thành completed: true
        // kích hoạt lại sự kiện để render lại trang

    })

    $btn.appendTo($li);
    return $li

}

function createList(tasks) {
    const list = [];
    for (let i = 0; i < tasks.length; i++){
        const $li = createTask[i];
        list.push($li);
    }

    return list;
}

$(function () {
    const $list = $('task-list');

    const list = createList(tasks);

    $.each(list, function (index,$item) {
        $item.appendTo($list);
    })
})







// $(function () {
//     const $username = $('.username');

//     $username.on('change', function (e) {
//         const value = $username.val().trim();

//         if (value.length < 6) {
//             $username.addClass("invalid");
//         } else {
//             $username.removeClass("invalid");
//         }
//     })
// })