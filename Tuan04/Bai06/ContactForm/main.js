document.querySelector('form').addEventListener('submit', function (e) {
    e.preventDefault(); // Ngăn gửi form mặc định
    let isValid = true;

    document.querySelectorAll('.error-message').forEach(error => error.textContent = '');
    document.querySelectorAll('.error').forEach(input => input.classList.remove('error'));

    const name = document.getElementById('name');
    if (name.value.trim() === '') {
        setError(name, 'Name is required.');
        isValid = false;
    }

    const email = document.getElementById('email');
    if (!/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(email.value)) {
        setError(email, 'Invalid email address.');
        isValid = false;
    }

    const phone = document.getElementById('phone');
    if (!/^\d{10}$/.test(phone.value)) {
        setError(phone, 'Phone number must be 10 digits.');
        isValid = false;
    }

    const services = document.getElementById('services');
    if (services.value === '') {
        setError(services, 'Please select a service.');
        isValid = false;
    }

    const message = document.getElementById('message');
    if (message.value.trim() === '') {
        setError(message, 'Message cannot be empty.');
        isValid = false;
    }

    if (isValid) {
        this.submit();
    }
});

// Hàm thiết lập lỗi
function setError(input, message) {
    const errorDisplay = input.parentElement.querySelector('.error-message');
    errorDisplay.textContent = message;
    input.classList.add('error'); // Đặt class 'error' trực tiếp cho phần tử nhập liệu
}

