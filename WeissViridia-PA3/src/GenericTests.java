import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.util.*;
import java.util.Random;

public class GenericTests {

    public static void main(String[] args) {
        MinPriorityQueue queue = new MinPriorityQueue(128);

        GraphNode home = null;
        GraphNode[][] index = null;

        int homeX = 3;
        int homeY = 3;
        int goalX = 76;
        int goalY = 42;
        Path path = Paths.get("node_ids.txt");
        List<String> l;
        try {
            l = Files.readAllLines(path);
            String[] s = l.get(0).split(" ");
            index = new GraphNode[l.size()][s.length];
            for (int i = 0; i < index.length; i++) {
                s = l.get(i).split(" ");
                for (int j = 0; j < index[0].length; j++) {
                    boolean isGoal = (i == goalY && j == goalX);
                    boolean isHome = (i == homeY && j == homeX);
                    index[i][j] = new GraphNode(s[j], isGoal);
                    if (isHome) {
                        home = index[i][j];
                    }

                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Missing file");
        }

        Random random = new Random();
        for (int i = 0; i < 24; i++) {
            GraphNode temp = index[random.nextInt(100)][random.nextInt(100)];
            temp.priority = random.nextInt(99999);
            queue.insert(temp);
        }
        queue.buildMinHeap();
        while (!queue.isEmpty()) {
            GraphNode gno = queue.pullHighestPriorityElement();
            System.out.print(gno.priority);
            System.out.print(", ");
            System.out.println(queue.indexMap.getValue(gno));
        }
        ;
    }
}
