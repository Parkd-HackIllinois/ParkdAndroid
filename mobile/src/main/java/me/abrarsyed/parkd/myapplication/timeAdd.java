package me.abrarsyed.parkd.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;


public class timeAdd extends ActionBarActivity {

    TextView numberView;
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_add);
        numberView = (TextView)findViewById(R.id.textView2);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(0);
        /*String[] stringArray = new String[19];
        int n=1;
        for(int i=0; i<180; i+=10){
            stringArray[i] = Integer.toString(n);
            n+=2;
        }
        numberPicker.setMaxValue(stringArray.length-1);
        numberPicker.setMinValue(0);
        numberPicker.setDisplayedValues(stringArray);
        */
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setOnValueChangedListener( new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {
                numberView.setText("Minutes added: "+ newVal);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_time_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, confirm.class);
        EditText editText = (EditText) findViewById(R.id.main);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void clickOk(View v) {

        Intent intent = new Intent(this, confirm2.class);
        startActivity(intent);

    }
    public void clickCancel(View v) {

        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
    }

}
