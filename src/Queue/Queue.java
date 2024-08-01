package Queue;

public class Queue {
    private Node first;
    private Node last;

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);

        if(last == null){
            first = newNode;
            last = newNode;

        }else{
            last.next = newNode;
            last = newNode;
        }


    }

    public Node dequeue(){
        if(first == null) return null;

        Node temp = first;

        if(first.next == null){
            first = null;
            last = null;
        }else{
            first = first.next;
            temp.next = null;
        }

        return temp;
    }
}
