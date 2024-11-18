public class LLRB<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node
    {
        private Key key;
        private Value val;
        private Node left, right;
        boolean color;

        public Node(Key key, Value val, boolean color)
        {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }
    private boolean isRed(Node x)
    {
        if (x == null) return false;
        return x.color == RED;
    }
    public void insert(Key key, Value val) throws Exception {
        root = insert(root, key, val);
    }

    private Node insert(Node x, Key key, Value val) throws Exception {
        if (x == null) return new Node(key, val, RED); // when empty, insert
        int cmp = key.compareTo(x.key); // returns
        if          (cmp < 0)   x.left = insert(x.left, key, val);
        else if     (cmp > 0)   x.right = insert(x.right, key, val);
        else if     (cmp == 0)  throw new Exception("Key already exists");   // if the key == a key which has already been inserted into the tree, it throws an error

        if (isRed(x.right)  && !isRed(x.left))          x = rotateLeft(x);
        if (isRed(x.left)   && isRed(x.left.left))      x = rotateRight(x);
        if (isRed(x.left)   && isRed(x.right))          flipColors(x);
        return x;
    }
    public Value search(Key key) { // returns value associated with key
        Node x = root;
        while(x != null)
        {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else if (cmp == 0) return x.val;
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
