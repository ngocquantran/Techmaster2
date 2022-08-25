public class TimKiemTuanTu {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9,10};
        System.out.println(search(nums,6,0));
        System.out.println(search(nums,11,0));

    }
    public static int search(int[] nums,int a,int index){
        if (index>= nums.length) return -1;
        if (nums[index]==a) return index;
        return search(nums,a,++index);
    }
}
