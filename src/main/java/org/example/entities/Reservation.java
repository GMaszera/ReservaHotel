package org.example.entities;

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

    public String updateDates(Date chekIn, Date checkOut) {

        Date now = new Date();
        if (chekIn.before(now) || checkOut.before(now)) {
            return "Erro na reserva: Data de reserva para atualizações devem ser futuras";
        }
        if (!checkOut.after(chekIn)) {
            return "Erro na reserva: Check-Out deve ser após a data de Check-In.";
        }
        this.chekIn = chekIn;
        this.checkOut = checkOut;
        return null;
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
