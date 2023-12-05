import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;
import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.animation.AnimationTimer;


public class GameScene extends Scene {
    private Camera camera;
    private StaticThing leftStaticThing;
    private StaticThing rightStaticThing;
    private StaticThing fullLeftStaticThing;
    private int numberofLive = 3;
    private StaticThing coeur1;
    private StaticThing coeur2;
    private StaticThing coeur3;
    private Hero hero;
    private int indiceImage = 1;
    private long timeLastRender = 0;
    private long timeSinceBackgroungChange = 0;
    private int gameSpeed = 4;
    private int k = 0;

    public GameScene(Pane pane,double largeur, double hauteur, Camera camera) {
        super(pane, largeur, hauteur);
        this.camera = camera;
        this.leftStaticThing = new StaticThing(800,400,"./img/desert.png");
        this.rightStaticThing = new StaticThing(800,400,"./img/desert.png");
        this.fullLeftStaticThing = new StaticThing(800,400,"./img/desert.png");
        this.coeur1 = new StaticThing(27,26,"./img/coeur.png");
        this.coeur2 = new StaticThing(27,26,"./img/coeur.png");
        this.coeur3 = new StaticThing(27,26,"./img/coeur.png");
        this.hero = new Hero(800,250,"./img/heros.png",1,1,100000000,6,75,100,0,0);
        leftStaticThing.getImage().setX(0);
        leftStaticThing.getImage().setY(0);
        rightStaticThing.getImage().setX(800);
        rightStaticThing.getImage().setY(0);
        fullLeftStaticThing.getImage().setX(-800);
        fullLeftStaticThing.getImage().setY(0);
        coeur1.getImage().setX(560);
        coeur1.getImage().setY(10);
        coeur2.getImage().setX(530);
        coeur2.getImage().setY(10);
        coeur3.getImage().setX(500);
        coeur3.getImage().setY(10);
        hero.getImage().setViewport(new Rectangle2D(20,0,hero.getSizeX(),hero.getSizeY()));
        hero.getImage().setX(hero.getX());
        hero.getImage().setY(hero.getY());
        timer.start();
        pane.getChildren().addAll(leftStaticThing.getImage(), fullLeftStaticThing.getImage(), rightStaticThing.getImage(), coeur1.getImage(), coeur2.getImage(), coeur3.getImage(), hero.getImage());
    }

    public void Render(){
        if(hero.getX()-k*gameSpeed<-leftStaticThing.getSizeX()) {
            this.fullLeftStaticThing.getImage().setX(hero.getX()-k*gameSpeed);
            this.fullLeftStaticThing.getImage().setY(0);
            this.leftStaticThing.getImage().setX(hero.getX()-k*gameSpeed+leftStaticThing.getSizeX());
            this.leftStaticThing.getImage().setY(0);
            this.rightStaticThing.getImage().setX(hero.getX()-k*gameSpeed+2*leftStaticThing.getSizeX());
            this.rightStaticThing.getImage().setY(0);
            k=(int)(-leftStaticThing.getSizeX()-hero.getX()+k*gameSpeed);
        }else {
            this.fullLeftStaticThing.getImage().setX(hero.getX()-k*gameSpeed-fullLeftStaticThing.getSizeX());
            this.fullLeftStaticThing.getImage().setY(0);
            this.leftStaticThing.getImage().setX(hero.getX() - k * gameSpeed);
            this.leftStaticThing.getImage().setY(0);
            this.rightStaticThing.getImage().setX(rightStaticThing.getSizeX()+hero.getX() - k * gameSpeed);
            this.rightStaticThing.getImage().setY(0);
            k = k + 1;
        }
    }

    AnimationTimer timer = new AnimationTimer(){
        public void handle(long time){
            hero.update(time);
            camera.setXheros(hero.getX());
            camera.update(time);
            hero.getImage().setX(camera.getXheros());
            hero.setX(camera.getXheros());
            update(time);
        }

        public void update(long time){
            timeSinceBackgroungChange = timeSinceBackgroungChange + time - timeLastRender;
            if(timeSinceBackgroungChange>10000000) {
                Render();
                timeSinceBackgroungChange = 0;
            }
            timeLastRender = time;
        }
    };
}
