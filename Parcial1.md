# Parcial 1


## Explique la diferencia entre @Component y @Configuration en Spring.

Ambos @Component y @Configuration son anotaciones utilizadas en Spring para definir beans, pero tienen diferentes propósitos y comportamientos:

1. @Component
 * Marca una clase como un componente administrado por Spring.
 * Utilizado para definiciones de beans simples y genéricas.
 * Beans creados con @Component no incluya ningún comportamiento especial, como la capacidad de definir otros Beans dentro de ellos.

2. @Configuration
 * Forma especializada de @Component.
 * Indica que la clase contiene @Bean definiciones.
 * Asegura que los beans definidos en esta clase se crean solo una vez (Singleton) habilitando Proxy CGLIB.
 * Soporta métodos de fábrica de Beans, que puede devolver otros Beans Spring.

## Explique el principio de inversión de control y cómo se aplica en esta solución.

 * Principio de Inversión de Control (IoC):
Definición:
El IoC es un principio de diseño donde el control de la creación y gestión de objetos se delega a un contenedor (Spring), en lugar de que las clases los instancien directamente.

 * Aplicación:

 ** Anotaciones @Repository

 ** Inyección de dependencias

 ## Explique cómo funciona la inyección de propiedades en Spring utilizando @Value y qué precedencia tiene cada fuente.

 La inyección de propiedades en Spring mediante @Value permite asignar valores a campos de componentes desde múltiples fuentes externas, como archivos de propiedades (application.properties), variables de entorno o argumentos de línea de comandos. Spring sigue un orden de precedencia para resolver conflictos: los argumentos de línea de comandos (ej: --app.name="valor") tienen la máxima prioridad, seguidos de las variables de entorno, luego los archivos específicos de perfil (como application-dev.properties), el archivo general application.properties, y finalmente los valores predeterminados definidos directamente en @Value (ej: @Value("${app.name:Default}")). Este mecanismo garantiza flexibilidad, permitiendo sobrescribir configuraciones según el entorno (desarrollo, producción, etc.) mientras se mantiene un valor base seguro en caso de que otras fuentes no estén disponibles.

