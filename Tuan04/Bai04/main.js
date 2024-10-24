function countWord() {
    const paragraph = document.getElementById("txtareaInput").value;
    const word = document.getElementById("textfieldInput").value;
    if (!word) {
        document.getElementById("result").innerHTML = "Please enter a word to search for";
        return;
    }
    const words = paragraph.split(/\s+/);
    const count = words.filter(w => w.toLowerCase() === word.toLowerCase()).length;
    document.getElementById('result').innerText = "The word " + word + " appears " + count + " time(s) in the paragraph.";
}
document.getElementById("countBtn").addEventListener("click", countWord);