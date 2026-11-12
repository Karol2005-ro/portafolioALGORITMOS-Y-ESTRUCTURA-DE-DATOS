// Sesión 26 - Árbol binario de búsqueda 
class Nodo {
  constructor(dato) { this.dato = dato; this.izq = null; this.der = null; }
}

class ArbolBinario {
  constructor() { this.raiz = null; }

  insertar(x) { this.raiz = this._insertar(this.raiz, x); }
  _insertar(n, x) {
    if (n === null) return new Nodo(x);            
    if (x < n.dato) n.izq = this._insertar(n.izq, x);
    else if (x > n.dato) n.der = this._insertar(n.der, x);
    return n;
  }

  buscar(x) {
    let n = this.raiz;
    while (n !== null) {
      if (x === n.dato) return true;
      n = x < n.dato ? n.izq : n.der;
    }
    return false;
  }

  altura(n = this.raiz) {
    return n === null ? -1 : 1 + Math.max(this.altura(n.izq), this.altura(n.der));
  }
  hojas(n = this.raiz) {
    if (n === null) return 0;
    if (n.izq === null && n.der === null) return 1;
    return this.hojas(n.izq) + this.hojas(n.der);
  }
}

module.exports = { ArbolBinario, Nodo };

if (require.main === module) {
  const a = new ArbolBinario();
  [50, 30, 70, 20, 40, 60, 80].forEach(x => a.insertar(x));
  console.log("Altura:", a.altura());              // 2
  console.log("Hojas:", a.hojas());                // 4
  console.log("¿Existe 60?", a.buscar(60) ? "sí" : "no");
  console.log("¿Existe 99?", a.buscar(99) ? "sí" : "no");
}
