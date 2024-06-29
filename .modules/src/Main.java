import java.util.ArrayList;

public class Main {
    static ArrayList<Point> startPoints = new ArrayList<>();
    static ArrayList<Double> distances = new ArrayList<>();
    static ArrayList<ArrayList<Point>> finalPoints = new ArrayList<>();
    public static void main(String[] args) {

        startPoints.add(new Point(1,1));
        startPoints.add(new Point(2,2));
        startPoints.add(new Point(3,2));
        startPoints.add(new Point(4,3));
        startPoints.add(new Point(5,5));
        startPoints.add(new Point(6,4));
        startPoints.add(new Point(7,4));
        startPoints.add(new Point(8,4));
        startPoints.add(new Point(9,4));
        startPoints.add(new Point(10,4));
        startPoints.add(new Point(11,4));
        startPoints.add(new Point(12,4));


        Wheels wheels = new Wheels(3,10,10);

        for(int i = 0; i<startPoints.size()-1; i++){
            distances.add(PathGen.dist(startPoints.get(i),startPoints.get(i+1)));
        }

        PID controller = new PID(startPoints, distances, new double[]{0.1, 0.5, 0.06});
        System.out.println(controller.calcOutput(2,11));








    }

    public void test(){
//        startPoints.add(new Point(1,2));
//        startPoints.add(new Point(1.5,1));
        startPoints.add(new Point(0.3,-9.94));
        startPoints.add(new Point(-1.6,1.2));
        startPoints.add(new Point(10,10));
        startPoints.add(new Point(15,-9));

        PathGen testPathGen = new PathGen(startPoints);
        finalPoints = testPathGen.getFinalPoints();

//        for(int i = 0; i<finalPoints.size(); i++){
//            for(int j = 0; j<finalPoints.getFirst().size(); j++)
//                System.out.println(finalPoints.get(i).get(j).x+" "+finalPoints.get(i).get(j).y+" | ");
//            System.out.println("\n");
//        }

        int sizeOfArr = 4;

        GFG calc = new GFG(sizeOfArr);
        float[][] inv = new float[startPoints.size()][startPoints.size()];
        float[][] floatArr1 =  new float[startPoints.size()][startPoints.size()];
        float[][] floatArr2 =  new float[startPoints.size()][startPoints.size()];
        float[][] floatArr3 =  new float[startPoints.size()][startPoints.size()];
        float[][] floatArr4 =  new float[startPoints.size()][startPoints.size()];
        float[][] floatArr5 =  new float[startPoints.size()][startPoints.size()];

// A de la inceput
//        for(int i = 0; i<sizeOfArr ; i++)
//            for(int j = 0; j<sizeOfArr ;j++)
//                if(j<3) floatArr[i][j] = (float) (Math.pow((startPoints.get(i).x), 3 - j));
//                else floatArr[i][j] = (float) (Math.pow(startPoints.get(i).y,4-j));

        for(int i = 0; i<sizeOfArr; i++)
            for (int j = 0; j < sizeOfArr; j++) {
                if (j == 0) floatArr1[i][j] = (float) (Math.pow((startPoints.get(i).x), 2));
                if (j == 1) floatArr1[i][j] = (float) (Math.pow((startPoints.get(i).x), 1));
                if (j == 2) floatArr1[i][j] = (float) (Math.pow((startPoints.get(i).y), 1));
                if (j == 3) floatArr1[i][j] = (float) (Math.pow((startPoints.get(i).x), 0));
            }

        for(int i = 0; i<sizeOfArr; i++)
            for(int j = 0; j<sizeOfArr; j++){
                if(j == 0)floatArr2[i][j] = (float) (Math.pow((startPoints.get(i).x), 3));
                if(j == 1)floatArr2[i][j] = (float) (Math.pow((startPoints.get(i).x), 1));
                if(j == 2)floatArr2[i][j] = (float) (Math.pow((startPoints.get(i).y), 1));
                if(j == 3)floatArr2[i][j] = (float) (Math.pow((startPoints.get(i).x), 0));
            }
        for(int i = 0; i<sizeOfArr; i++)
            for(int j = 0; j<sizeOfArr; j++){
                if(j == 0)floatArr3[i][j] = (float) (Math.pow((startPoints.get(i).x), 3));
                if(j == 1)floatArr3[i][j] = (float) (Math.pow((startPoints.get(i).x), 2));
                if(j == 2)floatArr3[i][j] = (float) (Math.pow((startPoints.get(i).y), 1));
                if(j == 3)floatArr3[i][j] = (float) (Math.pow((startPoints.get(i).x), 0));
            }
        for(int i = 0; i<sizeOfArr; i++)
            for(int j = 0; j<sizeOfArr; j++){
                if(j == 0)floatArr4[i][j] = (float) (Math.pow((startPoints.get(i).x), 3));
                if(j == 1)floatArr4[i][j] = (float) (Math.pow((startPoints.get(i).x), 2));
                if(j == 2)floatArr4[i][j] = (float) (Math.pow((startPoints.get(i).x), 1));
                if(j == 3)floatArr4[i][j] = (float) (Math.pow((startPoints.get(i).y), 0));
            }
        for(int i = 0; i<sizeOfArr; i++)
            for(int j = 0; j<sizeOfArr; j++){
                if(j == 0)floatArr5[i][j] = (float) (Math.pow((startPoints.get(i).x), 3));
                if(j == 1)floatArr5[i][j] = (float) (Math.pow((startPoints.get(i).x), 2));
                if(j == 2)floatArr5[i][j] = (float) (Math.pow((startPoints.get(i).x), 1));
                if(j == 3)floatArr5[i][j] = (float) (Math.pow((startPoints.get(i).y), 1));
            }


        calc.display(floatArr1);
        System.out.println("");
        calc.display(floatArr2);
        System.out.println("");
        calc.display(floatArr3);
        System.out.println("");
        calc.display(floatArr4);
        System.out.println("");
        calc.display(floatArr5);


        float a = calc.determinant(floatArr1, sizeOfArr);
        float b = calc.determinant(floatArr2, sizeOfArr);
        float c = calc.determinant(floatArr3, sizeOfArr);
        float d = calc.determinant(floatArr4, sizeOfArr);
        float e = calc.determinant(floatArr5, sizeOfArr);

        System.out.println(a+" "+-b+" "+c+" "+-d+" "+e);

    }

}