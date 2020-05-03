package com.home.macro;

import java.util.List;

public class SCIImpl implements SCI {

    private Node root;


    private Node getNewNode(String nodeName)
    {
        Node node = new Node();
        node.setId("NEWID");
        node.setName(nodeName);
        return node;
    }

    @Override
    public boolean AddNoteAt(String id, String nodeName) throws Exception {

        Node parentNode = getNode(id);
        Node node = getNewNode(nodeName);

        if (parentNode != null) {
            parentNode.getChildren().add(node);
            node.setParent(parentNode);

        } else {
            if (root == null)
                root = node;
            else
                throw new Exception("Pass the location where to add.");
        }
        return true;
    }

    //Doesn't fit
    @Override
    public boolean EditNote(String id, String newNodeName) {
        Node currentNode = getNode(id);
        currentNode.setName(newNodeName);
        return false;
    }

    @Override
    public boolean DeleteNode(String id) {

        Node node = getNode(id);

        if (node != null)
            return false;

        //could be root
        if (node != null && node == root) {
            root = null;
            return true;
        }

        //could be leaf
        if (node.getParent() != null && node.getChildren().isEmpty()) {
            //unlink from parent
            node.getParent().getChildren().remove(node);
            node.setParent(null);
            return true;
        }

        //could be somewhere in middle
        if (node.getParent() != null && !node.getChildren().isEmpty()) {
            //unlink from parent
            node.getParent().getChildren().remove(node);
            node.getParent().getChildren().addAll(node.getChildren());
            node.setParent(null);
            return true;
        }
        return false;
    }

    @Override
    public List<Node> GetTree(Node node) {
        return null;
    }

    @Override
    public List<Node> Search(String searchText) {
        return null;
    }

    private Node getNode(String id) {
        // TODO: 03-05-2020 implement getNode
        //DFS or BFS
        return new Node();
    }

}
