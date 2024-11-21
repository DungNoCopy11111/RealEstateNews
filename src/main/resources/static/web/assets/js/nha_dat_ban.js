document.addEventListener('DOMContentLoaded', function() {
    const input = document.getElementById('true_province_ban');
    const menuBan = document.getElementById('menu_ban');
    const closeMenu = document.getElementById('close-menu');
    const gridItems = document.querySelectorAll('.grid-item');

    // Ẩn bảng khi khởi động
    menuBan.classList.remove('active');

    // Toggle menu khi nhấn vào input
    input.addEventListener('click', function(event) {
        event.stopPropagation(); // Ngăn chặn sự kiện click lan ra ngoài
        menuBan.classList.toggle('active');
    });

    // Ẩn menu khi nhấn vào nút "X"
    closeMenu.addEventListener('click', function() {
        menuBan.classList.remove('active');
    });

    // Ẩn menu khi nhấn ra ngoài
    document.addEventListener('click', function(event) {
        if (!menuBan.contains(event.target) && event.target !== input) {
            menuBan.classList.remove('active');
        }
    });

    // Thay đổi giá trị input khi chọn một grid-item
    gridItems.forEach(item => {
        item.addEventListener('click', function() {
            input.value = this.dataset.value; // Cập nhật giá trị cho input
            menuBan.classList.remove('active'); // Ẩn bảng sau khi chọn
        });
    });
});



// // Chọn tất cả các phần tử có class _kind_show
// const kindShows = document.querySelectorAll('._kind_show');
// const closeButtons = document.querySelectorAll('.close_kind_mini');
// const applyButtons = document.querySelectorAll('.mini_bottom_right'); // Nút "Áp dụng"

// // Lặp qua từng phần tử _kind_show
// kindShows.forEach((kindShow, index) => {
//     kindShow.addEventListener('click', (e) => {
//         e.stopPropagation(); // Ngăn không cho sự kiện click lan ra ngoài

//         // Lấy phần tử kind_mini tương ứng với thẻ vừa click
//         const kindMini = document.querySelector(`.kind_mini_${index + 1}`);
//         const kindRight = kindShow.querySelector('.kind_right'); // Thay thế bằng cách lấy phần tử kind_right

//         // Ẩn tất cả các kind_mini và quay lại vị trí ban đầu cho tất cả kind_right
//         document.querySelectorAll('.kind_mini').forEach(mini => {
//             mini.classList.add('hidden');
//         });
//         document.querySelectorAll('.kind_right').forEach(right => {
//             right.classList.remove('rotate'); // Quay lại vị trí ban đầu
//         });

//         // Kiểm tra xem kind_mini có đang hiển thị hay không
//         if (!kindMini.classList.contains('hidden')) {
//             kindMini.classList.add('hidden'); // Nếu đang hiển thị thì ẩn đi
//             kindRight.classList.remove('rotate'); // Quay lại vị trí ban đầu
//         } else {
//             // Hiển thị thẻ kind_mini tương ứng
//             kindMini.classList.remove('hidden');
//             kindRight.classList.add('rotate'); // Thực hiện quay 180 độ
//         }
//     });
// });

// // Thêm sự kiện click cho từng nút "X" để tắt kind_mini
// closeButtons.forEach((button, index) => {
//     button.addEventListener('click', (e) => {
//         e.stopPropagation(); // Ngăn không cho sự kiện click lan ra ngoài
//         const kindMini = document.querySelector(`.kind_mini_${index + 1}`);
//         const kindRight = document.querySelector(`.kind_mini_${index + 1}`).closest('._kind_show').querySelector('.kind_right'); // Thay thế bằng cách lấy phần tử kind_right
//         kindMini.classList.add('hidden'); // Ẩn thẻ kind_mini khi nhấn nút "X"
//         kindRight.classList.remove('rotate'); // Quay lại vị trí ban đầu
//     });
// });

// // Thêm sự kiện click cho từng nút "Áp dụng" để tắt kind_mini
// applyButtons.forEach((button, index) => {
//     button.addEventListener('click', (e) => {
//         e.stopPropagation(); // Ngăn không cho sự kiện click lan ra ngoài
//         const kindMini = document.querySelector(`.kind_mini_${index + 1}`);
//         const kindRight = document.querySelector(`.kind_mini_${index + 1}`).closest('._kind_show').querySelector('.kind_right'); // Thay thế bằng cách lấy phần tử kind_right
//         kindMini.classList.add('hidden'); // Ẩn thẻ kind_mini khi nhấn nút "Áp dụng"
//         kindRight.classList.remove('rotate'); // Quay lại vị trí ban đầu
//     });
// });

// // Đóng kind_mini khi click ra bên ngoài
// document.addEventListener('click', (e) => {
//     // Kiểm tra nếu click xảy ra ngoài các thẻ _kind_show hoặc kind_mini
//     if (!e.target.closest('.kind_mini') && !e.target.closest('._kind_show')) {
//         document.querySelectorAll('.kind_mini').forEach(mini => {
//             mini.classList.add('hidden'); // Ẩn tất cả các thẻ kind_mini
//         });
//         // Quay lại vị trí ban đầu cho tất cả kind_right
//         document.querySelectorAll('.kind_right').forEach(right => {
//             right.classList.remove('rotate');
//         });
//     }
// });

//2
// document.querySelectorAll('.kind_show').forEach(kindShow => {
//     kindShow.addEventListener('click', function(event) {
//         // Ngăn chặn sự kiện click khỏi đi lên document
//         event.stopPropagation();

//         // Lấy thẻ kind_mini tương ứng
//         const kindMini = this.querySelector('.kind_mini');
//         const kindIcon = this.querySelector('.kind_right');

