package SUPERNOID.Sound;


import java.io.*;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class SoundClip {


    public void playAudio() {

        // Obtains the default Sequencer connected to a default device.
        Sequencer sequencer = null;
        try {
            sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        // Opens the device, indicating that it should now acquire any
        // system resources it requires and become operational.
        try {
            sequencer.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        // create a stream from a file
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(new File("resources/Music/8-Bit_Songs/gbusters.mid")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Sets the current sequence on which the sequencer operates.
        // The stream must point to MIDI file data.
        try {
            sequencer.setSequence(is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }

        // Starts playback of the MIDI data in the currently loaded sequence.
            sequencer.start();

    }
}
