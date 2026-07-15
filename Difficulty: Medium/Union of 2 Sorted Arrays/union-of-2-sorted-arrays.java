class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        int i=0;
        int j= 0;
        int n1 = a.length;
        int n2 = b.length;
        
        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                set.add(a[i++]);
            }else{
                set.add(b[j++]);
            }
        }
        while(i<n1){
            set.add(a[i++]);
        }
        while(j<n2){
            set.add(b[j++]);
        }
        for(int it: set){
            arr.add(it);
        }
        return arr;
    }
}
