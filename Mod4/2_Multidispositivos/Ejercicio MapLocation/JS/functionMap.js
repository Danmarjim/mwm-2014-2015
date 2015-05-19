if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(funcionExito, error);
} else {
    error('No soportado');
}

function funcionExito(position) {
    var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);    
    var myOption = {
        zoom: 16,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };    
    var map = new google.maps.Map(document.getElementById("map-canvas"), myOption);    
    var marker = new google.maps.Marker({
        position: latlng,
        map: map,
        title: "Aquí estás!"
    });
}

function error(msg) {
    document.getElementById("map-canvas") = msg;
}