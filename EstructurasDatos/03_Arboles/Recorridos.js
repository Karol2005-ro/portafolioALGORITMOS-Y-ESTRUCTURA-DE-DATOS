// Sesión 26 - Recorridos
const { ArbolBinario } = require("./ArbolBinario");

// Para copiar árboles
function preorden(n, res = []) {
  if (!n) return res;
  res.push(n.dato);
  preorden(n.izq, res);
  preorden(n.der, res);
  return res;
}
// Produce orden ascendente en un arbol binario
function inorden(n, res = []) {
  if (!n) return res;
  inorden(n.izq, res);
  res.push(n.dato);
  inorden(n.der, res);
  return res;
}
// Para eliminar nodos
function postorden(n, res = []) {
  if (!n) return res;
  postorden(n.izq, res);
  postorden(n.der, res);
  res.push(n.dato);
  return res;
}

module.exports = { preorden, inorden, postorden };

if (require.main === module) {
  const a = new ArbolBinario();
  [50, 30, 70, 20, 40, 60, 80].forEach(x => a.insertar(x));
  console.log("Preorden: ", preorden(a.raiz).join(" "));   
  console.log("Inorden:  ", inorden(a.raiz).join(" "));    
  console.log("Postorden:", postorden(a.raiz).join(" "));  
}
