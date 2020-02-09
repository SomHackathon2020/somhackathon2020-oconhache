package com.example.oconh;

import java.util.ArrayList;

public class EventService {

    private ArrayList<Entidad> events = new ArrayList<Entidad>();
    private static EventService eventService;

    public static EventService getInstance(){
        if(EventService.eventService == null){
            eventService = new EventService();
        }
        return eventService;
    }

    public boolean register(String day, String description, String hour, String place, String tema){

        Entidad event = new Entidad(day,description,hour,place,tema);
        events.add(event);
        return true;
    }

    public ArrayList<Entidad> getEvents() {
        return events;
    }
}
