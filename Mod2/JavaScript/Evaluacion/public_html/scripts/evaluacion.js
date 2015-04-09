function verificaFormulario() {
    var res = true;
    email = document.formulario.correo.value;
    producto = document.formulario.producto.value;
    hora = document.formulario.fecha.value;
    if (email == "") {
        alert("El campo email no puede quedar vacio");
        document.formulario.correo.focus();
        res = false;
    }
    else if (email != "") {
        if (email.indexOf('@.') !=  - 1 || email.indexOf(" ") !=  - 1 || email.indexOf('@') ==  - 1) {
            alert("El campo email: " + email + " no es correcto");
            document.formulario.correo.focus();
            res = false;
        };
    }
    if (res && producto == "") {
        alert("Al menos debe rellenar algun campo de producto");
        document.formulario.producto.focus();
        res = false;
    }
    else if (res && producto != "") {
        if (producto.indexOf('i01') ==  - 1 && producto.indexOf('i02') ==  - 1 && producto.indexOf('i03') ==  - 1 && producto.indexOf('i04') ==  - 1 && producto.indexOf('i05') ==  - 1 && producto.indexOf('i06') ==  - 1 && producto.indexOf('i07') ==  - 1 && producto.indexOf('i08') ==  - 1 && producto.indexOf('i09') ==  - 1 && producto.indexOf('i10') ==  - 1 && producto.indexOf('i11') ==  - 1 && producto.indexOf('i12') ==  - 1 && producto.indexOf('i13') ==  - 1 && producto.indexOf('i14') ==  - 1 && producto.indexOf('i15') ==  - 1 && producto.indexOf('t01') ==  - 1 && producto.indexOf('t02') ==  - 1 && producto.indexOf('t03') ==  - 1 && producto.indexOf('t04') ==  - 1 && producto.indexOf('t05') ==  - 1 && producto.indexOf('t06') ==  - 1 && producto.indexOf('t07') ==  - 1 && producto.indexOf('t08') ==  - 1 && producto.indexOf('t09') ==  - 1 && producto.indexOf('t10') ==  - 1) {
            alert("El codigo del producto debe estar entre i01-i15 o t01-t10");
            document.formulario.producto.focus();
            res = false;
        }
    }
    else if (res && producto == "") {
        alert("Al menos debe rellenar algun campo de producto");
        document.formulario.producto.focus();
        res = false;
    }
    if (res && hora == "") {
        alert("Debe indicar una fecha de entrega");
        document.formulario.fecha.focus();
        res = false;
    }
    else if (res && hora != "") {
        if (hora.indexOf('00:') ==  - 1 && hora.indexOf('01:') ==  - 1 && hora.indexOf('02:') ==  - 1 && hora.indexOf('03:') ==  - 1 && hora.indexOf('04:') ==  - 1 && hora.indexOf('05:') ==  - 1 && hora.indexOf('06:') ==  - 1 && hora.indexOf('07:') ==  - 1 && hora.indexOf('08:') ==  - 1 && hora.indexOf('09:') ==  - 1 && hora.indexOf('10:') ==  - 1 && hora.indexOf('11:') ==  - 1 && hora.indexOf('12:') ==  - 1 && hora.indexOf('13:') ==  - 1 && hora.indexOf('14:') ==  - 1 && hora.indexOf('15:') ==  - 1 && hora.indexOf('16:') ==  - 1 && hora.indexOf('17:') ==  - 1 && hora.indexOf('18:') ==  - 1 && hora.indexOf('19:') ==  - 1 && hora.indexOf('20:') ==  - 1 && hora.indexOf('21:') ==  - 1 && hora.indexOf('22:') ==  - 1 && hora.indexOf('23:') ==  - 1 && hora.indexOf('24:') ==  - 1) {
            alert("Formato no correcto, recuerde la hora debe indicarse entre las 00 y las 24 horas.");
            document.formulario.fecha.focus();
            res = false;
        }
    }
    if (res == true)
        document.formulario.submit();
    return res;
}

function mostrarFecha() {
    var d = new Date();
    document.write('Hora actual: ' + d.getHours(), ':' + d.getMinutes());
}