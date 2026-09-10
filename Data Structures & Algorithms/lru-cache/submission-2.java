class LRUCache {

    class Node {
        int val;
        int key;

        Node next;
        Node prev;

        Node (int x, int y) {
            val = x;
            key = y;
        }
    }

    private Map<Integer, Node> mp;

    Node head,tail;

    int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        mp = new HashMap<>();

        head = new Node(-1,-1);
        
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }

    
    public int get(int key) {

        if (!mp.containsKey(key)) {
            return -1;
        } else {

            Node n = mp.get(key);

            removeNode(n);
            addNodeAtFront(n);

            return n.val;
        }
        
    }
    
    public void put(int key, int value) {

        if (mp.containsKey(key)) {

            Node n = mp.get(key);
            n.val = value;

            removeNode(n);
            addNodeAtFront(n);

        } else {

            if (mp.size() == capacity) {

                Node lru = tail.prev;
                removeNode(lru);
                mp.remove(lru.key);

            } 

                Node newNode = new Node(value, key);
                mp.put(key, newNode);
                addNodeAtFront(newNode);
            
        }
        
    }

    public void addNodeAtFront(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(Node n) {

        n.prev.next = n.next;
        n.next.prev = n.prev;
    }
}
