package chestcleaner.config;

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class WordCategory implements Category<String>, ConfigurationSerializable {

    private String name;
    private String word;

    private static final String nameKey = "name";
    private static final String wordKey = "word";

    public WordCategory(String name, String word) {
        this.name = name;
        this.word = word;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return word;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();
        result.put(nameKey, this.name);
        result.put(wordKey, this.word);
        return result;
    }

    // not "unused". Needed for ConfigurationSerializable e.g. To read as Object from config.yml
    public static WordCategory deserialize(Map<String, Object> map) {
        String name = map.containsKey(nameKey) ? ((String)map.get(nameKey)) : "";
        String word = map.containsKey(wordKey) ? ((String)map.get(wordKey)) : "";

        return new WordCategory(name, word);
    }
}
