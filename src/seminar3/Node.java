package seminar3;

public class Node<E> {
    E value;
    Node<E> nextNode;
    Node<E> previousNode;

    public Node(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
