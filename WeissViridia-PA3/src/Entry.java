/**
 * Entry class with a key and value
 * Known Bugs: None
 * 
 * @author Viridia Weiss
 * @email gweiss@brandeis.edu
 *        December 13th, 2022
 *        COSI 21A PA3
 */
public class Entry {
    private GraphNode key;
    private Integer value;

    /**
     * Getter for entry key.
     */
    public GraphNode getKey() {
        return key;
    }

    /**
     * Setter for entry key.
     * 
     * @param key
     */
    public void setKey(GraphNode key) {
        this.key = key;
    }

    /**
     * Getter for the value of the entry.
     * 
     * 
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Setter for the value of the entry.
     * 
     * @param value
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Constructs an entry that holds a key and value field
     */
    public Entry(GraphNode key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
