import java.math.*;;

public class MinPriorityQueue {
    // static final int HEAP_SIZE = 128;
    private GraphNode[] heapArray;
    private int arrSize;
    private int arrLength;
    private int heapSize;

    public MinPriorityQueue(int size) {
        this.heapArray = new GraphNode[size];
        this.arrSize = size;
        this.arrLength = 0;
    }

    public GraphNode getParent(int i) {
        return this.heapArray[(int) i / 2];
    }

    public GraphNode get(int i) {
        return this.heapArray[i];
    }

    public GraphNode getLeft(int i) {
        return this.heapArray[2 * i];
    }

    public GraphNode getRight(int i) {
        return this.heapArray[(2 * i) + 1];
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
            if (getLeft(i).priority < getRight(i).priority) {
                return 2 * i;
            }
            if (getLeft(i).priority > getRight(i).priority) {
                return (2 * i) + 1;
            }
        }
        return -1;
    }

    public void buildMinHeap() {
        this.heapSize = arrLength;
        for (int i = (arrLength / 2); i > 0; i++) {
            heapifyDown(i);
        }
    }

    public GraphNode deleteMin() {
        int lih = 0;
        this.heapArray[0] = get(heapSize - 1);
        while (hasChildren(lih) && isSwappable(lih)) {
            int sm = smallerChild(lih);
            GraphNode smallerchild = get(sm);
            this.heapArray[sm] = this.heapArray[lih];
            this.heapArray[lih] = smallerchild;
            lih = sm;
        }
        return get(lih);
    }

    public void heapifyDown(int i) {
        int smallest = 0;
        int l = (2 * i);
        int r = ((2 * i) + 1);
        if (l <= this.heapSize && getLeft(i).priority < getRight(i).priority) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r <= this.heapSize && getRight(i).priority < get(smallest).priority) {
            smallest = r;
        }
        if (smallest != i) {
            GraphNode smallestNode = get(smallest);
            this.heapArray[smallest] = this.heapArray[i];
            this.heapArray[i] = smallestNode;
            heapifyDown(smallest);
        }
    }

    public void heapifyUp(int i) {
        while (i > 1 && get(i).priority > getParent(i).priority) {
            GraphNode parentNode = getParent(i);
            this.heapArray[(int) i / 2] = this.heapArray[i];
            this.heapArray[i] = parentNode;
        }
    }

    public void heapify(GraphNode g) {
    }

    /**
     * this should insert g into the queue with its priority
     * 
     * @param g
     */
    public void insert(GraphNode g) {
        this.heapArray[arrLength] = g;
        int i = arrLength;
        while (i != 0 && get(i).priority < getParent(i).priority) {
            GraphNode parentNode = getParent(i);
            this.heapArray[(int) i / 2] = this.heapArray[i];
            this.heapArray[i] = parentNode;
        }
    }

    /**
     * this should return and remove from the priority queue the
     * GraphNode with the highest priority in the queue.
     * 
     * @return
     */
    public GraphNode pullHighestPriorityElement() {
        return null;
    }

    /**
     * this calls the heapify method described below.
     * 
     * @param g
     */
    public void rebalance(GraphNode g) {
    }

    /**
     * Returns true if the queue is empty.
     */
    public void isEmpty() {
    }

}
