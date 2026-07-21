class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            int num = arr[i];
            while(!st.isEmpty() && num>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(num);
            }
            st.push(num);
        }
        Collections.reverse(ans);
        return ans;
    }
}
