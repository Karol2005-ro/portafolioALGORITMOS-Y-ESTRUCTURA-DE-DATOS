public class ColaArreglo {
    private final int[] datos;
    private int frente = 0;
    private int tamano = 0;

    public ColaArreglo(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero.");
        }
        datos = new int[capacidad];
    }

    public boolean vacia() {
        return tamano == 0;
    }

    public boolean llena() {
        return tamano == datos.length;
    }

    // Agrega al final lógico de la cola circular.
    public void encolar(int dato) {
        if (llena()) {
            System.out.println("La cola está llena.");
            return;
        }

        int indiceFinal = (frente + tamano) % datos.length;
        datos[indiceFinal] = dato;
        tamano++;
    }

    // Retira y devuelve el primer elemento.
    public int desencolar() {
        if (vacia()) {
            throw new IllegalStateException("La cola está vacía.");
        }

        int dato = datos[frente];
        frente = (frente + 1) % datos.length;
        tamano--;
        return dato;
    }

    // Consulta el primer elemento sin retirarlo.
    public int verFrente() {
        if (vacia()) {
            throw new IllegalStateException("La cola está vacía.");
        }
        return datos[frente];
    }

    public int tamano() {
        return tamano;
    }
}
