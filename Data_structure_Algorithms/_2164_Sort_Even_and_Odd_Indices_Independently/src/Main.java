import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odd=new ArrayList<>();
        List<Integer> even=new ArrayList<>();

        for (int i=0;i< nums.length;i++){
            if (i%2==0){
                even.add(nums[i]);

            }else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(odd, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Collections.sort(even, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int indexOdd=0;
        int indexEven=0;
        for (int i=0;i< nums.length;i++){
            if (i%2==0){
                nums[i]=even.get(indexEven);
                indexEven++;

            }else {
                nums[i]=odd.get(indexOdd);
                indexOdd++;
            }
        }
        return nums;



    }
}
