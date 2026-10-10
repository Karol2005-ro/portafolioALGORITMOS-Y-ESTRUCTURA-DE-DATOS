public class ListaSimple {
    Nodo cabeza;

    // Agrega un nodo al inicio de la lista. Complejidad: O(1).
    public void insertarInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // Agrega un nodo al final de la lista. Complejidad: O(n).
    public void insertarFinal(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
    }

    // Inserta en una posición empezando desde 0.
    // Si la posición es 0 o la lista está vacía, inserta al inicio.
    // Si la posición supera el tamaño, inserta al final.
    public void insertarPosicion(int dato, int posicion) {
        if (posicion <= 0 || cabeza == null) {
            insertarInicio(dato);
            return;
        }

        Nodo actual = cabeza;
        int indice = 0;

        while (actual.siguiente != null && indice < posicion - 1) {
            actual = actual.siguiente;
            indice++;
        }

        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }

    // Elimina el primer nodo si la lista no está vacía.
    public void eliminarInicio() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
        }
    }

    // Elimina el último nodo.
    public void eliminarFinal() {
        if (cabeza == null) {
            return;
        }

        if (cabeza.siguiente == null) {
            cabeza = null;
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = null;
    }

    // Elimina el nodo de la posición indicada, empezando desde 0.
    public void eliminarPosicion(int posicion) {
        if (cabeza == null || posicion < 0) {
            return;
        }

        if (posicion == 0) {
            eliminarInicio();
            return;
        }

        Nodo previo = cabeza;
        int indice = 0;

        while (previo.siguiente != null && indice < posicion - 1) {
            previo = previo.siguiente;
            indice++;
        }

        if (previo.siguiente != null) {
            previo.siguiente = previo.siguiente.siguiente;
        }
    }

    // Devuelve la posición del dato o -1 si no se encuentra.
    public int buscar(int dato) {
        Nodo actual = cabeza;
        int indice = 0;

        while (actual != null) {
            if (actual.dato == dato) {
                return indice;
            }
            actual = actual.siguiente;
            indice++;
        }

        return -1;
    }

    // Imprime los elementos de la lista.
    public void imprimir() {
        StringBuilder resultado = new StringBuilder();
        Nodo actual = cabeza;

        while (actual != null) {
            resultado.append(actual.dato).append(" -> ");
            actual = actual.siguiente;
        }

        resultado.append("null");
        System.out.println(resultado);
    }

    // Invierte los enlaces de la lista sin crear otra lista.
    public void invertir() {
        Nodo previo = null;
        Nodo actual = cabeza;

        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            actual.siguiente = previo;
            previo = actual;
            actual = siguiente;
        }

        cabeza = previo;
    }

    // Ordena la lista de menor a mayor usando Merge Sort.
    public void ordenar() {
        cabeza = mergeSort(cabeza);
    }

    private static Nodo mergeSort(Nodo inicio) {
        if (inicio == null || inicio.siguiente == null) {
            return inicio;
        }

        Nodo lento = inicio;
        Nodo rapido = inicio.siguiente;

        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
        }

        Nodo segundaMitad = lento.siguiente;
        lento.siguiente = null;

        Nodo izquierda = mergeSort(inicio);
        Nodo derecha = mergeSort(segundaMitad);

        return fusionar(izquierda, derecha);
    }

    // Une dos cadenas de nodos ya ordenadas.
    public static Nodo fusionar(Nodo a, Nodo b) {
        Nodo base = new Nodo(0);
        Nodo cola = base;

        while (a != null && b != null) {
            if (a.dato <= b.dato) {
                cola.siguiente = a;
                a = a.siguiente;
            } else {
                cola.siguiente = b;
                b = b.siguiente;
            }
            cola = cola.siguiente;
        }

        cola.siguiente = (a != null) ? a : b;
        return base.siguiente;
    }

    // Fusiona esta lista con otra lista ordenada y deja vacía la otra.
    public void fusionarCon(ListaSimple otra) {
        if (otra == null || otra == this) {
            return;
        }

        cabeza = fusionar(cabeza, otra.cabeza);
        otra.cabeza = null;
    }

    // Detecta un ciclo usando dos referencias que avanzan a distinta velocidad.
    public boolean tieneCiclo() {
        Nodo lento = cabeza;
        Nodo rapido = cabeza;

        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;

            if (lento == rapido) {
                return true;
            }
        }

        return false;
    }

    // Elimina la primera aparición del valor. Devuelve false si no existe.
    public boolean eliminarValor(int valor) {
        Nodo actual = cabeza;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.dato == valor) {
                if (anterior == null) {
                    cabeza = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }

        return false;
    }

    // Ordenamiento burbuja (S8): intercambia datos de nodos adyacentes. O(n^2).
    public void burbuja() {
        if (cabeza == null) {
            return;
        }

        boolean cambiado = true;
        while (cambiado) {
            cambiado = false;
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                if (actual.dato > actual.siguiente.dato) {
                    int temporal = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temporal;
                    cambiado = true;
                }
                actual = actual.siguiente;
            }
        }
    }

    // Método de apoyo para la demostración del ciclo en Main.
    public void crearCicloParaPrueba() {
        if (cabeza == null) {
            return;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = cabeza;
    }
}
