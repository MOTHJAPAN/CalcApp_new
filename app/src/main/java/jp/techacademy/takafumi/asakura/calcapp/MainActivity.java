package jp.techacademy.takafumi.asakura.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mEditText2 = (EditText) findViewById(R.id.editText2);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        double a = Double.parseDouble( mEditText.getText().toString() );
        double b = Double.parseDouble( mEditText2.getText().toString() );
        double r = 0.0f; // 取り敢えず0を入れておく


        if (v.getId() == R.id.button1) {
            r = a + b;
        }
            // button1 が押された
        else  if (v.getId() == R.id.button2) {
            r = a - b;

        }
                // button2 が押された
         else  if (v.getId() == R.id.button3) {
            r = a * b;

        }
                // button3 が押された

        else  if (v.getId() == R.id.button4) {
            r = a / b;
        }
        Log.d("javatest" , String.valueOf(r));
              // button4が押された
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE" ,r);
        startActivity(intent);
    }
}