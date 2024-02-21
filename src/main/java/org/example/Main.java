package org.example;

import org.example.model.entities.Reservation;
import org.example.model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero do quarto: ");
            int roomNumber = sc.nextInt();
            System.out.print("Data de check-in (Ex. dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (Ex. dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            //Validar se uma data é posterior a outra, se não, instanciar e apresentar a reserva
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Entre com a data de atualização de sua reserva");
            System.out.print("Data de check-in (Ex. dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (Ex. dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reserva: " + reservation);


        } catch (ParseException e) {
            System.out.println("Formato invalido de data");
        } catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error");
        }


        sc.close();
    }
}


