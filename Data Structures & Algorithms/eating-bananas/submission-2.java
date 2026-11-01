class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 1;
        int high = arr[n-1];
        int mid, ans=-1;

        while(low <= high){
            mid = (low + high) / 2;

            if(hoursTaken(mid,arr) <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;

    }

    private long hoursTaken(int mid, int[] arr){
        long h = 0;

        for(int i = 0; i < arr.length; i++){
            h += (arr[i] + (long)mid - 1) / mid;
        }

        return h;
    }
}
