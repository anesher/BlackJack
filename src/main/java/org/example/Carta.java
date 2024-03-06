package org.example;

import java.util.Objects;

public class Carta {
    enum Palo  {
        Trebol,
        Diamantes,
        Corazones,
        Picas
    }

    Integer numeroDeCarta;
    public Palo paloCarta;

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

    public int getValor() {
        if (numeroDeCarta == 1) {
            return 11; // Valor de AS en Blackjack
        } else if (numeroDeCarta >= 11 && numeroDeCarta <= 13) {
            return 10; // Valor de figuras (J, Q, K) en Blackjack
        } else {
            return numeroDeCarta;
        }
    }

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


    @Override
    public String toString() {
        return "Carta{" +
                "numeroDeCarta=" + numeroDeCarta +
                ", paloCarta=" + paloCarta +
                '}';
    }
}

