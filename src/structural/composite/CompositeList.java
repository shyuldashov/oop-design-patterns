package structural.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class CompositeList extends ArrayList<ValueContainer> {

    public CompositeList(Collection<? extends ValueContainer> collection) {
        super(collection);
    }

    public int sum() {
        int totalSum = 0;
        for (ValueContainer valueContainer : this) {
            for (int number : valueContainer) {
                totalSum += number;
            }
        }

        return totalSum;
    }
}

class MainTwo {
    public static void main(String[] args) {
        SingleValue value = new SingleValue(4);
        SingleValue value2 = new SingleValue(-5);
        SingleValue value3 = new SingleValue(19);
        ManyValues manyValues = new ManyValues();

        manyValues.addAll(
                Arrays.asList(55, 10, new SingleValue(8).value)
        );
        CompositeList compositeList = new CompositeList(
                List.of(value, value2, value3, manyValues)
        );

        System.out.printf("Total sum: %d", compositeList.sum());
    }
}
