import java.util.Scanner;

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

    public static void main(String[] args) {
        estrucdinam list = new estrucdinam();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int value, index;

        do {
            System.out.println("=====Lista Doblemente Enlazada=====\n");
            System.out.println("1. Insertar al Inicio");
            System.out.println("2. Insertar al Final");
            System.out.println("3. Recorrer hacia Adelante");
            System.out.println("4. Recorrer hacia Atrás");
            System.out.println("5. Mostrar Tamaño de la Lista");
            System.out.println("6. Mostrar SI la Lista está Vacía");
            System.out.println("7. Buscar Elemento por Valor");
            System.out.println("8. Buscar Elemento por Índice");
            System.out.println("9. Borrar un elemento de la Lista");
            System.out.println("0. Salir del MENÚ...");
            System.out.print("Ingrese su opción POR FAVOR: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Saliendo del programa... Adios CRACK");
                    break;
                case 1:
                    System.out.print("Ingrese el valor a insertar al Inicio de la Lista: ");
                    value = scanner.nextInt();
                    list.insertAtBeginning(value);
                    System.out.println("Se ha INSERTADO " + value + " al Inicio de la Lista");
                    break;
                case 2:
                    System.out.print("Ingrese el valor a insertar al final de la Lista: ");
                    value = scanner.nextInt();
                    list.insertAtEnd(value);
                    System.out.println("Se ha insertado " + value + " al final de la Lista");
                    break;
                case 3:
                    list.traverseForward();
                    break;
                case 4:
                    list.traverseBackward();
                    break;
                case 5:
                    System.out.println("Tamaño de la lista: " + list.getSize());
                    break;
                case 6:
                    System.out.println("La lista está Vacía: " + list.isEmpty());
                    break;
                case 7:
                    System.out.print("Ingrese el valor que desea buscar: ");
                    value = scanner.nextInt();
                    System.out.println("El Elemento " + value + " está en la lista: " + list.searchByValue(value));
                    break;
                case 8:
                    System.out.print("Ingrese el ïndice que desea buscar: ");
                    index = scanner.nextInt();
                    try {
                        value = list.searchByIndex(index);
                        System.out.println("El elemento en el Índice " + index + " es: " + value);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.print("Ingrese el elemento que desea Borrar: ");
                    value = scanner.nextInt();
                    list.deleteElement(value);
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente por favor");
                    break;
            }

            System.out.println();
        } while (choice != 0);

    }
}