//         // Kiểm tra nếu kind_mini đang hiển thị
//         if (kindMini.classList.contains('hidden')) {
//             // Ẩn tất cả các thẻ kind_mini
//             document.querySelectorAll('.kind_mini').forEach(k => {
//                 k.classList.add('hidden');
//                 // Đặt lại biểu tượng về vị trí ban đầu
//                 k.parentNode.querySelector('.kind_right').classList.remove('rotated');
//             });

//             // Hiển thị thẻ kind_mini vừa được click
//             kindMini.classList.remove('hidden');
//             // Quay biểu tượng
//             kindIcon.classList.add('rotated');
//         } else {
//             // Nếu kind_mini đang hiển thị, ẩn nó và quay lại biểu tượng
//             kindMini.classList.add('hidden');
//             kindIcon.classList.remove('rotated');
//         }
//     });
// });

// // Lắng nghe sự kiện click cho document
// document.addEventListener('click', function() {
//     // Ẩn tất cả các thẻ kind_mini
//     document.querySelectorAll('.kind_mini').forEach(kindMini => {
//         kindMini.classList.add('hidden');
//         // Quay lại biểu tượng
//         kindMini.parentNode.querySelector('.kind_right').classList.remove('rotated');
//     });
// });

// // Lắng nghe sự kiện click cho các nút mini_bottom_right
// document.querySelectorAll('.mini_bottom_right').forEach(button => {
//     button.addEventListener('click', function(event) {
//         // Ngăn chặn sự kiện click khỏi đi lên document
//         event.stopPropagation();

//         // Ẩn thẻ kind_mini chứa nút vừa được click
//         const kindMini = this.closest('.kind_mini');
//         if (kindMini) {
//             kindMini.classList.add('hidden');
//             // Đặt lại biểu tượng về vị trí ban đầu
//             kindMini.parentNode.querySelector('.kind_right').classList.remove('rotated');
//         }
//     });
// });

document.querySelectorAll('.kind_show').forEach(kindShow => {
    kindShow.addEventListener('click', function(event) {
        // Ngăn chặn sự kiện click khỏi đi lên document
        event.stopPropagation();

        // Lấy thẻ kind_mini tương ứng
        const kindMini = this.querySelector('.kind_mini');
        const kindIcon = this.querySelector('.kind_right');

        // Kiểm tra nếu kind_mini đang hiển thị
        if (kindMini.classList.contains('hidden')) {
            // Ẩn tất cả các thẻ kind_mini
            document.querySelectorAll('.kind_mini').forEach(k => {
                k.classList.add('hidden');
                // Đặt lại biểu tượng về vị trí ban đầu
                k.parentNode.querySelector('.kind_right').classList.remove('rotated');
            });

            // Hiển thị thẻ kind_mini vừa được click
            kindMini.classList.remove('hidden');
            // Quay biểu tượng
            kindIcon.classList.add('rotated');
        } else {
            // Nếu kind_mini đang hiển thị, ẩn nó và quay lại biểu tượng
            kindMini.classList.add('hidden');
            kindIcon.classList.remove('rotated');
        }
    });
});

// Lắng nghe sự kiện click cho document
document.addEventListener('click', function() {
    // Ẩn tất cả các thẻ kind_mini
    document.querySelectorAll('.kind_mini').forEach(kindMini => {
        kindMini.classList.add('hidden');
        // Quay lại biểu tượng
        kindMini.parentNode.querySelector('.kind_right').classList.remove('rotated');
    });
});

// Lắng nghe sự kiện click cho các nút mini_bottom_right
document.querySelectorAll('.mini_bottom_right').forEach(button => {
    button.addEventListener('click', function(event) {
        // Ngăn chặn sự kiện click khỏi đi lên document
        event.stopPropagation();

        // Ẩn thẻ kind_mini chứa nút vừa được click
        const kindMini = this.closest('.kind_mini');
        if (kindMini) {
            kindMini.classList.add('hidden');
            // Đặt lại biểu tượng về vị trí ban đầu
            kindMini.parentNode.querySelector('.kind_right').classList.remove('rotated');
        }
    });
});

// Lắng nghe sự kiện click cho các phần tử trong kind_mini để ngăn chặn việc ẩn
document.querySelectorAll('.kind_mini').forEach(kindMini => {
    kindMini.addEventListener('click', function(event) {
        event.stopPropagation(); // Ngăn chặn sự kiện click khỏi đi lên document
    });
});

// Lắng nghe sự kiện click cho nút close_kind_mini
document.querySelectorAll('.close_kind_mini').forEach(closeButton => {
    closeButton.addEventListener('click', function(event) {
        // Ngăn chặn sự kiện click khỏi đi lên document
        event.stopPropagation();

        // Ẩn thẻ kind_mini chứa nút vừa được click
        const kindMini = this.closest('.kind_mini');
        if (kindMini) {
            kindMini.classList.add('hidden');
            // Đặt lại biểu tượng về vị trí ban đầu
            kindMini.parentNode.querySelector('.kind_right').classList.remove('rotated');
        }
    });
});

document.addEventListener('DOMContentLoaded', function() {
    const avatar = document.querySelector('.log_avatar');
    const menu = document.querySelector('.show_down_avatar');

    // Hiển thị menu khi click vào avatar
    avatar.addEventListener('click', function(event) {
        menu.classList.toggle('hidden');
        event.stopPropagation(); // Ngăn việc click này kích hoạt sự kiện ở document
    });

    // Ẩn menu khi click ra ngoài
    document.addEventListener('click', function(event) {
        if (!menu.classList.contains('hidden')) {
            menu.classList.add('hidden');
        }
    });
});