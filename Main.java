public class Main {
    public static void main(String[] args) {
        System.out.println("=== LISTA SIMPLEMENTE ENLAZADA ===");
        ListaSimple lista = new ListaSimple();
        lista.insertarFinal(30);
        lista.insertarInicio(10);
        lista.insertarPosicion(20, 1);
        lista.imprimir();

        System.out.println("Posición del 20: " + lista.buscar(20));
        lista.eliminarPosicion(1);
        System.out.print("Después de eliminar la posición 1: ");
        lista.imprimir();

        lista.insertarFinal(20);
        lista.insertarFinal(40);
        System.out.print("Lista antes de invertir: ");
        lista.imprimir();
        lista.invertir();
        System.out.print("Lista invertida: ");
        lista.imprimir();

        lista.ordenar();
        System.out.print("Lista ordenada: ");
        lista.imprimir();

        System.out.println("\n=== FUSIÓN DE LISTAS ORDENADAS ===");
        ListaSimple listaA = new ListaSimple();
        listaA.insertarFinal(1);
        listaA.insertarFinal(3);
        listaA.insertarFinal(5);

        ListaSimple listaB = new ListaSimple();
        listaB.insertarFinal(2);
        listaB.insertarFinal(4);
        listaB.insertarFinal(6);

        listaA.fusionarCon(listaB);
        System.out.print("Lista fusionada: ");
        listaA.imprimir();
        System.out.print("Segunda lista después de fusionar: ");
        listaB.imprimir();

        System.out.println("\n=== DETECCIÓN DE CICLO ===");
        ListaSimple listaCiclo = new ListaSimple();
        listaCiclo.insertarFinal(7);
        listaCiclo.insertarFinal(8);
        listaCiclo.insertarFinal(9);
        listaCiclo.crearCicloParaPrueba();
        System.out.println("¿La lista tiene ciclo? " + listaCiclo.tieneCiclo());

        System.out.println("\n=== COLA CIRCULAR CON ARREGLO ===");
        ColaArreglo colaArreglo = new ColaArreglo(3);
        colaArreglo.encolar(10);
        colaArreglo.encolar(20);
        colaArreglo.encolar(30);
        System.out.println("Frente: " + colaArreglo.verFrente());
        System.out.println("Sale: " + colaArreglo.desencolar());
        colaArreglo.encolar(40);
        System.out.println("Nuevo frente: " + colaArreglo.verFrente());

        System.out.println("\n=== COLA ENLAZADA ===");
        ColaLista colaLista = new ColaLista();
        colaLista.encolar(100);
        colaLista.encolar(200);
        colaLista.encolar(300);
        colaLista.imprimir();
        System.out.println("Sale: " + colaLista.desencolar());
        colaLista.imprimir();

        System.out.println("\n=== COLA DE PRIORIDAD ===");
        ColaPrioridad tareas = new ColaPrioridad();
        tareas.encolar(3, "Leer apuntes");
        tareas.encolar(1, "Entregar proyecto");
        tareas.encolar(2, "Estudiar para el examen");
        tareas.imprimir();

        System.out.println("Siguiente tarea: " + tareas.desencolar());
        System.out.println("Siguiente tarea: " + tareas.desencolar());
        System.out.println("Siguiente tarea: " + tareas.desencolar());

        System.out.println("\n=== ELIMINAR POR VALOR Y BURBUJA (S8) ===");
        ListaSimple lb = new ListaSimple();
        int[] valores = {4, 2, 3, 1};
        for (int v : valores) {
            lb.insertarFinal(v);
        }
        System.out.print("Antes: ");
        lb.imprimir();
        lb.burbuja();
        System.out.print("Burbuja: ");
        lb.imprimir();
        System.out.println("eliminarValor(3): " + lb.eliminarValor(3));
        System.out.println("eliminarValor(99): " + lb.eliminarValor(99));
        lb.imprimir();

        System.out.println("\n=== PILA CON ARREGLO (S06) ===");
        PilaArreglo pa = new PilaArreglo(3);
        pa.push(1);
        pa.push(2);
        pa.push(3);
        System.out.println("push(4) -> " + (pa.push(4) ? "ok" : "LLENA"));
        System.out.println("Tope: " + pa.top());
        System.out.print("pop: ");
        while (!pa.isEmpty()) {
            System.out.print(pa.pop() + " ");
        }
        System.out.println();

        System.out.println("\n=== PILA CON LISTA (S06) ===");
        PilaLista pl = new PilaLista();
        pl.push(10);
        pl.push(20);
        pl.push(30);
        System.out.println("Tope: " + pl.top());
        System.out.print("pop: ");
        while (!pl.isEmpty()) {
            System.out.print(pl.pop() + " ");
        }
        System.out.println();

        System.out.println("\n=== LISTA DOBLEMENTE ENLAZADA (S9) ===");
        ListaDoble ld = new ListaDoble();
        ld.insertarFinal(20);
        ld.insertarInicio(10);
        ld.insertarFinal(40);
        ld.insertarPosicion(30, 2);
        System.out.print("Adelante: ");
        ld.recorrerAdelante();
        System.out.print("Atrás:    ");
        ld.recorrerAtras();
        ld.eliminarInicio();
        ld.eliminarFinal();
        ld.eliminarPosicion(0);
        System.out.print("Tras eliminar: ");
        ld.recorrerAdelante();

        System.out.println("\n=== LISTA CIRCULAR (S9) ===");
        ListaCircular lc = new ListaCircular();
        lc.insertarFinal(20);
        lc.insertarInicio(10);
        lc.insertarFinal(40);
        lc.insertarPosicion(30, 2);
        System.out.print("Recorrido: ");
        lc.recorrer();
        lc.eliminarInicio();
        lc.eliminarFinal();
        System.out.print("Tras eliminar inicio y final: ");
        lc.recorrer();
    }
}
