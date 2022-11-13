/**
 * Your code goes in this file
 * fill in the empty methods to allow for the required
 * operations. You can add any fields or methods you want
 * to help in your implementations.
 */

public class AVLPlayerNode {
    private Player data;
    private double value;
    private AVLPlayerNode parent;
    private AVLPlayerNode leftChild;
    private AVLPlayerNode rightChild;
    private int rightWeight;
    private int balanceFactor;

    public AVLPlayerNode(Player data, double value) {
        this.data = data;
        this.value = value;
    }

    // This should return the new root of the tree
    // make sure to update the balance factor and right weight
    // and use rotations to maintain AVL condition
    public AVLPlayerNode insert(Player newGuy, double value) {
        if (value < this.value) { // left
            if (this.leftChild == null) {
                this.leftChild = new AVLPlayerNode(newGuy, value);
                this.leftChild.parent = this;
            } else {
                this.leftChild.insert(newGuy, value);
            }
            this.balanceFactor++;

        } else if (value > this.value) { // right
            if (this.rightChild == null) {
                this.rightChild = new AVLPlayerNode(newGuy, value);
                this.rightChild.parent = this;
            } else {
                this.rightChild.insert(newGuy, value);
            }
            this.balanceFactor--;

            this.rightWeight++;
        }

        // rebalancing
        this.autoBalance();

        return this;
    }

    private void autoBalance() {
        if (this.balanceFactor > 1) {

            if (this.leftChild != null) { // double right
                if (this.leftChild.balanceFactor < 0) {
                    this.leftChild.rotateLeft();
                    this.rotateRight();

                    if (this.parent.balanceFactor == 0) {
                        this.parent.leftChild.balanceFactor = 0;
                        this.balanceFactor = 0;
                    } else if (this.parent.balanceFactor < 0) {
                        this.balanceFactor = -1;
                        this.parent.leftChild.balanceFactor = 0;
                    } else {
                        this.balanceFactor = 0;
                        this.parent.leftChild.balanceFactor = 1;
                    }
                    this.parent.balanceFactor = 0;

                    return;
                }
            }

            this.rotateRight();
            if (this.parent.balanceFactor == 0) {
                this.balanceFactor = 1;
                this.parent.balanceFactor = -1;
            } else {
                this.balanceFactor = 0;
                this.parent.balanceFactor = 0;
            }

        } else if (this.balanceFactor < -1) {

            if (this.rightChild != null) { // double left
                if (this.rightChild.balanceFactor > 0) {
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

                    return;
                }
            }

            this.rotateLeft();
            if (this.parent.balanceFactor == 0) {
                this.balanceFactor = -1;
                this.parent.balanceFactor = 1;
            } else {
                this.balanceFactor = 0;
                this.parent.balanceFactor = 0;
            }
        }

    }

    public AVLPlayerNode getRoot() {
        if (this.parent != null) {
            return this.parent.getRoot();
        } else {
            return this;
        }
    }

    // This should return the new root of the tree
    // remember to update the right weight
    public AVLPlayerNode delete(double value) {
        // TODO: write standard vanilla BST delete method
        // Extra Credit: use rotations to maintain the AVL condition
        return null;
    }

    // remember to maintain rightWeight
    private void rotateRight() {
        AVLPlayerNode y = this.leftChild;
        y.rightWeight = y.rightWeight + this.rightWeight + 1;

        this.leftChild = y.rightChild;
        if (y.rightChild != null) {
            y.rightChild.parent = this;
        }
        y.parent = this.parent;
        if (this.parent == null) {
            // // we dont actually need this check because "tree.root" isn't a feature we're
            // checking? might be mistaken tho
        } else if (this == this.parent.rightChild) {
            this.parent.rightChild = y;
        } else {
            this.parent.leftChild = y;
        }
        y.rightChild = this;
        this.parent = y;
    }

    // remember to maintain rightWeight
    private void rotateLeft() {
        AVLPlayerNode y = this.rightChild;
        this.rightChild = y.leftChild;

        if (y.leftChild != null) {
            y.leftChild.parent = this;
            this.rightWeight = y.rightWeight;
        } else {
            this.rightWeight = 0;
        }
        y.parent = this.parent;
        if (y.parent == null) {
            // t root stuff we don't need
        } else if (this == this.parent.leftChild) {
            this.parent.leftChild = y;
        } else {
            this.parent.rightChild = y;
        }
        y.leftChild = this;
        this.parent = y;
    }

    public void printMe(AVLPlayerNode node, int n) {
        if (node.leftChild != null) {
            printMe(node.leftChild, n + 1);
        }
        System.out.print(new String(new char[n]).replace("\0", " "));
        System.out.printf("%s is elo %d", node.data.toString(), node.value);
        if (node.leftChild != null) {
            printMe(node.leftChild, n + 1);
        }
    }

    // this should return the Player object stored in the node with this.value ==
    // value
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

    // this should return the rank of the node with this.value == value
    public int getRank(double value) {
        if (value == this.value) {
            return this.rightWeight;
        } else if (value > this.value && this.rightChild != null) {
            return this.rightChild.getRank(value);
        }

        if (value < this.value && this.leftChild != null) { // TODO
            return this.leftChild.getRank(value) + 1; // MAYBE FIXED???
        } else if (value > this.value && this.rightChild != null) {
            return this.rightChild.getRank(value);
        } else {
            return this.rightWeight;
        }
    }

    // this should return the tree of names with parentheses separating subtrees
    // eg "((bob)alice(bill))"
    public String treeString_submittable() {
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

    public String treeString() {
        String s = "(";

        if (this.leftChild != null) {
            s = s + this.leftChild.treeString();
        }
        s = s + this.data.getName() + " " + this.balanceFactor;
        if (this.rightChild != null) {
            s = s + this.rightChild.treeString();
        }
        s = s + ")";
        return s;
    }

    // this should return a formatted scoreboard in descending order of value
    // see example printout in the pdf for the command L
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

    public String scoreboard() {
        return String.join("", "NAME          ID  SCORE", this.scoreboard_loop(), "\n");
    }

}
