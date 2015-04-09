function ocultarParrafo(id) {
    elemento = document.getElementById(id)
    elemento.style.display = "none"
    if (id == "primero") {
        elemento2 = document.getElementById("elementoPrimero")
        elemento2.style.display = "block"
    }
    else if (id == "segundo") {
        elemento3 = document.getElementById("elementoSegundo")
        elemento3.style.display = "block"
    }
    else {
        elemento4 = document.getElementById("elementoTercero")
        elemento4.style.display = "block"
    }
}

function mostrarParrafo(id) {
    if (id == "elementoPrimero") {
        elemento = document.getElementById("primero")
        elemento.style.display = "block"
    }
    else if (id == "elementoSegundo") {
        elemento2 = document.getElementById("segundo")
        elemento2.style.display = "block"
    }
    else {
        elemento3 = document.getElementById("tercero")
        elemento3.style.display = "block"
    }
    elemento4 = document.getElementById(id)
    elemento4.style.display = "none"
}