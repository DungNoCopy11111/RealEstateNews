// Đợi DOM load xong
document.addEventListener('DOMContentLoaded', function() {
    // Khai báo và kiểm tra các elements
    const searchItems = document.querySelectorAll('.search_true');
    const input = document.getElementById('true_province_');
    const menu = document.getElementById('menu');
    const gridItems = document.querySelectorAll('.grid-item');
    const closeButton = document.getElementById('close-menu');

    // Xử lý search items
    if (searchItems.length > 0) {
        searchItems.forEach(item => {
            item.addEventListener('click', function() {
                searchItems.forEach(i => i.classList.remove('active'));
                this.classList.add('active');
            });
        });
    }

    // Xử lý avatar dropdown với jQuery
    $(document).ready(function() {
        const $logAvatar = $(".log_avatar");
        const $showDownAvatar = $(".show_down_avatar");

        if ($logAvatar.length && $showDownAvatar.length) {
            $logAvatar.click(function() {
                $showDownAvatar.toggleClass("hidden");
            });

            $(document).click(function(event) {
                if (!$(event.target).closest('.log_avatar, .show_down_avatar').length) {
                    $showDownAvatar.addClass("hidden");
                }
            });
        }
    });

    // Xử lý input và menu
    if (input && menu) {
        input.addEventListener('click', () => {
            menu.style.display = 'block';
            menu.style.position = 'absolute';
            menu.style.top = '116px';
            menu.style.margin = '0 50%';
            menu.style.transform = 'translateX(-50%)';
            menu.style.width = '100%';
            const inputWidth = input.offsetWidth;
            menu.style.width = `${inputWidth}px`;
            menu.style.left = `${input.offsetLeft}px`;
            menu.style.zIndex = '1';
            menu.style.boxShadow = '0 5px 10px rgba(0, 0, 0, 0.2)';
        });

        // Xử lý grid items
        if (gridItems.length > 0) {
            gridItems.forEach(item => {
                item.addEventListener('click', () => {
                    input.value = item.getAttribute('data-value');
                    menu.style.display = 'none';
                });
            });
        }

        // Xử lý nút đóng
        if (closeButton) {
            closeButton.addEventListener('click', () => {
                menu.style.display = 'none';
            });
        }

        // Xử lý click outside
        document.addEventListener('click', (event) => {
            const isClickInside = event.target.closest('.search_bar') || event.target.closest('.main');
            if (!isClickInside) {
                menu.style.display = 'none';
            }
        });
    }

    // Xử lý kind menu
    let classOld = "";
    let iconOld = null;

    const $kind = $(".kind");
    const $kindMini = $(".kind_mini");
    const $closeKindMini = $(".close_kind_mini");

    if ($kind.length) {
        $kind.click(function(event) {
            event.stopPropagation();
            let classClick = $(this).attr("class").split(" ").pop();
            let classTarget = classClick.replace('kind', 'kind_mini');
            let iconCurrent = $(this).find('.kind_right');

            if (classClick === classOld) {
                $("." + classTarget).addClass('hidden');
                iconCurrent.removeClass('active');
                classOld = "";
            } else {
                classOld = classClick;
                $kindMini.addClass('hidden');
                $("." + classTarget).removeClass('hidden');

                if (iconOld && !iconOld.is(iconCurrent)) {
                    iconOld.removeClass('active');
                }

                iconCurrent.addClass('active');
                iconOld = iconCurrent;
            }
        });

        if ($kindMini.length) {
            $kindMini.click(function(event) {
                event.stopPropagation();
            });
        }

        if ($closeKindMini.length) {
            $closeKindMini.click(function() {
                const $parent = $(this).closest('.kind_show').find('.kind_mini');
                const $icon = $(this).closest('.kind_show').find('.kind_right');

                $parent.addClass('hidden');
                $icon.removeClass('active');
                classOld = "";
            });
        }

        // Xử lý click outside cho kind menu
        $(document).click(function(event) {
            const isKindClick = $(event.target).closest('.kind').length;
            const isMainOrSearchClick = $(event.target).closest('.main').length ||
                $(event.target).closest('.search_bar').length;

            if (!isKindClick || isMainOrSearchClick) {
                $kindMini.addClass('hidden');
                $('.kind_right').removeClass('active');
                classOld = "";
            }
        });
    }

    // Xử lý apply buttons
    const applyButtons = document.querySelectorAll('.mini_bottom_right');
    if (applyButtons.length > 0) {
        applyButtons.forEach((button, index) => {
            button.addEventListener('click', (e) => {
                e.stopPropagation();
                const kindMini = document.querySelector(`.kind_mini_${index + 1}`);
                if (kindMini) {
                    kindMini.classList.add('hidden');
                }
            });
        });
    }

    // Thêm error handling
    window.onerror = function(msg, url, lineNo, columnNo, error) {
        console.log('Error: ' + msg +
            '\nURL: ' + url +
            '\nLine: ' + lineNo +
            '\nColumn: ' + columnNo +
            '\nError object: ' + JSON.stringify(error));
        return false;
    };
});