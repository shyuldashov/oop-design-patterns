package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;


public class User {
    public String name;
    public ChatRoom room;
    private List<String> chatLog = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void receive(String sender, String msg) {
        String chatInfo = String.format(
                "[%s's chat session] %s: '%s'",
                name, sender, msg
        );
        System.out.println(chatInfo);
        chatLog.add(chatInfo);
    }

    public void send(String msg) {
        room.broadcast(name, msg);
    }

    public void privateMsg(String who, String msg) {
        room.message(name, who, msg);
    }
}
