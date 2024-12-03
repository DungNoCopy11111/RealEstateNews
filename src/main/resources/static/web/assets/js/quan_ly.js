function confirmDelete(button) {
    const postRow = button.closest('.post-row');

    if (confirm('Bạn có chắc chắn muốn xóa tin này không?')) {
        postRow.remove();
        updateSTT();
    }
}

function updateSTT() {
    const rows = document.querySelectorAll('.post-row'); // Lấy tất cả các dòng post-row
    rows.forEach((row, index) => {
        const sttElement = row.querySelector('[id^="stt_"]');
        if (sttElement) {
            const newSTT = index + 1; // Thứ tự mới, bắt đầu từ 1
            sttElement.textContent = newSTT; // Gán giá trị STT mới
            sttElement.id = `stt_${newSTT}`; // Cập nhật id
        }

        updateRowIDs(row, index + 1);
    });
}

// Hàm cập nhật id và name trong một dòng
function updateRowIDs(row, newIndex) {
    // Lấy tất cả các phần tử trong dòng hiện tại
    const elements = row.querySelectorAll('[id]');
    elements.forEach((element) => {
        // Cập nhật id
        const id = element.id;
        const updatedID = id.replace(/_\d+$/, `_${newIndex}`); // Thay số cũ bằng số mới
        element.id = updatedID;

        // Nếu có thuộc tính name, cũng cập nhật
        if (element.name) {
            const updatedName = element.name.replace(/_\d+$/, `_${newIndex}`);
            element.name = updatedName;
        }
    });
}

document.addEventListener('DOMContentLoaded', () => {
    updateSTT();
});

$(document).ready(function() {
    $(".log_avatar").click(function() {
        $(".show_down_avatar").toggleClass("hidden"); // Thêm/bỏ lớp 'hidden'
    });

    $(document).click(function(event) {
        if (!$(event.target).closest('.log_avatar, .show_down_avatar').length) {
            $(".show_down_avatar").addClass("hidden");
        }
    });
});