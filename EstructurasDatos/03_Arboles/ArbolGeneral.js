// Sesión 26 - Terminología de árboles 
class NodoG {
  constructor(nombre) { this.nombre = nombre; this.hijos = []; }
  agregar(nombre) {
    const h = new NodoG(nombre);
    this.hijos.push(h);
    return h;
  }
}

function altura(n) {
  if (!n) return -1;
  return n.hijos.reduce((h, c) => Math.max(h, 1 + altura(c)), 0);
}
function hojas(n, lista = []) {
  if (n.hijos.length === 0) lista.push(n.nombre);
  else n.hijos.forEach(c => hojas(c, lista));
  return lista;
}
function mostrar(n, nivel = 0) {
  console.log(`${"   ".repeat(nivel)}${n.nombre}  [nivel ${nivel}, grado ${n.hijos.length}]`);
  n.hijos.forEach(c => mostrar(c, nivel + 1));
}

module.exports = { NodoG, altura, hojas, mostrar };

if (require.main === module) {
  // Sistema de archivos como ejemplo
  const raiz = new NodoG("C:");
  const docs = raiz.agregar("Documentos");
  const prog = raiz.agregar("Programas");
  docs.agregar("tarea.docx");
  docs.agregar("notas.txt");
  prog.agregar("src").agregar("main.js");
  prog.agregar("readme.md");

  mostrar(raiz);
  console.log("\nRaíz:", raiz.nombre);
  console.log("Hojas:", hojas(raiz).join(", "));
  console.log("Altura del árbol:", altura(raiz));
}
