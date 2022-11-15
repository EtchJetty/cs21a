/**
 * <p>
 * AVLPlayerNode. Node that creates an AVL self-balancing tree with special
 * functionality like <code>scoreboard()</code> to be used with
 * ScoreKeeper.java.
 * </p>
 * <p>
 * Known bugs: <code>delete()</code> doesn't change balance factors and thus
 * insertions do not work after a delete (only required for extra credit)
 * </p>
 * 
 * @author
 *         <p>
 *         Viridia Weiss
 *         </p>
 *         <p>
 *         gweiss@brandeis.edu
 *         </p>
 *         <p>
 *         November 13, 2022
 *         </p>
 *         <p>
 *         COSI 21A PA2
 *         </p>
 */

public class AVLPlayerNode {
    private Player data;
    private double value;
    private AVLPlayerNode parent;
    private AVLPlayerNode leftChild;
    private AVLPlayerNode rightChild;
    private int leftWeight;
    private int rightWeight;
    private int balanceFactor;

    /**
     * @param data
     * @param value
     */
    public AVLPlayerNode(Player data, double value) {
        this.data = data;
        this.value = value;
    }

    /**
     * Insertion function. This makes sure to update the balance factor and right
     * weight
     * and uses rotations to maintain AVL condition. Runtime is O(log(n))
     * 
     * @param newGuy new player for node
     * @param value  value stored alongside player (ELO or ID)
     * @return the new root of the tree
     */
    public AVLPlayerNode insert(Player newGuy, double value) {
        if (value < this.value) { // left
            if (this.leftChild == null) {
                this.leftChild = new AVLPlayerNode(newGuy, value);
                this.leftChild.parent = this;
                this.leftChild.balanceFactor();
            } else {
                this.leftChild.insert(newGuy, value);
            }
            this.leftWeight++;

        } else if (value > this.value) { // right
            if (this.rightChild == null) {
                this.rightChild = new AVLPlayerNode(newGuy, value);
                this.rightChild.parent = this;
                this.rightChild.balanceFactor();

            } else {
                this.rightChild.insert(newGuy, value);
            }
            this.rightWeight++;
        }

        return this.autoBalance();
    }

    /**
     * Recursive balanceFactor update function for insert(). Runtime is O(log(n))
     */
    private void balanceFactor() {
        if (this.parent != null) {
            if (this.parent.leftChild == this) {
                this.parent.balanceFactor++;
            } else {
                this.parent.balanceFactor--;
            }
            if (this.parent.balanceFactor != 0) {
                this.parent.balanceFactor();
            }
        }
    }

    /**
     * Recursive balanceFactor update function for autoBalance(). Runtime is
     * O(log(n))
     */
    private void balanceFactorReversed() {
        if (this.parent != null) {

            if (this.parent.leftChild == this) {
                this.parent.balanceFactor--;
            } else {
                this.parent.balanceFactor++;
            }
            if ((this.parent.leftChild == this && this.parent.balanceFactor > -1)
                    || (this.parent.rightChild == this && this.parent.balanceFactor < 1)) {
                this.parent.balanceFactorReversed();
            }
        }
    }

