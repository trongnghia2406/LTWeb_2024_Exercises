document.querySelector('form').addEventListener('submit', function (e) {
    e.preventDefault();
    let isValid = true;

    document.querySelectorAll('.error-message').forEach(error => error.textContent = '');
    document.querySelectorAll('input').forEach(input => input.classList.remove('error'));

    const username = document.getElementById('username');
    if (username.value.trim() === '') {
        setError(username, 'Username or email is required.');
        isValid = false;
    } else if (!/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(username.value) && !/^[\w-]+$/.test(username.value)) {
        setError(username, 'Please enter a valid email or username.');
        isValid = false;
    }

    const password = document.getElementById('password');
    if (password.value.trim() === '') {
        setError(password, 'Password is required.');
        isValid = false;
    } else if (password.value.length < 6) {
        setError(password, 'Password must be at least 6 characters long.');
        isValid = false;
    }

    if (isValid) {
        alert('Form submitted successfully!');
    }
});

function setError(input, message) {
    const errorDisplay = input.parentElement.querySelector('.error-message');
    errorDisplay.textContent = message;
    input.classList.add('error');
}
