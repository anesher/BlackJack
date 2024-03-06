package org.example;

import java.util.Objects;

public class Carta {
    //enumeracion de los posibles palos que que puede tener una carta
    enum Palo  {
        Trebol,
        Diamantes,
        Corazones,
        Picas
    }

    Integer numeroDeCarta;
    public Palo paloCarta;

    //El constructor de la clase Carta se utiliza para crear instancias de cartas con un número y un palo dados
    public Carta(int numeroDeCarta,Palo paloCarta) {
        this.paloCarta=paloCarta;
        if (numeroDeCarta < 1 || numeroDeCarta > 13) {
            System.out.println("El número de la carta debe estar entre 1 y 13");
        }
        this.numeroDeCarta = numeroDeCarta;
    }
    public int getNumeroDeCarta() {

        return numeroDeCarta;
    }
    public Palo getPaloCarta() {

        return paloCarta;
    }

    ////Este método devuelve el valor de la carta en un juego de Blackjack.
    public int getValor() {
        if (numeroDeCarta == 1) {
            return 11; // Valor de AS en Blackjack
        } else if (numeroDeCarta >= 11 && numeroDeCarta <= 13) {
            return 10; // Valor de figuras (J, Q, K) en Blackjack
        } else {
            return numeroDeCarta;
        }
    }
    //Este método devuelve una representación en forma de cadena del número de la carta.
    public String mostrarNumero() {
        switch (numeroDeCarta) {
            case 1:
                return "AS";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(numeroDeCarta);
        }
    }

    //Este método proporciona una representación de cadena de la carta, incluyendo el número y el palo de la carta.
    @Override
    public String toString() {
        return "Carta{" +
                "numeroDeCarta=" + numeroDeCarta +
                ", paloCarta=" + paloCarta +
                '}';
    }
}

