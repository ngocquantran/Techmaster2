import java.util.Arrays;

public class Bai1051 {
    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        System.out.println(heightChecker1(heights));
        System.out.println(heightChecker2(heights));

    }

    public static int heightChecker1(int[] heights) {   //O(n)
        int[] arr = new int[100];
        for (int i = 0; i < heights.length; i++) {
            arr[heights[i]]++;
        }
        int result = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                int count = 0;
                while (count < arr[i]) {
                    if (heights[index] != i) result++;
                    index++;
                    count++;
                }
            }
        }
        return result;
    }

    public static int heightChecker2(int[] heights) {     //O(nlogn)
        int[] expected = new int[heights.length];
        System.arraycopy(heights, 0, expected, 0, heights.length);
        Arrays.sort(expected);
        int found = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                found++;
            }
        }
        return found;
    }
}
