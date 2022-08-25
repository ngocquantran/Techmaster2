public class Main {
    public static void main(String[] args) {

    }
    public int findFinalValue(int[] nums, int original) {
        int[] arr=new int[1001];
        for (int i=0;i< nums.length;i++){
            arr[nums[i]]++;
        }
        while (arr[original]>0){
            if (original>1000) return original;
            original*=2;

        }
        return original;


    }
}
