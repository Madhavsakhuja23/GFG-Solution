class Solution {
    static boolean isPrime(int n) {
        // code here
        if(n<2){
            return false;
        }
        if(n%2==0){
            if(n==2){
                return true;
            }
            return false;
        }
        for(int i=3;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}