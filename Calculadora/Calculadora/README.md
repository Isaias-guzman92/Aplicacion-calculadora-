# Calculadora (Java SE, sin frameworks)

Aplicación de escritorio con POO y tres capas: modelo, vista y controlador.

## Estructura
    src/calculadora/Main.java
    src/calculadora/modelo/        (Operacion, Suma, Resta, Multiplicacion, Division, Calculadora)
    src/calculadora/controlador/   (ControladorCalculadora)
    src/calculadora/vista/         (VentanaCalculadora)
    test/calculadora/modelo/       (pruebas unitarias JUnit 5)
    docs/diagrama_clases.png       (diagrama hecho con Dia)

## IntelliJ IDEA
1. File > Open > carpeta `Calculadora`.
2. Clic derecho en `src` > Mark Directory as > Sources Root.
3. Clic derecho en `test` > Mark Directory as > Test Sources Root.
4. Abrir una clase de prueba, Alt+Enter sobre `@Test` > "Add 'JUnit5.x' to classpath".
5. Ejecutar pruebas: clic derecho en `test` > Run 'All Tests'.
6. Ejecutar la app: clic derecho en `Main` > Run 'Main.main()'.
