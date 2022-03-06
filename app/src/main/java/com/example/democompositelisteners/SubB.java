package com.example.democompositelisteners;

public class SubB {
    private static String value = "No event";

    private static SubB subB = null;
    private static Event event = null;

    private int registeredEvents = 0;

    private static EventListener listener = new EventListener() {
        @Override
        public void onEvent(String arg) {
            value = arg;
        }
    };

    public static SubB init() {
        if (subB != null) {
            return subB;
        }
        subB = new SubB();
        event = new Event();

        return subB;
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
