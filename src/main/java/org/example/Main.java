package org.example;

import org.example.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int roomNumber = sc.nextInt();
        System.out.print("Data de check-in (Ex. dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data de check-out (Ex. dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        //Validar se uma data é posterior a outra, se não, instanciar e apresentar a reserva
        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: Check-Out deve ser após a data de Check-In.");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Entre com a data de atualização de sua reserva");
            System.out.print("Data de check-in (Ex. dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (Ex. dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Erro na reserva: " + error);
            } else {
                System.out.println("Reserva: " + reservation);
            }

        }
        sc.close();
    }
}


