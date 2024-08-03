package Stack;

public class Stack {
    private Node top;
    private int height;

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack(){
        Node temp = top;

        while(temp != null){
            System.out.println("+---+");
            System.out.println("| " + temp.value + " |");
            temp = temp.next;
        }
        System.out.println("+---+");
    }


    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }

        height++;
    }

    public Node pop(){
        if(height == 0) return null;

        Node temp = top;

        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    /*

    ------------Stack: Parentheses Balanced ( -**- Interview Question  -**- ) ----------------------

    For example, the string "((()))" has three pairs of balanced parentheses,
    so it is a balanced string. On the other hand, the string "(()))" has an imbalance,
    as the last two parentheses do not match, so it is not balanced.
    Also, the string ")(" is not balanced because the close parenthesis needs to follow the open parenthesis.


    */

    public static boolean isBalancedParentheses(String ss){
        Stack<Character> stack = new Stack<>();


        for(int i = 0 ; i < ss.length() ; i++ ){

            if(ss.charAt(i) == '('){
                stack.push('(');
            }

            if(ss.charAt(i) == ')'){
                if(stack.isEmpty()) return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
