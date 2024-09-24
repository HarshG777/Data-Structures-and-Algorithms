package HashTable;

public class HashTable{

    private int size = 7;
    private Node[] dataMap;

    public HashTable(){
        dataMap = new Node[size];
    }

    public void printTable(){
        for(int i = 0 ; i< dataMap.length; i++){
            System.out.print("\n");
            System.out.print(i+ ": ");
            if(dataMap[i] != null){
                Node temp = dataMap[i];
                while (temp != null){
                    System.out.print("{"+temp.key+" => "+temp.value+"} --> ");
                    temp = temp.next;
                }

            }
        }
        System.out.println("\n");
    }

    private int hash(String key){
        int hash = 0;

        char[] keyChar = key.toCharArray();

        for(int i = 0;i<keyChar.length;i++){
            int asciiValue = keyChar[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }

        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key,value);

        if(dataMap[index]==null){
            dataMap[index] = newNode;
        }
        else {
            Node temp = dataMap[index];
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null){
            if(temp.key == key) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys(){
        ArrayList <String> allkeys = new ArrayList<>();
        for(int i = 0; i< dataMap.length;i++){
            Node temp = dataMap[i];
            while (temp != null){
                allkeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allkeys;
    }
}
