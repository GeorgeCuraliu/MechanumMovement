import java.util.ArrayList;

public class HalfMinePF {

    private ArrayList<Point> PointsList = new ArrayList<>();
    private ArrayList<Double> DistancesList = new ArrayList<>();
    private ArrayList<ArrayList<Double>> build_PointsList = new ArrayList<>();
    private int iterations = 0;

    HalfMinePF(int Iterations){
        iterations = Iterations;
    }

    public HalfMinePF AddPoint(int x, int y){
        PointsList.add(new Point(x, y));
        return this;
    }
    public HalfMinePF AddPoint(int x, int y, boolean dynamic){
        PointsList.add(new Point(x, y, dynamic));
        return this;
    }

    public void Build(){

        for(int i = 0; i<=iterations; i++){
            PointsList = PathIteration(PointsList);
        }
        GenerateOutput();

        System.out.println("Build points-x-y");
        for (Point point : PointsList) {
            System.out.println(point.x + " " + point.y);
        }
    }

    private void GenerateOutput(){
        for(int j=0; j<PointsList.size(); j++){
            ArrayList<Double> temp = new ArrayList<>();
            temp.add(PointsList.get(j).x);
            temp.add(PointsList.get(j).y);
            build_PointsList.add(temp);

            if(j<PointsList.size()-1) {
                double distance = Math.sqrt(Math.pow(PointsList.get(j + 1).x - PointsList.get(j).x, 2) + Math.pow(PointsList.get(j + 1).y - PointsList.get(j).y, 2));
                DistancesList.add(distance);
            }
        }
    }

    private ArrayList<Point> PathIteration(ArrayList<Point> InputPoints){
        ArrayList<Point> OutputPoints = new ArrayList<>();
        for(int j = 0; j < InputPoints.size()-1; j++){
            if(!InputPoints.get(j).dynamic){
                OutputPoints.add(InputPoints.get(j));
            }
            double x = (InputPoints.get(j).x + InputPoints.get(j+1).x)/2;
            double y = (InputPoints.get(j).y + InputPoints.get(j+1).y)/2;
            OutputPoints.add(new Point(x, y));
        }

        if(!InputPoints.getLast().dynamic){
            OutputPoints.add(InputPoints.getLast());
        }

        return OutputPoints;
    }

}
