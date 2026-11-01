class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length,i;
        int ans[] = new int[n];

        st.push(n-1);
        ans[n-1] = 0;

        for(i=n-2;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }

            ans[i] = st.isEmpty() ? 0 : st.peek() - i;

            st.push(i);
        }

        return ans;
    }
}
