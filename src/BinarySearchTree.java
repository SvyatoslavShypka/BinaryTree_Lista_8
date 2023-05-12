public class BinarySearchTree<T extends Comparable<T>> {

    Node root;

    class Node {
        T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    public void add(T value) throws DuplicateElementException {
        // TODO: Dodawanie nowej wartości do drzewa. Rzuć DuplicateElementException, jeśli element już istnieje.

        root = addRecursive(root, value);

    }

    private Node addRecursive(Node current, T value) throws DuplicateElementException {
        if (current == null) {
            return new Node(value);
        }
        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            throw new DuplicateElementException();
        }
        return current;
    }

    public boolean contains(T value) {
        // TODO: Sprawdzenie, czy drzewo zawiera podaną wartość.
        return containsNodeRecursive(root, value);
    }
    private boolean containsNodeRecursive(Node current, T value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value.compareTo(current.value) < 0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(T value) {
        // TODO: Usunięcie wskazanej wartości z drzewa.
        root = deleteRecursive(root, value);
    }
    private Node deleteRecursive(Node current, T value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            T smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }

        if (value.compareTo(current.value) < 0) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private T findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public String toStringPreOrder() {
        // TODO: Zwróć wartość String reprezentującą drzewo po przejściu metodą pre-order.
        if (root == null) return "";
        String result = traversePreOrder(root);
        // kasujemy ostatni ", " izwracamy wynik
        return result.substring(0, result.length() - 2);
    }
    public String traversePreOrder(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (node != null) {
            stringBuilder.append(node.value + ", ");
            stringBuilder.append(traversePreOrder(node.left));
            stringBuilder.append(traversePreOrder(node.right));
        }
        return stringBuilder.toString();
    }

    public String toStringInOrder() {
        // TODO: Zwróć wartość String reprezentującą drzewo po przejściu metodą in-order.
        if (root == null) return "";
        String result = traverseInOrder(root);
        return result.substring(0, result.length() - 2);
    }
    public String traverseInOrder(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (node != null) {
            stringBuilder.append(traverseInOrder(node.left));
            stringBuilder.append(node.value + ", ");
            stringBuilder.append(traverseInOrder(node.right));
        }
        return stringBuilder.toString();
    }

    public String toStringPostOrder() {
        // TODO: Zwróć wartość String reprezentującą drzewo po przejściu metodą in-order.
        if (root == null) return "";
        String result = traversePostOrder(root);
        return result.substring(0, result.length() - 2);
    }
    public String traversePostOrder(Node node) {
        StringBuilder stringBuilder = new StringBuilder();

        if (node != null) {
            stringBuilder.append(traversePostOrder(node.left));
            stringBuilder.append(traversePostOrder(node.right));
            stringBuilder.append(node.value + ", ");
        }
        return stringBuilder.toString();
    }
}
