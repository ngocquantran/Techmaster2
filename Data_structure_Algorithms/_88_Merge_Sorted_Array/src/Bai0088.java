import java.util.Arrays;

public class Bai0088 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);

        int[] nums3 = {1};
        int[] nums4 = {};
        merge(nums3, 1, nums4, 0);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }
        while (m > 0 && n > 0) {
            if (nums1Copy[m - 1] > nums2[n - 1]) {
                nums1[index] = nums1Copy[m - 1];
                m--;
            } else {
                nums1[index] = nums2[n - 1];
                n--;
            }
            index--;
        }
        while (m > 0) {
            nums1[index] = nums1Copy[m - 1];
            m--;
            index--;
        }
        while (n > 0) {
            nums1[index] = nums2[n - 1];
            n--;
            index--;
        }
        System.out.println(Arrays.toString(nums1));
    }

}
