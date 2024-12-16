import org.jetbrains.annotations.NotNull;

public class MockSong implements Comparable<MockSong>{
    private final String title;
    private final String artist;
    private final int bpm;

    public MockSong(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    @Override
    public boolean equals(Object obj) {
        MockSong other = (MockSong) obj;
        return title.equals(other.getTitle()) && artist.equals(other.getArtist()) && bpm == other.getBpm();
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(@NotNull MockSong o) {
        return title.compareTo(o.title);
    }
}
