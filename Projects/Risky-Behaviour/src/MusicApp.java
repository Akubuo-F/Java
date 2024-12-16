import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;


public class MusicApp {
    public static void main(String[] args) {
        MusicApp musicTest = new MusicApp();
        musicTest.play();
    }

    public void play() {
        try (Sequencer sequencer = MidiSystem.getSequencer()) {
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            Track track = seq.createTrack();

            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(NOTE_ON, 9, 52, 100);
            MidiEvent midiEvent1 = new MidiEvent(msg1, 0);
            track.add(midiEvent1);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(NOTE_OFF, 9, 52, 100);
            MidiEvent midiEvent2 = new MidiEvent(msg2, 16);
            track.add(midiEvent2);

            sequencer.setSequence(seq);
            sequencer.start();

            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