    /**
     * Function that handles DoubleLeft and DoubleRight rotations, maintaining BF
     * and RW. Runtime is O(log(n))
     * 
     * @return root of the new tree
     */
    private AVLPlayerNode autoBalance() {
        if (this.balanceFactor > 1) {

            if (this.leftChild != null && this.leftChild.balanceFactor < 0) {
                this.leftChild.rotateLeft();
                this.rotateRight();

                if (this.parent.balanceFactor == 0) {
                    this.parent.leftChild.balanceFactor = 0;
                    this.balanceFactor = 0;
                } else if (this.parent.balanceFactor > 0) {
                    this.balanceFactor = -1;
                    this.parent.leftChild.balanceFactor = 0;
                } else {
                    this.balanceFactor = 0;
                    this.parent.leftChild.balanceFactor = 1;
                }
                this.parent.balanceFactor = 0;

            } else {

                this.rotateRight();
                if (this.parent.balanceFactor == 0) {
                    this.balanceFactor = 1;
                    this.parent.balanceFactor = -1;
                } else {
                    this.balanceFactor = 0;
                    this.parent.balanceFactor = 0;
                }
            }

            this.parent.balanceFactorReversed();

        } else if (this.balanceFactor < -1) {

            if (this.rightChild != null && this.rightChild.balanceFactor > 0) {
                this.rightChild.rotateRight();
                this.rotateLeft();

                if (this.parent.balanceFactor == 0) {
                    this.parent.rightChild.balanceFactor = 0;
                    this.balanceFactor = 0;
                } else if (this.parent.balanceFactor < 0) {
                    this.balanceFactor = 1;
                    this.parent.rightChild.balanceFactor = 0;
                } else {
                    this.balanceFactor = 0;
                    this.parent.rightChild.balanceFactor = -1;
                }
                this.parent.balanceFactor = 0;

            } else {

                this.rotateLeft();
                if (this.parent.balanceFactor == 0) {
                    this.balanceFactor = -1;
                    this.parent.balanceFactor = 1;
                } else {
                    this.balanceFactor = 0;
                    this.parent.balanceFactor = 0;
                }
            }

            this.parent.balanceFactorReversed();

        }

        if (this.parent == null) {
            return this;
        }
        return this.parent;

    }

    /**
     * Deletion function. Runtime is O(log(n))
     * 
     * @param value the value of the node to be deleted
     * @return the new root of the tree
     */
    public AVLPlayerNode delete(double value) {
        // Extra Credit: use rotations to maintain the AVL condition
        if (value < this.value && this.leftChild != null) {
            this.leftChild.delete(value);
        } else if (value > this.value && this.rightChild != null) {
            this.rightChild.delete(value);
        } else if (value == this.value) {
            return this.delete_node();
        }

        return this;
    }

    public AVLPlayerNode getRoot() {
        if (this.parent != null) {
            return this.parent.getRoot();
        } else {
            return this;
        }
    }

    private AVLPlayerNode delete_node() {
        if (this.leftChild == null) {
            this.shiftNodes(this.rightChild);
            return this.rightChild;
        } else if (this.rightChild == null) {
            this.shiftNodes(this.leftChild);
            return this.leftChild;
        } else {
            AVLPlayerNode y = this.treeSuccessor();
            if (y.parent != this) {
                y.shiftNodes(y.rightChild);
                y.rightChild = this.rightChild;
                y.rightChild.parent = y;
            }
            this.shiftNodes(y);
            y.leftChild = this.leftChild;
            y.leftChild.parent = y;
            return y;
        }
    }

    private AVLPlayerNode treeSuccessor() {
        if (this.rightChild != null) {
            AVLPlayerNode x = this.rightChild;
            while (x.leftChild != null) {
                x = x.leftChild;
            }
            return x;
        }
        AVLPlayerNode y = this.parent;
        AVLPlayerNode yCompare = this;

        while (y != null && yCompare == y.rightChild) {
            yCompare = y;
            y = y.parent;
        }

        return y;
    }

    private void shiftNodes(AVLPlayerNode v) {
        if (this.parent != null) {
            if (this == this.parent.leftChild) {
                this.parent.leftChild = v;
            } else if (this == this.parent.rightChild) {
                this.parent.rightChild = v;
            }
        }
        if (v != null) {
            v.parent = this.parent;
        }
    }

    /**
     * Right rotation based on pseudocode. Handles left and right weights. O(1)
     */
    private void rotateRight() {
        AVLPlayerNode y = this.leftChild;
        int newLb = y.rightWeight;
        this.leftWeight = newLb;
        y.rightWeight = newLb + this.rightWeight + 1;

        this.leftChild = y.rightChild;
        if (y.rightChild != null) {
            y.rightChild.parent = this;
        } else {
            this.leftWeight = 0;
        }
        y.parent = this.parent;
        if (this.parent != null) {
            if (this == this.parent.rightChild) {
                this.parent.rightChild = y;
            } else if (this == this.parent.leftChild) {
                this.parent.leftChild = y;
            }
        }
        y.rightChild = this;
        this.parent = y;
    }

