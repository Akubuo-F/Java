import java.util.*;


public class JukeBox1 {
    public static void main(String[] args) {
        new JukeBox1().go();
    }

    public void go() {
        // lists
        System.out.println("Lists");
        List<MockSong> songList = MockSongs.getSongStrings();
        System.out.println(songList);

        Collections.sort(songList);
        System.out.println(songList);

        songList.sort((a, b) -> a.getArtist().compareTo(b.getArtist()));
        System.out.println(songList);

        songList.sort((a,b) -> a.getBpm() - b.getBpm());
        System.out.println(songList);

        songList.sort((a,b) -> -(a.getBpm() - b.getBpm()));
        System.out.println(songList);

        System.out.println();
        System.out.println("Sets");
        // sets
        List<MockSong> songList2 = MockMoreSongs.getSongStrings();
        System.out.println(songList2);

        songList2.sort((a,b) -> a.getTitle().compareTo(b.getTitle()));
        System.out.println(songList2);

        Set<MockSong> songSet = new HashSet<>(songList2);
        System.out.println(songSet);

        TreeSet<MockSong> songTreeSet= new TreeSet<>((a, b) -> a.getTitle().compareTo(b.getTitle()));
        songTreeSet.addAll(songList2);
        System.out.println(songTreeSet);
    }
}
