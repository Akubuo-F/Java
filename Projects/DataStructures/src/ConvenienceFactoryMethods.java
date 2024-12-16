import java.util.*;

public class ConvenienceFactoryMethods {
    public static void main(String[] args) {
        // Lists
        List<String> strings = List.of("somersault", "cassidy", "$10");
        List<MockSong> songs = List.of(new MockSong("somersault", "zero 7", 147),
                new MockSong("cassidy", "grateful dead", 158),
                new MockSong("$10", "hitchhiker", 140));

        // Sets
        Set<MockSong> songSet = Set.of(new MockSong("How Cats Work", "millan", 343),
                new MockSong("Remix your Body", "jackie", 198),
                new MockSong("Finding Emo", "rock band", 247));

        // Maps
        Map<String, Integer> scores = Map.of("Kathy", 42,
                "Bert", 343,
                "Skyler", 420); // or
        Map<String, String> stores = Map.ofEntries(Map.entry("Riley", "Supersports"),
                Map.entry("Brooklyn", "Camera World"),
                Map.entry("Jay", "Homecase"));
    }
}
