import java.util.Arrays;

public class ColaPrioridad {
    // Menor número de prioridad = mayor prioridad.
    private static class Elemento {
        int prioridad;
        String tarea;

        Elemento(int prioridad, String tarea) {
            this.prioridad = prioridad;
            this.tarea = tarea;
        }

        @Override
        public String toString() {
            return "Tarea: " + tarea + " | Prioridad: " + prioridad;
        }
    }

    private Elemento[] heap = new Elemento[4];
    private int n = 0;

    public boolean vacia() {
        return n == 0;
    }

    // Agrega una tarea y la sube hasta mantener la propiedad del min-heap.
    public void encolar(int prioridad, String tarea) {
        if (n == heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }

        heap[n] = new Elemento(prioridad, tarea);
        subir(n);
        n++;
    }

    // Retira la tarea con el número de prioridad más pequeño.
    public String desencolar() {
        if (vacia()) {
            throw new IllegalStateException("La cola de prioridad está vacía.");
        }

        Elemento primero = heap[0];
        n--;

        if (n > 0) {
            heap[0] = heap[n];
            bajar(0);
        }

        heap[n] = null;
        return primero.toString();
    }

    private void subir(int indice) {
        while (indice > 0) {
            int padre = (indice - 1) / 2;

            if (heap[padre].prioridad <= heap[indice].prioridad) {
                break;
            }

            intercambiar(padre, indice);
            indice = padre;
        }
    }

    private void bajar(int indice) {
        while (true) {
            int izquierda = 2 * indice + 1;
            int derecha = 2 * indice + 2;
            int menor = indice;

            if (izquierda < n
                    && heap[izquierda].prioridad < heap[menor].prioridad) {
                menor = izquierda;
            }

            if (derecha < n
                    && heap[derecha].prioridad < heap[menor].prioridad) {
                menor = derecha;
            }

            if (menor == indice) {
                break;
            }

            intercambiar(indice, menor);
            indice = menor;
        }
    }

    private void intercambiar(int i, int j) {
        Elemento temporal = heap[i];
        heap[i] = heap[j];
        heap[j] = temporal;
    }

    public void imprimir() {
        for (int i = 0; i < n; i++) {
            System.out.println(heap[i]);
        }
    }
}
