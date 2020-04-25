const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});

var password = document.getElementById("psw")
  , confirm_password = document.getElementById("cpsw");

function validatePassword(){
  if(psw.value != cpsw.value) {
    cpsw.setCustomValidity("Passwords Don't Match");
  } else {
    cpsw.setCustomValidity('');
  }
}

psw.onchange = validatePassword;
cpsw.onkeyup = validatePassword;


