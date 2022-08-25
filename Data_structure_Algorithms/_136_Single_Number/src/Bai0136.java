import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bai0136 {
    public static void main(String[] args) {
//        int[] nums ={1};
        int[] nums ={4,1,2,1,2};
        System.out.println(singleNumber(nums));

    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int sum=0, sumDouble=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i%2==1){
                sumDouble+=nums[i]*2;
            }
        }
        return (sum-sumDouble);
    }


    public static int singleNumber2(int[] nums) {
        Set<Integer> list=new HashSet<>();
//        int sum=0, sumDouble=0;
        int result=0;
        for(int i=0;i<nums.length;i++){
//            sum+=nums[i];
            if (!list.contains(nums[i])){
//                sumDouble+=nums[i]*2;
                result+=nums[i]*2;
            }
            result-=nums[i];
            list.add(nums[i]);
        }
//        return sumDouble-sum;
        return result;
    }
}
