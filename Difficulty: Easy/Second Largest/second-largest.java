class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest = -1;
        int secondLargest = -1;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(largest<arr[i]){
                
                secondLargest = largest;
                largest=arr[i];
                
            }
            else if(arr[i] < largest && arr[i]>secondLargest){
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }
}