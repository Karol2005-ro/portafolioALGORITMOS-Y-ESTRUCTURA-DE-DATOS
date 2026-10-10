/** TAD Pila (LIFO) implementada con lista enlazada (el tope es la cabeza).
 *  Usa la clase Nodo (campos: dato, siguiente; constructor Nodo(int)). */
public class PilaLista {
    private Nodo tope;

    public boolean isEmpty() { return tope == null; }

    public void push(int x) {                    // O(1): insertar al inicio
        Nodo n = new Nodo(x);
        n.siguiente = tope;
        tope = n;
    }

    public int pop() {                           // O(1): eliminar al inicio
        if (isEmpty()) throw new IllegalStateException("Pila vacía");
        int d = tope.dato;
        tope = tope.siguiente;
        return d;
    }

    public int top() {
        if (isEmpty()) throw new IllegalStateException("Pila vacía");
        return tope.dato;
    }
}
