package edu.fullerton.ajinkyakulkarni.project1;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
/*
CPSC411: MiniApp1
Name: Ajinkya Kulkarni
CWID: 893566448
 */
public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText speed;
    private EditText fileSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.app_name));

        speed = (EditText) findViewById(R.id.network_speed);
        fileSize = (EditText) findViewById(R.id.file_size);
        result = (TextView)findViewById(R.id.result);

        speed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(speed.getText().toString().equals("") || fileSize.getText().toString().equals("")) {
                    result.setText("");
                } else{
                    calculateResult(Double.parseDouble(speed.getText().toString()), Double.parseDouble(fileSize.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        fileSize.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(speed.getText().toString().equals("") || fileSize.getText().toString().equals("")) {
                    result.setText("");
                } else{
                    calculateResult(Double.parseDouble(speed.getText().toString()), Double.parseDouble(fileSize.getText().toString()));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void calculateResult(double networkSpeed, double fileSize){
        double output;
        fileSize = fileSize * 1024;
        networkSpeed = networkSpeed * 1000;
        output = (fileSize * 8)/networkSpeed;

        String pattern = "#.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        result.setTypeface(result.getTypeface(), Typeface.BOLD);
        result.setText(getString(R.string.transfer_time) + " " + String.valueOf(decimalFormat.format(output)) + " " + getString(R.string.sec));

    }

}
