package solid.srp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Journal {
    private ArrayList<String> entries;
    private int count;

    Journal() {
        this.entries = new ArrayList<>();
        this.count = 0;
    }

    public void addEntry(String title) {
        this.count++;
        entries.add(String.format("%d: %s", this.count, title));
    }

    public void removeEntry(int index) {
        if (index < 0 || index >= this.entries.size()) {
            throw new IndexOutOfBoundsException("Array index out of range");
        }

        entries.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();
        for (String entry : entries) {
            elements.append(entry).append("\n");
        }
        return elements.toString();
    }
}

class Main {
    public static void main(String[] args) {
        try {
            Journal journal = new Journal();
            journal.addEntry("Whisper of Life in Nature");
            journal.addEntry("Health Benefits of Nature");

            System.out.printf("Journal entries: \n%s", journal);

            // --------

            PersistenceManager pManager = new PersistenceManager();
            String filename = "journal.txt";
            pManager.saveToFile(journal, filename);

            // filename = "oldJournal.txt"; // Raise FileNotFoundException

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
