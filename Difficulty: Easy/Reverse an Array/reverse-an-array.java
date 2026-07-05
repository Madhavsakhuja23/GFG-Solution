class Solution {
    public void reverseArray(int arr[]) {
        // code here
        solve(arr, 0);
    }
    public void solve(int arr[], int i){
        if(i>=arr.length/2){
            return;
        }
        int tmp = arr[i];
        arr[i]=arr[arr.length-1-i];
        arr[arr.length-1-i] = tmp;
        solve(arr,i+1);
    }
}