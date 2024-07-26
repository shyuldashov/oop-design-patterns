package structural.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


public class Neuron implements ManageNeurons {
    public ArrayList<Neuron> in, out;

    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }

    /*
    @Override
    public void connectTo(ManageNeurons other) {
        ManageNeurons.super.connectTo(other);
    }
     */
}


class Main {
    public static void main(String[] args) {
        Neuron neuron = new Neuron();
        Neuron neuron2 = new Neuron();

        NeuronLayer neuronLayer = new NeuronLayer();
        NeuronLayer neuronLayer2 = new NeuronLayer();

        neuron.connectTo(neuron2);
        neuron.connectTo(neuronLayer);
        neuronLayer.connectTo(neuron);
        neuronLayer.connectTo(neuronLayer2);

    }
}
