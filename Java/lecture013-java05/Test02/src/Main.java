public class Main {
    public static void main(String[] args){
        String myString="You only live once, but if you do it right, once is enough";
        System.out.println("Chuỗi được cho là:\n"+myString);

        System.out.println();
        String[] myArray=myString.split(" ");
        System.out.println("Số từ trong chuỗi là: "+myArray.length);
        System.out.println();

        int count=0;
        for (int i=0; i<myString.length();i++){
            if (myString.charAt(i)=='o'){
                System.out.println("Chuỗi có kí tự 'o' tại ví trí ứng với index "+i);
                count++;
            }
        }
        System.out.printf("Chuỗi có tổng cộng %d kí tự 'o'",count);

    }
}
