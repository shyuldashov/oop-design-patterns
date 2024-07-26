package structural.composite;

public interface ManageNeurons extends Iterable<Neuron>{
    default void connectTo(ManageNeurons other)
    {
        if (this == other) return;

        for (Neuron from : this)
            for (Neuron to : other)
            {
                from.out.add(to);
                to.in.add(from);
            }
    }
}
