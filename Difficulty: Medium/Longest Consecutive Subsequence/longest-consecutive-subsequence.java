class Solution {
    public int longestConsecutive(int[] arr) {
        // code here
        int cnt = 1;
        int maxCnt = 1;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if (arr[i] == arr[i + 1]) {
                continue;
            }
            if (arr[i] + 1 == arr[i + 1]) {
                cnt++;
            }else{
                maxCnt=Math.max(maxCnt, cnt);
                cnt=1;
            }
        }
        maxCnt=Math.max(maxCnt, cnt);
        return maxCnt;
    }
}