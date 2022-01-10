
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Dictionary {
    private ArrayList<String> words;
    private HashMap<String, String> translations;
    
    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
        add("Mama", "Mother");
    }
    
    public void add(String word, String translation) {
        if (!(this.translations.containsKey(word))) {
            this.words.add(word);
        }
        this.translations.put(word, translation);
    }
    
    public String getTranslation(String word) {
        return this.translations.getOrDefault(word, "no translation found");
    }
    
    public String randomWord() {
        Random rnd = new Random();
        return this.words.get(rnd.nextInt(this.words.size()));
    }
}
