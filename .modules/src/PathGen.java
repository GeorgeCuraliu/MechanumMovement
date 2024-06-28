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
            tensions.add(0.5);
        for(int i = 0; i<startingPoints.size()-1; i++)
            distances.add(dist(startingPoints.get(i + 1), startingPoints.get(i)));

        for(int i = 1; i<startingPoints.size()-2; i++){
            Double t0 = 0d;
            Double t1 = t0 + Math.pow(dist(startingPoints.get(i-1), startingPoints.get(i)), alpha);
            Double t2 = t1 + Math.pow(dist(startingPoints.get(i), startingPoints.get(i+1)), alpha);
            Double t3 = t2 + Math.pow(dist(startingPoints.get(i+1), startingPoints.get(i+2)), alpha);

            m1.x = (1 - tensions.get(i)) * (t2 - t1) * ((startingPoints.get(i-1).x - startingPoints.get(i).x) / (t0 - t1) - (startingPoints.get(i-1).x - startingPoints.get(i+1).x) / (t0 - t2) + (startingPoints.get(i).x - startingPoints.get(i+1).x) / (t1 - t2));
            m1.y = (1 - tensions.get(i)) * (t2 - t1) * ((startingPoints.get(i-1).y - startingPoints.get(i).y) / (t0 - t1) - (startingPoints.get(i-1).y - startingPoints.get(i+1).y) / (t0 - t2) + (startingPoints.get(i).y - startingPoints.get(i+1).y) / (t1 - t2));

            m2.x = (1 - tensions.get(i)) * (t2 - t1) * ((startingPoints.get(i).x - startingPoints.get(i+1).x) / (t1 - t2) - (startingPoints.get(i).x - startingPoints.get(i+2).x) / (t1 - t3) + (startingPoints.get(i+1).x - startingPoints.get(i+2).x) / (t2 - t3));
            m2.y = (1 - tensions.get(i)) * (t2 - t1) * ((startingPoints.get(i).y - startingPoints.get(i+1).y) / (t1 - t2) - (startingPoints.get(i).y - startingPoints.get(i+2).y) / (t1 - t3) + (startingPoints.get(i+1).y - startingPoints.get(i+2).y) / (t2 - t3));

            a.x = 2 * startingPoints.get(i).x - 2 * startingPoints.get(i+1).x + m1.x + m2.x;
            a.y = 2 * startingPoints.get(i).y - 2 * startingPoints.get(i+1).y + m1.y + m2.y;
            b.x = -3 * startingPoints.get(i).x + 3 * startingPoints.get(i+1).x - 2 * m1.x - m2.x;
            b.y = -3 * startingPoints.get(i).y + 3 * startingPoints.get(i+1).y - 2 * m1.y - m2.y;
            c.x = m1.x;
            c.y = m1.y;
            d.x = startingPoints.get(i).x;
            d.y = startingPoints.get(i).y;



//            System.out.println(a.x+" "+a.y+" | "+b.x+" "+b.y+" | "+c.x+" "+c.y+" | "+d.x+" "+d.y+"\n");

            amount = Math.max(5, Math.ceil(dist(startingPoints.get(i-1), startingPoints.get(i)) / 10.0));

            ArrayList<Point> tempArr = new ArrayList<>();

            for(int j = 1; j<=amount; j++){
                double t = j / amount;
                Point tempPoint = new Point(0,0);
                tempPoint.x = a.x*t*t*t+b.x*t*t+c.x*t+d.x;
                tempPoint.y = a.y*t*t*t+b.y*t*t+c.y*t+d.y;

                tempArr.add(tempPoint);
            }
            finalPoints.add(tempArr);
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
