package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * composite
 */
abstract class Node {
    abstract public void p();
}

class LeafNode extends Node {

    String content = "";

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    public void p() {
        System.out.println(content);
    }
}

class BranchNode extends Node {

    String name = "";
    List<Node> nodes = new ArrayList<Node>();

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    public void p() {
        System.out.println(this.name);
    }

    public void add(Node n) {
        nodes.add(n);
    }
}

public class Main {

    public static void main(String[] args) {

        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BranchNode b21 = new BranchNode("section21");
        LeafNode c211 = new LeafNode("c211");
        LeafNode c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

        tree(root, 0);
    }

    static void tree(Node node, int depth) {

        for (int i=0; i<depth*2; i++){
            System.out.print("-");
        }
        node.p();
        if (node instanceof BranchNode) {

            for (Node node1 : ((BranchNode) node).nodes) {
                tree(node1, depth+1);
            }
        }
    }
}
