import java.util.Scanner;

public class StringEx {
    public static void standardString(String str){
        String[] myArray=str.split(" ");
        String newString="";
        for (int i=0;i< myArray.length;i++){
            newString=newString+myArray[i].substring(0,1).toUpperCase()+myArray[i].substring(1);
            newString=newString+" ";
        }
        System.out.println("\nChuỗi sau khi chuẩn hóa là");
        System.out.println(newString);
    }

    public static void mirrorString(String str){

        String reservedString="";
        for (int i=str.length()-1;i>=0;i--){
            reservedString=reservedString+str.charAt(i);
        }
        System.out.println(reservedString);
        if (reservedString.equals(str)){
            System.out.println("Chuỗi vừa nhập có đối xứng");
        }
        else {
            System.out.println("Chuỗi vừa nhập không đối xứng");
        }
    }
}
