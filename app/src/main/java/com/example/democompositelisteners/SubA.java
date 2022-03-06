package com.example.democompositelisteners;

public class SubA {
    private static String value = "No event";

    private static SubA subA = null;
    private static Event event = null;

    private int registeredEvents = 0;

    private static final EventListener listener = new EventListener() {
        @Override
        public void onEvent(String arg) {
            value = arg;
        }
    };

    public static SubA init() {
        if (subA != null) {
            return subA;
        }
        subA = new SubA();
        event = new Event();

        return subA;
    }

    public void addEvent() {
        event.addOnEventListener(listener);
        registeredEvents++;
    }

    public void removeEvent() {
        event.removeOnEventListener(listener);
        if (registeredEvents > 0) registeredEvents--;
    }

    private void setValue(String arg) {
        value = arg;
    }

    public String getValue() {
        return value;
    }

    public String getRegisteredEvents() {
        return String.valueOf(registeredEvents);
    }
}