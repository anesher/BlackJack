package org.example;

import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String rutaAbsoluta = "C:\\Users\\Usuario\\Desktop\\Antonio Eslava Hernández\\Cursos\\Desarollo de aplicaciones web\\Programación\\Trabajos\\Antonio_Eslava_Hernandez_U5";

        Mazo mazo = new Mazo();
        mazo.barajar();
        Scanner sc= new Scanner(System.in);
        try {
        // Crear un contexto JAXB para la clase Libros
        JAXBContext jaxbContext = JAXBContext.newInstance(Mano.class);

        Mano manoJugador = new Mano();
        manoJugador.pedirCarta(mazo);
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
                System.out.println("escoja n o s");
            }
        }

        if (manoJugador.finDeJuego()) {
            System.out.println("Has perdido, te has pasado de 21.");
        } else {
            System.out.println("Te plantaste con una puntuación de: " + manoJugador.valorMano());
        }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
//String rutaAbsoluta ="C:\\Users\\Usuario\\Desktop\\Antonio Eslava Hernández\\Cursos\\Desarollo de aplicaciones web\\Programación\\Trabajos\\Antonio_Eslava_Hernandez_U5" ;
