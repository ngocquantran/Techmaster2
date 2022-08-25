public class Main {
    public static void main(String[] args) {

    }
    public void moveZeroes(int[] nums) {
        int index=0;
       for(int i=0;i< nums.length;i++){
           if (nums[i]!=0){
               nums[index]=nums[i];
               index++;
           }
       }
       for (int i=0;i< nums.length-index;i++){
           nums[nums.length-1-i]=0;
       }
    }

    public void moveZeroes2(int[] nums) {
        for (int i=0;i< nums.length;i++){
            for (int j=0;j< nums.length-1;i++){
                if (nums[j]==0){
                    int t=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=t;
                }
            }
        }
    }


}
