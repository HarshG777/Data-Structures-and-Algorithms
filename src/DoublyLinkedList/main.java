package DoublyLinkedList;

public class main {
    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(4);
//        myDLL.printList();
//        myDLL.getHead();
//        myDLL.getTail();
//        myDLL.getLength();

        myDLL.append(2);
        myDLL.append(1);
        myDLL.append(4);
        myDLL.append(4);

//        myDLL.printList();
//
//        System.out.println(myDLL.removeLast().value);
//        System.out.println(myDLL.removeFirst().value);
//
//        myDLL.printList();
//
//
//        myDLL.prepend(3);
//        myDLL.printList();
//
//        System.out.println(myDLL.get(2).value);
//        myDLL.getLength();
//
//        myDLL.insert(1,2);
//        myDLL.remove(2);
//        myDLL.printList();

//        myDLL.swapFirstLast();

//        myDLL.reverse();
        myDLL.printList();
        System.out.println(myDLL.isPalindrome());
    }
}
