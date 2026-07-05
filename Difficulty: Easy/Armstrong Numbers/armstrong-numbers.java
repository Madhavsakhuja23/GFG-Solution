class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int m = n;
        int ans = 0;
        while(n>0){
            ans=ans+(int)Math.pow(n%10, 3);
            n=n/10;
        }
        return m==ans;
    }
}