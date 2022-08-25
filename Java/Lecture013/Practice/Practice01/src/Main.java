public class Main <T>{
    public static void main(String[] args) {
        MyGeneric<Integer> myGeneric1=new MyGeneric<>(1);
        System.out.println(myGeneric1.getVariable());

        MyGeneric<Double> myGeneric2=new MyGeneric<>(5.63);
        System.out.println(myGeneric2.getVariable());

        MyGeneric<String> myGeneric3=new MyGeneric<>("Hello");
        System.out.println(myGeneric3.getVariable());

        String[] arrStr=new String[]{"Java","HTML","CSS","Python","C++"};
        Integer[] arrInt=new Integer[]{1,2,3,4};
        Double[] arrDouble=new Double[]{1.3,4.5,5.77,8.22};

//        System.out.println("Mảng chuỗi là");
//        showArray(arrStr);

        Main<String> stringMain=new Main<>();
        Main<Integer> integerMain=new Main<>();
        Main<Double> doubleMain=new Main<>();
        System.out.println("Mảng chuỗi là");
        stringMain.showAllTypeArray(arrStr);
        System.out.println("\nMảng số nguyên");
        integerMain.showAllTypeArray(arrInt);
        System.out.println("\nMảng số thực");
        doubleMain.showAllTypeArray(arrDouble);

        System.out.println("\nMảng chuỗi");
        show(arrStr);
        System.out.println("\nMảng số nguyên");
        show(arrInt);
    }

    public static void showArray(String arr[]){
        for ( String a:arr){
            System.out.print(a+ "\t");
        }
    }

    public void showAllTypeArray(T arr[]){
        for (T s:arr){
            System.out.print(s+"\t");
        }
    }

    public static <T> void show(T arr[]){
        for (T s:arr){
            System.out.print(s+"\t");
        }
    }

}
