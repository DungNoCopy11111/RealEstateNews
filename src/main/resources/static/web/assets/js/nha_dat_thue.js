document.addEventListener('DOMContentLoaded', function() {
    // Kiểm tra các elements tồn tại
    const input = document.getElementById('true_province_thue');
    const menuThue = document.getElementById('menu_thue');
    const closeMenu = document.getElementById('close-menu');
    const gridItems = document.querySelectorAll('.grid-item');

    // Chỉ thêm event listeners nếu elements tồn tại
    if (input && menuThue && closeMenu) {
        // Ẩn bảng khi khởi động
        menuThue.classList.remove('active');

        // Toggle menu khi nhấn vào input
        input.addEventListener('click', function(event) {
            event.stopPropagation();
            menuThue.classList.toggle('active');
        });

        // Ẩn menu khi nhấn vào nút "X"
        closeMenu.addEventListener('click', function() {
            menuThue.classList.remove('active');
        });

        // Ẩn menu khi nhấn ra ngoài
        document.addEventListener('click', function(event) {
            if (!menuThue.contains(event.target) && event.target !== input) {
                menuThue.classList.remove('active');
            }
        });

        // Thay đổi giá trị input khi chọn một grid-item
        gridItems.forEach(item => {
            item.addEventListener('click', function() {
                input.value = this.dataset.value;
                menuThue.classList.remove('active');
            });
        });
    }

    // Xử lý kind show/hide
    document.querySelectorAll('.kind_show').forEach(kindShow => {
        kindShow.addEventListener('click', function(event) {
            event.stopPropagation();

            const kindMini = this.querySelector('.kind_mini');
            const kindIcon = this.querySelector('.kind_right');

            if (kindMini && kindIcon) {
                if (kindMini.classList.contains('hidden')) {
                    // Ẩn tất cả kind_mini khác
                    document.querySelectorAll('.kind_mini').forEach(k => {
                        if (k && k.parentNode) {
                            k.classList.add('hidden');
                            const parentIcon = k.parentNode.querySelector('.kind_right');
                            if (parentIcon) {
                                parentIcon.classList.remove('rotated');
                            }
                        }
                    });

                    // Hiển thị kind_mini hiện tại
                    kindMini.classList.remove('hidden');
                    kindIcon.classList.add('rotated');
                } else {
                    kindMini.classList.add('hidden');
                    kindIcon.classList.remove('rotated');
                }
            }
        });
    });

    // Document click event để ẩn tất cả kind_mini
    document.addEventListener('click', function() {
        document.querySelectorAll('.kind_mini').forEach(kindMini => {
            if (kindMini && kindMini.parentNode) {
                kindMini.classList.add('hidden');
                const kindIcon = kindMini.parentNode.querySelector('.kind_right');
                if (kindIcon) {
                    kindIcon.classList.remove('rotated');
                }
            }
        });
    });

    // Xử lý nút mini_bottom_right
    document.querySelectorAll('.mini_bottom_right').forEach(button => {
        button.addEventListener('click', function(event) {
            event.stopPropagation();
            const kindMini = this.closest('.kind_mini');
            if (kindMini && kindMini.parentNode) {
                kindMini.classList.add('hidden');
                const kindIcon = kindMini.parentNode.querySelector('.kind_right');
                if (kindIcon) {
                    kindIcon.classList.remove('rotated');
                }
            }
        });
    });

    // Ngăn propagation cho kind_mini
    document.querySelectorAll('.kind_mini').forEach(kindMini => {
        kindMini.addEventListener('click', function(event) {
            event.stopPropagation();
        });
    });

    // Xử lý nút close_kind_mini
    document.querySelectorAll('.close_kind_mini').forEach(closeButton => {
        closeButton.addEventListener('click', function(event) {
            event.stopPropagation();
            const kindMini = this.closest('.kind_mini');
            if (kindMini && kindMini.parentNode) {
                kindMini.classList.add('hidden');
                const kindIcon = kindMini.parentNode.querySelector('.kind_right');
                if (kindIcon) {
                    kindIcon.classList.remove('rotated');
                }
            }
        });
    });

    // Xử lý avatar menu
    const avatar = document.querySelector('.log_avatar');
    const menu = document.querySelector('.show_down_avatar');

    if (avatar && menu) {
        // Hiển thị menu khi click vào avatar
        avatar.addEventListener('click', function(event) {
            event.stopPropagation();
            menu.classList.toggle('hidden');
        });

        // Ẩn menu khi click ra ngoài
        document.addEventListener('click', function(event) {
            if (menu && !menu.classList.contains('hidden')) {
                menu.classList.add('hidden');
            }
        });
    }
});

