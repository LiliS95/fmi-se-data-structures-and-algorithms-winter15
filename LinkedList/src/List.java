
/**
 * !!! DO NOT CHANGE THE INTERFACE !!!
 *
 * @author Dimitar
 */
public interface List {

    /**
     * Adds an element at the end of the list (appending).
     *
     * @param value
     */
    public void add(int value);

    /**
     * Insert an element at a given index of the list.
     *
     * @param index - the inserting index.
     * @param value - the newly inserted value.
     */
    public void insert(int index, int value);

    /**
     * Remove the last element of the list. <br>
     * Hint: reuse the remove(int) method.
     */
    public void remove();

    /**
     * Removes the element at the given index;
     *
     * @param index
     */
    public void remove(int index);

    /**
     * Reverse the order of the elements.
     */
    public void reverse();

    /**
     *
     * @return the number of elements.
     */
    public int getSize();

    /**
     *
     * @return whether the list is empty or not.
     */
    public boolean isEmpty();

    /**
     * The node class, representing the elements of the linked list.
     */
    public class Node {

        private int data;
        private Node next;

        //------- Constructors -------\\
        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        //------- Setters and getters -------\\
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
