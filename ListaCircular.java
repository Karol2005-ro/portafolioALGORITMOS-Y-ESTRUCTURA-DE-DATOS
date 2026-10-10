/** Lista circular simple: el último nodo apunta al primero.
 *  Usa la clase Nodo (campos: dato, siguiente; constructor Nodo(int)). */
public class ListaCircular {
    private Nodo inicio;

    private Nodo ultimo() {                      // el último es el que apunta al inicio
        Nodo a = inicio;
        while (a.siguiente != inicio) a = a.siguiente;
        return a;
    }

    public void insertarInicio(int d) {
        Nodo n = new Nodo(d);
        if (inicio == null) { n.siguiente = n; inicio = n; return; }
        n.siguiente = inicio;
        ultimo().siguiente = n;
        inicio = n;
    }

    public void insertarFinal(int d) {
        Nodo n = new Nodo(d);
        if (inicio == null) { n.siguiente = n; inicio = n; return; }
        ultimo().siguiente = n;
        n.siguiente = inicio;
    }

    public void insertarPosicion(int d, int pos) {
        if (pos <= 0 || inicio == null) { insertarInicio(d); return; }
        Nodo previo = inicio;
        for (int i = 0; i < pos - 1 && previo.siguiente != inicio; i++)
            previo = previo.siguiente;
        Nodo n = new Nodo(d);
        n.siguiente = previo.siguiente;
        previo.siguiente = n;
    }

    public void eliminarInicio() {
        if (inicio == null) return;
        if (inicio.siguiente == inicio) { inicio = null; return; }   // único nodo
        ultimo().siguiente = inicio.siguiente;
        inicio = inicio.siguiente;
    }

    public void eliminarFinal() {
        if (inicio == null) return;
        if (inicio.siguiente == inicio) { inicio = null; return; }
        Nodo penultimo = inicio;
        while (penultimo.siguiente.siguiente != inicio)
            penultimo = penultimo.siguiente;
        penultimo.siguiente = inicio;
    }

    public void eliminarPosicion(int pos) {
        if (inicio == null || pos < 0) return;
        if (pos == 0) { eliminarInicio(); return; }
        Nodo previo = inicio;
        for (int i = 0; i < pos - 1 && previo.siguiente != inicio; i++)
            previo = previo.siguiente;
        if (previo.siguiente == inicio) return;  // posición inválida
        previo.siguiente = previo.siguiente.siguiente;
    }

    public void recorrer() {                     // termina al volver al inicio
        if (inicio == null) { System.out.println("(vacía)"); return; }
        StringBuilder sb = new StringBuilder();
        Nodo a = inicio;
        do {
            sb.append(a.dato).append(" -> ");
            a = a.siguiente;
        } while (a != inicio);
        System.out.println(sb + "(vuelve a " + inicio.dato + ")");
    }
}
