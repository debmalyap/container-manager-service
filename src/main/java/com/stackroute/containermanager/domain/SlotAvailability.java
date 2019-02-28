package com.stackroute.containermanager.domain;

import java.util.Date;
import java.util.List;

public class SlotAvailability
{
    private Date date;
    private List<Slot> slots;

    public SlotAvailability(Date date, List<Slot> slots)
    {
        this.date = date;
        this.slots = slots;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "SlotAvailability{" +
                "date=" + date +
                ", slots=" + slots +
                '}';
    }
}
