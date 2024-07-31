package Stack;

public class main {

    public static String reverseString(String ss){

        String ret = "";
        int len = ss.length();

        for(int j = len-1 ; j != -1 ; j--){


            ret = ret + ss.charAt(j);

        }

        return ret;

    }

    public static void main(String[] args) {
//        Stack stack = new Stack(1);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.pop();
//        stack.pop();
//        stack.push(10);
//
//
//        System.out.println("value poped : " +  stack.pop().value);

        String ss = "ABCDE";
        System.out.println(reverseString(ss));
//
//        stack.printStack();
    }
}
