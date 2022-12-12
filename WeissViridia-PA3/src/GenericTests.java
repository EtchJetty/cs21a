import java.util.Random;

public class GenericTests {

    public static void main(String[] args) {
        MinPriorityQueue queue = new MinPriorityQueue(128);

        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            GraphNode temp = new GraphNode(null, false);
            temp.priority = random.nextInt(99999);
            queue.insert(temp);
        }
        queue.buildMinHeap();
        while (!queue.isEmpty()) {
            System.out.println(queue.pullHighestPriorityElement().priority);
        }
        ;
    }
}
