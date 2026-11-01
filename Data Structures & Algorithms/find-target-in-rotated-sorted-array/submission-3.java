class Solution {
    public int search(int[] arr, int target) {
        int i,n=arr.length,count=0;

        if(n==1){
            if(target == arr[0])
            return 0;
            else
            return -1;
        }

        for(i=1;i<n;i++){
            if(arr[i-1] > arr[i]){
                count = i;
                break;
            }
        }

        if(count > 0 && (target >= arr[0] && target <= arr[count-1])){
            return binarySearch(0,count-1,arr, target);
        }
        else if(target >= arr[count] && target <= arr[n-1]){
            return binarySearch(count,n-1,arr,target);
        }
        else{
            return -1;
        }
    }

    private int binarySearch(int low, int high, int arr[], int target){
        int mid;

        while(low <= high){
            mid = (low + high) / 2;

            if(arr[mid] < target){
                low++;
            }
            else if(arr[mid] > target){
                high--;
            }
            else{
                return mid;
            }
        }

        return -1;
    }
}
