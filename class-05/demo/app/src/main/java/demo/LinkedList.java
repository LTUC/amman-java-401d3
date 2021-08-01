package demo;

public class LinkedList {

    Node head;
    Node tail;

    // add to linkedList (add last)
    public void add(int value){
        Node nodeToAdd = new Node(value);

        // the linkedlist is empty
        if(head == null){
            head = nodeToAdd;
//            tail = head;
        } else {
//            tail.next = nodeToAdd;
//            tail = nodeToAdd;
            // When we don't have a tail ...
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = nodeToAdd;
        }
    }

    // Insert to linked list (add first)
    public void insert(int value){
        if(head == null)
            add(value);
        else {
            Node nodeToAdd = new Node(value);
            nodeToAdd.next = head;
            head = nodeToAdd;
        }

    }
}
