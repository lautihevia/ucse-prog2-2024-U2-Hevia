# Benchmark

La salida muestra los resultados de dos benchmarks: `benchmarkParallelStream` y `benchmarkStream`. Para cada benchmark,
JMH ejecuta varias iteraciones e informa el tiempo promedio tomado por operación (en milisegundos), junto con una
estimación de error.
La operación `benchmarkParallelStream` tomó un promedio de 97.985 ms/op, mientras que la operación `benchmarkStream`
tomó un promedio de 225.935 ms/op. Como podemos ver, la operación de stream paralelo es más rápida que la operación de
stream secuencial.

- El "avgt" en la columna de modo significa "tiempo promedio", es decir que hace referencia a que el benchmark mide el
  tiempo promedio de ejecución de una operación.
- El "5" en la columna de conteo (Cnt) indica la cantidad de mediciones que JMH tomó para calcular el promedio.
- La columna "Score" representa el tiempo promedio tomado por operación.
- La columna "Error" representa el intervalo de confianza del 99.9% alrededor del score.
- La columna "Units" indica las unidades para el score y el error, en este caso, milisegundos por operación (ms/op).

## Elección

En general, `parallelStream` puede ser más rápido que `stream` para operaciones que son computacionalmente intensivas y
que se pueden dividir fácilmente en tareas independientes. Esto se debe a que `parallelStream` puede dividir el trabajo
entre múltiples hilos, aprovechando los múltiples núcleos de la CPU.

Sin embargo, `parallelStream` tiene un costo de configuración y coordinación. Si estamos trabajando con un número
pequeño de elementos o realizando operaciones que no son computacionalmente intensivas, el costo de dividir el trabajo
entre múltiples hilos puede superar los beneficios, y `stream` puede ser más rápido. Además, `parallelStream` puede
tener efectos secundarios no deseados si se utiliza con operaciones que alteran el estado, y puede ser más difícil de
depurar que `stream`.

En este caso, según los resultados del benchmark,`benchmarkParallelStream` es significativamente más rápido
que `benchmarkStream`. Por lo que `parallelStream` puede ser la mejor opción.

# Correcciones - Estado: A CORREGIR

## Necesarias para aprobar:

- Ejercicio 1: en los tests no utliza @BeforeEach, codigo repetido que se pisa ya que no se renueva en cada @Test.
- Ejercicio 2: Deben duplicar el codigo anterior, no modificarlo en el mismo archivo. NO utilizar
  optimizaciones del compilador JIT (Just In Time). Para ésto deberían de utilizar el objeto BlackHole, el cual les
  permite tener resultados sin sesgos en cuanto a la optimización del compilador, pueden ver un ejemplo
  acá https://www.baeldung.com/java-microbenchmark-harness#dead-code-elimination
- Ejercicio 3: Hace un .get() por cada tarea, debería de utilizar otro método de CompletableFuture para poder esperar a
  todas las tareas juntas. Al hacer un .get() por cada tarea, éstas se ejecutan secuencialmente, incrementando en N el
  tiempo de ejecución dependiendo del tamaño N del input recibido. Ejecutarlas paralelamente. Por otra parte, tanto en
  éste ejercicio como en el ejercicio 4, deberían de tener un método main para poder ejecutar dicho ejercicio por
  separado.
- Ejercicio 4: Agregar metodo main para ejecutar por separado.
- En la elaboración de sus conclusiones, es fundamental que incluyan los valores obtenidos en la descripción y
  cuantifiquen los resultados con medidas específicas. Al hacer esto, sus conclusiones serán más precisas y sólidas.

## Adicionales:

- Ejercicio 4: Es innecesario hacer el anyFuture.join();
- Deberían de actualizar el .gitignore para no incluir los archivos generados al compilar, ni los archivos propios del
  framework que utilicen (.idea, .vscode, etc). De lo contrario se pueden pushear archivos indeseados, como la carpeta
  build, "hs_err_pid5148.log" y otros.
- La estructura de las carpetas podría separarse entre cada ejercicio de una manera más granular. Pordían separar entre
  ClasesATestear, Ejercicio3, Ejercicio4, PrebaBenchmark y colocar cada archivo en cada package correspondiente.
- En ésta misma linea, si hacen el refactor sugerido en el punto anterior, los tests siempre deberían de ir en el mismo
  package y tener la misma estructura de carpetas que en main, por lo tanto en vez de ir en test/java deberían de ir
  dentro de test/java/org/example/TestClasesATestear

