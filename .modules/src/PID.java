import java.util.ArrayList;

public class PID {
    ArrayList<Double> pDistances = new ArrayList<>();
    ArrayList<Point> points = new ArrayList<>();

    double p;
    double i;
    double d;

    double output = 0;

    public PID(ArrayList<Point> points, ArrayList<Double> pDistances , double[]terms ){
        this.points = points;
        this.pDistances = pDistances;
        this.p = terms[0];
        this.i = terms[1];
        this.d = terms[2];
    }
    public Point max(Point a, Point b){
        Point m = new Point(0,0);
        m.y = Math.max(a.y,b.y);
        if(m.y == a.y)m.x = a.x;
        if(m.y == b.y)m.x = b.x;
        return m;
    }
    public Point min(Point a, Point b){
        Point m = new Point(0,0);
        m.y = Math.min(a.y,b.y);
        if(m.y == a.y)m.x = a.x;
        if(m.y == b.y)m.x = b.x;
        return m;
    }
    public double slope(Point a, Point b){
        return (a.y-b.y)/(a.x - b.x);
    }
    public double calcErr(int rId , int vId){
        double temp = 0;
        for(int i = rId ; i<vId ; i++)
            temp+=pDistances.get(i);
        return temp;
    }
    private double calcInt(int rId, int vId){
        double temp = 0;
        for(int i = rId ; i<vId ; i++) {
            temp+=(points.get(i).y+points.get(i+1).y)*(max(points.get(i),points.get(i+1)).x-min(points.get(i),points.get(i+1)).x)/2.0;
        }
        System.out.println(temp);
        return temp;
    }
    private double calcDeriv(int rId, int vId){
        return slope(points.get(rId),points.get(vId));
    }
    public double calcOutput(int rId , int vId){
        output = p*calcErr(rId, vId)+i*calcInt(rId,vId) + d*calcDeriv(rId,vId);
        return output;
    }
}
