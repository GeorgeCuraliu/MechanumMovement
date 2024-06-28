import java.util.ArrayList;

public class Main {
    static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) {
        Wheels wheels = new Wheels(3,10,10);
        points.add(new Point(1,1));
        points.add(new Point(2,4));
        points.add(new Point(3,2));
        points.add(new Point(6,1));

        PathGen testPathGen = new PathGen(points);
        System.out.println(testPathGen.getDistances());

        PathVisualRepresentation path = new PathVisualRepresentation();
        path.Start();


    }

}