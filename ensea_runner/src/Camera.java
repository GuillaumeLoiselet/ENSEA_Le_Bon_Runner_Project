public class Camera {
    private int x;
    private int y;
    private double xheros;
    private double yheros;
    private double deltat = 0.016;
    private double vx = 0;
    private double ax = 0;
    private double deltax = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getXheros() {
        return xheros;
    }

    public double getYheros() {
        return yheros;
    }

    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXheros(double xheros) {
        this.xheros = xheros;
    }

    public void setYheros(double yheros) {
        this.yheros = yheros;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }

    public void update(long time){
        this.ax = 30*(xheros-x) + 3*vx;
        this.vx = ax*deltat;
        this.deltax = (vx*deltat);
        this.xheros = (int) (this.xheros - this.deltax);
    }
}
