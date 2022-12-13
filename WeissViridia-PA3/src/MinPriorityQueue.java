
public class MinPriorityQueue {
    // static final int HEAP_SIZE = 128;
    private GraphNode[] heapArray;
    private int heapSize;
    protected HashMap indexMap;

    public MinPriorityQueue(int size) {
        this.heapArray = new GraphNode[size];
        // this.arrSize = size;
        this.heapArray[0] = null;
        // this.arrLength = 0;
        this.heapSize = 0;
        this.indexMap = new HashMap(size);
    }

    private GraphNode getParent(int i) {
        if (i > 0) {
            return this.heapArray[((int) i / 2)];
        }
        return null;
    }

    private GraphNode get(int i) {
        return this.heapArray[i];
    }

    private GraphNode getLeft(int i) {
        return this.heapArray[(2 * (i))];
    }

    private GraphNode getRight(int i) {
        return this.heapArray[((2 * (i)) + 1)];
    }

    private boolean hasChildren(int i) {
        if (getLeft(i) != null || getRight(i) != null) {
            return true;
        }
        return false;
    }

    private boolean isSwappable(int i) {
        if (getLeft(i) != null && getLeft(i).priority < get(i).priority) {
            return true;
        } else if (getRight(i) != null && getRight(i).priority < get(i).priority) {
            return true;
        }
        return false;
    }

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

    public void buildMinHeap() {
        buildMinHeap(1);
    }

    public void buildMinHeap(int x) {
        for (int i = (this.heapSize / 2); i > (x - 1); i--) {
            heapifyDown(i);
        }
    }

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

    }

    private void swapParent(int i) {
        swapWith(i, i / 2);
    };

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
