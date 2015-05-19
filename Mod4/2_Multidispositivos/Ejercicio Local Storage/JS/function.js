if (!localStorage.contadorPagina) {
    localStorage.setItem('contadorPagina', 0);
}

localStorage.setItem('contadorPagina', parseInt(localStorage.contadorPagina) + 1);

var cont = localStorage.contadorPagina;

document.getElementById("veces").innerHTML = "Has visto esta página <strong>" + cont + "</strong> veces.";