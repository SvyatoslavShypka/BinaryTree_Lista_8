import java.util.LinkedList;
import java.util.List;

public class BinarySearchTreeSorter {
    public static <T extends Comparable<T>> void sort(List<T> list) throws DuplicateElementException {
        // TODO: Posortuj listę używając klasy BinarySearchTree.
        System.out.println("list.toStringInOrder() = " + list.toString());
        BinarySearchTree<T> newList = new BinarySearchTree<T>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i));
        }
        List<T> resultList = new LinkedList<>();
        resultList = sortTraverseInOrder(newList.root, resultList);
        list.clear();
        for (int i = 0; i < resultList.size(); i++) {
            list.add(resultList.get(i));
        }
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
