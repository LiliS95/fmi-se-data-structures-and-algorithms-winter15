package com.fmi.se.sda.bfs;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Dimitar
 */
public class TreeBuilder {

    public static Tree buildTree(String file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonTree = (JSONObject) parser.parse(new FileReader(file));

        Tree tree = new Tree();

        for (int i = 1; i <= jsonTree.size(); i++) {
            tree.nodes.put(i, new Node(i));
        }

        for (int i = 1; i <= jsonTree.size(); i++) {
            JSONArray children = (JSONArray) jsonTree.get(String.valueOf(i));
            Node node = tree.nodes.get(i);

            for (int j = 0; j < children.size(); j++) {
                String child = Long.toString((long) children.get(j));
                node.children.add(tree.nodes.get(Integer.parseInt(child)));
            }
        }

        return tree;
    }

}
