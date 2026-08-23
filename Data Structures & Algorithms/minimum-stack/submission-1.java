class MinStack {

    private Node head;

    public MinStack() {
        
    }
    
    public void push(int val) {

        if (head == null) {
            head = new Node(val, val, null);
        } else {

            head = new Node(val, Math.min(head.min, val), head);    
        }
        
    }
    
    public void pop() {

        head = head.n;
        
    }
    
    public int top() {

        return head.val;
        
    }
    
    public int getMin() {
        return head.min;
    }

    class Node {

        int val;
        int min;
        Node n;

        Node(int a, int b, Node c) {
            val = a;
            min = b;
            n = c;
        }
    }
}
