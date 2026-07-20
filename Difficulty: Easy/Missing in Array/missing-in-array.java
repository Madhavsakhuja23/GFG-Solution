class Solution {
    int missingNum(int arr[]) {
        // code here
        long n  = arr.length +1;
        long s =0 ;
        for(int i=0;i<n-1;i++){
            s=s+(long)arr[i];
        }
        return (int)(((n*(n+1))/2 )-s);
    }
}