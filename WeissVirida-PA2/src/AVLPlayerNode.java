/**
 * Your code goes in this file
 * fill in the empty methods to allow for the required
 * operations. You can add any fields or methods you want
 * to help in your implementations.
 */

public class AVLPlayerNode{
    private Player data;
    private double value;
    private AVLPlayerNode parent;
    private AVLPlayerNode leftChild;
    private AVLPlayerNode rightChild;
    private int rightWeight;
    private int balanceFactor;
    
    public AVLPlayerNode(Player data,double value){
        //TODO
    }
    
    //This should return the new root of the tree
    //make sure to update the balance factor and right weight
    //and use rotations to maintain AVL condition
    public AVLPlayerNode insert(Player newGuy,double value){
    	//TODO
    	return null;
    }
    
    //This should return the new root of the tree
    //remember to update the right weight
    public AVLPlayerNode delete(double value){
	//TODO: write standard vanilla BST delete method
    	//Extra Credit: use rotations to maintain the AVL condition
    	return null;
    }
    
    //remember to maintain rightWeight
    private void rotateRight(){
    	//TODO
    }

    //remember to maintain rightWeight
    private void rotateLeft(){
    	//TODO
    }
	
    //this should return the Player object stored in the node with this.value == value
    public Player getPlayer(double value){
    	//TODO
    	return null;
    }
    
    //this should return the rank of the node with this.value == value
    public int getRank(double value){
        //TODO
    	return 0;
    }

    //this should return the tree of names with parentheses separating subtrees
    //eg "((bob)alice(bill))"
    public String treeString(){
    	//TODO
    	return "";
    }

    //this should return a formatted scoreboard in descending order of value
    //see example printout in the pdf for the command L
    public String scoreboard(){
    	//TODO
    	return "";
    }
	
}
    
	
