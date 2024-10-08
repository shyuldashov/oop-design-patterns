package behavioral.state;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Phone {
    private static Map<State, List<Pair<Trigger, State>>> rules = new HashMap<>();

    static {
        rules.put(
                State.OFF_HOOK,
                List.of(
                        new Pair<>(Trigger.CALL_DIALED, State.CONNECTED),
                        new Pair<>(Trigger.STOP_USING_PHONE, State.ON_HOOK)
                )
        );
        rules.put(
                State.CONNECTING,
                List.of(
                        new Pair<>(Trigger.HUNG_UP, State.OFF_HOOK),
                        new Pair<>(Trigger.CALL_CONNECTED, State.CONNECTED)
                )
        );
        rules.put(
                State.CONNECTED,
                List.of(
                        new Pair<>(Trigger.LEFT_MESSAGE, State.OFF_HOOK),
                        new Pair<>(Trigger.HUNG_UP, State.OFF_HOOK),
                        new Pair<>(Trigger.PLACED_ON_HOLD, State.ON_HOLD)
                )
        );
        rules.put(
                State.ON_HOLD,
                List.of(
                        new Pair<>(Trigger.TAKEN_OFF_HOLD, State.CONNECTED),
                        new Pair<>(Trigger.HUNG_UP, State.OFF_HOOK)
                )
        );
    }

    private static State currentState = State.OFF_HOOK;
    private static State exitState = State.ON_HOOK;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        do {
            System.out.printf("The phone is currently %s%n", currentState);
            System.out.println("Select a trigger: ");
            for (int i = 0; i < rules.get(currentState).size(); ++i) {
                Trigger trigger = rules.get(currentState).get(i).getTrigger();
                System.out.printf("%d. %s%n", i, trigger);
            }
            boolean parseOk = true;
            int choice = 0;
            do {
                try {
                    System.out.println("Please enter your choice: ");
                    choice = Integer.parseInt(bufferedReader.readLine());
                } catch (Exception err) {
                    parseOk = false;
                }
            }
            while (!parseOk);
            currentState = rules.get(currentState).get(choice).getState();
        } while (currentState != exitState);
        System.out.println("We are done using the phone");
    }

}
