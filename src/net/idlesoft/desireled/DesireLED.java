package net.idlesoft.desireled;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

import net.idlesoft.desireled.DesireLEDLibrary;

public class DesireLED extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        if(!DesireLEDLibrary.compatible()) {
        	Context context = getApplicationContext();
        	Toast.makeText(context, "I'm sorry, your device/rom is not compatible.", Toast.LENGTH_LONG).show();
        }
    }
    
    public void onBlueToggle(View v) {
    	ToggleButton button = ((ToggleButton)v);
    	DesireLEDLibrary.setLed("blue", button.isChecked());
    }
    
    public void onAmberToggle(View v) {
    	ToggleButton button = ((ToggleButton)v);
    	DesireLEDLibrary.setLed("amber", button.isChecked());
    }
    
    public void onGreenToggle(View v) {
    	ToggleButton button = ((ToggleButton)v);
    	DesireLEDLibrary.setLed("green", button.isChecked());
    }
    
    public void onAmberBlinkToggle(View v) {
    	ToggleButton button = ((ToggleButton)v);
    	DesireLEDLibrary.setBlinkLed("amber", button.isChecked());
    }
    
    public void onGreenBlinkToggle(View v) {
    	ToggleButton button = ((ToggleButton)v);
    	DesireLEDLibrary.setBlinkLed("green", button.isChecked());
    }
}