package behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;


public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }

    private void traverse(TreeNode<T> current, ArrayList<TreeNode<T>> list) {
        list.add(current);
        if (current.left != null) traverse(current.left, list);
        if (current.right != null) traverse(current.right, list);
    }

    public Iterator<TreeNode<T>> preOrder() {
        ArrayList<TreeNode<T>> items = new ArrayList<>();
        traverse(this, items);
        items.forEach((element) -> System.out.println(element.value));
        return items.iterator();
    }
}


class MainTwo {
    public static void main(String[] args) {
        TreeNode<Character> node = new TreeNode<>(
                'a',
                new TreeNode<>(
                        'b',
                        new TreeNode<>('c'),
                        new TreeNode<>('d')
                ),
                new TreeNode<>('e')
        );
        System.out.println(node.preOrder());
        //      a
        //     / \
        //    b   e
        //   / \
        //  c   d
    }
}
