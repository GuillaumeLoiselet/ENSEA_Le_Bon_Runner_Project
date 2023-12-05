import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {
    protected double x;
    protected double y;
    protected ImageView imageView;
    protected int attitude;
    protected int index;
    protected double frameDuration;
    protected int maxIndex;
    protected int sizeX;
    protected int sizeY;
    protected int offsetX;
    protected int offsetY;

    public AnimatedThing(double x, double y, String path, int attitude, int index, double frameDuration, int maxIndex, int sizeX, int sizeY, int offsetX, int offsetY) {
        this.x = x;
        this.y = y;
        Image imageView  = new Image(path);
        this.imageView = new ImageView(imageView);
        this.attitude = attitude;
        this.index = index;
        this.frameDuration = frameDuration;
        this.maxIndex = maxIndex;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public ImageView getImage() {
        return imageView;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
