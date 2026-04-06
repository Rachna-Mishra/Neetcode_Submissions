class MyHashSet {
    ArrayList<Pair>[] map;
    int size = 10000;
    public MyHashSet() {
        map = new ArrayList[size];
    }
    
    public void add(int key) {
        int flag = 0;
        int hval = hashCode(key);
        if(map[hval] == null){
            map[hval] = new ArrayList<>();
        }
        else{
            ArrayList<Pair> list = map[hval];
            for(int i = 0; i < list.size(); i++){
                Pair p = list.get(i);
                if(p.k == key){
                    p.v = key;
                    flag = 1;
                }
            }
        }
        if(flag == 0)
        map[hval].add(new Pair(key, key));
    }
    
    public void remove(int key) {
        int hval = hashCode(key);
        if(map[hval] != null){
            for(int i = 0; i < map[hval].size(); i++){
                Pair p = map[hval].get(i);
                if(p.k == key){
                    map[hval].remove(i);
                    break;
                }
            }
        }
    }
    
    public boolean contains(int key) {
        int hval = hashCode(key);
         if(map[hval] == null){
           return false;
         }
         ArrayList<Pair> list = map[hval];
            for(Pair p : list){
                if(p.k == key){
                    return true;
                }
            }
        return false;
    }

    private int hashCode(int key){
        return key % size;
    }
}


class Pair{
    int k;
    int v;
    Pair(int k, int v){
        this.k = k;
        this.v = v;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */