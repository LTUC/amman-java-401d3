package demo;

public class LinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int length;

    // add to linkedList (add last)
    public void add(T value){
        Node<T> nodeToAdd = new Node<>(value);
        // the linkedlist is empty
        if(head == null){
            head = nodeToAdd;
//            tail = head;
        } else {
//            tail.next = nodeToAdd;
//            tail = nodeToAdd;
            // When we don't have a tail ...
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = nodeToAdd;
        }
        length++;
    }

    // Insert to linked list (add first)
    public void insert(T value){
        if(head == null)
            add(value);
        else {
            Node<T> nodeToAdd = new Node<>(value);
            nodeToAdd.next = head;
            head = nodeToAdd;
        }

        length++;
    }

    public void delete() throws Exception {
        if(head == null){
            throw new Exception("This is the message");
            //throw new Exception("You cannot delete from an empty list");
        }
    }

    public int getLength(){
        return length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node current = head;
        while(current != null){
            builder.append(current.value + " -> ");
        }
        builder.append("null");
        return builder.toString();
    }
}
