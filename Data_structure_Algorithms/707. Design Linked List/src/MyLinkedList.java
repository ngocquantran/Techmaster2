public class MyLinkedList {

    class Mynode{
        public int val;
        public Mynode next;

        public Mynode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return ""  + val;
        }
    }

    int length;
    Mynode head;

    public MyLinkedList() {
        length=0;
        head=null;
    }


    public int get(int index) {
        if (head==null){
            return -1;
        }
        int count=0;
        Mynode iNode=head;
        while (iNode!=null){
            if (count==index){
                return iNode.val;
            }
            iNode=iNode.next;
            count++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Mynode newNode=new Mynode(val);
        newNode.next=head;
        head=newNode;
        length++;
    }

    public void addAtTail(int val) {
        Mynode newNode=new Mynode(val);
        if (head==null){
            head=newNode;
            length++;
            return;
        }
        Mynode iNode=head;
        while (iNode!=null){
            if (iNode.next==null){
                iNode.next=newNode;
                length++;
                return;
            }
            iNode=iNode.next;
        }

    }

    public void addAtIndex(int index, int val) {
        if (head==null) {
            return;
        }else if(index==0){
            addAtHead(val);
        }else {
            int countIndex=1;
            Mynode newNode=new Mynode(val);
            Mynode prev=head;
            Mynode current=head.next;
            while (current!=null){
                if (countIndex==index){
                    prev.next=newNode;
                    newNode.next=current;
                    return;
                }
                current=current.next;
                prev=prev.next;

            }
        }



    }

    public void deleteAtIndex(int index) {


    }

    public void printAll(){
        if (head==null){
            System.out.println("List is empty");
        }
        Mynode iNode=head;
        while (iNode!=null){
            System.out.print(iNode+"--> ");
            iNode=iNode.next;
        }
        System.out.println();
    }

}
