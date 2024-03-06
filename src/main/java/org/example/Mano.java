package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Mano")
public class Mano extends Mazo{
@XmlElement
    private ArrayList<Carta> carta;
    public Mano() {
        this.Cartas= new ArrayList<>();
    }

    public int valorMano(){
        int valor = 0;
        for (Carta carta : Cartas) {
            valor += carta.getValor();
        }
        return valor;
    }


    public boolean finDeJuego() {
        return valorMano() > 21;
    }

    @Override
    public String toString() {
        return "Puntuación: " + valorMano() + "\n" + super.toString();
    }

    public void pedirCarta(Mazo m) {
        Cartas.add(m.solicitarCarta());
    }
}

