class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            int other = target - nums[i];
            if(map.containsKey(other) && map.get(other) != i){
                result[0] = Math.min(i, map.get(other));
                result[1] = Math.max(i, map.get(other));
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
