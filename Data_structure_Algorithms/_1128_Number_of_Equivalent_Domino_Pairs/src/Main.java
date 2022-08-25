import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int[][] dominoes = {{1, 2}, {2, 1}, {1, 2}, {1, 1}, {2, 2}};
        numEquivDominoPairs2(dominoes);

    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            System.out.println("i: " + i);
            Map<Integer, Integer> map = new HashMap<>();
            map.put(dominoes[i][0], 1);
            map.put(dominoes[i][1], 1);

            for (int j = i + 1; j < dominoes.length; j++) {

                if (!map.containsKey(dominoes[j][0]) || !map.containsKey(dominoes[j][1])) {
                    continue;
                }
                map.put(dominoes[j][0], map.get(dominoes[i][0]) + 1);
                map.put(dominoes[j][1], map.get(dominoes[i][1]) + 1);
                int a = map.get(dominoes[i][0]);
                int b = map.get(dominoes[i][1]);
                if (a == b) {
                    count++;
                } else {
                    map.put(dominoes[j][0], map.get(dominoes[i][0]) - 1);
                    map.put(dominoes[j][1], map.get(dominoes[i][1]) - 1);
                }
            }
        }
        return count;

    }

    public static int numEquivDominoPairs2(int[][] dominoes) {
        int count = 0;
        Map<Domino, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            Domino newDomino = new Domino(dominoes[i]);
            map.put(newDomino, map.getOrDefault(newDomino, 0) + 1);
        }
        for (Integer num : map.values()) {
            count += num * (num - 1) / 2;
        }
        System.out.println(map);

        return count;

    }
}

class Domino {
    public int x;
    public int y;

    public Domino(int[] arr) {
        x = arr[0];
        y = arr[1];
    }

    @Override
    public int hashCode() {
        if (x > y) {
            return x * 10 + y;
        }
        return y * 10 + x;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

}
