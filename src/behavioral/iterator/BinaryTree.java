package behavioral.iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


public class BinaryTree<T> implements Iterable<T> {
    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new InOrderIterator<>(root);
    }

    // As you use the for loop, the for loop uses the
    // iterator yielded from the iterator() method.
    @Override
    public void forEach(Consumer<? super T> action) {
        for (T item : this)
            action.accept(item);
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

}


class Main {
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(
                1,
                new Node<>(2),
                new Node<>(3)
        );

        InOrderIterator<Integer> it = new InOrderIterator<>(root);

        // --------------------

        // While loop
        while (it.hasNext()) {
            System.out.printf(" %d;", it.next());
        }
        System.out.println();

        // --------------------

        BinaryTree<Integer> tree = new BinaryTree<>(root);
        for (int n : tree) {
            System.out.printf(" %d;", n);
        }
        System.out.println();

        //   1
        //  / \
        // 2   3
    }
}
