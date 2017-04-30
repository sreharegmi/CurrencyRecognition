package ExamplesTryOpebCV;

/**
 * Created by Shreha on 4/30/2017.
 */
public class Main {
    public static void main(String[] args)
    {
        double topleftpixels[][]=new double[5][6];
        double toprightpixels[][]=new double[4][6];
        double bottomleftpixels[][]=new double[2][6];
        double bottomrightpixels[][]=new double[1][6];

        int row=topleftpixels.length+toprightpixels.length+bottomleftpixels.length+bottomrightpixels.length;
        int col=topleftpixels[0].length;

        double merge[][]=new double[row][col];

        int rowcount=0;
        for (int i=0;i<topleftpixels.length;i++){
            for (int j=0; j<topleftpixels[0].length;j++){
                merge[rowcount][j]=topleftpixels[i][j];
            }
            rowcount++;
        }
        for (int i=0;i<toprightpixels.length;i++){
            for (int j=0; j<toprightpixels[0].length;j++){
                merge[rowcount][j]=toprightpixels[i][j];
            }
            rowcount++;
        }

        for (int i=0;i<bottomleftpixels.length;i++){
            for (int j=0; j<bottomleftpixels[0].length;j++){
                merge[rowcount][j]=bottomleftpixels[i][j];
            }
            rowcount++;
        }


        for (int i=0;i<bottomrightpixels.length;i++){
            for (int j=0; j<bottomrightpixels[0].length;j++){
                merge[rowcount][j]=bottomrightpixels[i][j];
            }
            rowcount++;
        }
    }
}
