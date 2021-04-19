package org.academiadecodigo.rapunshells.game.obstacle;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedObjects implements Iterable<Obstacle> {
    private Node head;
    private int length = 0;

    public LinkedObjects(){
        this.head = new Node(null);
    }

    public int size(){
        return length;
    }

    public void add(Obstacle obstacle){
        Node node = new Node(obstacle);
        Node iterator = head;
        while(iterator.getNext() != null){
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;
    }

    public int indexOf(Obstacle data) {

        int index = 0;
        Node iterator = head.getNext();

        while (iterator != null) {

            if (iterator.getObstacle().equals(data)) {
                return index;
            }

            iterator = iterator.getNext();
            index++;
        }

        // Data was not found
        return -1;
    }

    public Obstacle get(int index) {

        Node iterator = head.getNext();

        while (iterator != null) {
            if (index == 0) {
                return iterator.getObstacle();
            }

            iterator = iterator.getNext();
            index--;
        }

        return null;
    }

    public boolean remove(Obstacle data) {

        Node previous = head;
        Node iterator = head.getNext();

        while (iterator != null) {

            if (iterator.getObstacle().equals(data)) {
                previous.setNext(iterator.getNext());
                length--;
                return true;
            }

            previous = iterator;
            iterator = iterator.getNext();

        }

        return false;
    }

    @Override
    public Iterator<Obstacle> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Obstacle> {

        Node iterator = head;

        @Override
        public boolean hasNext() {
            return iterator.next != null;
        }

        @Override
        public Obstacle next() {
            iterator = iterator.getNext();
            return iterator.getObstacle();
        }

        @Override
        public void remove() {
            LinkedObjects.this.remove(iterator.getObstacle());
        }
    }

    public class Node{
       private Obstacle obstacle;
       private Node next;

       public Node(Obstacle obstacle){
            this.obstacle = obstacle;
            next = null;
       }
       public Obstacle getObstacle(){
           return obstacle;
       }
       public void setObstacle(Obstacle obstacle){
           this.obstacle = obstacle;
       }
       public Node getNext(){
           return next;
       }
       public void setNext(Node next){
           this.next = next;
       }
    }
}
