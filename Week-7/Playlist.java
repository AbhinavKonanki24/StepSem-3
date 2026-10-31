import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[Math.max(0, capacity)];
        this.count = 0;
    }

    public void addSong(String song) {
        if (song == null) {
            return;
        }
        if (count < songs.length) {
            songs[count++] = song;
        } else {
            System.out.println("Playlist is full");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Current songs in playlist: " + Arrays.toString(copy));
        System.out.println("p.getSongCount() -> " + p.getSongCount());

        copy[0] = "Hacked";
        System.out.println("copy[0] changed to: \"" + copy[0] + "\"");
        System.out.println("p.getSongs()[0] is still: \"" + p.getSongs()[0] + "\" (defensive copy intact)");
    }
}
