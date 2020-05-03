package com.home.macro;

import java.util.List;

public interface SCI {
   // Create/Edit
    boolean AddNoteAt(String parentNode, String node) throws Exception;

    boolean EditNote(String id, String name);

    boolean DeleteNode(String node);

    //Get/Search
    List<Node> GetTree(Node node);

    List<Node> Search(String searchText);

}
