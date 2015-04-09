(function($){
    $('.miniaturas a').on('click', function(){
        var largePath = $(this).attr('href');
        $('#grande').attr({
            src: largePath,
        });
        return false;
    });
})(jQuery);


(function($){
    $('#menu li').hover(function(){
        $(this).animate({width: '7rem' },500
        );
    }, function(){
        $(this).animate({width: '5rem' },500
        );
    });
})(jQuery);

(function($){
    $('#enviar').on('click', function(){
        var ciudad = $('#ciudad').val();
        $.ajax({
            type='GET',
            url='http://api.openweathermap.org/data/2.5/weather',
            data: {
                q:ciudad
            }, 
        .done(function(data){
            var res = getInformation(data);
            $('#resultado').html(res);
        });
    });
})(jQuery);