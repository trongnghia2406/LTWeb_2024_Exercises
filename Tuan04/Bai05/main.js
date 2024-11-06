let angle = 0;
function rotateImage() {
    angle += 15;
    document.getElementById("img-rotate").style.transform = `rotate(${angle}deg)`;
}
setInterval(rotateImage, 2000);