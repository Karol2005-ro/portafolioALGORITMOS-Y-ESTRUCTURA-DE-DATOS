public class ColaLista {
    private Nodo frente;
    private Nodo fin;

    public boolean vacia() {
        return frente == null;
    }

    // Agrega un nodo al final de la cola.
    public void encolar(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (vacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    // Retira y devuelve el primer elemento.
    public int desencolar() {
        if (vacia()) {
            throw new IllegalStateException("La cola está vacía.");
        }

        int dato = frente.dato;
        frente = frente.siguiente;

        if (frente == null) {
            fin = null;
        }

        return dato;
    }

    // Consulta el primer elemento sin retirarlo.
    public int verFrente() {
        if (vacia()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return frente.dato;
    }

    public void imprimir() {
        Nodo actual = frente;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println(" -> null");
    }
}
