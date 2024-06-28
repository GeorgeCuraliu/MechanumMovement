public class Matrix {
    public static double[][] multiply(double[][] arr1, double[][] arr2){
        double[][] ans = new double[arr1.length][arr2[0].length];
        for(int i = 0; i<arr1.length; i++)
            for(int j = 0;j<arr2[0].length;j++) {
                double temp = 0;
                for (int k = 0;k<Math.max(arr1[0].length,arr2[0].length); k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                ans[i][j] = temp;
            }
        return ans;
    }
    public static double determinant(double[][] arr){
        return arr[0][0]*arr[1][1]-arr[0][1]*arr[1][0];
    }
    public static double[][] inverse(double[][] arr){
        double det = determinant(arr);
        return new double[][]{{det*arr[1][1],-det*arr[0][1]},{-det*arr[1][0],det*arr[0][0]}};
    }
    public static double[][] transpose(double[][] arr){
        double[][] ans = new double[arr[0].length][arr.length];
        for(int i=0; i<arr.length; i++)
            for(int j=0; j<arr[0].length; j++)
                ans[j][i] = arr[i][j];
        return ans;
    }
    public static double[][] numMultiply(double[][] arr, double value){
        double[][] ans = new double[arr.length][arr[0].length];
        for(int i = 0; i<arr.length; i++)
            for(int j = 0; j<arr[0].length; j++){
                ans[i][j] = arr[i][j]*value;
            }
        return ans;
    }
}
