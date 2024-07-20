package solid.srp;

import java.io.*;

public class PersistenceManager {
    public static void saveToFile(Journal journal, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter((new FileWriter(filename)))) {
            writer.write(journal.toString());
        }
    }

    public static Journal loadFromFile(String filename) throws IOException {
        Journal journal = new Journal();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line=reader.readLine()) != null) {
                journal.addEntry(line);
            }
        }
        return journal;
    }

    public static Journal loadFromWeb(String uri) {
        // Реализация загрузки данных из Интернета.
        return new Journal();
    }

}
