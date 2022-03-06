package com.example.democompositelisteners;

import java.util.ArrayList;
import java.util.List;

public class Event implements EventListener {

    public static List<EventListener> listeners = new ArrayList<>();
    public static int counter = 0;

    public void addOnEventListener(EventListener listener){
        listeners.add(listener);
    }

    public void removeOnEventListener(EventListener listener){
        listeners.remove(listener);
    }

    @Override
    public void onEvent(String value) {
        for(EventListener listener : listeners){
            listener.onEvent(value);
        }
    }

    public int fire(){
        onEvent("Fired: "+counter);
        counter++;

        return counter;
    }
}