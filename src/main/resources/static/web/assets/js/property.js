const thumbnails = document.querySelectorAll('.thumbnail');
const mainImage = document.querySelector('.main-image');
const prevButton = document.querySelector('.nav-button.prev');
const nextButton = document.querySelector('.nav-button.next');
const imageCounter = document.querySelector('.image-counter');

let currentImageIndex = 0;

// Lấy danh sách đường dẫn ảnh từ các thumbnail
const images = Array.from(thumbnails).map(thumb => thumb.src);

// Khởi tạo số ảnh ban đầu
if (images.length > 0) {
    imageCounter.textContent = `1/${images.length}`;
}

// Cập nhật active thumbnail
function updateActiveThumbnail() {
    thumbnails.forEach((thumb, index) => {
        if (index === currentImageIndex) {
            thumb.classList.add('active');
        } else {
            thumb.classList.remove('active');
        }
    });
}

// Hàm cập nhật ảnh chính
function updateMainImage() {
    if (images.length > 0) {
        mainImage.src = images[currentImageIndex];
        imageCounter.textContent = `${currentImageIndex + 1}/${images.length}`;
        updateActiveThumbnail();
    }
}

// Xử lý click nút prev
if (prevButton) {
    prevButton.addEventListener('click', () => {
        if (images.length > 0) {
            currentImageIndex = (currentImageIndex - 1 + images.length) % images.length;
            updateMainImage();
        }
    });
}

// Xử lý click nút next
if (nextButton) {
    nextButton.addEventListener('click', () => {
        if (images.length > 0) {
            currentImageIndex = (currentImageIndex + 1) % images.length;
            updateMainImage();
        }
    });
}

// Xử lý click thumbnail
thumbnails.forEach((thumbnail, index) => {
    thumbnail.addEventListener('click', () => {
        currentImageIndex = index;
        updateMainImage();
    });
});

// Thêm xử lý phím mũi tên
document.addEventListener('keydown', (e) => {
    if (e.key === 'ArrowLeft' && prevButton) {
        prevButton.click();
    } else if (e.key === 'ArrowRight' && nextButton) {
        nextButton.click();
    }
});

// Set thumbnail đầu tiên là active và cập nhật ảnh chính ban đầu
if (images.length > 0) {
    updateActiveThumbnail();
    updateMainImage();
}

// Phần xử lý avatar (giữ nguyên)
$(document).ready(function() {
    $(".log_avatar").click(function() {
        $(".show_down_avatar").toggleClass("hidden");
    });

    $(document).click(function(event) {
        if (!$(event.target).closest('.log_avatar, .show_down_avatar').length) {
            $(".show_down_avatar").addClass("hidden");
        }
    });
});