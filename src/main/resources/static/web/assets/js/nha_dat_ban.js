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