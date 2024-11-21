// Lấy tất cả các phần tử có class search_true
const searchItems = document.querySelectorAll('.search_true');

// Lặp qua các phần tử và thêm sự kiện click
searchItems.forEach(item => {
    item.addEventListener('click', function() {
        // Xóa lớp active khỏi tất cả các mục
        searchItems.forEach(i => i.classList.remove('active'));
        
        // Thêm lớp active cho mục đã được click
        this.classList.add('active');
    });
});

const input = document.getElementById('true_province_');
const menu = document.getElementById('menu');
const gridItems = document.querySelectorAll('.grid-item');
const closeButton = document.getElementById('close-menu');

    // Khi click vào input, hiển thị menu
input.addEventListener('click', () => {
    menu.style.display = 'block';
    menu.style.position = 'absolute'; // Hoặc dùng 'absolute' nếu bạn muốn nó nằm trong vùng chứa
    menu.style.top = '116px'; // Khoảng cách từ đỉnh màn hình
    menu.style.margin = '0 50%';
    // Căn giữa theo chiều ngang
    menu.style.transform = 'translateX(-50%)';
    menu.style.width = '100%';
    const inputWidth = input.offsetWidth; // Lấy chiều rộng của input
    menu.style.width = `${inputWidth}px`; // Đặt chiều rộng cho menu
    menu.style.left = `${input.offsetLeft}px`; // Đặt vị trí menu bên trái bằng vị trí của input
    menu.style.zIndex = '1';
    menu.style.boxShadow = '0 5px 10px rgba(0, 0, 0, 0.2)';
});

// Lắng nghe sự kiện click trên từng grid-item
gridItems.forEach(item => {
    item.addEventListener('click', () => {
        input.value = item.getAttribute('data-value'); // Gán giá trị vào input
        menu.style.display = 'none'; // Ẩn menu sau khi chọn
    });
});

    // Ẩn menu khi click vào nút đóng "X"
closeButton.addEventListener('click', () => {
        menu.style.display = 'none';
});

    // Ẩn menu khi click ra ngoài vùng menu
document.addEventListener('click', (event) => {
    if (!event.target.closest('.search_bar') || !event.target.closest('.main')) {
        menu.style.display = 'none'; // Ẩn menu
    }
});

var classOld = "";
var iconOld = null;

// Sự kiện click vào thẻ .kind (chính thẻ kind_1, kind_2, kind_3)
$(".kind").click(function(event) {
    event.stopPropagation();  // Ngăn sự kiện lan truyền vào các phần tử con
    let classClick = $(this).attr("class").split(" ").pop();  // Lấy class của thẻ kind hiện tại
    let classTarget = classClick.replace('kind', 'kind_mini');  // Chuyển từ class kind sang class kind_mini
    let iconCurrent = $(this).find('.kind_right');  // Lấy biểu tượng kind_right của thẻ hiện tại

    // Nếu nhấp vào cùng một thẻ thì ẩn nó đi
    if (classClick == classOld) {
        $("." + classTarget).addClass('hidden');  // Ẩn thẻ kind_mini
        iconCurrent.removeClass('active');  // Xóa lớp active để biểu tượng trở lại bình thường
        classOld = "";  // Reset lại classOld
    } else {
        classOld = classClick;  // Ghi lại class của thẻ hiện tại
        $(".kind_mini").addClass('hidden');  // Ẩn tất cả các thẻ kind_mini khác
        $("." + classTarget).removeClass('hidden');  // Hiển thị thẻ kind_mini tương ứng

        // Xử lý biểu tượng của thẻ trước đó nếu có
        if (iconOld && iconOld !== iconCurrent) {
            iconOld.removeClass('active');  // Xóa lớp active của biểu tượng trước
        }

        iconCurrent.addClass('active');  // Thêm lớp active vào biểu tượng hiện tại
        iconOld = iconCurrent;  // Lưu lại biểu tượng hiện tại để lần sau xử lý
    }
});

// Ngăn không cho việc click vào bên trong kind_mini làm đóng kind_mini
$(".kind_mini").click(function(event) {
    event.stopPropagation();  // Ngăn sự kiện click này lan truyền ra ngoài
});

// Sự kiện click vào close_kind_mini để đóng tất cả các thẻ kind_mini và reset trạng thái của thẻ kind
$(".close_kind_mini").click(function() {
    const parent = $(this).closest('.kind_show').find('.kind_mini');
    const icon = $(this).closest('.kind_show').find('.kind_right');

    parent.addClass('hidden');  // Ẩn kind_mini tương ứng
    icon.removeClass('active');  // Xóa lớp active của biểu tượng kind_right
    classOld = "";  // Reset lại classOld để khi click vào thẻ kind có thể hiển thị lại kind_mini
});

// Sự kiện click ra ngoài vùng .main hoặc .search_bar sẽ ẩn tất cả các thẻ kind_mini
$(document).click(function(event) {
    if (!$(event.target).closest('.kind').length || ($(event.target).closest('.main').length || $(event.target).closest('.search_bar').length)) {
        $(".kind_mini").addClass('hidden');  // Ẩn tất cả các thẻ kind_mini
        $(".kind_right").removeClass('active');  // Xóa lớp active trên tất cả các biểu tượng kind_right
        classOld = "";  // Reset lại classOld
    }
});

$(document).ready(function() {
    // Khi click vào avatar, menu sẽ hiện ra
    $(".log_avatar").click(function() {
        $(".show_down_avatar").toggleClass("hidden"); // Thêm/bỏ lớp 'hidden'
    });

    // Khi click ra ngoài menu, sẽ đóng menu lại
    $(document).click(function(event) {
        if (!$(event.target).closest('.log_avatar, .show_down_avatar').length) {
            $(".show_down_avatar").addClass("hidden");
        }
    });
});

const applyButtons = document.querySelectorAll('.mini_bottom_right'); // Nút "Áp dụng"

// Thêm sự kiện click cho từng nút "Áp dụng" để tắt kind_mini
applyButtons.forEach((button, index) => {
    button.addEventListener('click', (e) => {
        e.stopPropagation(); // Ngăn không cho sự kiện click lan ra ngoài
        const kindMini = document.querySelector(`.kind_mini_${index + 1}`);
        kindMini.classList.add('hidden'); // Ẩn thẻ kind_mini khi nhấn nút "Áp dụng"
    });
});

