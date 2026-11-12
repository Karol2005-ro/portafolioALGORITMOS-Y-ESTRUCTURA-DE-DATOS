// Sesión 22 - Pila implementada con ARREGLO de capacidad fija
class PilaArreglo {
  constructor(capacidad = 5) {
    this.datos = new Array(capacidad);
    this.capacidad = capacidad;
    this.cima = -1; 
  }
  estaVacia() { return this.cima === -1; }
  estaLlena() { return this.cima === this.capacidad - 1; }

  push(x) {
    if (this.estaLlena()) { console.log("Desbordamiento: pila llena"); return; } 
    this.datos[++this.cima] = x;
  }
  pop() {
    if (this.estaVacia()) { console.log("Pila vacía"); return null; }           
    return this.datos[this.cima--];
  }
  peek() { return this.estaVacia() ? null : this.datos[this.cima]; }
}

module.exports = PilaArreglo;

if (require.main === module) {
  const p = new PilaArreglo(3);
  p.push(10); p.push(20); p.push(30);
  p.push(40);                                  
  console.log("Peek:", p.peek());               
  while (!p.estaVacia()) console.log("Pop:", p.pop()); 
  p.pop();                                     
}
