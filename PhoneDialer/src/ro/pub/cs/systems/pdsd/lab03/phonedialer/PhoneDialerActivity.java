package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {

	private KeypadButtonClickListener buttonClickListener = new KeypadButtonClickListener();
    
	
	private class KeypadButtonClickListener implements View.OnClickListener {

		@Override
		@SuppressWarnings("all")
		public void onClick(View v) {
			
			EditText editPhoneNumber = (EditText) findViewById(R.id.edit_phone_number);
			String phoneNumber = editPhoneNumber.getText().toString();
			if(v instanceof Button){
				editPhoneNumber.setText(phoneNumber+ ((Button)v).getText().toString());
			}
			
			if(v instanceof ImageButton){
				
				switch (((ImageButton)v).getId()) {
				case R.id.button_backspace:
					editPhoneNumber.setText(phoneNumber.substring(0, phoneNumber.length()-1));
					break;
				case R.id.button_call:
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel:"+phoneNumber));
					startActivity(intent);
					break;
					
				case R.id.button_hangup:
					finish();
					break;

				default:
					break;
				}
			}
			
		}
		
	}
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        
        ArrayList<? super View> buttondIds = new ArrayList<View>();
        	Button textButton1 = (Button) findViewById(R.id.digit0);
        	buttondIds.add(textButton1);
        	Button textButton2 = (Button) findViewById(R.id.digit1);
        	buttondIds.add(textButton2);

        	Button textButton3 = (Button) findViewById(R.id.digit2);
        	buttondIds.add(textButton3);

        	Button textButton4 = (Button) findViewById(R.id.digit3);
        	buttondIds.add(textButton4);
        	Button textButton5 = (Button) findViewById(R.id.digit4);
        	buttondIds.add(textButton5);
        	Button textButton6 = (Button) findViewById(R.id.digit5);
        	buttondIds.add(textButton6);
        	Button textButton7 = (Button) findViewById(R.id.digit6);
        	buttondIds.add(textButton7);
        	Button textButton8 = (Button) findViewById(R.id.digit7);
        	buttondIds.add(textButton8);
        	Button textButton9 = (Button) findViewById(R.id.digit8);
        	buttondIds.add(textButton9);
        	Button textButton10 = (Button) findViewById(R.id.digit9);
        	buttondIds.add(textButton10);
        	Button textButtonStar = (Button) findViewById(R.id.button_star);
        	buttondIds.add(textButtonStar);
        	Button textButtonPound = (Button) findViewById(R.id.button_pound);
        	buttondIds.add(textButtonPound);
        	
        	
        	ImageButton backspace = (ImageButton) findViewById(R.id.button_backspace);
        	buttondIds.add(backspace);
        	
        	ImageButton call = (ImageButton) findViewById(R.id.button_call);
        	buttondIds.add(call);
        	ImageButton close = (ImageButton) findViewById(R.id.button_hangup);
        	buttondIds.add(close);

        	for(int index=0;index<buttondIds.size();index++){
        		((View) buttondIds.get(index)).setOnClickListener(buttonClickListener);
        	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
