function Panel (texturePath)
{
    //attributes
    this.texture = new Image();
    this.texture.src = texturePath;
    
    //methods
    this.draw = function (context){
        context.drawImage(  this.texture,
                            context.canvas.width/2 - this.texture.width/2,
                            context.canvas.height/2 - this.texture.height/2
                           );
    }
}


