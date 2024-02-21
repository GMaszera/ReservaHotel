package org.example.model.entities;

import org.example.model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date chekIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date chekIn, Date checkOut) {
        super();
        if (!checkOut.after(chekIn)) {
            //throw new IllegalArgumentException();
            throw new DomainException("Check-Out deve ser após a data de Check-In.");
        }

        this.roomNumber = roomNumber;
        this.chekIn = chekIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getChekIn() {
        return chekIn;
    }

    public void setChekIn(Date chekIn) {
        this.chekIn = chekIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - chekIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date chekIn, Date checkOut)  {

        Date now = new Date();
        if (chekIn.before(now) || checkOut.before(now)) {
            //throw new IllegalArgumentException();
            throw new DomainException("Data de reserva para atualizações devem ser futuras");
        }
        if (!checkOut.after(chekIn)) {
           //throw new IllegalArgumentException();
            throw new DomainException("Check-Out deve ser após a data de Check-In.");
        }
        this.chekIn = chekIn;
        this.checkOut = checkOut;

    }


    @Override
    public String toString() {
        return "Room"
                + roomNumber
                + ", check-in: "
                + sdf.format(chekIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }

}
