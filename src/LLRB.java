public class LLRB<Item extends Comparable<Item>> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node
    {
        private Item item;
        private Node left, right;
        boolean color;

        public Node(Item item, boolean color)
        {
            this.item = item;
            this.color = color;
        }
    }
    private boolean isRed(Node x)
    {
        if (x == null) return false;
        return x.color == RED;
    }
    public void put(Item item) {
        root = put(root, item);
    }

    private Node put(Node x, Item item){
        if (x == null) return new Node(item, RED); // when empty, insert
        int cmp = item.compareTo(x.item); // returns
        if          (cmp < 0)   x.left = put(x.left, item);
        else if     (cmp > 0)   x.right = put(x.right, item);
        else if     (cmp == 0)  x.item = item;

        if (isRed(x.right)  && !isRed(x.left))          x = rotateLeft(x);
        if (isRed(x.left)   && isRed(x.left.left))      x = rotateRight(x);
        if (isRed(x.left)   && isRed(x.right))          flipColors(x);

        return x;
    }
    public Item get(Item item) {   // Return value associated with item in the subtree rooted at x;
        // return null if item not present in subtree rooted at x.
        Node x = root;
        while(x != null)
        {
            int cmp = item.compareTo(x.item);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return x.item;
        }
        return null;
    }

    private Node rotateLeft(Node h)
    {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    private Node rotateRight(Node h)
    {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    private void flipColors(Node h)
    {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}
