const tasks = [
  {
    id: 1,
    text: "Buy a new gaming laptop",
  },
  {
    id: 2,
    text: "Compelte previous homework",
  },
  {
    id: 3,
    text: "Learning javaScript DOM",
  },
  {
    id: 4,
    text: "Create beautiful Todo App",
  },
  {
    id: 5,
    text: "Complete all task",
  },
];

function createTask($template, task) {
    const $clone = $template.clone();
    $clone.find('.task-name').text(task['text']);
    return $clone;
}

function createList($template, tasks) {
    const list = [];
    console.log(tasks)

    for (let i = 0; i < tasks.length; i++){
        const $li = createTask($template, tasks[i]);
        list.push($li);
        console.log($li);
    }
    return list;
}

$(function () {
    const $list = $('.task-list');
    const $template = $(
      document.querySelector(".task-item-template").content.firstElementChild
    );

    const list = createList($template, tasks);


    $.each(list, function (index, $item) {
        $item.appendTo($list);
    });

});