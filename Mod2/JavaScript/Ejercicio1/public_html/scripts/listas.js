function listaViñetaNumerada(n) {
    var s = "<ul>";
    for (i = 1;i <= n;i++) {
        s = s + "<li>" + i + "</li>";
    }
    s += "</ul>";
    return s;
}

function listaViñetaNumerada2(n) {
    var s = "<ul>";
    var contador = 1;
    for (i = 1;i <= n;i++) {
        s = s + "<li>" + contador + "</li>";
        contador *= 10;
    }
    s += "</ul>";
    return s;
}