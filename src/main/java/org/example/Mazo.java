package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mazo {
    //La clase Mazo tiene una variable de instancia Cartas, que es un ArrayList que contiene objetos de tipo Carta.
    ArrayList<Carta> Cartas;
    //El constructor inicializa el mazo de cartas
    public Mazo(){
        Cartas=new ArrayList<>();
        for(Carta.Palo p: Carta.Palo.values()){
            for (int numeroCarta=1; numeroCarta<14;numeroCarta++){
                Cartas.add(new Carta(numeroCarta,p));
            }
        }
    }
    //La expresión Collections.shuffle(Cartas) es una llamada al método shuffle() de la clase Collections en Java. Este método se utiliza para barajar (o mezclar aleatoriamente) los elementos de una lista.
    public void barajar(){

        Collections.shuffle(Cartas);
    }
    //Este método proporciona una representación de cadena del mazo. Itera sobre todas las cartas en el mazo y las concatena en una cadena.
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
    ////Este método permite sacar una carta del mazo. Verifica si el mazo está vacío y, si no lo está, selecciona aleatoriamente una carta del mazo, la elimina y la devuelve. Si el mazo está vacío, imprime un mensaje de advertencia y devuelve null.
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

