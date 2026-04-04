class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freqElements = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                if(p1.val == p2.val){
                    return Integer.compare(p2.key, p1.key);
                }
                return Integer.compare(p1.val, p2.val);
            }
        });
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.add(new Pair(entry.getKey(), entry.getValue()));
            if(queue.size() > k){
                queue.remove();
            }
        }
        int ind = 0;
        while(!queue.isEmpty()){
            freqElements[ind++] = queue.remove().key;
        }
        return freqElements;
    }
}
class Pair{
    int key;
    int val;
    public Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}
