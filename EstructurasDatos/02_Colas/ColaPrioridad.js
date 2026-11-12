// Sesión 24 - Cola con PRIORIDAD usando heap binario
class ColaPrioridad {
  constructor() { this.heap = []; }
  estaVacia() { return this.heap.length === 0; }

  _subir(i) {
    while (i > 0) {
      const padre = Math.floor((i - 1) / 2);
      if (this.heap[padre].prioridad >= this.heap[i].prioridad) break;
      [this.heap[padre], this.heap[i]] = [this.heap[i], this.heap[padre]];
      i = padre;
    }
  }
  _bajar(i) {
    const n = this.heap.length;
    while (true) {
      let mayor = i;
      const izq = 2 * i + 1, der = 2 * i + 2;
      if (izq < n && this.heap[izq].prioridad > this.heap[mayor].prioridad) mayor = izq;
      if (der < n && this.heap[der].prioridad > this.heap[mayor].prioridad) mayor = der;
      if (mayor === i) break;
      [this.heap[i], this.heap[mayor]] = [this.heap[mayor], this.heap[i]];
      i = mayor;
    }
  }

  enqueue(nombre, prioridad) {       
    this.heap.push({ nombre, prioridad });
    this._subir(this.heap.length - 1);
  }
  dequeue() {
    if (this.estaVacia()) { console.log("Cola vacía"); return null; }
    const top = this.heap[0];
    const ultimo = this.heap.pop();
    if (!this.estaVacia()) { this.heap[0] = ultimo; this._bajar(0); }
    return top;
  }
}

module.exports = ColaPrioridad;

if (require.main === module) {
  const c = new ColaPrioridad();
  c.enqueue("Imprimir reporte", 2);
  c.enqueue("Proceso del sistema", 9);
  c.enqueue("Actualizar antivirus", 5);
  c.enqueue("Backup nocturno", 3);
  while (!c.estaVacia()) {
    const t = c.dequeue();
    console.log(`Atendiendo: ${t.nombre} (prioridad ${t.prioridad})`);
  }
}
