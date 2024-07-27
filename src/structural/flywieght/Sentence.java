package structural.flywieght;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Sentence {
    private final String[] words;
    private final Map<Integer, WordToken> tokenMap = new HashMap<>();

    public Sentence(String plainText) {
        words = plainText.split(" ");
    }

    public WordToken getWord(int index) {
        index--;
        WordToken wordtoken = new WordToken();
        tokenMap.put(index, wordtoken);
        return tokenMap.get(index);
    }

    @Override
    public String toString() {
        ArrayList<String> wordsList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (tokenMap.containsKey(i) && tokenMap.get(i).capitalize) {
                word = word.toUpperCase();
            }
            wordsList.add(word);
        }
        return String.join(" ", wordsList);
    }
}


class Main {
    public static void main(String[] args) {
        Sentence sentence = new Sentence("Write once, run anywhere!");
        sentence.getWord(4).capitalize = true;
        System.out.println(sentence);
    }
}
