package airport;

import java.util.ArrayList;
import java.util.List;

class Terminal {
    private List<String> messeges;

    public Terminal () {
        this.messeges = new ArrayList<String>();
    }

    public void OutputOnDisplay(int day) {
        System.out.println("day " + day);
        for (String msg : messeges)
            System.out.println(msg);
    }

    public void getMessege(String msg) {
        this.messeges.add(msg);
    }

    public void cleanmessages() {
        messeges.clear();
    }
}
