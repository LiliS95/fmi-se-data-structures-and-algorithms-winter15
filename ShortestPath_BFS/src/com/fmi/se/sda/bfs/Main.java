package com.fmi.se.sda.bfs;

import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Dimitar
 */
public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        String file = "C:\\Users\\Dimitar\\Desktop\\tree.json";

        Tree tree = TreeBuilder.buildTree(file);

        Node startNode = tree.nodes.get(1);
        Node endNode = tree.nodes.get(14);

        List<Node> shortestPath = getShortestPath(startNode, endNode);

        System.out.println(shortestPath.toString());
    }

    private static List<Node> getShortestPath(Node startNode, Node endNode) {
        //TODO: implement
        return null;
    }
}
