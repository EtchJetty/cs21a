public class HashMap {

    private DoubleLinkedList[] hashArray;
    private int arrSize;

    public int getArrSize() {
        return arrSize;
    }

    public HashMap(int size) {
        this.hashArray = (DoubleLinkedList[]) new DoubleLinkedList[size];
        this.arrSize = size;
    }

    /**
     * - check the hashmap to see if there is an Entry for the
     * GraphNode “key”, if there is, change its value to “value”, otherwise, add it
     * to the
     * hashmap with that value.
     * 
     * @param key
     * @param value
     */
    public void set(GraphNode key, int value) {
        int hashVal = hash(key);
        Integer val = this.hashArray[hashVal].get(key);
        if (val != null) {
            this.hashArray[hashVal].update(key, value);
        } else {
            this.hashArray[hashVal].insert(key, value);
        }
    }

    private int hash(GraphNode key) {
        int hashNum = 0;
        for (int i = 0; i < key.getId().length(); i++) {
            hashNum += key.getId().charAt(i);
        }
        return hashNum % getArrSize();
    }

    /**
     * gets the value for the entry with g as the key.
     * 
     * 
     * @param g
     * @return
     */
    public int getValue(GraphNode g) {
        return this.hashArray[hash(g)].get(g);
    }

    /**
     * true if the hashmap has that key.
     * 
     * @param g
     * @return
     */
    public boolean hasKey(GraphNode g) {
        if (this.hashArray[hash(g)].get(g) != null) {
            return true;
        }
        return false;
    }
}
