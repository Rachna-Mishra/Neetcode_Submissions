class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            int j = i+1;
            int k = n-1;
            int remSum = 0 - nums[i];
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while(j < k){
                if(nums[j] + nums[k] == remSum){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    while(++j < k && nums[j] == nums[j-1]);
                    while(--k > j && nums[k] == nums[k+1]);
                }
                else if(nums[j] + nums[k] < remSum){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return result;
    }
}
