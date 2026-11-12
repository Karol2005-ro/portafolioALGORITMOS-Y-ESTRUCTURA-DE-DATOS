// Sesión 22 - Pila implementada con LISTA ENLAZADA 
class Nodo {
  constructor(dato, sig = null) { this.dato = dato; this.sig = sig; }
}

class PilaLista {
  constructor() { this.cima = null; }
  estaVacia() { return this.cima === null; }

  push(x) { this.cima = new Nodo(x, this.cima); }   
  pop() {                                           
    if (this.estaVacia()) { console.log("Pila vacía"); return null; }
    const x = this.cima.dato;
    this.cima = this.cima.sig;
    return x;
  }
  peek() { return this.estaVacia() ? null : this.cima.dato; }
}

module.exports = PilaLista;

if (require.main === module) {
  const p = new PilaLista();
  for (let i = 1; i <= 5; i++) p.push(i * 10);      
  console.log("Peek:", p.peek());                   
  while (!p.estaVacia()) console.log("Pop:", p.pop());
}
