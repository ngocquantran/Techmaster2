const products = [
  {
    name: "Samsung S22 Ultra",
    category: "Điện thoại",
    price: 30000000,
    quantity: 100,
  },
  {
    name: "Dell XPS ",
    category: "Laptop",
    price: 40000000,
    quantity: 29,
  },
  {
    name: "Iphone 13 Promax",
    category: "Điện thoại",
    price: 34000000,
    quantity: 50,
  },
  {
    name: "Tủ lạnh Toshiba",
    category: "Gia dụng",
    price: 8000000,
    quantity: 50,
  },

  {
    name: "Tủ lạnh Samsung",
    category: "Gia dụng",
    price: 12000000,
    quantity: 0,
  },
  {
    name: "Tủ lạnh Nikkei",
    category: "Gia dụng",
    price: 9000000,
    quantity: 29,
  },
  {
    name: "Oppo Reno 7",
    category: "Điện thoại",
    price: 13000000,
    quantity: 29,
  },
  {
    name: "Macbook pro M1 16 inch",
    category: "Laptop",
    price: 50000000,
    quantity: 65,
  },
  {
    name: "Asus Vivobook",
    category: "Laptop",
    price: 25000000,
    quantity: 0,
  },
  {
    name: "Vsmart",
    category: "Điện thoại",
    price: 10000000,
    quantity: 0,
  },
  {
    name: "Máy giặt samsung",
    category: "Gia dụng",
    price: 8000000,
    quantity: 35,
  },
  {
    name: "Lenono thinkpad X1",
    category: "Laptop",
    price: 36000000,
    quantity: 35,
  },
  {
    name: "Dell Precision 5510",
    category: "Laptop",
    price: 38000000,
    quantity: 45,
  },
  {
    name: "Sạc dự phòng 10000MA",
    category: "Phụ kiện",
    price: 500000,
    quantity: 100,
  },
];


function createProductTemplate(product) {
  const $template = $(document.querySelector(".product-template").content.firstElementChild).clone();

  $template.find(".name").text(product.name);
  $template.find(".category").text(product.category);
  $template.find(".price").text(product.price);
  $template.find(".quantity").text(product.quantity);

  //gắn dữ liệu product vào $template

  $template.data(product);
  console.log($template.data());

  return $template;
}

function createProductList() {
  const list = products.map(function (product) {
    return createProductTemplate(product);
  })
  return list;
}

function render() {
  const $list = $(".product-info");
  const list = createProductList();
  $list.append(...list);


//Thêm category vào bảng lọc danh mục
  const categories = getAllCategory();
  const $categories = $(".filter-category");
  categories.forEach(function (category) {
    let categoryValue = category.replaceAll(" ", "-");
    $categories.append("<option value=" + categoryValue + ">" + category + "</option>");
  });

  
}

function showAvailable() {
  // const isCheck = e.target.checked;
  const isCheck = document.querySelector("#status-check");  // dùng DOM để không cần lấy sự kiện
  // console.log(isCheck);

  // lấy tất cả các thẻ tr
  const $products = $('.product-row');
  // console.log($products);
  

  // Lặp qua với mối thẻ tr
  $products.each( function (index,product) {
    //lấy ra data
    const data = $(product).data();
    // console.log(data);
    // console.log(data.quantity);

    if (data.quantity == 0) {
      if (isCheck.checked) {
        $(product).addClass("hidden");
      } else {
        $(product).removeClass("hidden");
      }
    }
  })
}

function getAllCategory() {
  const products = $(".product-row").get();
  
  const categories = new Set();  //Tạo mảng Set nhận các giá trị category khác nhau
  products.forEach(function (product) {
    categories.add($(product).data().category);
  })
  return categories;
}

function getCurrentFilter() {
  const categoryValue = document.querySelector(".filter-category").value.replaceAll("-", " ");
  const isCheck = document.querySelector("#status-check").checked;
  
  let currentFilter = {
    category: categoryValue,
    statusAvailable: isCheck,
  };

  return currentFilter;
}

function showAsCurrentFilter() {
  const currentFilter = getCurrentFilter();
  
  const $products = $(".product-row");

  $products.each(function (index, product) {
    $(product).addClass('hidden');
  })

  $products.each(function (index, product) {
    if (currentFilter.statusAvailable == true) {
       if (currentFilter.category != 0) {
         if ($(product).data().category == currentFilter.category && $(product).data().quantity !=0) {
           $(product).removeClass("hidden");
         }
       } else {
         if ($(product).data().quantity != 0) {
           $(product).removeClass("hidden");
         }
       }
    
    } else {
      if (currentFilter.category != 0) {
        if ($(product).data().category == currentFilter.category) {
          $(product).removeClass("hidden");
        }
      } else {$(product).removeClass("hidden");
      }
    }
  })
};

function filterByCategory() {
  // const option = e.target.value;  lấy value bằng Jquery
 
  const option = document.querySelector('.filter-category').value;   //lấy value bằng DOM
  
  let cloneOption = option.replaceAll("-", " ");
  
  const $products = $(".product-row");
  
   
  $products.each(function (index, product) {
    if (option != 0) {
      if ($(product).data().category != cloneOption) {
        $(product).addClass("hidden");
      } else {
        $(product).removeClass("hidden");
      }
    } else {
      $(product).removeClass("hidden");
    }
    
  });


  //**************************************** */
  //Cập nhật lại checkbox còn hàng
  const $isCheck = document.querySelector("#status-check"); 
  $products.each(function (index, product) {
    //lấy ra data
    const data = $(product).data();
    if (data.quantity == 0) {
      if ($isCheck.checked) {
        $(product).addClass("hidden");
      } 
    }
  });
  
   
}

function sortBy(option) {
  //key, isAscending
  const products = $('.product-row').get();
  console.log(products);

  products.sort(function (productA, productB) {
    // lấy ra data tương ứng
    const dataOfProductA = $(productA).data();
    const dataOfProductB = $(productB).data();

    if (option.isAscending) {
      return dataOfProductA[option.key] - dataOfProductB[option.key];
    } else {
      return dataOfProductB[option.key] - dataOfProductA[option.key];
    }

  });

  $(".product-table").append(products);

}

function sortProduct(e) {
  const option = +e.target.value;

  switch (option) {
    case 1:
      sortBy({ key: "price", isAscending: true });
      break;
    case 2:
      sortBy({ key: "price", isAscending: false });
      break;
    case 3:
      sortBy({ key: "quantity", isAscending: true });
      break;
    case 4:
      sortBy({ key: "quantity", isAscending: false });
      break;
    default:
      break;
  }
}

$(function () {

  // $("#status-check").on('change', function () {
  //   showAvailable();
  //   setTimeout(filterByCategory, 0);
  // });

  // $(".filter-category").on('change', filterByCategory);

  //  $(".content").on("click", showAvailable);

  //  $(".content").on("click", filterByCategory);

  $("#status-check").on("change", showAsCurrentFilter);

  $(".filter-category").on("change", showAsCurrentFilter);



  $('.selection').on('change', sortProduct);

  render();
})

