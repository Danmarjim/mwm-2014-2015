function Bird (y)
{
    //attributes
    this.textures = new Array();
    this.textures[0] = new Image();
    this.textures[0].src = textureFolder + 'birdOrange0.png';
    this.textures[1] = new Image();
    this.textures[1].src = textureFolder + 'birdOrange1.png';
    this.textures[2] = new Image();
    this.textures[2].src = textureFolder + 'birdOrange2.png';
    this.currentFrame = 0;
    //methods
    //To calculate the height we use the freefall equation
    //Y = h0 + v0 + T - 0.5 *g*T2
    this.h0=y;
    this.v0=-30;
    this.g=-9.8;
    this.time=0.0;
    this.position = new Vector2 (100, this.h0);
    this.vertex = new Array(4);
    
    
    this.update = function (frameTime)
    {
        this.currentFrame= (this.currentFrame+1) % this.textures.length;
        if(state==gameStates.GAMEPLAY)
        {
            //Animation position
            this.time+=frameTime/100;
            this.position.y=this.h0 + (this.v0*this.time-0.5*this.g*Math.pow(this.time,2));
            if(this.position.y>context.canvas.height)//if the bird touch the ground
            {
                setNewState(gameStates.GAMEOVER);
            }
            //Collisions
            var minx = this.position.x - 20; 
            var maxx = this.position.x + 20;
            var miny = this.position.y - 12;
            var maxy = this.position.y + 12;

            this.vertex[0] = new Vector2(minx, miny); //Top Left
            this.vertex[1] = new Vector2(maxx, miny); //Top Right
            this.vertex[2] = new Vector2(minx, maxy); //Bottom Left
            this.vertex[3] = new Vector2(maxx, maxy); //Bottom Right
            this.checkCollision(entities [0]);
            this.checkCollision(entities [1]);
        }
    };
    //Method to make the bird to fly
    this.applyBirdImpulse = function ()
    {
        this.v0 = -30;
        this.h0 = this.position.y;
        this.time = 0.0;
    }
    //Method to check colllision against the pipeline
    this.checkCollision = function(pipeline)
    {
        for(var i = 0; i < this.vertex.length; i++)
        {
            var vx = this.vertex[i].x;
            var vy = this.vertex[i].y;
            if(vx >= pipeline.scrollX && vx < pipeline.scrollX + 52
                    && (vy < pipeline.gapY-50 || vy > pipeline.gapY+50))
            {
                setNewState(gameStates.GAMEOVER);
            }
        }
    }
    
    this.draw = function ()
    {
        context.drawImage(this.textures[this.currentFrame],
                          // ensuring the texture goes on the middle
                          this.position.x - this.textures[0].width/2,
                          this.position.y - this.textures[0].height/2);
    };
    this.reset = function ()
    {
        this.position.y=this.h0;
        this.time = 0.0;
    };
}





