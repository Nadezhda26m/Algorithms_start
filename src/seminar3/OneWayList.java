package seminar3;

import java.util.EmptyStackException;

public class OneWayList<E> {
    private Node<E> head;
    private int size = 0;

    public void add(E value) { // добавление в начало
        Node<E> newNode = new Node<>(value);
        if (head != null) newNode.nextNode = head;
        head = newNode;
        size++;
    }

    public void add(E value, int index) {
        if (index < 0 || index > size())
            throw new ArrayIndexOutOfBoundsException();
        if (index != 0) {
            Node<E> currentNode = head;
            boolean flag = false;
            if (index == size) flag = true; // добавление в конец
            while (index-- > 1) currentNode = currentNode.nextNode;
            Node<E> newNode = new Node<>(value);
            if (flag) currentNode.nextNode = newNode;
            else {
                Node<E> tmp = currentNode.nextNode;
                currentNode.nextNode = newNode;
                newNode.nextNode = tmp;
            }
            size++;
        } else add(value);
    }

    public void delete() { // удаление первого элемента
        if (head != null) {
            head = head.nextNode;
            size--;
        } else {
            throw new EmptyStackException();
        }
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) delete();
        else {
            Node<E> currentNode = head;
            while (index-- > 1) {
                currentNode = currentNode.nextNode;
            }
            Node<E> delNode = currentNode.nextNode;
            currentNode.nextNode = delNode.nextNode;
            size--;
        }
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Node<E> currentNode = head;
        int counter = 0;
        while (counter < index) {
            counter++;
            if (currentNode.nextNode == null)
                throw new ArrayIndexOutOfBoundsException();
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    public boolean contains(E value) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(value))
                return true;
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public int indexOf(E value) {
        int counter = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(value))
                return counter;
            counter++;
            currentNode = currentNode.nextNode;
        }
        return -1;
    }

    public void revert() {
        Node<E> currentNode = head;
        Node<E> nextNode = currentNode.nextNode;
        Node<E> temp;
        currentNode.nextNode = null;
        while (nextNode != null) {
            temp = currentNode;
            currentNode = nextNode;
            nextNode = currentNode.nextNode;
            currentNode.nextNode = temp;
        }
        head = currentNode;
    }
}
