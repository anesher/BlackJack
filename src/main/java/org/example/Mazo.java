package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mazo {
    ArrayList<Carta> Cartas;

    public Mazo(){
        Cartas=new ArrayList<>();
        for(Carta.Palo p: Carta.Palo.values()){
            for (int numeroCarta=1; numeroCarta<14;numeroCarta++){
                Cartas.add(new Carta(numeroCarta,p));
            }
        }
    }
    public void barajar(){
        Collections.shuffle(Cartas);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < Cartas.size(); i++) {
            // Si el índice actual es par y no es el último elemento
            if (i % 2 == 0 && i != Cartas.size() - 1) {
                result += Cartas.get(i) + "\t\t";
            } else {
                result += Cartas.get(i) + "\n";
            }
        }
        return result;
    }

    public Carta solicitarCarta(){
        if (!Cartas.isEmpty()){
            Random random= new Random();
            int indiceCarta =random.nextInt(Cartas.size());

            Carta cartaSolicitada = Cartas.remove(indiceCarta);

            return cartaSolicitada;
        }else{
            System.out.println("El mazo esta vacio");
            return null;
        }
    }

}

