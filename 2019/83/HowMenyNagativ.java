package 2019.83;

public class HowMenyNagativ {
    public static int HowMenyNagativ (int arr[][]) {
        int i=0;
        int j=arr[i].length-1;
        int count=0
        while (i < arr.length && j > -1) {
            if (arr[i][j] < 0 ){
                count += j+1;
                i++;
            }
            else j--;

        }
    }
}
