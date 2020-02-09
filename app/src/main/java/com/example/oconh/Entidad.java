package com.example.oconh;

public class Entidad {

    private String day;
    private String description;
    private String hour;
    private String place;
    private String tema;

    public Entidad(String day,String description,String hour,String place,String tema) {
       this.day = day;
       this.description = description;
       this.hour = hour;
       this.place = place;
       this.tema = tema;
    }

    public String getDay() {
        return day;
    }

    public String getDescription() {
        return description;
    }

    public String getHour() {
        return hour;
    }

    public String getPlace() {
        return place;
    }

    public String getTema() {
        return tema;
    }
}
