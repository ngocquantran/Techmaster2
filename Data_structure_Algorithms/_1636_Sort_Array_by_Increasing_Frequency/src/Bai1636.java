import java.util.*;

public class Bai1636 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};
        frequencySort(nums);
        frequencySort2(nums);
    }

    public static int[] frequencySort(int[] nums) {

        int[] arr = new int[201];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i] + 100]++;
        }
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                Number number = new Number();
                number.value = i - 100;
                number.frequency = arr[i];
                numbers.add(number);
            }
        }

        Collections.sort(numbers, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                if (o1.frequency == o2.frequency) {
                    return o2.value - o1.value;
                }
                return o1.frequency - o2.frequency;
            }
        });

        System.out.println(Arrays.toString(numbers.toArray()));
        int index = 0;
        for (Number n : numbers) {
            int count = 1;
            while (count <= n.frequency) {
                nums[index] = n.value;
                index++;
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));

        return nums;

    }

    public static int[] frequencySort2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o2.getKey() - o1.getKey();
                }
                return o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> e : list) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }

        int index = 0;
        for (Map.Entry<Integer, Integer> e : list) {
            int count = 1;
            while (count <= e.getValue()) {
                nums[index++] = e.getKey();
                count++;
            }
        }

        System.out.println(Arrays.toString(nums));


        return nums;

    }
}

class Number {
    public int value;
    public int frequency;

    @Override
    public String toString() {
        return value +
                " - " + frequency;
    }
}
