function Pipeline (initPosX)
{
    //attributes
    this.texture = new Image();
    this.texture.src = textureFolder + 'pipeline.png';
    this.initPosX= initPosX;
    this.scrollX=this.initPosX;
    this.gapY=200;
    this.passed = false;
    
    //methods
    this.update = function (frameTime)
    {
        if(state==gameStates.GAMEPLAY){
            this.scrollX= (this.scrollX-1);
            if (this.scrollX< -this.texture.width)
            {
                this.scrollX=context.canvas.width;
                this.gapY=100 + Math.random()*200;
                this.passed = false;
            }
            
            if (!this.passed && this.scrollX < 50)
            {
                newPointSound.currentTime = 0;
				newPointSound.play();
                
               this.passed = true;
               scores += 1;
            }
        }
    };
    
    this.draw = function ()
    {
        //Down Pipe
        context.drawImage(this.texture,this.scrollX,this.gapY+50);
        
        //Up Pipe (flipping the context)
        var x = this.texture.width + this.scrollX;
        var y = this.gapY - 50; //Keeping a hole of 100 px for crossing
        context.translate(x,y);
        context.rotate(Math.PI); //rotation of 180º
        context.drawImage(this.texture,0,0);
        context.rotate(-Math.PI); //back to the original position
        context.translate(-x,-y);
    };
    
    this.reset = function ()
    {
        this.scrollX=initPosX;
    };
    
}


