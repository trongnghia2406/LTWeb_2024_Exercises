const greeting = [
    "Hello, I'm Barry Allen", "Hi, I'm a big fan of GOAT Leo Messi", "Welcome to my website, I'm Lee Jong Nghia",
    "こんにちは", "Bonjour", "你好", "안녕하세요", "Здравствуйте", "050804 + 240604 -> 010"
];
function randomGreeting() {
    const randomIndex = Math.round(Math.random() * greeting.length);
    document.getElementById("greeting").innerHTML = greeting[randomIndex];
}
document.getElementById("otherGreetingBtn").addEventListener('click', randomGreeting);
window.onload = randomGreeting;