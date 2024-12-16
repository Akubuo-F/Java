import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MockSongs{
    public static List<MockSong> getSongStrings() {
        List<MockSong> songs = new ArrayList<>();
        songs.add(new MockSong("somersault", "zero 7", 147));
        songs.add(new MockSong("cassidy", "grateful dead", 158));
        songs.add(new MockSong("$10", "hitchhiker", 140));
        songs.add(new MockSong("havana", "cabello", 105));
        songs.add(new MockSong("Cassidy", "grateful dead", 158));
        songs.add(new MockSong("50 ways", "simon", 102));
        return songs;
    }
}
