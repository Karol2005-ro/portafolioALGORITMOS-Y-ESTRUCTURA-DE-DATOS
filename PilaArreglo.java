/** TAD Pila (LIFO) implementada con arreglo.
 *  Precondición de pop() y top(): la pila no debe estar vacía. */
public class PilaArreglo {
    private final int[] datos;
    private int tope = -1;                       // índice del último elemento

    public PilaArreglo(int capacidad) {
        datos = new int[capacidad];
    }

    public boolean isEmpty() { return tope == -1; }

    /** Postcondición: x queda en el tope. Devuelve false si está llena. */
    public boolean push(int x) {
        if (tope == datos.length - 1) return false;
        datos[++tope] = x;
        return true;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Pila vacía");
        return datos[tope--];
    }

    public int top() {
        if (isEmpty()) throw new IllegalStateException("Pila vacía");
        return datos[tope];
    }
}
