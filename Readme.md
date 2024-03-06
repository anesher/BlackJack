## Las dependencias que necesitamos para poder hacer un archivo xml es:

    <dependencies>
        <dependency>
            <groupId>javax.xml.bind</groupId>
            <artifactId>jaxb-api</artifactId>
            <version>2.3.1</version>
        </dependency>

        <dependency>
            <groupId>org.glassfish.jaxb</groupId>
            <artifactId>jaxb-runtime</artifactId>
            <version>2.3.3</version>
        </dependency>
    </dependencies>

## Intrucciones

### Clase Carta.
Este código Java define una clase llamada Carta, que representa una carta de una baraja de
cartas. Veamos los componentes principales del código:

 Enumeración Palo: En el código, se define una enumeración llamada Palo, que enumera
los posibles palos de una carta de una baraja estándar. Esto incluye Trebol, Diamantes,
Corazones y Picas. Usar una enumeración para los palos proporciona una forma
conveniente y segura de representar estos valores, ya que evita errores de escritura y
proporciona un conjunto limitado de opciones.

 Constructor: El constructor de la clase Carta se utiliza para crear instancias de cartas con
un número y un palo dados. Verifica si el número de la carta está dentro del rango válido
(entre 1 y 13) y muestra un mensaje de advertencia si no lo está. Esto asegura que las
cartas creadas estén dentro de los límites esperados y ayudan a prevenir errores en la
aplicación.

 Métodos de acceso: La clase proporciona métodos para obtener el número de la carta y
el palo de la carta. Estos métodos son útiles para acceder a la información de una carta
desde otras partes de la aplicación de manera segura, ya que encapsulan el acceso a las
variables de instancia de la clase.

 Método getValor: Este método devuelve el valor de la carta en un juego de Blackjack.
Por ejemplo, en Blackjack, las cartas numéricas tienen el mismo valor que su número,
mientras que las figuras (J, Q, K) tienen un valor de 10 y el As puede tener un valor de 11
o 1 según convenga al jugador.

 Método mostrarNumero: Este método devuelve una representación en forma de cadena
del número de la carta. Convierte los valores numéricos especiales (1 para AS, 11 para J,
12 para Q y 13 para K) en sus correspondientes nombres de cartas. Esto es útil para
mostrar la carta de una manera más comprensible para los usuarios, especialmente en
interfaces de usuario de juegos de cartas.

 Método toString: Este método proporciona una representación de cadena de la carta,
incluyendo el número y el palo de la carta. Sobrescribe el método toString heredado de la
clase Object, lo que permite imprimir fácilmente una carta en forma legible para humanos,
facilitando la depuración y el desarrollo de la aplicación.

### Clase Mazo.
 Declaración de la clase Mazo: La clase Mazo tiene una variable de instancia Cartas, que
es un ArrayList que contiene objetos de tipo Carta.

 Constructor Mazo(): El constructor inicializa el mazo de cartas. Utiliza dos bucles
anidados para iterar sobre cada uno de los palos (definidos en la clase Carta) y cada
número de carta del 1 al 13. Para cada combinación de palo y número de carta, crea un
objeto Carta y lo agrega al mazo.

 Método barajar(): Este método baraja las cartas en el mazo utilizando el método shuffle()
de la clase Collections, que reorganiza aleatoriamente los elementos en la lista.

 Método toString(): Este método proporciona una representación de cadena del mazo. Itera
sobre todas las cartas en el mazo y las concatena en una cadena. Además, formatea la
salida para que cada par de cartas esté separado por un tabulador (\t) y cada carta esté
en una nueva línea.

 Método solicitarCarta(): Este método permite sacar una carta del mazo. Verifica si el
mazo está vacío y, si no lo está, selecciona aleatoriamente una carta del mazo, la elimina
y la devuelve. Si el mazo está vacío, imprime un mensaje de advertencia y devuelve null.


### Clase Mano.
La clase Mano extiende la clase Mazo, lo que significa que hereda todas las características y
métodos de la clase Mazo. Además, tiene una anotación @XmlRootElement que especifica que
esta clase puede ser mapeada a un elemento raíz en un documento XML.

 Atributo carta: Esta clase tiene un atributo carta que es un ArrayList de objetos de tipo
Carta. Esta lista contiene las cartas que componen la mano del jugador.
 Constructor Mano(): El constructor inicializa la lista de cartas de la mano como un nuevo
ArrayList.

 Método valorMano(): Este método calcula el valor total de la mano sumando los valores
de todas las cartas en la mano utilizando el método getValor() de la clase Carta.

 Método finDeJuego(): Este método verifica si la suma de los valores de las cartas en la
mano supera 21, lo que significa que la mano está "quemada" en un juego de Blackjack.

 Método toString(): Este método proporciona una representación de cadena de la mano,
que incluye la puntuación total de la mano y una representación de cadena de las cartas
en la mano, utilizando el método toString() de la clase Mazo.

 Método pedirCarta(): Este método permite al jugador pedir una carta de un mazo dado.
Agrega la carta solicitada a la mano del jugador.

### Clase Main.
El código es una implementación de un juego simple de Blackjack en Java, que permite a un
jugador pedir cartas del mazo hasta que decida plantarse o sobrepasar un total de 21. A
continuación, se detallan los principales componentes y funcionalidades del código:

 Clase Main: Esta es la clase principal del programa, que contiene el método main donde
comienza la ejecución del juego.

 Inicialización del mazo y barajado: Se crea un objeto de la clase Mazo, se barajan las
cartas y se prepara el mazo para el juego.

 Bucle principal del juego: Se utiliza un bucle while para permitir al jugador pedir cartas
del mazo mientras no se pase de 21 puntos.

 Interacción con el jugador: Se muestra la mano actual del jugador y se le pregunta si
desea pedir otra carta. La entrada del jugador se captura mediante un objeto Scanner.
 Manejo de la lógica del juego: Dependiendo de la decisión del jugador, se agregan
cartas a la mano del jugador o se finaliza el juego.

 Generación de un archivo XML: Después de cada jugada, se utiliza JAXB (Java
Architecture for XML Binding) para convertir la mano del jugador en un documento XML y
se guarda en un archivo llamado salida.xml.

 Finalización del juego: El juego termina cuando el jugador decide plantarse o cuando su
mano supera los 21 puntos. Se muestra un mensaje indicando si el jugador ganó o perdió.


