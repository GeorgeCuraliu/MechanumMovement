public class Point {
    double x;
    double y;
    boolean dynamic = true;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Point(double x, double y, boolean D){
        this.x = x;
        this.y = y;
        this.dynamic = D;
    }


}
