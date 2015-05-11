/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Pipeline(initPosX)
{
    //Atributos
    this.texture = new Image();
    this.texture.src = textureFolder + 'pipeline.png';
    
    this.initPosX = initPosX;
    this.scrollX = this.initPosX;
    this.gapY = 200;
    this.passed = false;
    
    //Actualizar metodo
    this.update = function(frameTime)
    {
        if (state == GameStates.GAMEPLAY)
        {
            this.scrollX = (this.scrollX -1);
            if(this.scrollX < -this.texture.width);
            {
                this.scrollX = context.canvas.width;
                this.gapY = 100 + Math.random() * 200;
                this.passed = false;
            }
            if(!this.passed && this.scrollX < 50)
            {
                this.passed = true;
                scores += 1;
            }
        }
    }
    
    // Pintar metodo
    this.draw = function() {
        // Pipeline baja
        context.drawImage(this.texture, this.scrollX, this.gapY + 50);
        
        // Pipeline alta
        var x = this.texture.width + this.scrollX;
        var y = this.gapY -50;
        context.translate(x,y);
        context.rotate(Math.PI);
        context.drawImage(this.texture, 0, 0);
        context.rotate(-Math.PI);
        context.translate(-x,-y);
    }
    
    //Resetear metodo
    this.reset = function()
    {
        this.scrollX = this.initPosX;
    }
}

