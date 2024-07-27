package structural.flywieght;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class UserOptimal {

    static List<String> namesStorage = new ArrayList<>();
    private int[] names;  // indexes which the current user refers to

    public UserOptimal(String fullName) {
        Function<String, Integer> getOrAdd = (String name) -> {
            int index = namesStorage.indexOf(name);
            if (index != -1) {
                // found name in the storage
                return index;
            } else {
                namesStorage.add(name);
                // index of last element
                return namesStorage.size() - 1;
            }
        };
        names = Arrays.stream(fullName.split(" "))
                .mapToInt(getOrAdd::apply)
                .toArray();
    }
}

class MainTwo {
    public static void main(String[] args) {
        UserOptimal userOptimal = new UserOptimal("Ivan Ivanov");
        UserOptimal userOptimal2 = new UserOptimal("Max Ivanov");
        UserOptimal userOptimal3 = new UserOptimal("Alex Ivanov");
        System.out.println(UserOptimal.namesStorage);
    }
}
