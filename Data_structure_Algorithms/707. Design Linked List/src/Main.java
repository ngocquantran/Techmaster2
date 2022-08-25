public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.printAll();
        myLinkedList.addAtHead(1);
        myLinkedList.printAll();
        myLinkedList.addAtHead(2);
        myLinkedList.printAll();
        myLinkedList.addAtTail(4);
        myLinkedList.printAll();
        System.out.println(myLinkedList.length);
        myLinkedList.addAtIndex(1,5);
        myLinkedList.printAll();



    }
}
