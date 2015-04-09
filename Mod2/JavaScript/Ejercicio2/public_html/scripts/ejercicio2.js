function entrada() {
    var entrar = confirm("¿Realmente quiere entrar mi página?");
    if (entrar) {
        alert("¿Preparado?");
        empieza();
    }
    else {
        alert("Otra vez será");
        parent.location = "http://www.eii.us.es";
    }
}

function empieza() {
    var nombre = prompt("Introduzca su nombre");
    var date = new Date();
    alert("Hola "+nombre+" ha entrado en la pagina a las "+date.getHours()+" horas y "+date.getMinutes()+" minutos");
}

function salida(){
    var res = "Gracias por su visita";
    res +="\nNumeros aleatorios:";
    for(var i=0;i<6;i++){
        res += " "+Math.round(((Math.random()*49)+1));
    }
    alert(res);
    location.href="http://www.eii.us.es";
}