    /**
     * Right rotation based on pseudocode. Handles left and right weights. O(1)
     */
    private void rotateLeft() {
        AVLPlayerNode y = this.rightChild;
        int newRb = y.leftWeight;
        y.leftWeight = this.leftWeight + newRb + 1;
        this.rightWeight = newRb;

        this.rightChild = y.leftChild;

        if (y.leftChild != null) {
            y.leftChild.parent = this;
        } else {
            this.rightWeight = 0;
        }

        y.parent = this.parent;
        if (y.parent != null) {
            if (this == this.parent.leftChild) {
                this.parent.leftChild = y;
            } else if (this == this.parent.rightChild) {
                this.parent.rightChild = y;
            }
        }
        y.leftChild = this;
        this.parent = y;
    }

    /**
     * Runtime is O(log(n))
     * 
     * @param value the node to check
     * @return the Player object stored in the node with this.value ==
     *         value
     */
    public Player getPlayer(double value) {
        if (value < this.value && this.leftChild != null) {
            return this.leftChild.getPlayer(value);
        } else if (value > this.value && this.rightChild != null) {
            return this.rightChild.getPlayer(value);
        } else if (value == this.value) {
            return this.data;
        }
        return null;
    }

    /**
     * Function to get the rank of a given node using binary search. Runtime is
     * O(log(n))
     * 
     * @param value
     * @return the rank of the node with this.value == value
     */
    public int getRank(double value) {
        if (value > this.value) {
            return this.rightChild.getRank(value);
        } else if (value < this.value) {
            return this.rightWeight + 1 + this.leftChild.getRank(value);
        } else {
            return this.rightWeight + 1;
        }
    }

    /**
     * @return the tree of names with parentheses separating subtrees
     *         eg "((bob)alice(bill))". Runtime is O(n)
     */
    public String treeString() {
        String s = "(";

        if (this.leftChild != null) {
            s = s + this.leftChild.treeString();
        }
        s = s + this.data.getName();
        if (this.rightChild != null) {
            s = s + this.rightChild.treeString();
        }
        s = s + ")";
        return s;
    }

    /**
     * @return the tree of names with parentheses separating subtrees
     *         eg "((bob)alice(bill))" but with the balancefactor printed for
     *         debugging purposes. Runtime is O(n)
     */
    public String treeString_debug() {
        String s = "(";

        if (this.leftChild != null) {
            s = s + this.leftChild.treeString_debug();
        }
        s = s + this.data.getName() + " " + this.balanceFactor;
        if (this.rightChild != null) {
            s = s + this.rightChild.treeString_debug();
        }
        s = s + ")";
        return s;
    }

    /**
     * fencepost error prevention function. Runtime is O(n)
     * 
     * @return a formatted scoreboard in descending order of value
     * 
     */
    public String scoreboard_loop() {
        String s = "";

        if (this.rightChild != null) {
            s = s + this.rightChild.scoreboard_loop();
        }

        s = s + String.join("", "\n", String.format("%-14s", this.data.getName()),
                String.format("%2s", Integer.toString(this.data.getID())), " ", Double.toString(this.value));

        if (this.leftChild != null) {
            s = s + this.leftChild.scoreboard_loop();
        }

        return s;
    }

    /**
     * Scoreboard generator. Runtime is O(n)
     * 
     * @return the top line of the scoreboard plus the formatted scoreboard
     *         generated by scoreboard_loop()
     */
    public String scoreboard() {
        return String.join("", "NAME          ID  SCORE", this.scoreboard_loop(), "\n");
    }

}
