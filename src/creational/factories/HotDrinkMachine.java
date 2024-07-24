package creational.factories;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("[+]: This tea is delicious");
    }
}

class Coffee implements HotDrink {
    @Override
    public void consume() {
        System.out.println("[+]: This coffee is delicious");
    }
}


class TeaFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.printf(
                "[+]: Put in tea bag, boil water, pour %dml, add lemon, enjoy!\n",
                amount
        );
        return new Tea();
    }
}

class CoffeeFactory implements HotDrinkFactory {
    @Override
    public HotDrink prepare(int amount) {
        System.out.printf(
                "[+]: Grind some beans, boil water, pour %dml, add cream and sugar, enjoy!\n",
                amount
        );
        return new Coffee();
    }
}

class HotDrinkMachine {
    private final List<Pair<String, HotDrinkFactory>> factoriesList = new ArrayList<>();

    public HotDrinkMachine() {
        factoriesList.add(new Pair<>("Tea", new TeaFactory()));
        factoriesList.add(new Pair<>("Coffee", new CoffeeFactory()));
    }

    public void getAvailableDrinksList() {
        System.out.println("[+]: Available drinks:");
        for (int index = 0; index < factoriesList.size(); index++) {
            Pair<String, HotDrinkFactory> item = factoriesList.get(index);
            System.out.printf(" %d: %s\n", index, item.getDrinkName());
        }
    }

    public HotDrink makeDrink() throws Exception {
        this.getAvailableDrinksList();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String inputValue;
            int i, amount;

            System.out.print("[+]: Num of drink: ");
            if ((inputValue = reader.readLine()) != null
                    && (i = Integer.parseInt(inputValue)) >= 0
                    && i < factoriesList.size()) {
                System.out.print("[+]: Specify amount: ");
                inputValue = reader.readLine();
                if (inputValue != null && (amount = Integer.parseInt(inputValue)) > 0) {
                    return factoriesList.get(i).getDrinkFactoryObject().prepare(amount);
                }
            }
            System.out.println("[-] Incorrect value, try again...");
        }
    }
}

class MainThree {
    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink drink = machine.makeDrink();
        drink.consume();
    }
}
