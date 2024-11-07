let nextNumber = 1;

const container = document.querySelector('.container .row');
for (let i = 1; i <= 64; i++) {
    const button = document.createElement('button');
    button.classList.add('btn', 'btn-outline-primary', 'col');
    button.textContent = i;
    button.addEventListener('click', () => handleButtonClick(button, i));
    container.appendChild(button);
}

function handleButtonClick(button, number) {
    if (number === nextNumber) {
        button.remove();
        nextNumber++;
    } else {
        alert("Bạn đã nhấn sai thứ tự. Vui lòng nhấn đúng thứ tự từ 1 đến 64.");
    }
}