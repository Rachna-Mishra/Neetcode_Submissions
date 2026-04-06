class MyHashMap {

    ArrayList<Pair>[] map;
    public MyHashMap() {
        map = new ArrayList[10000];
    }
    
    public void put(int key, int value) {
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
                    p.v = value;
                    flag = 1;
                }
            }
        }
        if(flag == 0)
        map[hval].add(new Pair(key, value));
       // System.out.println("hash "+hval+" "+"val "+map[hval].size());
    }
    
    public int get(int key) {
         int hval = hashCode(key);
         if(map[hval] == null){
            return -1;
         }
         ArrayList<Pair> list = map[hval];
            for(Pair p : list){
                
                if(p.k ==key){
                    return p.v;
                }
            }
        return -1;
    }
    
    public void remove(int key) {
        int hval = hashCode(key);
        if(map[hval] != null){
          //  System.out.println("remoc "+map[hval].size());
            for(int i = 0; i < map[hval].size(); i++){
                Pair p = map[hval].get(i);
                if(p.k == key){
                  //  System.out.println("index "+map[hval].size());
                    map[hval].remove(i);
                    break;
                }
            }
        }
    }

    public int hashCode(int key){
        return key%10000;
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
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */