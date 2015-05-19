if (navigator.geolocation) {
    /* La geolocalización está disponible */
    // Obtener la posición actual
    navigator.geolocation.getCurrentPosition(funcionExito, funcionFracaso);
} else {
    funcionFracaso(null);
}

function funcionExito(position) {
    // display current position (position.coords.latitude, position.coords.longitude).
    var msg = "";
    msg += 'Latitud: ' + position.coords.latitude + '<br />' +
        'Longitud: ' + position.coords.longitude + '<br />' +
        'Altitud: ' + position.coords.altitude + '<br />' +
        'Precisión: ' + position.coords.accuracy + '<br />' +
        'Altitud precisión: ' + position.coords.altitudeAccuracy + '<br />' +
        'Dirección: ' + position.coords.heading + '<br />' +
        'Velocidad: ' + position.coords.speed + '<br />' +
        'Tiempo: ' + new Date(position.timestamp);
    document.getElementById("coordenadas").innerHTML = msg;
}

function funcionFracaso(position) {
    // Notificación al usuario
    var msg = "Lo siento pero la geolocalización no se soporta en tu navegador";
    document.getElementById("coordenadas").innerHTML = msg;
}