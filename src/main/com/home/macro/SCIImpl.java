package com.home.macro;

import java.util.ArrayList;
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

    //visualize the tree
    @Override
    public List<Node> GetTree() {
        List<Node> list = new ArrayList<>();
        traverseAndAdd(root, list);
        return list;
    }

    private void traverseAndAdd(Node node, List<Node> list)
    {
        list.add(node);
        for(Node n: node.getChildren())
        {
            traverseAndAdd(n, list);
        }
    }

    @Override
    public List<Node> Search(String searchText) {
        //first locate the node with the name.
        //Trace upto the the parent and return
        List<Node> l = new ArrayList<>();
        SearchAndAdd(root, searchText, l);
        return l;
        //return null;
    }

    private void SearchAndAdd(Node n, String searchText, List<Node> list)
    {
        if (n.getName() == searchText)
        {
            list.add(n);
        }
        for(Node nChild : n.getChildren())
        {
            SearchAndAdd(nChild, searchText, list);
        }
    }

    private Node getNode(String id)
    {
        List<Node> found = new ArrayList<>();
        dfs(id, root, found);
        return found.get(0);
    }


    private void dfs(String id, Node node, List<Node> found)
    {
        if(node != null && node.getId() == id) {
            found.add(node);
            return;
        }
        else
        {
            for(Node n : node.getChildren())
            {
                dfs(id, n, found);
            }
        }
    }

}
