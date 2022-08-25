public class Main {
    public static void main(String[] args){
        String chuoi="You only live once, but if you do it right, once is enough";
        System.out.println("Chuỗi được cho: "+chuoi+".\n");
        int count=0;

        for(int i=0;i<chuoi.length();i++){

            if (chuoi.charAt(i)=='o'){
                count++;
                System.out.println("Chuỗi có 1 kí tự 'o' ở vị trí số "+(i+1));
            }

        }
        System.out.println("\nChuỗi có tổng cộng "+count+" kí tự 'o'");
    }
}
