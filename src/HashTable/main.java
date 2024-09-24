package HashTable;

public class main {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();
      //  myHashTable.printTable();

        myHashTable.set("Apple",30);
        myHashTable.set("orange",40);
        myHashTable.set("banana",50);
        myHashTable.set("fig",70);
        myHashTable.set("grapes",30);
        myHashTable.set("watermelon",10);
        myHashTable.set("papaya",90);
        myHashTable.set("lemon",40);

        myHashTable.printTable();

        System.out.println(myHashTable.get("lemon"));


    }
}
