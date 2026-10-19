// -- Leetcode 2089 -- 
// -- Find Target Indices After Sorting Array -- 


APPROACH I:
  // Using Implementation of QuickSort 
  
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        int small=0, cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]<target){
                small++;
            }
            if(nums[i] == target){
                cnt++;
            }
        }
        if(cnt == 0){
            return list;
        }
        for(int i=1;i<=cnt;i++){
            list.add(small++);
        }
        return list;
        
    }
}


APPROACH II: 
  // Using implementation of QuictSort 
  
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        quickSort(nums,0,nums.length-1);

        List<Integer> list=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                list.add(i);
            }
        }
        return list;
    }

    static int partition(int[] arr, int low, int high){

        // choose the pivot
        int pivot = arr[high];

        // index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // swap function
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // the QuickSort function implementation
    static void quickSort(int[] arr, int low, int high){
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
 
}
