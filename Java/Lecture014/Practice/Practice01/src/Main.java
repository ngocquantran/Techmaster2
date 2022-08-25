import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list=new ArrayList<>();
//        list.add(5);
//        list.add(7);
//        list.add(9);
//        list.add(6);
//        list.add(3);
//        System.out.println(list);
//
//        Iterator<Integer> itr=list.iterator();
//
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//        }

//        Queue<Integer> listInt=new LinkedList<>();
//        listInt.add(5);
//        listInt.offer(6);
//        listInt.add(8);
//        listInt.add(3);
//        listInt.add(9);

//        System.out.println(listInt);
//        System.out.println("Phần tử đầu tiên: "+listInt.poll());
//        System.out.println(listInt);

//        System.out.println("Phần tử thứ hai: "+listInt.remove());
//        System.out.println(listInt);

//        Queue<Integer> listInt=new PriorityQueue<>();
//        listInt.add(5);
//        listInt.offer(6);
//        listInt.add(8);
//        listInt.add(3);
//        listInt.add(9);
//        listInt.add(-1);
//        System.out.println(listInt);
//
//        System.out.println("Phần tử đầu tiên: "+listInt.remove());
//        System.out.println(listInt);

//        Set<Integer> listInt=new HashSet<>();
//        listInt.add(5);
//        listInt.add(6);
//        listInt.add(8);
//        listInt.add(6);
//        listInt.add(9);
//        listInt.add(-1);
//
//        System.out.println(listInt);

        Map<Integer,String> map=new HashMap<>();
        map.put(1,"Ngọc");
        map.put(2,"Linh");
        map.put(8,"Hoàng");
        map.put(5,"Tuấn");
        map.put(7,"Trang");
        map.put(5,"Phan");

        System.out.println(map);

        for (Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }






    }
}
