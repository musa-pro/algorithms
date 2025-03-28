package MergeSort;

/***
// It uses divide and conquer technique.  
// Merge sort is a stable sorting algorithm, which means it maintains the relative order of equal elements in the input array.  
// Merge Sort is Slower than QuickSort in general as QuickSort is more cache friendly because it works in-place.  
// It requires additional memory.
// ================================
// Time complexity = nlogn  
// Space complexity = O(n)
*/
public class MergeSort{

    public static void printArray(int[] myArray){

        for(int i=0; i<myArray.length;i++){
            System.out.print(myArray[i] + " ");
        }

    }

    public static void mergeSort(int[] arr){

        if(arr.length <= 1) return;


        int m = arr.length/2;

        int[] leftArray = new int[m];
        int[] rightArray = new int[arr.length-m];


        int i  = 0;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        // copy values to left array
        for(;i<m;i++){
            leftArray[leftArrayIndex] = arr[i];
            leftArrayIndex++;
        }

        //copy value to right array
        for(;i<arr.length;i++){
            rightArray[rightArrayIndex] = arr[i];
            rightArrayIndex++;
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(leftArray, rightArray, arr);

    }

    public static void merge(int[] leftA, int[] rightA, int[] arr){

        int ll = leftA.length;
        int rl = rightA.length;

        int i = 0;
        int l = 0;
        int r = 0;

        //compare and merge
        while(l<ll && r<rl){
            if(leftA[l] < rightA[r]){
                arr[i] = leftA[l];
                i++;
                l++;
            }else{
                arr[i] = rightA[r];
                i++;
                r++;
            }
        }

        //if any item left in left array, just copy it to main array
        while(l<ll){
            arr[i] = leftA[l];
            i++;
            l++;
        }

        //if any item left in right array, just copy it to main array
        while(r<rl){
            arr[i] = rightA[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args){
        int[] arr = {5,3,0,1,4,2,6,7,3};
        System.out.println("Before sort: ");
        printArray(arr);

        mergeSort(arr);

        System.out.println("After sort: ");
        printArray(arr);


    }
}
