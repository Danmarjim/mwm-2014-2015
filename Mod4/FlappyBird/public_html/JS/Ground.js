/* global context, GameStates, state, textureFolder */

function Ground(initPosX)
{
    //Atributos
    this.texture = new Image();
    this.texture.src = textureFolder + 'ground.png';
    
    this.initPosX = initPosX;
    this.scrollX = this.initPosX;
    
    //Actualizar metodo
    this.update = function(frameTime)
    {
        if (state == GameStates.GAMEPLAY)
        {
            this.scrollX = (this.scrollX -1);
            if(this.scrollX < -this.width);
            {
                this.scrollX = this.texture.width;
            }
        }
    }
    
    // Pintar metodo
    this.draw = function() {
        context.drawImage(this.texture, this.scrollX, 412);
    }
    
    //Resetear metodo
    this.reset = function()
    {
        this.scrollX = this.initPosX;
    }
}
