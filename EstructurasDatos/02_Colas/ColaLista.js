// Sesión 24 - Cola (FIFO) con LISTA ENLAZADA
class Nodo {
  constructor(dato) { this.dato = dato; this.sig = null; }
}

class ColaLista {
  constructor() { this.frente = null; this.final = null; }
  estaVacia() { return this.frente === null; }

  enqueue(x) {                       
    const n = new Nodo(x);
    if (this.estaVacia()) this.frente = this.final = n;
    else { this.final.sig = n; this.final = n; }
  }
  dequeue() {                        
    if (this.estaVacia()) { console.log("Cola vacía"); return null; }
    const x = this.frente.dato;
    this.frente = this.frente.sig;
    if (this.frente === null) this.final = null;
    return x;
  }
  front() { return this.estaVacia() ? null : this.frente.dato; }
}

module.exports = ColaLista;

if (require.main === module) {
  const c = new ColaLista();
  for (let i = 1; i <= 5; i++) c.enqueue(i * 10);
  console.log("Front:", c.front());   // 10
  while (!c.estaVacia()) console.log("Dequeue:", c.dequeue());
}
