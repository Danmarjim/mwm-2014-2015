function Ground (initPosX)
{
    //attributes
    this.texture = new Image();
    this.texture.src = textureFolder + 'ground.png';
    
    this.initPosX= initPosX;
    this.scrollX=this.initPosX;
    
    //methods
    this.update = function (frameTime)
    {
        if(state==gameStates.GAMEPLAY){
            this.scrollX= (this.scrollX-1);
            if (this.scrollX< -this.texture.width)
            {
                this.scrollX=this.texture.width;
            }
        }
    };
    
    this.draw = function ()
    {
        context.drawImage(this.texture,this.scrollX,412);
    };
    
    this.reset = function ()
    {
        this.scrollX=initPosX;
    };
    
}


