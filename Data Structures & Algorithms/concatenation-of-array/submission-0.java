class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] newNum = new int[2*n];
        for(int i = 0; i<n; i++){
            newNum[i] =  nums[i];
            newNum[i+n] = nums[i];
        }
        return newNum;
    }
}