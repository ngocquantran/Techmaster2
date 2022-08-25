public class Main {
    public static void main(String[] args) {

    }
    public int[] findErrorNums(int[] nums) {
        int[] appearance=new int[nums.length+1];
        int[] result=new int[2];
        for (int i=0;i< nums.length;i++){
            appearance[nums[i]]++;
        }
        for (int i=1;i<appearance.length;i++){

            if (appearance[i]==2) result[0]=i;
            if (appearance[i]==0) result[1]=i;
        }


        return result;

    }
}
