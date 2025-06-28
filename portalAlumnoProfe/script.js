const arrowBack = document.getElementById("back");
const backTest = document.getElementById("back-text");
const signUp = document.getElementById("sign-up");
const login = document.getElementById("log-in");

arrowBack.addEventListener("click", () => {
    signUp.style.display = "none";
    login.style.display = "block";
})

backTest.addEventListener("click", () => {
    signUp.style.display = "none";
    login.style.display = "block";
})