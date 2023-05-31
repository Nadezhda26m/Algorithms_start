package seminar3;

import java.util.EmptyStackException;

public class TwoWayList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void add(E value) { // добавление в начало
        Node<E> newNode = new Node<>(value);
        if (size == 0) tail = newNode;
        else if (size == 1) {
            tail.previousNode = newNode;
            newNode.nextNode = tail;
        } else {
            head.previousNode = newNode;
            newNode.nextNode = head;
        }
        head = newNode;
        size++;
    }

    public void addLast(E value) {
        if (head != null) {
            Node<E> newNode = new Node<>(value);
            newNode.previousNode = tail;
            tail.nextNode = newNode;
            tail = newNode;
            size++;
        } else add(value);
    }

    public int size() {
        return size;
    }

    public void add(E value, int index) {
        if (index == 0) add(value);
        else if (index == size) addLast(value);
        else {
            Node<E> newNode = new Node<>(value);
            Node<E> nextNode = getNode(index);
            Node<E> previousNode = nextNode.previousNode;
            previousNode.nextNode = newNode;
            newNode.previousNode = previousNode;
            newNode.nextNode = nextNode;
            nextNode.previousNode = newNode;
            size++;
        }
    }

    public void delete() { // удаление первого элемента
        if (size > 1) {
            head = head.nextNode;
            head.previousNode = null;
        } else if (size == 1) {
            head = null;
            tail = null;
        } else throw new EmptyStackException();
        size--;
    }

    public void delete(int index) {
        if (index == 0) delete();
        else {
            Node<E> delNode = getNode(index);
            Node<E> previousNode = delNode.previousNode;
            if (delNode.nextNode == null) {
                previousNode.nextNode = null;
                tail = previousNode;
            } else {
                previousNode.nextNode = delNode.nextNode;
                previousNode.nextNode.previousNode = previousNode;
            }
            size--;
        }
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();
        Node<E> currentNode;
        if (index < size - index) { // с какого конца меньше искать
            currentNode = head;
            while (index-- > 0) currentNode = currentNode.nextNode;
        } else {
            currentNode = tail;
            while (index++ < size - 1) currentNode = currentNode.previousNode;
        }
        return currentNode;
    }

    public E get(int index) {
        return getNode(index).value;
    }

    public boolean contains(E value) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(value)) return true;
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public int indexOf(E value) {
        int counter = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(value)) return counter;
            counter++;
            currentNode = currentNode.nextNode;
        }
        return -1;
    }

    public void revert() {
        Node<E> currentNode = head;
        while (currentNode != null) {
            Node<E> nextNode = currentNode.nextNode;
            Node<E> previousNode = currentNode.previousNode;
            currentNode.nextNode = previousNode;
            currentNode.previousNode = nextNode;
            if (previousNode == null)
                tail = currentNode;
            if (nextNode == null)
                head = currentNode;
            currentNode = nextNode;
        }
    }
}
