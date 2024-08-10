public class meetingPint {


    public static int meetingPoint(int[] a, int[] b) {
        int low = 0, 
        mid = 0, 
        minIndex = -1;
        int high = Math.min(a.length - 1, b.length - 1);
        
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == b[mid]) {
                minIndex = mid;
                high = mid - 1;
            } else if (a[mid] > b[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return minIndex;
    }
    
}