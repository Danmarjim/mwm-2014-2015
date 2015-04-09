(function ($) {
    $('#enviar').on('click', function () {
        var nombre = $('#nombre').val();
        var email = $('#email').val();
        var telefono = $('#telefono').val();

        $.ajax( {
            type : 'POST', url : 'process.jsp', data :  {
                name : nombre, mail : email, phone : telefono
            },
            dataType : "json"
        }).done(function (data) {
            if (data.respuesta == "true") {
                var pagina = 'user.jsp';
                document.location.href = pagina;
            }
            else {
                var res = 'Validación incorrecta';
                $('#resultado').html(res);
            }
        });
    });

})(jQuery);