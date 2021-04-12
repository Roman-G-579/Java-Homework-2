package tree;

public class Node {

    private Node[] children = new Node['z' - 'a' + 1];
    private int count;

    public int num(String s) {
        if (s.isEmpty()) {
            return count;
        }
        if (children[s.charAt(0) - 'a'] == null) { // if the next node is not found
            return 0;
        }
        return children[s.charAt(0) - 'a'].num(s.substring(1));
    }

    public void add(String s) {
        if (s.equals("")) {
            count++;
            return;
        }
        //in case the current letter count is zero, creates new node
        if (children[s.charAt(0) - 'a'] == null) {
            children[s.charAt(0) - 'a'] = new Node();
        }
        children[s.charAt(0) - 'a'].add(s.substring(1));
    }
}