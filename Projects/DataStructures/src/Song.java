import org.jetbrains.annotations.NotNull;

public class Song implements Comparable<Song> {
    private final String title;
    private final String artist;
    private final String genre;
    private final int year;
    private final int timesPlayed;

    Song(String title, String artist, String genre, int year, int timesPlayed) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.timesPlayed = timesPlayed;
    }

    @Override
    public String toString() {
        return "title: " + title + " by: " + artist;
    }

    @Override
    public int compareTo(@NotNull Song o) {
        return title.compareTo(o.getTitle());
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Song other = (Song) obj;
        return title.equals(other.getTitle()) && artist.equals(other.getArtist())
                && genre.equals(other.getGenre()) && year == other.year;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
