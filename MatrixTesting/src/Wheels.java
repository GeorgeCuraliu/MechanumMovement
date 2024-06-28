public class Wheels {
    double bigRadius;

    double[] wheelSpeeds = new double[4];
    double xLength;
    double yLength;

    public Wheels(double bigRadius, double xLength, double yLength){
        this.xLength = xLength;
        this.yLength = yLength;
        this.bigRadius = bigRadius;

//        double[][] a = {{1,-1,-(xLength+yLength)},
//                {1,1,xLength+yLength},
//                {1,1,-(xLength+yLength)},
//                {1,-1,(xLength+yLength)}};
//        double[][] b = {{xSpeed},{ySpeed},{rAngularSpeed}};
    }
    public double[] getSpeeds(double xSpeed, double ySpeed, double rAngularSpeed){
        wheelSpeeds[0] = (xSpeed - ySpeed - (xLength + yLength) * rAngularSpeed) / bigRadius;
        wheelSpeeds[1] = (xSpeed + ySpeed + (xLength + yLength) * rAngularSpeed) / bigRadius;
        wheelSpeeds[2] = (xSpeed + ySpeed - (xLength + yLength) * rAngularSpeed) / bigRadius;
        wheelSpeeds[3] = (xSpeed - ySpeed + (xLength + yLength) * rAngularSpeed) / bigRadius;
        return wheelSpeeds;
    }
}
