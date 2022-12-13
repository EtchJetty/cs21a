/**
 * Entry class
 * Known Bugs: None
 * 
 * @author Viridia Weiss
 * @email gweiss@brandeis.edu
 *        December 13th, 2022
 *        COSI 21A PA3
 */
public class Entry {
    private GraphNode key;

    public GraphNode getKey() {
        return key;
    }

    public void setKey(GraphNode key) {
        this.key = key;
    }

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Constructs a doubly linked list node that holds a key and value field but
     * does not point to any other nodes. O(1)
     */
    public Entry(GraphNode key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
