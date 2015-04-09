function creaTabla(){
    nuevaTabla = document.createElement("TABLE")
    nuevaTabla.id = "Tabla1"
    nuevaTabla.border = 1
    
    nuevaTablaBody = document.createElement("TBODY")
    for(i=0;i<3;i++){
        fila = document.createElement("TR");
        for(j=0;j<3;j++){
            celda = document.createElement("TD")
            celda.setAttribute("WIDTH", "75")
            celda.setAttribute("HEIGHT", "50")
            texto = " Celda" + i + "_" + j
            nodoTexto = document.createTextNode(texto)
            celda.appendChild(nodoTexto)
            fila.appendChild(celda)
        }
        nuevaTablaBody.appendChild(fila)
    }
    nuevaTabla.appendChild(nuevaTablaBody)
    docBody = document.getElementsByTagName("body").item(0)
    docBody.appendChild(nuevaTabla)
}