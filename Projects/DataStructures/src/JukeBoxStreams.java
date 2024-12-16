import java.util.*;

public class JukeBoxStreams {
    public static void main(String[] args) {
        List<Song> songs = new Songs().getSongs();
        List<Song> rockSongs = songs.stream()
                .filter(song -> song.getGenre().contains("Rock"))
                .toList();
        System.out.println(rockSongs);

        List<Song> moreComplexFilter = songs.stream()
                .filter(song -> song.getArtist().equals("The Beatles") && song.getTitle().startsWith("H")
                            && song.getYear() > 1995)
                .toList();
        System.out.println(moreComplexFilter);

        List<String> genres = songs.stream()
                .map(Song::getGenre)
                .distinct()
                .toList();
        System.out.println(genres);
    }
}

