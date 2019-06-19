class SLQueue{
    Node head;
    Node tail;

    static class Node{
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // enqueue(val): add val to Queue
    public SLQueue enqueue(int val){
    	Node newNode = new Node(val);
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    	return this;
    }

    // dequeue(): remove $ return first value
    public Integer dequeque(){
        if(this.head == null) {
            return null;
        } else if(this.head.next == null) {
            this.head = null;
            this.tail = null;
            Integer rem = this.head.data;
            return rem;
        } else {
            Node ptr = this.head;
            Integer rem = ptr.data;
            this.head = this.head.next;
            ptr.next = null;
            return rem;
        } 
    }
    // front() : return (not remove) first value
    public Integer front(){
        if(this.head == null) {
            return null;
        } else {
            return this.head.data;
        }
    }

    //contains(val): Queue contains val?
    public Boolean contains(int val){
        if(this.head == null) {
            return false;
        } else {
            Node runner = this.head;
            while(runner.data != val && runner.next != null){
                runner = runner.next;
            }
            if(runner.data == val){
                return true;
            } else {
                return false;
            }
        }
    }

    // Queue contains no values?
    public Boolean isEmpty(){
        if(this.head == null){
            return true;
        } else {
            return false;
        }
    }

    // return num of vals in Queue
    public int size(){
        if(this.head == null) {
            return 0;
        } else {
            int num = 1;
            Node ptr = this.head;
            while(ptr.next!=null){
                ptr = ptr.next;
                num++;
            }
            return num;
        }

    }

    public static void main(String[] args){
        // create two SLQueue objects to test the enqueque() method
        SLQueue q1 = new SLQueue();
        q1.head = new Node(2);
        q1.tail = new Node(4);
        q1.head.next = q1.tail;
        SLQueue q2 = new SLQueue();
        // test the enqueue() method
        q1.enqueue(6);
        q1.enqueue(8);
        System.out.println(q1.dequeque()); // 2
        System.out.println(q1.head.data); // 4
        System.out.println(q2.dequeque()); // null
        System.out.println(q1.front()); // 4
        System.out.println(q2.front()); // null
        System.out.println(q1.contains(8)); // true
        System.out.println(q2.contains(8)); // false
        System.out.println(q2.isEmpty()); // true
        System.out.println(q1.isEmpty()); // false
        System.out.println(q1.size()); // 3
    }
}