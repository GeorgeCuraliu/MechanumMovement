import java.util.ArrayList;

public class PathGen {

    static ArrayList<Point> startingPoints = new ArrayList<>();
    static ArrayList<Double> distances = new ArrayList<>();

    static ArrayList<Double> tensions = new ArrayList<>();


    public PathGen(ArrayList<Point> arr){
        startingPoints = arr;
        for(int i = 0; i<startingPoints.size()-1; i++)
            distances.add(dist(startingPoints.get(i + 1), startingPoints.get(i)));
    }
    private static double dist(Point a, Point b){
        return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
    }
    public ArrayList<Double> getDistances(){
        return distances;
    }
}
