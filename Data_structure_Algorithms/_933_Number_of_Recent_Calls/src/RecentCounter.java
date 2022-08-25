import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    public Queue<Integer> queue=new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        queue.add(t);
        if (queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();

    }
}
