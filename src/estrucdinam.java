

public class estrucdinam {
//Tarea Progra_3_Autor: Nelson Enríquez
private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public estrucdinam() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
