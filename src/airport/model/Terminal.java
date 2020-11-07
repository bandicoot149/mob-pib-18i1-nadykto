package airport.model;

import java.util.ArrayList;
import java.util.List;

public class Terminal {
    private final List<String> messages;

    public Terminal () {
        this.messages = new ArrayList<>();
    }

    public void outputOnDisplay(int day) {
        System.out.println("day " + day);
        for (String msg : messages)
            System.out.println(msg);
    }

    public void addMessage(String msg) {
        this.messages.add(msg);
    }

    public void cleanMessages() {
        messages.clear();
    }
}
