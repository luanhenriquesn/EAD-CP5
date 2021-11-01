var personagens = document.querySelector('#idPersonagens');
personagens.addEventListener('change', ()=>{
	location = personagens.value;
});


var links = document.querySelector('#idLinks');
links.addEventListener('change', ()=>{
	location = links.value;
});