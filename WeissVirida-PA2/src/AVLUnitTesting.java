import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AVLUnitTesting {
    AVLPlayerNode node;

    @Test
    void testTreeOfSeven() {
        node = new AVLPlayerNode(makePlayer(1), 1);
        assertEquals(node.treeString_debug(), "(1 0)");
        assertEquals(node.treeString(), "(1)");

        node = insertSingleNode(node, 2);
        assertEquals(node.treeString_debug(), "(1 -1(2 0))");
        assertEquals(node.treeString(), "(1(2))");

        node = insertSingleNode(node, 3);
        assertEquals(node.treeString_debug(), "((1 0)2 0(3 0))");
        assertEquals(node.treeString(), "((1)2(3))");

        node = insertSingleNode(node, 4);
        assertEquals(node.treeString_debug(), "((1 0)2 -1(3 -1(4 0)))");
        assertEquals(node.treeString(), "((1)2(3(4)))");

        node = insertSingleNode(node, 5);
        assertEquals(node.treeString_debug(), "((1 0)2 -1((3 0)4 0(5 0)))");
        assertEquals(node.treeString(), "((1)2((3)4(5)))");

        node = insertSingleNode(node, 6);
        assertEquals(node.treeString_debug(), "(((1 0)2 0(3 0))4 0(5 -1(6 0)))");
        assertEquals(node.treeString(), "(((1)2(3))4(5(6)))");

        node = insertSingleNode(node, 7);
        assertEquals(node.treeString_debug(), "(((1 0)2 0(3 0))4 0((5 0)6 0(7 0)))");
        assertEquals(node.treeString(), "(((1)2(3))4((5)6(7)))");

        node = insertSingleNode(node, 8);
        assertEquals(node.treeString_debug(), "(((1 0)2 0(3 0))4 -1((5 0)6 -1(7 -1(8 0))))");
        assertEquals(node.treeString(), "(((1)2(3))4((5)6(7(8))))");

        node = insertSingleNode(node, 9);
        assertEquals(node.treeString_debug(), "(((1 0)2 0(3 0))4 -1((5 0)6 -1((7 0)8 0(9 0))))");
        assertEquals(node.treeString(), "(((1)2(3))4((5)6((7)8(9))))");

        node = insertSingleNode(node, 10);
        assertEquals(node.treeString_debug(), "(((1 0)2 0(3 0))4 -1(((5 0)6 0(7 0))8 0(9 -1(10 0))))");
        assertEquals(node.treeString(), "(((1)2(3))4(((5)6(7))8(9(10))))");

        node = insertSingleNode(node, 11);
        assertEquals(node.treeString_debug(), "(((1 0)2 0(3 0))4 -1(((5 0)6 0(7 0))8 0((9 0)10 0(11 0))))");
        assertEquals(node.treeString(), "(((1)2(3))4(((5)6(7))8((9)10(11))))");

        node = insertSingleNode(node, 12);
        assertEquals(node.treeString_debug(), "((((1 0)2 0(3 0))4 0((5 0)6 0(7 0)))8 0((9 0)10 -1(11 -1(12 0))))");
        assertEquals(node.treeString(), "((((1)2(3))4((5)6(7)))8((9)10(11(12))))");

        node = insertSingleNode(node, 13);
        assertEquals(node.treeString_debug(), "((((1 0)2 0(3 0))4 0((5 0)6 0(7 0)))8 0((9 0)10 -1((11 0)12 0(13 0))))");
        assertEquals(node.treeString(), "((((1)2(3))4((5)6(7)))8((9)10((11)12(13))))");

        node = insertSingleNode(node, 14);
        assertEquals(node.treeString_debug(),
                "((((1 0)2 0(3 0))4 0((5 0)6 0(7 0)))8 0(((9 0)10 0(11 0))12 0(13 -1(14 0))))");
        assertEquals(node.treeString(), "((((1)2(3))4((5)6(7)))8(((9)10(11))12(13(14))))");
        node = insertSingleNode(node, 15);
        assertEquals(node.treeString_debug(),
                "((((1 0)2 0(3 0))4 0((5 0)6 0(7 0)))8 0(((9 0)10 0(11 0))12 0((13 0)14 0(15 0))))");
        assertEquals(node.treeString(), "((((1)2(3))4((5)6(7)))8(((9)10(11))12((13)14(15))))");

    }

    @Test
    void testLeftRotationCase() {
        node = new AVLPlayerNode(makePlayer(1), 1);
        node = insertSingleNode(node, 2);
        node = insertSingleNode(node, 3); // rotate left
        assertEquals(node.treeString(), "((1)2(3))");
    }

    @Test
    void testRightRotationCase() {
        node = new AVLPlayerNode(makePlayer(3), 3);
        node = insertSingleNode(node, 2);
        node = insertSingleNode(node, 1); // rotate right
        assertEquals(node.treeString(), "((1)2(3))");
    }

    @Test
    void testDoubleLeftRotationCase() {
        node = new AVLPlayerNode(makePlayer(1), 1);
        node = insertSingleNode(node, 3);
        node = insertSingleNode(node, 2); // double left
        assertEquals(node.treeString(), "((1)2(3))");
    }

    @Test
    void testDoubleRightRotationCase() {
        node = new AVLPlayerNode(makePlayer(3), 3);
        node = insertSingleNode(node, 1);
        node = insertSingleNode(node, 2); // double right
        assertEquals(node.treeString(), "((1)2(3))");
    }

    @Test
    void testPA2Case() {
        AVLPlayerNode eloTree = new AVLPlayerNode(new Player("Mike", 1, 2400), 2400);
        eloTree = eloTree.insert(new Player("Sandra", 2, 2300), 2300);
        eloTree = eloTree.insert(new Player("Eric", 3, 2200), 2200);
        eloTree = eloTree.insert(new Player("Fred", 4, 2100), 2100);

        AVLPlayerNode idTree = new AVLPlayerNode(new Player("Mike", 1, 2400), 1);
        idTree = idTree.insert(new Player("Sandra", 2, 2300), 2);
        idTree = idTree.insert(new Player("Eric", 3, 2200), 3);
        idTree = idTree.insert(new Player("Fred", 4, 2100), 4);

        assertEquals(eloTree.treeString(), "(((Fred)Eric)Sandra(Mike))");
        assertEquals(idTree.treeString(), "((Mike)Sandra(Eric(Fred)))");

        Player p = idTree.getPlayer((double) 1);
        assertEquals(String.format("ID: %d NAME: %s RANK: %d\n", 1, p.getName(), eloTree.getRank(p.getELO())),
                "ID: 1 NAME: Mike RANK: 1\n");

        p = idTree.getPlayer((double) 2);
        assertEquals(String.format("ID: %d NAME: %s ELO: %f\n", 2, p.getName(), p.getELO()),
                "ID: 2 NAME: Sandra ELO: 2300.000000\n");

        assertEquals(eloTree.scoreboard(),
                "NAME          ID  SCORE\nMike           1 2400.0\nSandra         2 2300.0\nEric           3 2200.0\nFred           4 2100.0\n");
    }

    @Test
    void testPA2CaseWithDelete() {
        AVLPlayerNode eloTree = new AVLPlayerNode(new Player("Mike", 1, 2400), 2400);
        eloTree = eloTree.insert(new Player("Sandra", 2, 2300), 2300);
        eloTree = eloTree.insert(new Player("Fred", 4, 2100), 2100);
        eloTree = eloTree.insert(new Player("Eric", 3, 2200), 2200);

        AVLPlayerNode idTree = new AVLPlayerNode(new Player("Mike", 1, 2400), 1);
        idTree = idTree.insert(new Player("Sandra", 2, 2300), 2);
        idTree = idTree.insert(new Player("Fred", 4, 2100), 4);
        idTree = idTree.insert(new Player("Eric", 3, 2200), 3);

        assertEquals(eloTree.treeString(), "((Fred(Eric))Sandra(Mike))");

        Player curtains = idTree.getPlayer((double) 2);
        idTree = idTree.delete(2);
        eloTree = eloTree.delete(curtains.getELO());

        assertEquals(eloTree.treeString(), "((Fred(Eric))Mike)");

        curtains = idTree.getPlayer((double) 1);
        idTree = idTree.delete(1);
        eloTree = eloTree.delete(curtains.getELO());

        assertEquals(eloTree.treeString(), "(Fred(Eric))");

        node = new AVLPlayerNode(makePlayer(1), 1);
        for (int i = 2; i < 16; i++) {
            node = insertSingleNode(node, i);
        }

        assertEquals(node.treeString(), "((((1)2(3))4((5)6(7)))8(((9)10(11))12((13)14(15))))");
        node = node.delete(11);
        assertEquals(node.treeString(), "((((1)2(3))4((5)6(7)))8(((9)10)12((13)14(15))))");
        node = node.delete(4);
        assertEquals(node.treeString(), "((((1)2(3))5(6(7)))8(((9)10)12((13)14(15))))");

    }

    public static Player makePlayer(int i) {
        Player p = new Player(Integer.toString(i), i, i);
        return p;
    }

    public static AVLPlayerNode insertSingleNode(AVLPlayerNode node, int nodeValue) {
        return node.insert(makePlayer(nodeValue), nodeValue);
    }
}
