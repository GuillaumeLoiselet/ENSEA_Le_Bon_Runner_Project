import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    private long timeDuringLastUpdate = 0;
    private long timeSinceLastSwitch = 0;

    public Hero(double x, double y, String path, int attitude, int index, double frameDuration, int maxIndex, int sizeX, int sizeY, int offsetX, int offsetY) {
        super(x, y, path, attitude, index, frameDuration, maxIndex, sizeX, sizeY, offsetX, offsetY);
    }

    public void update(long time){
    this.timeSinceLastSwitch = this.timeSinceLastSwitch + time - this.timeDuringLastUpdate;
        if(this.timeSinceLastSwitch>this.frameDuration){
            if(this.index<this.maxIndex) {
                this.index = this.index + 1;
            }else{
                this.index =  1;
            }
            switch(index){
                case 1:
                    this.getImage().setViewport(new Rectangle2D(15,0,this.sizeX,this.sizeY));
                    break;
                case 2:
                    this.getImage().setViewport(new Rectangle2D(95,0,this.sizeX,this.sizeY));
                    break;
                case 3:
                    this.getImage().setViewport(new Rectangle2D(175,0,this.sizeX,this.sizeY));
                    break;
                case 4:
                    this.getImage().setViewport(new Rectangle2D(255,0,this.sizeX,this.sizeY));
                    break;
                case 5:
                    this.getImage().setViewport(new Rectangle2D(335,0,this.sizeX,this.sizeY));
                    break;
                case 6:
                    this.getImage().setViewport(new Rectangle2D(430,0,this.sizeX,this.sizeY));
                    break;
            }
            this.timeSinceLastSwitch = 0;
        }
    this.timeDuringLastUpdate = time;
    }
}
