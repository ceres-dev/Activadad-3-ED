# Diferencias entre List, Queue, Deque y Map (y dónde se usa)
## List

**Características:** Colección ordenada, permite elementos duplicados, acceso por índice.

**Implementaciones comunes:** ArrayList (basado en array, acceso rápido por índice), LinkedList (lista doblemente enlazada, inserciones/eliminaciones eficientes en cualquier posición).

**Dónde se usa:**
- Almacenar y recorrer elementos en el orden de inserción.
- Acceder frecuentemente a elementos por posición (ej. ArrayList).
- Aplicar operaciones como búsqueda, ordenación, o filtrado.
- Ejemplos: lista de usuarios, resultados de una consulta, historial de acciones.

## Queue

**Características**: Estructura `FIFO (first-in-first-out)`. Define operaciones como offer(), poll(), peek().

**Implementaciones comunes**: LinkedList, PriorityQueue (elementos ordenados por prioridad, no estrictamente FIFO), ArrayBlockingQueue (para concurrencia).

Dónde se usa:
- Procesamiento de tareas por orden de llegada (buffer, cola de impresión).
- Algoritmos de búsqueda en anchura (BFS) en grafos.
- Manejo de solicitudes en servidores (cola de peticiones).
- Ejemplos: cola de mensajes, cola de trabajos en un pool de hilos.

## Deque

**Características**: Doble cola (double-ended queue), permite inserción y eliminación por ambos extremos (cabeza o cola). Puede usarse como FIFO o LIFO (pila).

**Implementaciones** comunes: ArrayDeque (más eficiente que LinkedList para pilas/colas), LinkedList.

Dónde se usa:
- Implementar pilas (push/pop) de forma más eficiente que con Stack (que es obsoleto).
- Colas con posibilidad de insertar/extraer por ambos lados (ej. ventana deslizante, procesamiento de comandos con deshacer/rehacer).
- Algoritmos como el recorrido de árboles (zigzag), o cachés LRU simples.
- Ejemplos: historial de navegación (atrás/adelante), cola de tareas con prioridad de extremos.

## Map

**Características**: Almacena pares clave–valor. Las claves son únicas (no se permiten duplicados). No es una colección "Collection" (no hereda de Collection).

**Implementaciones comunes**: HashMap (sin orden), TreeMap (ordenado por clave), LinkedHashMap (orden de inserción o acceso).

Dónde se usa:
- Búsquedas rápidas por clave (diccionarios, cachés).
- Agrupar elementos por una propiedad (ej. agrupar personas por edad).
- Contar frecuencias (mapa palabra → frecuencia).
- Almacenar configuración (clave-valor).
- Ejemplos: mapa de usuarios por ID, inventario de productos, caché de resultados.

# Diferencias entre implementar estructuras propias y usar las provistas por Java

## Usar las estructuras de Java (Collections Framework)

### Ventajas
- Código probado y optimizado: Las implementaciones estándar son maduras, eficientes (tiempo/espacio) y libres de errores comunes.
- Rica API: Métodos útiles (addAll, removeIf, stream(), sort, etc.) que reducen código repetitivo.
- Interoperabilidad: Se integran con otros APIs de Java (Streams, concurrencia, serialización).
- Mantenibilidad: Otros desarrolladores conocen el comportamiento estándar; no hay que aprender una implementación casera.
- Rendimiento suficiente para la mayoría de casos: ArrayList, HashMap, ArrayDeque son muy rápidos.

### Desventajas
- Sobrecarga de funcionalidad: Algunas estructuras (ej. HashMap) tienen overhead de memoria y operaciones por soportar rehashing, iteradores, etc.
- Limitaciones para casos muy específicos: No siempre permiten control fino sobre la memoria, la ubicación de datos, o algoritmos muy particulares.
- No atómicos sin sincronización externa: Salvo las clases del paquete java.util.concurrent, no son thread-safe por defecto.

## Implementar estructuras propias
- Control total: Puedes optimizar para un patrón de acceso concreto (ej. lista enlazada que mantiene un pool de nodos reutilizables).
- Ajuste de memoria: Puedes usar primitivas o unsafe para reducir overhead de objetos (útil en sistemas embebidos o big data).
- Comportamiento especial: Implementar estructuras exóticas (trie, skip list, lock-free queue) o variantes (mapa con expiración por tiempo).
- Aprendizaje: Entender cómo funcionan internamente las estructuras.

### Ventajas:
- Control total: Puedes optimizar para un patrón de acceso concreto (ej. lista enlazada que mantiene un pool de nodos reutilizables).
- Ajuste de memoria: Puedes usar primitivas o unsafe para reducir overhead de objetos (útil en sistemas embebidos o big data).
- Comportamiento especial: Implementar estructuras exóticas (trie, skip list, lock-free queue) o variantes (mapa con expiración por tiempo).
- Aprendizaje: Entender cómo funcionan internamente las estructuras.

### Desventajas
- Alto costo de desarrollo y prueba: Es fácil introducir bugs (referencias nulas, pérdidas de memoria, concurrencia incorrecta).
- Mantenimiento complicado: Otros programadores tendrán que entender tu implementación.
- Rendimiento a menudo peor: Sin experiencia, una implementación casera suele ser más lenta que las optimizadas de Java (que usan trucos nativos y años de ajustes).
- Duplicación de esfuerzo: Reinventar la rueda cuando ya existe una solución estándar.