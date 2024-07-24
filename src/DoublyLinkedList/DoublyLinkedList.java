package DoublyLinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    private int length = 0;

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

//Printing the linked list ---------------------------------------------------------------
    public void printList(){
        Node temp = head;
        System.out.print("null <-- ");
        while(temp != null){
            System.out.print(temp.value +" <==> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public void getHead(){
        System.out.println("Head : " + head.value);

    }

    public void getTail(){
        System.out.println("Tail : " + tail.value);
    }

    public void getLength(){
        System.out.println("Length : " + length);
    }



    //Append new node --------------------------------------------------------------------------------------

    public void append(int value){
        Node newNode = new Node(value);

        if(length == 0 || head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length++;
    }

    //Remove From Last ___________________________________________________________________________________

    public Node removeLast(){

        if (length == 0) return null;

        Node temp = tail;

        if (length == 1){
            head = null;
            tail = null;
        }else {

            tail = tail.prev;
            tail.next = null;
            temp.prev = null;

        }

        length--;

        return temp;

    }


    //Prepend new Node __________________________________________________________________________________________

    public void prepend(int value){

        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

        }

        length++;
    }

    //Remove first ----------------------------------------------------------------------------------------------------

    public Node removeFirst(){

        if (head == null) return null;

        Node temp = head;

        if (length == 1){
            head = null;
            tail = null;
        }else {

            head = head.next;
            head.prev = null;
            temp.next = null;

        }
        length--;
        return temp;
    }


    // get ------------------------------------------------------------------------------------------------------

    public Node get(int index){
        if(index < 0 || index >= length) return null;

        Node temp = head;
        if(index < length/2){
            for (int i = 0 ; i < index ; i++){
                temp = temp.next;
            }
        }else {
            temp = tail;
            for (int i = length-1 ; i > index ;i--){
                temp = temp.prev;
            }
        }

        return temp;
    }

    //set index -> value ------------------------------------------------------------------------------------------------

    public boolean set(int index , int value){
        Node temp = get(index);

        if(temp != null){
            temp.value = value;
            return true;
        }

        return false;
    }


    //Inset new Node at index -------------------------------------------------------------------------------------------

    public boolean insert(int index , int value){
        if (index < 0 || index > length) return false;

        if(index == 0){
            prepend(value);
            return true;
        }

        if(index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index-1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;

        before.next = newNode;
        after.prev = newNode;

        length++;

        return true;
    }

    // remove at index ------------------------------------------------------------------------------------------------

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node temp = get(index);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;

        length--;
        return temp;
    }

    public void swapFirstLast(){
        Node headTemp = head;
        Node tailTemp = tail;

        tail.prev.next = headTemp;
        headTemp.prev = tail.prev;
        tail.prev = null;
        tail = headTemp;

        tailTemp.next = head.next;
        head.next.prev = tailTemp;
        head.next = null;
        head = tailTemp;


    }

    public void reverse(){
        if(head == null || head.next == null) return;


        Node current = head;
        Node temp = null;

        head = tail;
        tail = current;

        while (current != null){

            temp = current.prev;

            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

    }

    public boolean isPalindrome(){

        if(head == null || head.next == null) return true;

        Node first = head;
        Node last = tail;

        while(first != last){

            if(first.value != last.value){
                return false;
            }
            first = first.next;
            last = last.prev;

        }
        return true;
    }

    public void swapPairs() {
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        while (head != null && head.next != null) {
            Node firstNode = head;
            Node secondNode = head.next;

            previousNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            secondNode.prev = previousNode;
            firstNode.prev = secondNode;

            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            head = firstNode.next;
            previousNode = firstNode;
        }

        head = dummyNode.next;
        if (head != null) head.prev = null;
    }

}
