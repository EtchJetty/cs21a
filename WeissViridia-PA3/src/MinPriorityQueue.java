/**
 * MinPriorityQueue
 * Known Bugs: Does not resize automatically, will crash if exceeds size.
 * 
 * @author Viridia Weiss
 * @email gweiss@brandeis.edu
 *        December 13th, 2022
 *        COSI 21A PA3
 */
public class MinPriorityQueue {
    // static final int HEAP_SIZE = 128;
    private GraphNode[] heapArray;
    private int heapSize;
    protected HashMap indexMap;

    /**
     * Generates an empty MinPriorityQueue.
     * 
     * @param size
     */
    public MinPriorityQueue(int size) {
        this.heapArray = new GraphNode[size];
        this.heapArray[0] = null;
        this.heapSize = 0;
        this.indexMap = new HashMap(size);
    }

    /**
     * Gets parent of the node at i.
     * 
     * @param i
     * @return
     */
    private GraphNode getParent(int i) {
        if (i > 0) {
            return this.heapArray[((int) i / 2)];
        }
        return null;
    }

    /**
     * Gets the node at i.
     * 
     * @param i
     * @return
     */
    private GraphNode get(int i) {
        return this.heapArray[i];
    }

    /**
     * Gets the left node of the node at i.
     * 
     * @param i
     * @return
     */
    private GraphNode getLeft(int i) {
        return this.heapArray[(2 * (i))];
    }

    /**
     * Gets the right node of the node at i.
     * 
     * @param i
     * @return
     */
    private GraphNode getRight(int i) {
        return this.heapArray[((2 * (i)) + 1)];
    }

    /**
     * Tests if node at i has at least one child.
     * 
     * @param i
     * @return
     */
    private boolean hasChildren(int i) {
        if (getLeft(i) != null || getRight(i) != null) {
            return true;
        }
        return false;
    }

    /**
     * Tests if either of the node at i's children can swap with i.
     * 
     * @param i
     * @return
     */
    private boolean isSwappable(int i) {
        if (getLeft(i) != null && getLeft(i).priority < get(i).priority) {
            return true;
        } else if (getRight(i) != null && getRight(i).priority < get(i).priority) {
            return true;
        }
        return false;
    }

    /**
     * Returns the smaller child of i.
     * 
     * @param i
     * @return
     */
    private int smallerChild(int i) {
        if (getLeft(i) != null && getRight(i) == null) {
            return 2 * i;
        } else if (getRight(i) != null && getLeft(i) == null) {
            return (2 * i) + 1;
        } else if (getLeft(i) != null && getRight(i) != null) {
            if (getLeft(i).priority <= getRight(i).priority) {
                return 2 * i;
            }
            if (getLeft(i).priority >= getRight(i).priority) {
                return (2 * i) + 1;
            }
        }
        return -1;
    }

    /**
     * Builds a heap from the root down.
     * 
     */
    public void buildMinHeap() {
        buildMinHeap(1);
    }

    /**
     * Builds a heap from i down.
     * 
     * @param x
     */
    public void buildMinHeap(int x) {
        for (int i = (this.heapSize / 2); i > (x - 1); i--) {
            heapifyDown(i);
        }
    }

    /**
     * HeapifyDown.
     * 
     * @param i
     */
    public void heapifyDown(int i) {
        int smallest = 1;
        int l = (2 * i);
        int r = ((2 * i) + 1);

        if (l <= this.heapSize && getLeft(i).priority < get(i).priority) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r <= this.heapSize && getRight(i).priority < get(smallest).priority) {
            smallest = r;
        }
        if (smallest != i) {
            swapWith(i, smallest);
            heapifyDown(smallest);
        }
    }

    /**
     * HeapifyUp.
     * 
     * @param i
     */
    public void heapifyUp(int i) {
        while (i > 1 && get(i).priority < getParent(i).priority) {
            swapParent(i);
        }
    }

    /**
     * this should insert g into the queue with its priority
     * 
     * @param g
     */
    public void insert(GraphNode g) {
        this.heapSize += 1;
        this.heapArray[heapSize] = g;
        int i = heapSize;

        while (i != 1 && get(i).priority < getParent(i).priority) {
            swapParent(i);
        }
        this.indexMap.set(get(i), i);

        // if (this.heapArray.length < (this.heapSize + 1)) {
        //     GraphNode[] newArr = new GraphNode[(this.heapArray.length + 1) * 4];
        //     for (int j = 0; j < this.heapArray.length; j++) {
        //         newArr[j] = this.heapArray[j];
        //     }
        //     this.heapArray = newArr;
        // }
    }

    /**
     * Swaps item with its parent.
     * 
     * @param i
     */
    private void swapParent(int i) {
        swapWith(i, i / 2);
    };

    /**
     * Swaps the nodes at i and b.
     * 
     * @param i
     * @param b
     */
    private void swapWith(int i, int b) {
        GraphNode bNode = get(b);

        this.heapArray[(int) b] = this.heapArray[i];
        this.heapArray[i] = bNode;

        this.indexMap.set(get(i), i);
        this.indexMap.set(get(b), b);
    };

    /**
     * this should return and remove from the priority queue the
     * GraphNode with the highest priority in the queue.
     * 
     * @return
     */
    public GraphNode pullHighestPriorityElement() {
        int lih = 1;
        GraphNode rootNode = this.heapArray[1];
        this.heapArray[1] = get(heapSize);
        this.indexMap.set(get(1), 1);
        this.heapArray[heapSize] = null;
        this.heapSize -= 1;
        while (hasChildren(lih) && isSwappable(lih)) {
            int sm = smallerChild(lih);
            swapWith(lih, sm);
            lih = sm;
        }

        this.indexMap.set(rootNode, -1);
        return rootNode;
    }

    /**
     * this calls the heapify method described below.
     * 
     * @param g
     */
    public void rebalance(GraphNode g) {
        buildMinHeap(this.indexMap.getValue(g));
    }

    /**
     * Returns true if the queue is empty.
     */
    public boolean isEmpty() {
        if (this.heapSize > 0) {
            return false;
        }
        return true;
    }

}
