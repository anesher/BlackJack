package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Mano")
public class Mano extends Mazo{
    //Esta clase tiene un atributo carta que es un ArrayList de objetos de tipo Carta. Esta lista contiene las cartas que componen la mano del jugador.

@XmlElement
    //El constructor inicializa la lista de cartas de la mano como un nuevo ArrayList.
    private ArrayList<Carta> carta;
    public Mano() {
        this.Cartas= new ArrayList<>();
    }
    //(): Este método calcula el valor total de la mano sumando los valores de todas las cartas en la mano utilizando el método getValor() de la clase Carta.
    public int valorMano(){
        int valor = 0;
        for (Carta carta : Cartas) {
            valor += carta.getValor();
        }
        return valor;
    }

    //Este método verifica si la suma de los valores de las cartas en la mano supera 21, lo que significa que la mano está "quemada" en un juego de Blackjack.
    public boolean finDeJuego() {

        return valorMano() > 21;
    }
    //Este método proporciona una representación de cadena de la mano, que incluye la puntuación total de la mano y una representación de cadena de las cartas en la mano, utilizando el método toString() de la clase Mazo.
    @Override
    public String toString() {
        return "Puntuación: " + valorMano() + "\n" + super.toString();
    }
    //Este método permite al jugador pedir una carta de un mazo dado. Agrega la carta solicitada a la mano del jugador
    public void pedirCarta(Mazo m) {
        Cartas.add(m.solicitarCarta());
    }
}

