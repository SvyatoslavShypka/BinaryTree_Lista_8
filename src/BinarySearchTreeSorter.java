import java.util.List;

public class BinarySearchTreeSorter {
    public static <T extends Comparable<T>> void sort(List<T> list) throws DuplicateElementException {
        // TODO: Posortuj listę używając klasy BinarySearchTree.
        BinarySearchTree<T> newList = new BinarySearchTree<T>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i));
        }
        list.clear();
        list = sortTraverseInOrder(newList.root, list);
    }
    private static <T extends Comparable<T>> List<T> sortTraverseInOrder(BinarySearchTree.Node node, List<T> resultList) {
        if (node != null) {
            sortTraverseInOrder(node.left, resultList);
            resultList.add((T) node.value);
            sortTraverseInOrder(node.right, resultList);
        }
        return resultList;
    }
}
