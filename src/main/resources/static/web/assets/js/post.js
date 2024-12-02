const imageUpload = document.getElementById('imageUpload');
const fileInput = document.getElementById('fileInput');
const imagePreview = document.getElementById('imagePreview');
const postForm = document.getElementById('postForm');

// Xử lý upload ảnh
imageUpload.addEventListener('click', () => {
    fileInput.click();
});

imageUpload.addEventListener('dragover', (e) => {
    e.preventDefault();
    imageUpload.style.borderColor = '#055699';
});

imageUpload.addEventListener('dragleave', () => {
    imageUpload.style.borderColor = '#ddd';
});

imageUpload.addEventListener('drop', (e) => {
    e.preventDefault();
    imageUpload.style.borderColor = '#ddd';
    handleFiles(e.dataTransfer.files);
});

fileInput.addEventListener('change', () => {
    handleFiles(fileInput.files);
});

function handleFiles(files) {
    if (files.length + imagePreview.children.length > 8) {
        alert('Bạn chỉ có thể tải lên tối đa 8 ảnh');
        return;
    }

    Array.from(files).forEach(file => {
        if (file.size > 2 * 1024 * 1024) {
            alert('Kích thước ảnh không được vượt quá 2MB');
            return;
        }

        const reader = new FileReader();
        reader.onload = (e) => {
            const div = document.createElement('div');
            div.className = 'preview-item';
            
            const img = document.createElement('img');
            img.src = e.target.result;
            
            const removeBtn = document.createElement('div');
            removeBtn.className = 'remove-image';
            removeBtn.innerHTML = '×';
            removeBtn.onclick = function() {
                div.remove();
            };
            
            div.appendChild(img);
            div.appendChild(removeBtn);
            imagePreview.appendChild(div);
        };
        
        reader.readAsDataURL(file);
    });
}

// Xử lý form submit
postForm.addEventListener('submit', (e) => {
    e.preventDefault();
    
    // Validate các trường bắt buộc
    const requiredFields = postForm.querySelectorAll('[required]');
    let isValid = true;
    
    requiredFields.forEach(field => {
        if (!field.value.trim()) {
            isValid = false;
            field.style.borderColor = 'red';
            const label = field.previousElementSibling;
            if (label && label.tagName === 'LABEL') {
                alert(`Vui lòng nhập ${label.textContent.replace('*', '')}`);
            }
        } else {
            field.style.borderColor = '#ddd';
        }
    });

    // Validate tiêu đề
    const title = postForm.querySelector('input[type="text"]');
    if (title.value.length < 30 || title.value.length > 99) {
        isValid = false;
        title.style.borderColor = 'red';
        alert('Tiêu đề phải từ 30 đến 99 ký tự');
    }

    // Validate mô tả
    const description = postForm.querySelector('textarea');
    if (description.value.length < 30 || description.value.length > 3000) {
        isValid = false;
        description.style.borderColor = 'red';
        alert('Mô tả phải từ 30 đến 3000 ký tự');
    }

    // Validate hình ảnh
    if (imagePreview.children.length === 0) {
        isValid = false;
        imageUpload.style.borderColor = 'red';
        alert('Vui lòng tải lên ít nhất 1 hình ảnh');
    }

    if (isValid) {
        // Thêm animation loading khi submit
        const submitBtn = postForm.querySelector('.submit-button');
        submitBtn.innerHTML = 'Đang xử lý...';
        submitBtn.disabled = true;

        // Giả lập API call
        setTimeout(() => {
            alert('Đăng tin thành công!');
            submitBtn.innerHTML = 'Đăng tin';
            submitBtn.disabled = false;
        }, 1500);
    }
});

// Xử lý select địa chỉ phụ thuộc
const provinceSelect = document.querySelector('select:nth-of-type(1)');
const districtSelect = document.querySelector('select:nth-of-type(2)');
const wardSelect = document.querySelector('select:nth-of-type(3)');

// Data mẫu
const locations = {
    'HN': {
        name: 'Hà Nội',
        districts: {
            'HK': {
                name: 'Hoàn Kiếm',
                wards: ['Hàng Bông', 'Hàng Gai', 'Hàng Trống']
            },
            'TX': {
                name: 'Thanh Xuân', 
                wards: ['Thanh Xuân Bắc', 'Thanh Xuân Nam', 'Thanh Xuân Trung']
            }
        }
    },
    'HCM': {
        name: 'TP. Hồ Chí Minh',
        districts: {
            'Q1': {
                name: 'Quận 1',
                wards: ['Bến Nghé', 'Bến Thành', 'Đa Kao']
            },
            'Q2': {
                name: 'Quận 2',
                wards: ['Thảo Điền', 'An Phú', 'Bình An']
            }
        }
    }
};

// Cập nhật select quận/huyện
provinceSelect.addEventListener('change', function() {
    const province = locations[this.value];
    
    // Reset quận/huyện
    districtSelect.innerHTML = '<option value="">-- Chọn Quận/Huyện --</option>';
    wardSelect.innerHTML = '<option value="">-- Chọn Phường/Xã --</option>';
    
    if (province) {
        Object.keys(province.districts).forEach(key => {
            const option = document.createElement('option');
            option.value = key;
            option.textContent = province.districts[key].name;
            districtSelect.appendChild(option);
        });
    }
});

// Cập nhật select phường/xã
districtSelect.addEventListener('change', function() {
    const province = locations[provinceSelect.value];
    const district = province?.districts[this.value];
    
    // Reset phường/xã
    wardSelect.innerHTML = '<option value="">-- Chọn Phường/Xã --</option>';
    
    if (district) {
        district.wards.forEach(ward => {
            const option = document.createElement('option');
            option.value = ward;
            option.textContent = ward;
            wardSelect.appendChild(option);
        });
    }
});
