
/**
 * Main FindMinPath file
 * Known Bugs: None
 * 
 * @author Viridia Weiss
 * @email gweiss@brandeis.edu
 *        December 13th, 2022
 *        COSI 21A PA3
 */

import java.io.FileWriter;
import java.io.IOException;

public class FindMinPath {
    static final int QUEUE_SIZE = 1024;

    /**
     * Main FindMinPath class.
     * 
     * @param args
     */
    public static void main(String[] args) {
        MinPriorityQueue q = new MinPriorityQueue(QUEUE_SIZE);

        GraphWrapper gw = new GraphWrapper();
        GraphNode home = gw.getHome();
        home.priority = 0;
        q.insert(home);

        GraphNode goalNode = null;
        while (!q.isEmpty() && goalNode == null) {
            GraphNode curr = q.pullHighestPriorityElement();
            if (curr.isGoalNode()) {
                goalNode = curr;
            } else {
                int x = 0;
                if (curr.hasNorth()) {
                    GraphNode north = curr.getNorth();
                    x = curr.priority + curr.getNorthWeight() + north.getSouthWeight();

                    if (!q.indexMap.hasKey(north)) {
                        north.priority = x;
                        north.previousNode = curr;
                        north.previousDirection = "North";
                        q.insert(north);
                    } else if (q.indexMap.hasKey(north) && x < north.priority) {
                        north.priority = x;
                        q.buildMinHeap();
                        north.previousNode = curr;
                        north.previousDirection = "North";
                    }
                }
                if (curr.hasEast()) {
                    GraphNode east = curr.getEast();
                    x = curr.priority + curr.getEastWeight() + east.getWestWeight();

                    if (!q.indexMap.hasKey(east)) {
                        east.priority = x;
                        east.previousNode = curr;
                        east.previousDirection = "East";
                        q.insert(east);
                    } else if (q.indexMap.hasKey(east) && x < east.priority) {
                        east.priority = x;
                        q.buildMinHeap();
                        east.previousNode = curr;
                        east.previousDirection = "East";
                    }
                }
                if (curr.hasSouth()) {
                    GraphNode south = curr.getSouth();
                    x = curr.priority + curr.getSouthWeight() + south.getNorthWeight();

                    if (!q.indexMap.hasKey(south)) {
                        south.priority = x;
                        south.previousNode = curr;
                        south.previousDirection = "South";
                        q.insert(south);
                    } else if (q.indexMap.hasKey(south) && x < south.priority) {
                        south.priority = x;
                        q.buildMinHeap();
                        south.previousNode = curr;
                        south.previousDirection = "South";
                    }
                }
                if (curr.hasWest()) {
                    GraphNode west = curr.getWest();
                    x = curr.priority + curr.getWestWeight() + west.getEastWeight();

                    if (!q.indexMap.hasKey(west)) {
                        west.priority = x;
                        west.previousNode = curr;
                        west.previousDirection = "West";
                        q.insert(west);
                    } else if (q.indexMap.hasKey(west) && x < west.priority) {
                        west.priority = x;
                        q.buildMinHeap();
                        west.previousNode = curr;
                        west.previousDirection = "West";
                    }
                }

            }
        }
        String s = "";
        GraphNode traverse = goalNode;
        while (traverse != home) {
            // s = String.join(" ", traverse.previousDirection,
            // String.valueOf(traverse.getNorthWeight()),
            // String.valueOf(traverse.getSouthWeight()),
            // String.valueOf(traverse.getWestWeight()),
            // String.valueOf(traverse.getEastWeight()), "\n", s);
            s = String.join("", traverse.previousDirection, "\n", s);
            traverse = traverse.previousNode;
        }

        s = s.substring(0, s.length() - 1);
        // System.out.println(s);
        try {
            FileWriter f = new FileWriter("answer.txt");
            f.write(s);
            f.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
