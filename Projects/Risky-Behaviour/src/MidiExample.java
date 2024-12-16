import javax.sound.midi.*;

public class MidiExample {
    public static void main(String[] args) {
        try {
            // Create a new sequence
            Sequence sequence = new Sequence(Sequence.PPQ, 24);

            // Create a track
            Track track = sequence.createTrack();

            // Create a NOTE ON message (start playing Middle C)
            ShortMessage noteOn = new ShortMessage();
            noteOn.setMessage(ShortMessage.NOTE_ON, 0, 60, 93); // channel 0, note 60 (Middle C), velocity 93
            MidiEvent noteOnEvent = new MidiEvent(noteOn, 1); // play at tick 1
            track.add(noteOnEvent);

            // Create a NOTE OFF message (stop playing Middle C)
            ShortMessage noteOff = new ShortMessage();
            noteOff.setMessage(ShortMessage.NOTE_OFF, 0, 60, 0); // channel 0, note 60 (Middle C), velocity 0
            MidiEvent noteOffEvent = new MidiEvent(noteOff, 16); // stop at tick 16
            track.add(noteOffEvent);

            // Now you can use a sequencer to play this sequence
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.start();

            // Let the sequence play for a while
            Thread.sleep(5000);

            // Close the sequencer
            sequencer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

