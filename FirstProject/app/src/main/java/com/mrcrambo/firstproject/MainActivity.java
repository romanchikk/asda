package com.mrcrambo.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String COUNTER = "counter";
    public static final String BUTTON_COUNTER = "buttonCounter";
    private Button button1;
    private int buttonCounter = 0;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Button button = new Button(this);
        button.setText("Button");
        Button button1 = new Button(this);
        button1.setText("Button1");
        LinearLayout linearLayout = new LinearLayout(this);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(button);
        linearLayout.addView(button1);
        // Для того чтобы было вертикально, размеры баттонов пока непонятно как определяются
        // при чем если писать здесь про ориентайшен,то размеры баттонов будут другими!!
        setContentView(linearLayout);
        */
        setContentView(R.layout.content_main);
        Button button = new Button(this);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);

        //button1.setText(String.valueOf(counter));

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Stopped");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Resumed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Destroyed");
    }

    // чтобы сохранить значения переменных при поворотах!!!
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER, counter);//(alt + cmd + c)
        outState.putInt(BUTTON_COUNTER,buttonCounter);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt(COUNTER);
        button1.setText(String.valueOf(counter));
        buttonCounter = savedInstanceState.getInt(BUTTON_COUNTER);
        ((Button) findViewById(R.id.button)).setText(String.valueOf(buttonCounter));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void clicked(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                if(counter > 0) {
                    counter = 0;
                    buttonCounter++;
                    button1.setText(String.valueOf(counter));
                    ((Button) findViewById(R.id.button)).setText(String.valueOf(buttonCounter));
                }
                break;
            case R.id.button2:
                counter++;
                button1.setText(String.valueOf(counter));
                break;
        }
    }
}
