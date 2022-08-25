public class Main {
    public static void main(String[] args) {

    }
    public int[] getConcatenation(int[] nums) {
        int[] result=new int[nums.length*2];
        for (int i=0;i< result.length;i++){
            if (i< nums.length){
                result[i]=nums[i];
            }else {
                result[i]=nums[i- (nums.length)];
            }
        }
        return result;

    }
}
