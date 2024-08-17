package behavioral.mediator;


import java.util.ArrayList;
import java.util.List;


/**
 * Mediator class.
 */
public class ChatRoom {
    private List<User> members = new ArrayList<>();

    public void join(User user) {
        String info = String.format("%s joins the room", user.name);
        broadcast("room", info);
        user.room = this;
        members.add(user);
    }

    public void broadcast(String source, String msg) {
        for (User user : members) {
            // Don't send message to sender
            if (!user.name.equals(source)) {
                user.receive(source, msg);
            }
        }
    }

    public void message(String source, String destination, String msg) {
        members.stream()
                .filter(user -> user.name.equals(destination))
                .findFirst()
                .ifPresent(member -> member.receive(source, msg));
    }
}


class Main {
    public static void main(String[] args) {
        final ChatRoom room = new ChatRoom();

        User ivan = new User("Ivan");
        User anna = new User("Anna");

        room.join(ivan);
        room.join(anna);

        ivan.send("Хеллоу чат!");
        anna.send("Привет, Иван :)");

        User ilya = new User("Ilya");
        room.join(ilya);
        ilya.send("Всем Привет!");

        anna.privateMsg("Ilya", "Спасибо за поддержку чата!");

        /*
        [Ivan's chat session] room: 'Anna joins the room'
        [Anna's chat session] Ivan: 'Хеллоу чат!'
        [Ivan's chat session] Anna: 'Привет, Иван :)'
        [Ivan's chat session] room: 'Ilya joins the room'
        [Anna's chat session] room: 'Ilya joins the room'
        [Ivan's chat session] Ilya: 'Всем Привет!'
        [Anna's chat session] Ilya: 'Всем Привет!'
        [Ilya's chat session] Anna: 'Спасибо за поддержку чата!'
         */
    }
}
