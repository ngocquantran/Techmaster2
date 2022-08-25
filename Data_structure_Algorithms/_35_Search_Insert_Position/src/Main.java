public class Main {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        int index=-1;
        for(int i=0;i< nums.length;i++){
            if (nums[i]>target){
                index=i;
                break;
            }
        }
        if (index==-1) return nums.length;
        return index;


    }
}
