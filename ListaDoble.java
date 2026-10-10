/** Lista doblemente enlazada con punteros a inicio y fin. */
public class ListaDoble {
    private NodoDoble inicio, fin;

    public void insertarInicio(int d) {
        NodoDoble n = new NodoDoble(d);
        n.next = inicio;
        if (inicio != null) inicio.prev = n;
        else fin = n;                            // lista vacía
        inicio = n;
    }

    public void insertarFinal(int d) {
        NodoDoble n = new NodoDoble(d);
        n.prev = fin;
        if (fin != null) fin.next = n;
        else inicio = n;
        fin = n;
    }

    public void insertarPosicion(int d, int pos) {
        if (pos <= 0 || inicio == null) { insertarInicio(d); return; }
        NodoDoble previo = inicio;
        for (int i = 0; i < pos - 1 && previo.next != null; i++)
            previo = previo.next;
        if (previo.next == null) { insertarFinal(d); return; }
        NodoDoble n = new NodoDoble(d);
        n.next = previo.next;
        n.prev = previo;
        previo.next.prev = n;
        previo.next = n;
    }

    public void eliminarInicio() {
        if (inicio == null) return;
        inicio = inicio.next;
        if (inicio != null) inicio.prev = null;
        else fin = null;
    }

    public void eliminarFinal() {                // O(1) gracias a 'fin'
        if (fin == null) return;
        fin = fin.prev;
        if (fin != null) fin.next = null;
        else inicio = null;
    }

    public void eliminarPosicion(int pos) {
        if (inicio == null || pos < 0) return;
        if (pos == 0) { eliminarInicio(); return; }
        NodoDoble actual = inicio;
        for (int i = 0; i < pos && actual != null; i++) actual = actual.next;
        if (actual == null) return;              // posición inválida
        if (actual == fin) { eliminarFinal(); return; }
        actual.prev.next = actual.next;
        actual.next.prev = actual.prev;
    }

    public void recorrerAdelante() {
        StringBuilder sb = new StringBuilder("null <-> ");
        for (NodoDoble a = inicio; a != null; a = a.next)
            sb.append(a.dato).append(" <-> ");
        System.out.println(sb + "null");
    }

    public void recorrerAtras() {
        StringBuilder sb = new StringBuilder("null <-> ");
        for (NodoDoble a = fin; a != null; a = a.prev)
            sb.append(a.dato).append(" <-> ");
        System.out.println(sb + "null");
    }
}
