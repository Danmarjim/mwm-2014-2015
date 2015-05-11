/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Bird(y)
{
    //Texturas
    this.textures = new Array();
    this.textures[0] = new Image();
    this.textures[0].src = textureFolder + 'birdOrange0.png';
    this.textures[1] = new Image();
    this.textures[1].src = textureFolder + 'birdOrange1.png';
    this.textures[2] = new Image();
    this.textures[2].src = textureFolder + 'birdOrange2.png';
    
    this.currentFrame = 0;
    // y = h0 + v0 * T - 0.5 * g * T^2
    this.h0 = y;
    this.v0 = -30;
    this.g = -9.8;
    this.time = 0.0;
    this.position = new Vector2(100, this.h0);
    this.vertex = new Array(4);
    
    //Metodo update
    this.update = function(frameTime)
    {
       //Animacion folder
       this.currentFrame = (this.currentFrame + 1) % this.textures.length;
       
       if(state == GameStates.GAMEPLAY)
       {
           //Posicion animacion
           this.time += frameTime / 100;
           this.position.y = this.h0 + (this.v0 * this.time - 0.5 *this.g * Math.pow(this.time, 2));
           if(this.position.y > context.canvas.height)
           {
               SetNewState(GameStates.GAMEOVER);
           }
           
           //Colision
           var minx = this.position.x - 20;
           var maxx = this.position.x + 20;
           var miny = this.position.x - 12;
           var maxy = this.position.x + 12;
           
           this.vertex[0] = new Vector2(minx, miny); // Top left
           this.vertex[1] = new Vector2(maxx, miny); // Top right
           this.vertex[2] = new Vector2(minx, maxy); // Bottom left
           this.vertex[3] = new Vector2(maxx, maxy); // Bottom right
           
           this.checkCollision(entities[0]);
           this.checkCollision(entities[1]);
       }
    }
    
    this.checkCollision = function(pipeline)
    {
        for(var i = 0; i < this.vertex.length; i++)
        {
            var vx = this.vertex[i].x;
            var vy = this.vertex[i].y;
            if(vx >= pipeline.scrollX && vx < pipeline.scrollX + 52
                    && (vy < pipeline.gapY-50 || vy > pipeline.gapY+50))
            {
                SetNewState(GameStates.GAMEOVER);
            }
        }
    }
    
    this.applyImpulse = function()
    {
        this.v0 = -30;
        this.h0 = this.position.y;
        this.time = 0;
    }
    
    this.draw = function()
    {
        context.drawImage(this.textures[this.currentFrame], 
        this.position.x - this.textures[0].width/2,
        this.position.y - this.textures[0].height/2);
    }    
    
    //Reset metodo
    this.reset = function()
    {
        this.position.y = this.h0;
        this.time = 0.0;
    }
    
}

