import java.util.ArrayList;

public class PathGen {

    static ArrayList<Point> startingPoints = new ArrayList<>();
    static ArrayList<Double> distances = new ArrayList<>();
    static ArrayList<Double> tensions = new ArrayList<>();

    static ArrayList<ArrayList<Point>> finalPoints = new ArrayList<>();

    double alpha = 0.5;
    double amount = 0;

    Point m1 = new Point(0,0);
    Point m2 = new Point(0,0);

    Point a = new Point(0,0);
    Point b = new Point(0,0);
    Point c = new Point(0,0);
    Point d = new Point(0,0);



    public PathGen(ArrayList<Point> spRef){
        startingPoints = spRef;
        for(int i = 0;i<startingPoints.size(); i++)
            tensions.add(1.0);
        for(int i = 0; i<startingPoints.size()-1; i++)
            distances.add(dist(startingPoints.get(i + 1), startingPoints.get(i)));

        for(int i = 0; i<startingPoints.size()-3; i++){
            Point tempPoint = new Point(0,0);
            Double t0 = 0d;
            Double t1 = t0 + Math.pow(dist(startingPoints.getFirst(), startingPoints.get(1)), alpha);
            Double t2 = t1 + Math.pow(dist(startingPoints.get(1), startingPoints.get(2)), alpha);
            Double t3 = t2 + Math.pow(dist(startingPoints.get(2), startingPoints.get(3)), alpha);

            m1.x = (1 - tensions.get(i)) * (t2 - t1) * ((startingPoints.get(0).x - startingPoints.get(1).x) / (t0 - t1) - (startingPoints.get(0).x - startingPoints.get(2).x) / (t0 - t2) + (startingPoints.get(1).x - startingPoints.get(2).x) / (t1 - t2));
            m1.y = (1 - tensions.get(i)) * (t2 - t1) * ((startingPoints.get(0).y - startingPoints.get(1).y) / (t0 - t1) - (startingPoints.get(0).y - startingPoints.get(2).y) / (t0 - t2) + (startingPoints.get(1).y - startingPoints.get(2).y) / (t1 - t2));

            m2.x = (1 - tensions.get(i)) * (t2 - t1) * ((startingPoints.get(1).x - startingPoints.get(2).x) / (t1 - t2) - (startingPoints.get(1).x - startingPoints.get(3).x) / (t1 - t3) + (startingPoints.get(2).x - startingPoints.get(3).x) / (t2 - t3));
            m2.y = (1 - tensions.get(i)) * (t2 - t1) * ((startingPoints.get(1).y - startingPoints.get(2).y) / (t1 - t2) - (startingPoints.get(1).y - startingPoints.get(3).y) / (t1 - t3) + (startingPoints.get(2).y - startingPoints.get(3).y) / (t2 - t3));

            a.x = 2 * startingPoints.get(1).x - 2 * startingPoints.get(2).x + m1.x + m2.x;
            a.y = 2 * startingPoints.get(1).y - 2 * startingPoints.get(2).y + m1.y + m2.y;
            b.x = -3 * startingPoints.get(1).x + 3 * startingPoints.get(2).x - 2 * m1.x - m2.x;
            b.y = -3 * startingPoints.get(1).y + 3 * startingPoints.get(2).y - 2 * m1.y - m2.y;
            c.x = m1.x;
            c.y = m1.y;
            d.x = startingPoints.get(1).x;
            d.y = startingPoints.get(1).y;
            amount = Math.max(10, Math.ceil(dist(startingPoints.get(0), startingPoints.get(1)) / 10));

            finalPoints.add(new ArrayList<>());

            for(int j = 1; j<=amount; j++){
                double t = j / amount;
                tempPoint.x = a.x*t*t*t+b.x*t*t+c.x*t+d.x;
                tempPoint.y = a.y*t*t*t+b.y*t*t+c.y*t+d.y;

                finalPoints.get(i).add(tempPoint);
            }
        }
    }
    private static double dist(Point a, Point b){
        return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
    }
    public ArrayList<Double> getDistances(){
        return distances;
    }
    public ArrayList<ArrayList<Point>> getFinalPoints(){return finalPoints;}
}
