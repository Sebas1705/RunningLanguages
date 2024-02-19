package com.sebss;

import static com.sebss.Statics.*;

import com.sebss.DataStructures.Lists.Linked_List.Nodes.DNode;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        DNode<Integer> node = new DNode<Integer>(2,null,null);
        DNode<Integer> node2 = node;

        println(node.getElement());
        println(node2.getElement());

        node.setElement(10);

        println(node.getElement());
        println(node2.getElement());
    }
}
