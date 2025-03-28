
/***
 * Time Complexity = O(log n)
 * Space Complexity  =  O(1)
 * 
 * =================================
 * The array must be sorted
 */
public class BinarySearch {
    
    //search an item and return the index
    public static int bSearch(int[] arr, int start, int end, int item){

        if(start>end) return -1;

        int m = start + (end-start)/2;
        if(arr[m]==item){
            return m;
        }else if(arr[m]<item){
            //look into right half of the array
            start = m+1;
            return bSearch(arr, start, end, item);
        }else{
            //look into the left half of the array
            end = m-1;
            return bSearch(arr, start, end, item);
        }

    }

    public static void main(String[] args){
        int[] arr = {0,5,8,9,14,28,34,68};

        int item = -5;
        int indx = bSearch(arr,0,arr.length-1, item); 
        System.out.println("found in index: "+ indx);
    }
}
