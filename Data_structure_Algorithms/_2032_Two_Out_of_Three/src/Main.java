import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] n1= {7,2,3,8,7,14,11,7,6};
        int[] n2= {3,8,14,14,4};
        int[] n3={14,7,11,8};
        twoOutOfThree(n1,n2,n3);

    }
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result=new ArrayList<>();
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        Set<Integer> set3=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (Integer n:nums1) set1.add(n);
        for (Integer n:nums2) set2.add(n);
        for (Integer n:nums3) set3.add(n);

        for (Integer n:set1){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for (Integer n:set2){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        for (Integer n:set3){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for (Integer n: map.keySet()){
            if (map.get(n)>=2){
                result.add(n);
            }
        }
        return result;



    }

    public static List<Integer> twoOutOfThree2(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (Integer n:nums1){
            map.put(n,1);
        }
        for (Integer n:nums2){
            if (map.containsKey(n)){
                map.put(n,2);
                result.add(n);
            }else {
                map.put(n,1);
            }
        }
        for (Integer n:nums3) {
            if (map.containsKey(n) && (map.get(n) == 1 || map.get(n) == 2)) {
                map.put(n,4);
                result.add(n);
            }
        }
        return result;
    }
}
