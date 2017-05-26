var textarea = document.getElementById("textarea");
var num = document.getElementById("num");
		
textarea.onkeydown = function(){
	num.innerText = textarea.value.length;
}
textarea.onkeyup = function(){
	num.innerText = textarea.value.length;
}