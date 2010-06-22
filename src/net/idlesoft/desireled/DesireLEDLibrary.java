package net.idlesoft.desireled;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.util.Log;

public class DesireLEDLibrary {
	private static final String TAG = "DesireLED";
	
	public static boolean compatible() {
		return new File("/sys/devices/platform/leds-microp/leds/blue/brightness").exists()
			&& new File("/sys/devices/platform/leds-microp/leds/green/brightness").exists()
			&& new File("/sys/devices/platform/leds-microp/leds/amber/brightness").exists();
	}
	
	public static void setLed(String color, boolean state) {
		String writeout = null;
		
		if(state) {
			writeout = "1";
		} else {
			writeout = "0";
		}
		
		try {
			FileWriter out = new FileWriter("/sys/devices/platform/leds-microp/leds/"+color+"/brightness");
			out.write(writeout);
			out.close();
		} catch(IOException e) {
			Log.e(TAG, "Error toggling led: " + e.toString());
		}
	}
	
	public static boolean ledState(String color) {
		char[] state = {};
		try {
			FileReader in = new FileReader("/sys/devices/platform/leds-microp/leds/"+color+"/brightness");
			Log.d(TAG, "Reading ready: " + Boolean.toString(in.ready()));
			int read = in.read(state);
			Log.d(TAG, "Read x bytes: " + Integer.toString(read));
			in.close();
		} catch(IOException e) {
			Log.e(TAG, "Error obtaining led state: " + e.toString());
		}
		
		Log.d(TAG, "Led state is: " + new String(state));
		
		String statestring = new String(state);
		if (statestring == "1") {
			return true;
		} else {
			return false;
		}
	}
	
	public static void setBlinkLed(String color, boolean state) {
		String writeout = null;
		
		if(state) {
			writeout = "1";
		} else {
			writeout = "0";
		}
		
		try {
			FileWriter out = new FileWriter("/sys/devices/platform/leds-microp/leds/"+color+"/blink");
			out.write(writeout);
			out.close();
		} catch(IOException e) {
			Log.e(TAG, "Error setting blink: " + e.toString());
		}
	}
}
