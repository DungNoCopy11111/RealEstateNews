document.addEventListener('DOMContentLoaded', function() {
    // Sửa lại id cho đúng
    const input = document.getElementById('true_province_');
    const menuBan = document.getElementById('menu_ban');
    const closeMenu = document.getElementById('close-menu');
    const gridItems = document.querySelectorAll('.grid-item');

    // Thêm CSS để xử lý hiển thị/ẩn
    const style = document.createElement('style');
    style.textContent = `
        .show_all_ {
            display: none;
        }
        .show_all_.active {
            display: block;
        }
    `;
    document.head.appendChild(style);

    // Xử lý sự kiện click vào input
    input.addEventListener('click', function(event) {
        event.stopPropagation();
        const showAll = document.querySelector('.show_all_');
        showAll.classList.toggle('active');
    });

    // Xử lý đóng menu
    closeMenu.addEventListener('click', function() {
        const showAll = document.querySelector('.show_all_');
        showAll.classList.remove('active');
    });

    // Xử lý click ra ngoài
    document.addEventListener('click', function(event) {
        const showAll = document.querySelector('.show_all_');
        if (!showAll.contains(event.target) && event.target !== input) {
            showAll.classList.remove('active');
        }
    });

    // Xử lý chọn tỉnh
    gridItems.forEach(item => {
        item.addEventListener('click', function() {
            input.value = this.dataset.value;
            const showAll = document.querySelector('.show_all_');
            showAll.classList.remove('active');
        });
    });
});
document.addEventListener('DOMContentLoaded', function() {
    // 1. Xử lý từng kind riêng biệt (1-5)
    ['1', '2', '3', '4', '5'].forEach(num => {
        const kind = document.querySelector(`.kind.kind_${num}`);
        const kindShow = kind ? kind.querySelector('.kind_show') : null;
        const kindMini = kind ? kind.querySelector('.kind_mini') : null;
        const kindIcon = kind ? kind.querySelector('.kind_right') : null;

        if (kind && kindShow && kindMini && kindIcon) {
            // Click handler cho kind
            kind.addEventListener('click', function(e) {
                console.log(`Kind ${num} clicked`); // Debug log
                e.stopPropagation();

                // Ẩn tất cả kind_mini khác
                ['1', '2', '3', '4', '5'].filter(n => n !== num).forEach(n => {
                    const otherKindMini = document.querySelector(`.kind_mini_${n}`);
                    const otherKindIcon = document.querySelector(`.kind.kind_${n} .kind_right`);
                    if (otherKindMini) otherKindMini.classList.add('hidden');
                    if (otherKindIcon) otherKindIcon.classList.remove('rotated');
                });

                // Toggle kind_mini hiện tại
                kindMini.classList.toggle('hidden');
                kindIcon.classList.toggle('rotated');
            });

            // Click handler cho close button trong kind_mini
            const closeButton = kindMini.querySelector('.close_kind_mini');
            if (closeButton) {
                closeButton.addEventListener('click', function(e) {
                    e.stopPropagation();
                    kindMini.classList.add('hidden');
                    kindIcon.classList.remove('rotated');
                });
            }

            // Click handler cho apply button trong kind_mini
            const applyButton = kindMini.querySelector('.mini_bottom_right');
            if (applyButton) {
                applyButton.addEventListener('click', function(e) {
                    e.stopPropagation();
                    kindMini.classList.add('hidden');
                    kindIcon.classList.remove('rotated');
                });
            }
        }
    });

    // 2. Xử lý click outside
    document.addEventListener('click', function(e) {
        const target = e.target;
        if (!target.closest('.kind')) {
            // Ẩn tất cả kind_mini
            ['1', '2', '3', '4', '5'].forEach(num => {
                const kindMini = document.querySelector(`.kind_mini_${num}`);
                const kindIcon = document.querySelector(`.kind.kind_${num} .kind_right`);
                if (kindMini) kindMini.classList.add('hidden');
                if (kindIcon) kindIcon.classList.remove('rotated');
            });
        }
    });

    // 3. Ngăn chặn propagation cho các phần tử trong kind_mini
    document.querySelectorAll('.kind_mini').forEach(kindMini => {
        kindMini.addEventListener('click', function(e) {
            e.stopPropagation();
        });
    });

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
});


