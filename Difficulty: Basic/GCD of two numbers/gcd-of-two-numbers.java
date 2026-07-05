class Solution {
    public static int gcd(int a, int b) {
        // code here
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}
