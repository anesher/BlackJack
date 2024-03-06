package org.example;

import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        //ruta donde se va a guardar
        String rutaAbsoluta = "C:\\Users\\Usuario\\Desktop\\Antonio Eslava Hernández\\Cursos\\Desarollo de aplicaciones web\\Programación\\Trabajos\\Antonio_Eslava_Hernandez_U5";
        //se inicaliza la clase Mazo y Scanner
        Mazo mazo = new Mazo();
        mazo.barajar();
        Scanner sc= new Scanner(System.in);
        try {
        // Crear un contexto JAXB para la clase Mano
        JAXBContext jaxbContext = JAXBContext.newInstance(Mano.class);
        // se inicializa la clase mano y se pide una carta al jugador
        Mano manoJugador = new Mano();
        manoJugador.pedirCarta(mazo);
        System.out.println("Mano del jugador:");
        System.out.println(manoJugador);

        while (!manoJugador.finDeJuego()) {
            // Solicitar carta al jugador
            System.out.println("¿Quieres otra carta? pulse 1 sino pulse 2");
            int respuesta=sc.nextInt();

            if (respuesta == 1) {
                manoJugador.pedirCarta(mazo);
                System.out.println("Mano del jugador:");
                System.out.println(manoJugador);
                    // Crear un marshaller
                    Marshaller marshaller = jaxbContext.createMarshaller();
                    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                    // Marshalling y escritura a un archivo XML
                    marshaller.marshal(manoJugador, new File("salida.xml"));

                    System.out.println("Archivo XML generado exitosamente.");

            } else if (respuesta == 2) {
                break;

            }else{
                System.out.println("escoja 1 o 2");
            }
        }
        // conclusion para dar los resultados y terminar el juego
        if (manoJugador.finDeJuego()) {
            System.out.println("Has perdido, te has pasado de 21." +manoJugador.valorMano());
        } else {
            System.out.println("Te plantaste con una puntuación de: " + manoJugador.valorMano());
        }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
//String rutaAbsoluta ="C:\\Users\\Usuario\\Desktop\\Antonio Eslava Hernández\\Cursos\\Desarollo de aplicaciones web\\Programación\\Trabajos\\Antonio_Eslava_Hernandez_U5" ;
