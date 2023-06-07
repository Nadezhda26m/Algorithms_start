package seminar4;

public class Mapa<K, V> {
    private int capacity = 5; // 16
    private Node<K, V>[] nodes = new Node[capacity];
    private int size = 0;

    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        while (currentNode != null) {
            if (currentNode.key == key) {
                V tmp = currentNode.value;
                currentNode.value = value;
                return tmp;
            }
            currentNode = currentNode.nextNode;
        }
        size++;
        newNode.nextNode = nodes[index];
        nodes[index] = newNode;
        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % capacity; // по модулю
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = nodes[index];
        while (node != null) {
            if (node.key.equals(key))
                return node.value;
            node = node.nextNode;
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> currentNode = nodes[index];
        Node<K, V> previousNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                V tmp = currentNode.value;
                if (previousNode == null)
                    nodes[index] = currentNode.nextNode;
                else if (currentNode.nextNode == null)
                    previousNode.nextNode = null;
                else previousNode.nextNode = currentNode.nextNode;
                size--;
                return tmp;
            }
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        return null;
    }

    public V replays(K key, V value) {
        int index = getIndex(key);
        Node<K, V> node = nodes[index];
        while (node != null) {
            if (node.key.equals(key)) {
                V tmp = node.value;
                node.value = value;
                return tmp;
            }
            node = node.nextNode;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Node<K, V> node = nodes[index];
        while (node != null) {
            if (node.key.equals(key))
                return true;
            node = node.nextNode;
        }
        return false;
    }

    public boolean containsValue(V value) {
        Node<K, V> node;
        for (int i = 0; i < capacity; i++) {
            node = nodes[i];
            while (node != null) {
                if (node.value.equals(value))
                    return true;
                node = node.nextNode;
            }
        }
        return false;
    }
}
