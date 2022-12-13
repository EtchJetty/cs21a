/**
 * HashMap
 * Known Bugs: None
 * 
 * @author Viridia Weiss
 * @email gweiss@brandeis.edu
 *        December 13th, 2022
 *        COSI 21A PA3
 */
public class HashMap {

    private DoubleLinkedList[] hashArray;
    private int arrSize;
    private int numElements;

    public HashMap(int size) {
        this.hashArray = new DoubleLinkedList[size];
        this.arrSize = size;
        this.numElements = 0;
    }

    public int getArrSize() {
        return arrSize;
    }

    public double loadFactor() {
        return numElements / arrSize;
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
        set(key, value, this.hashArray);
    }

    private void set(GraphNode key, int value, DoubleLinkedList[] specificHashArray) {
        int hashVal = hash(key);

        DoubleLinkedList bucket = specificHashArray[hashVal];
        if (bucket == null) {
            specificHashArray[hashVal] = new DoubleLinkedList();
            bucket = specificHashArray[hashVal];
        }

        Integer val = bucket.get(key);

        if (val != null) {
            bucket.update(key, value);
        } else {
            bucket.insert(key, value);
            // bandaid fix for recursion issue
            if (specificHashArray == this.hashArray) {
                this.numElements += 1;
            }
            if (loadFactor() >= 0.5) {
                rehashing();
            }
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
        if (this.hashArray[hash(g)] != null) {
            if (this.hashArray[hash(g)].get(g) != null) {
                return true;
            }
        }
        return false;
    }

    public void rehashing() {
        DoubleLinkedList[] rehashArray = new DoubleLinkedList[arrSize * 2];
        this.arrSize *= 2;

        for (int i = 0; i < this.hashArray.length; i++) {
            if (this.hashArray[i] != null) {
                while (this.hashArray[i].getFirst() != null) {
                    Entry entry = this.hashArray[i].getFirst().getEntry();
                    set(entry.getKey(), entry.getValue(), rehashArray);
                    this.hashArray[i].delete(entry.getKey());
                }
            }
        }

        this.hashArray = rehashArray;
    }
}
