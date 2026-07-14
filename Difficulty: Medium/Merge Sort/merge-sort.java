class Solution {
    public void mergeSort(int arr[], int l, int r) {
        // code here
        if(l<r){
            int mid = l+ (r-l)/2;
            mergeSort(arr,l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr,l,r,mid);
        }
    }
    public void merge(int arr[], int l, int r, int mid){
        int left=l;
        int right = mid+1;
        ArrayList<Integer> ar = new ArrayList<>();
        while(left<=mid && right <=r){
            if(arr[left]<arr[right]){
                ar.add(arr[left++]);
            }else{
                ar.add(arr[right++]);
            }
        }
        while(left<=mid){
            ar.add(arr[left++]);
        }
        while(right<=r){
            ar.add(arr[right++]);
        }
        for(int i=0;i<ar.size();i++){
            arr[i+l] = ar.get(i);
        }
    }
}