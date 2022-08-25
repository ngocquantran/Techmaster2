public class Main {
    public static void main(String[] args) {
        int[] nums={0,4,0,3,2};
        System.out.println(findMaxAverage(nums,1));


    }
    public static double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int start=0;
        int max=sum;
        for (int i=k;i< nums.length;i++){
            sum=sum+nums[i]-nums[start];
            max=Math.max(max,sum);
            start++;
        }
        return (double)max/k;



    }
}
