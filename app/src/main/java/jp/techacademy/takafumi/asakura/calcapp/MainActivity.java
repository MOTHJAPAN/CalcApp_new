package jp.techacademy.takafumi.asakura.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.math.BigDecimal;


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
        if( mEditText.getText().toString().length() <= 0 )
        {
            Log.d( "ErrorLog", "Error1" );
            Toast.makeText(MainActivity.this, "数字を入力してください。",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if( mEditText2.getText().toString().length() <= 0 )

        {
            Log.d( "ErrorLog", "Error2" );
            Toast.makeText(MainActivity.this, "数字を入力してください。",
                    Toast.LENGTH_LONG).show();
            return;
        }

        BigDecimal a = new java.math.BigDecimal(mEditText.getText().toString());
        java.math.BigDecimal b = new java.math.BigDecimal(mEditText2.getText().toString());
        java.math.BigDecimal r = java.math.BigDecimal.ZERO; // 取り敢えず0を入れておく



       if (v.getId() == R.id.button1) {
            r = a.add(b);
        }
        // button1 が押された
        else if (v.getId() == R.id.button2) {
            r = a.subtract(b);
        }
        // button2 が押された
        else if (v.getId() == R.id.button3) {
            r = a.multiply(b);
        }
        // button3 が押された

        else if (v.getId() == R.id.button4) {
            r = a.divide(b, java.math.BigDecimal.ROUND_HALF_UP);
        }

        if (r == null) {
            Toast.makeText(MainActivity.this, "正しい値を入力してください。",
                    Toast.LENGTH_LONG).show();
        } else {
            Log.d("javatest", String.valueOf(r));
            // button4が押された
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE", r);
            startActivity(intent);

        }
    }
}