// Sesión 24 - Cola  con ARREGLO CIRCULAR
class ColaCircular {
  constructor(capacidad = 5) {
    this.datos = new Array(capacidad);
    this.capacidad = capacidad;
    this.frente = 0;
    this.final = 0;
    this.tam = 0;
  }
  estaVacia() { return this.tam === 0; }
  estaLlena() { return this.tam === this.capacidad; }

  enqueue(x) {
    if (this.estaLlena()) { console.log("Cola llena"); return; }
    this.datos[this.final] = x;
    this.final = (this.final + 1) % this.capacidad; // vuelve al inicio al llegar al final
    this.tam++;
  }
  dequeue() {
    if (this.estaVacia()) { console.log("Cola vacía"); return null; }
    const x = this.datos[this.frente];
    this.frente = (this.frente + 1) % this.capacidad;
    this.tam--;
    return x;
  }
  front() { return this.estaVacia() ? null : this.datos[this.frente]; }
}

module.exports = ColaCircular;

if (require.main === module) {
  const c = new ColaCircular(4);
  [1, 2, 3, 4].forEach(x => c.enqueue(x));
  c.enqueue(5);                                
  console.log("Dequeue:", c.dequeue());        
  console.log("Dequeue:", c.dequeue());      
  c.enqueue(5); c.enqueue(6);                  
  console.log("Front:", c.front());           
  while (!c.estaVacia()) console.log("Dequeue:", c.dequeue());
}
