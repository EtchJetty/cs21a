
/**
 * This code has been provided for you
 * The only modifications you need to make are deleting the comments,
 * and removing the filler code, 
 * like return null or System.out.println("Unsupported Operation")
 * as you complete the AVLPlayerNode class.
 * Aside from getTree, all commented code is inside of the driverLoop
 *
 * @author COSI 21a-Team
 */

import java.util.Scanner;

public class ScoreKeeper_Modified {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Player[] startPlayers = getPlayers(scan);
		AVLPlayerNode eloTree = getTree(startPlayers, true);
		AVLPlayerNode idTree = getTree(startPlayers, false);
		driverLoop(scan, eloTree, idTree, startPlayers.length);
	}

	public static Player[] getPlayers(Scanner scan) {
		System.out.println(
				"Hello, I'm ScoreKeeper. Let's start a new scoreboard, shall we? How many players do you need to add to the scoreboard? (must be at least 3)");
		int n = scan.nextInt();
		while (n < 3) {
			System.out.println("must be at least 3");
			n = scan.nextInt();
		}
		System.out.printf("Thank you. You may now enter in %d players, one at a time\n", n);
		Player[] people = new Player[n];
		for (int i = 0; i < n; i++) {
			// people[i] = getNextPlayer(scan);
			people[i] = genBadPlayer(i);
		}
		return people;
	}

	/**
	 * testing function to generate tree
	 * 
	 * @param i
	 * @return
	 */
	public static Player genBadPlayer(int i) {
		Player p = new Player(Integer.toString(i + 1), i + 1, i + 1);
		return p;
	}

	public static Player getNextPlayer(Scanner scan) {
		System.out.println("Please enter the name of a player you wish to add");
		String name = scan.next();
		System.out.println("Please enter the id number for " + name);
		int id = scan.nextInt();
		System.out.println("Please enter the current ELO rating for " + name);
		double elo = scan.nextDouble();
		Player p = new Player(name, id, elo);
		return p;
	}

	public static AVLPlayerNode getTree(Player[] players, boolean useElo) {
		// Uncomment this code when you have implemented insert

		AVLPlayerNode tree = new AVLPlayerNode(players[0], (double) players[0].getID());
		if (useElo) {
			tree = new AVLPlayerNode(players[0], players[0].getELO());
		}
		for (int i = 1; i < players.length; i++) {
			if (useElo) {
				tree = tree.insert(players[i], players[i].getELO());
			} else {
				tree = tree.insert(players[i], (double) players[i].getID());
			}
		}
		return tree;

	}

	public static void checkRank(AVLPlayerNode eloTree, AVLPlayerNode idTree, Scanner scan) {
		System.out.println("Please enter the ID number of the player whose rank you wish to check");
		int id = scan.nextInt();
		Player p = idTree.getPlayer((double) id);
		System.out.printf("ID: %d NAME: %s RANK: %d\n", id, p.getName(), eloTree.getRank(p.getELO()));
	}

	public static void checkELO(AVLPlayerNode idTree, Scanner scan) {
		System.out.println("Please enter the ID number of the player whose ELO you wish to check");
		int id = scan.nextInt();
		Player p = idTree.getPlayer((double) id);
		System.out.printf("ID: %d NAME: %s ELO: %f\n", id, p.getName(), p.getELO());
	}

	public static void driverLoop(Scanner scan, AVLPlayerNode eloTree, AVLPlayerNode idTree, int numPeople) {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.printf(
					"What would you like to do next?\nA/D to Add/Delete a player to the scoreboard\nR/E to check the Rank or Elo rating of a player (requires player ID)\nL to list the entire leader board in order of Elo (decreasing order)\nM to log the outcome of a chess Match between two players\nP to Print the elo tree in parentheses format\nX to eXit\n");
			String answer = scan.next();
			char ans = answer.charAt(0);
			switch (ans) {
				case 'X':
					keepGoing = false;
					break;
				case 'A':
					// Uncomment this code when you have implemented insert

					Player p = getNextPlayer(scan);
					eloTree = eloTree.insert(p, p.getELO());
					idTree = idTree.insert(p, (double) p.getID());
					numPeople++;
					// System.out.println("Unsupported operation");
					break;
				case 'D':
					if (numPeople > 3) {
						// Uncomment this code when you have implemented delete

						System.out
								.println("Please enter the ID number of the player you wish to remove from the system");
						int id = scan.nextInt();
						Player curtains = idTree.getPlayer((double) id);
						idTree = idTree.delete(id);
						eloTree = eloTree.delete(curtains.getELO());
						numPeople--;
						// System.out.println("Unsupported operation");
					} else {
						System.out.println("Cannot afford to lose any more people");
					}
					break;
				case 'R':
					// Uncomment this code when you have implemented getPlayer and getRank
					checkRank(eloTree, idTree, scan);
					// System.out.println("Unsupported Operation");
					break;
				case 'E':
					// Uncomment this code when you have implemented getRank
					checkELO(idTree, scan);
					// System.out.println("Unsupported Operation");
					break;
				case 'L':
					// Uncomment this code when you have implemented scoreboard
					System.out.println(eloTree.scoreboard());
					// System.out.println("Unsupported Operation");
					break;
				case 'P':
					// Uncomment this code when you have implemented treeString
					System.out.println("ELO tree: " + eloTree.treeString());
					System.out.println("ID tree: " + idTree.treeString());
					// System.out.println("Unsupported Operation");
					break;
				case 'M':
					// extra credit, requires self balancing delete
					// Uncomment this when you have implemented the extra credit

					/*
					 * System.out.
					 * println("Please enter the ID number of the first player in the match");
					 * int id1=scan.nextInt();
					 * Player p1 = idTree.getPlayer((double)id1);
					 * idTree=idTree.delete((double)id1);
					 * eloTree=eloTree.delete(p1.getELO());
					 * System.out.
					 * println("Please enter the ID number of the second player in the match");
					 * int id2=scan.nextInt();
					 * Player p2 = idTree.getPlayer((double)id2);
					 * idTree=idTree.delete((double)id2);
					 * eloTree=eloTree.delete(p2.getELO());
					 * System.out.
					 * printf("Please enter the outcome of the match\n1 if the first player (%s) was the winner\n2 if the second player (%s) was the winner\n0 if the match was a draw\n"
					 * ,p1.getName(),p2.getName());
					 * int n = scan.nextInt();
					 * if(n==2){
					 * p2.logVictory(p1);
					 * }else if(n==1){
					 * p1.logVictory(p2);
					 * }else if(n==0){
					 * p1.stalemate(p2);
					 * }else{
					 * System.out.println("Invalid command");
					 * break;
					 * }
					 * idTree=idTree.insert(p1,(double)p1.getID());
					 * idTree=idTree.insert(p2,(double)p2.getID());
					 * eloTree=eloTree.insert(p1,p1.getELO());
					 * eloTree=eloTree.insert(p2,p2.getELO());
					 */
					System.out.println("Unsupported Operation");
					break;
				default:
					System.out.println("Invalid command");
					break;
			}
		}
	}
}
