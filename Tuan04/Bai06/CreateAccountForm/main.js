document.getElementById('accept').addEventListener('change', function (e) {
    if (e.target.checked) {
        validateForm();
    }
});

function validateForm() {
    let isValid = true;

    document.querySelectorAll('.error-message').forEach(error => error.textContent = '');
    document.querySelectorAll('.error').forEach(input => input.classList.remove('error'));

    const name = document.querySelector('.fullname input');
    if (name.value.trim() === '') {
        setError(name, 'Full Name is required.');
        isValid = false;
    }

    const email = document.querySelector('.email input');
    if (!/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/.test(email.value)) {
        setError(email, 'Invalid email address.');
        isValid = false;
    }

    const password = document.querySelector('.password input');
    if (password.value.trim() === '') {
        setError(password, 'Password is required.');
        isValid = false;
    }

    const day = document.querySelector('.birth input[placeholder="DD"]');
    const month = document.querySelector('.birth input[placeholder="MM"]');
    const year = document.querySelector('.birth input[placeholder="YYYY"]');
    if (day.value === '' || month.value === '' || year.value === '') {
        setError(day.parentElement, 'Date of Birth is required.');
        isValid = false;
    }

    const cardNumber = document.querySelector('.cardnumber-input input');
    if (!/^\d{16}$/.test(cardNumber.value)) {
        setError(cardNumber, 'Card Number must be 16 digits.');
        isValid = false;
    }

    const cvc = document.querySelector('.cvc input');
    if (!/^\d{3}$/.test(cvc.value)) {
        setError(cvc, 'Card CVC must be 3 digits.');
        isValid = false;
    }

    if (isValid) {
        alert("All fields are valid. Form is ready to be submitted.");
    } else {
        document.getElementById('accept').checked = false;
    }
}

function setError(input, message) {
    const errorDisplay = input.parentElement.querySelector('.error-message');
    errorDisplay.textContent = message;
    input.classList.add('error');
}
