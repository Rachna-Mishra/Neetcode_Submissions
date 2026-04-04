class FreqStack {
    HashMap<Integer, Integer> numFreqMap ;
    PriorityQueue<Pair> pq;
    int seq ;
    public FreqStack() {
        seq = 0;
        numFreqMap = new HashMap<Integer, Integer>();
        pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                if(p1.freq == p2.freq){
                    return p2.seq - p1.seq;
                }
                return p2.freq - p1.freq;
            }
        });
    }
    
    public void push(int val) {
        int freq = 0;
        if(numFreqMap.containsKey(val)){
            freq = numFreqMap.get(val);
        }
        Pair p = new Pair(val, ++seq, ++freq);
        pq.add(p);
        numFreqMap.put(val, freq);
    }
    
    public int pop() {
        Pair p = pq.remove();
        numFreqMap.put(p.num, p.freq-1);
        return p.num;
    }
}
class Pair{
    int num;
    int seq;
    int freq;
    Pair(int num, int seq, int freq){
        this.num = num;
        this.seq = seq;
        this.freq = freq;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */