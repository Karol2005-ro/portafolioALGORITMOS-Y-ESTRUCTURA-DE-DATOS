// Sesión 22 - Actividad: comparar rendimiento arreglo vs lista enlazada
const PilaArreglo = require("./PilaArreglo");
const PilaLista = require("./PilaLista");

const N = 1_000_000;

function medir(nombre, pila) {
  const t0 = process.hrtime.bigint();
  for (let i = 0; i < N; i++) pila.push(i);
  while (!pila.estaVacia()) pila.pop();
  const ms = Number(process.hrtime.bigint() - t0) / 1e6;
  console.log(`${nombre}: ${ms.toFixed(1)} ms`);
}

medir("Arreglo        ", new PilaArreglo(N));
medir("Lista enlazada ", new PilaLista());
console.log("Ambas son O(1) por operación; la lista paga overhead por crear nodos.");
