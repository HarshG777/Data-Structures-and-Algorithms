public class LinkedList {

    //Data Members :---------------------------------------------------
    private Node head;
    private Node tail;
    private int length;


    //Constructor :--------------------------------------------------
    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;

    }


    //Printing Values :--------------------------------------

    public void printList(){
        Node temp = head;

        while (temp != null){
            System.out.print(temp.value+" --> ");
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public void getHead(){
        System.out.println("Head : "+head.value);
    }

    public void getTail(){
        System.out.println("Tail :"+tail.value);
    }

    public void getLength(){
        System.out.println("Length :"+length);
    }


    //Append New Node :----------------------------------------------------------

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;

        System.out.println("Added node :"+value);
    }


    //prepend --------------------------------------------------------------------------

    public void prepend(int value){
        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }


    //Remove last node -----------------------------------------------------------------

    public Node removeLast(){
        if(length == 0) return null;

        Node temp = head;
        Node pre = head;

        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;

        if(length == 0){
            head = null;
            tail = null;
        }

        return temp;
    }


    //Remove first ----------------------------------------------------------------------

    public Node removeFirst(){
        if(length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;

        length--;

        if(length == 0){
            tail = null;
        }

        return temp;
    }

    // GET using INDEX ---------------------------------------------------------

    public Node get(int index){
        if(index<0 || index >= length){
            return null;
        }

        Node temp = head;
        for(int i = 0 ; i < index ; i++){
            temp = temp.next;
        }

        return temp;
    }


    // SET index , value --------------------------------------------------------------------------

    public boolean set(int index , int value){
        Node temp = get(index);

        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    // Remove index ---------------------------------------------------------------------------------


    public Node remove(int index){
        if(index < 0 || index > length) return null;

        if(index == 0) return removeFirst();
        if(index == length-1) return removeLast();

        Node pre = get(index-1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }



    //Reverse the LinkedList ---------------------------------------------------------------------------------------

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = temp.next;

        for(int i = 0 ; i <length ;i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

        printList();
    }


    //LEETCODE Exercises :---------------------------------------------------------------------------------------------

    // Qustion 1 :-
    // LL: Find Middle Node ( -**- Interview Question -**- )

    /*

    1 -> 2 -> 3 -> 4 -> 5-> null

    output : 3

    */

    public Node findMiddleNode(){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    //Question 2 :-----------------------------------------------------------------------------------------------------
    //LL: Has Loop ( -**- Interview Question -**- )

    /*

    1 -> 2 -> 3 -> 4
              |    |
              6 <- 5

     Output : true

     */

    public boolean hasLoop(){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) return true;
        }
        return false;
    }


    //Question 3 :-----------------------------------------------------------------------------------------------------
    //LL: Find Kth Node From End ( -**- Interview Question -**-)

    /*

    10 -> 20 -> 30 -> 40 -> 50
     5     4     3     2     1  <--- index form end

    input  k = 2

    Output : 40  <----- at index 2 there is 40

     */


    public Node findKthFromEnd(int K){

        Node fast = head;
        Node slow = head;

        for(int i = 0 ; i<K ; i++){
            if(fast == null) return null;

            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;

        }

        return slow;


    }



    //Question 4 :-----------------------------------------------------------------------------------------------------
    //LL: Partition List ( -**- Interview Question -**-)

    /*

   Example 1:

    Input:
    Linked List: 3 -> 8 -> 5 -> 10 -> 2 -> 1

    x: 5

    Process:
    Values less than 5: 3, 2, 1
    Values greater than or equal to 5: 8, 5, 10

    Output:
    Linked List: 3 -> 2 -> 1 -> 8 -> 5 -> 10


     */

    public void partitionList(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;

        head = dummy1.next;
    }





}
