public class MangHaiChieu {
    public static void main(String[] args) {
        int[][] nums={{1,2,3},{4,5,6},{7,8,9}};
        array2D(nums);

    }
    public static void array2D(int[][] nums){
        printArray(nums,0,0);
    }

    public static void printArray(int[][] nums, int i,int j){
        if (j>=nums[0].length){
            i++; j=0;
            System.out.println();
        }
        if (i>= nums.length) return;

        System.out.print(nums[i][j]+" ");

        printArray(nums,i,j+1);

    }
}
