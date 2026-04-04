class LRUCache {
    Node start;
    Node end;
    HashMap<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        start = new Node(-1, -1);
        end = new Node(-1, -1);
        map = new HashMap<>();
        start.right = end;
        end.left = start;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node address = map.get(key);
        Node newKey = new Node(address.key, address.value);
        deleteNode(address);
        addNodeAtStart(newKey);
        map.put(key, newKey);
        return address.value;
    }
    
    public void put(int key, int value) {
        Node newKey = new Node(key, value);
        if(map.containsKey(key)){
            Node address = map.get(key);
            deleteNode(address);
            map.remove(key);
        }
        if(map.size() == capacity){
            Node nodeToDelete = end.left;
            deleteNode(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
        addNodeAtStart(newKey);
        map.put(key, newKey);
        System.out.println(map.keySet());
    }

    public void deleteNode(Node node){
        Node leftNode = node.left;
        Node rightNode = node.right;
        leftNode.right = rightNode;
        rightNode.left = leftNode;
    }
    public void addNodeAtStart(Node node){
        Node rightNode = start.right;
        node.right = rightNode;
        rightNode.left = node;
        start.right = node;
        node.left = start;
    }
}
class Node{
    int key;
    int value;
    Node left;
    Node right;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.left = null;
        this.right= null;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
