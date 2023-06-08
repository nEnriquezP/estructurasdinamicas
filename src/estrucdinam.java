

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

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void traverseForward() {
        if (isEmpty()) {
            System.out.println("La lista se encuentra vacía");
        } else {
            Node current = head;
            System.out.print("Lista==> ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    public void traverseBackward() {
        if (isEmpty()) {
            System.out.println("La lista se encuentra vacía.");
        } else {
            Node current = tail;
            System.out.print("Lista==> ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.prev;
            }
            System.out.println();
        }
    }
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean searchByValue(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int searchByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("El índice se encuentra fuera de rango");
        }
        Node current = head;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                return current.data;
            }
            current = current.next;
            currentIndex++;
        }
        return -1;
    }
    public void deleteElement(int value) {
        if (isEmpty()) {
            System.out.println("La lista se encuentra vacía por lo TANTO No se puede borrar ningún elemento");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                    if (current == tail) {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                System.out.println("El elemento... " + value + " se ha borrado de la lista");
                return;
            }
            current = current.next;
        }
        System.out.println("El elemento... " + value + " no se encontró en la lista");
    }
}
