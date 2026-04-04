class LFUCache {
    int cap;
    HashMap<Integer, Node[]> map;
    HashMap<Integer, Integer> counterMap;
    HashMap<Integer, Node> addMap;
    int lfuCount;
   
    public LFUCache(int cap) {
        this.cap = cap;
        this.map = new HashMap<Integer,Node[]>();
        counterMap = new HashMap<>();
        addMap = new HashMap<>();
        lfuCount = 1;
    }

    public int get(int key ) {
        if(cap <= 0 || !counterMap.containsKey(key)){
            return -1;
        }
        changeLocation(key, addMap.get(key).value);
        return addMap.get(key).value;
    }
        
    public void changeLocation(int key, int value){
        Node n = new Node(key, value);
        int cnt = counterMap.get(key);
        Node start = map.get(cnt)[0];
        Node end = map.get(cnt)[1];
        deleteNode(addMap.get(key));
        if (start.next == end && lfuCount == cnt) {
            lfuCount++;
        }
        if(!map.containsKey(cnt+1)){
            start = new Node(-1,-1);
            end = new Node(-1, -1);
            start.next = end;
            end.prev = start;
            map.put(cnt+1, new Node[]{start, end});
        }else{
            start = map.get(cnt+1)[0];
            end = map.get(cnt+1)[1];
        }
        addNodeAtStart(start, n);
        counterMap.put(key, cnt+1);
        addMap.put(key, n);
    }
    
    public void put(int key, int value) {
        if(cap == 0)
            return;
        if(addMap.containsKey(key)){
            changeLocation(key, value);
        }else{
            if(counterMap.size() == cap){
                Node[] nodeAdd = map.get(lfuCount);
                Node nodeToEvict = nodeAdd[1].prev;
                deleteNode(nodeToEvict);
                addMap.remove(nodeToEvict.key);
                counterMap.remove(nodeToEvict.key);
            }
            
            lfuCount = 1;
            Node n = new Node(key, value);
            
            if(!map.containsKey(1)){
                map.put(1, new Node[2]);
                Node start = new Node(-1,-1);
                Node end = new Node(-1, -1);
                start.next = end; 
                end.prev = start;
                map.put(1, new Node[]{start, end});
            }
            addNodeAtStart(map.get(1)[0], n);
            addMap.put(key, n);
            counterMap.put(key, 1);
        }
    }
        
    public void putNew(int key, int value) {
        if (cap == 0) return;

        if (addMap.containsKey(key)) {
            changeLocation(key, value);
        } else {
            if (addMap.size() == cap) {
                // Evict the LRU node from the LFU list
                Node[] nodes = map.get(lfuCount);
                Node nodeToEvict = nodes[1].prev; // nodes[1] is 'end'
                deleteNode(nodeToEvict);
                addMap.remove(nodeToEvict.key);
                counterMap.remove(nodeToEvict.key);
            }
            
            // New item always starts at frequency 1
            lfuCount = 1; 
            Node newNode = new Node(key, value);
            
            // Ensure freq 1 list exists
            if (!map.containsKey(1)) {
                Node s = new Node(-1, -1), e = new Node(-1, -1);
                s.next = e; e.prev = s;
                map.put(1, new Node[]{s, e});
            }
            
            addNodeAtStart(map.get(1)[0], newNode);
            addMap.put(key, newNode);
            counterMap.put(key, 1);
    }
}
    
    public void deleteNode(Node node){
        Node previous = node.prev;
        previous.next = node.next;
        node.next.prev = previous;
        node = null;
    }
    
    public void addNodeAtStart(Node head, Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
class Node{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}