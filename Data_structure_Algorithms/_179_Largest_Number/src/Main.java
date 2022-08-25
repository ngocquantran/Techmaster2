import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,30,8,80,34,5,7,78,9};

        System.out.println(largestNumber(nums));
        System.out.println("330".compareTo("331"));
        String[] arr={"330,303"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));



    }
    public static String largestNumber(int[] nums) {

        String[] strArr=new String[nums.length];
        for (int i=0;i<strArr.length;i++){
            strArr[i]=String.valueOf(nums[i]);
        }
        System.out.println(Arrays.toString(strArr));
        for(int i=0;i< strArr.length;i++){
            for (int j=i;j< strArr.length;j++){
                if ((strArr[i]+strArr[j]).compareTo(strArr[j]+strArr[i])<0){
                   // System.out.println(Integer.parseInt(strArr[i]+strArr[j])+" - "+Integer.parseInt(strArr[j]+strArr[i]));
                    String t=strArr[j];
                    strArr[j]=strArr[i];
                    strArr[i]=t;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i< strArr.length;i++){
            sb.append(strArr[i]);
        }
        String result= sb.toString();
        if (result.charAt(0)=='0') return "0";
        return sb.toString();
    }
}
