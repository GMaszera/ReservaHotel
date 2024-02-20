package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Rooms {

    public static int quartos = 5;
    public static void  quantidadeQuartos() {
        List<String> numeroDosQuartos = new ArrayList<>();
        for (int i = 0; quartos >= i; i++) {
            numeroDosQuartos.add("Quarto #" + i);
            System.out.println(numeroDosQuartos.get(i));
        }

    }
}