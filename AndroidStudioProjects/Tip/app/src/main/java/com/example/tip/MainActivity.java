package com.example.tip;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.tip.ColorActivity;
import com.example.tip.R;


public class MainActivity extends AppCompatActivity {

    private EditText Bill1;
    private EditText Diners1;
    private TextView BillPer;
    private TextView TipPer;
    private RadioButton TipPercent1;
    private RadioButton TipPercent2;
    private RadioButton TipPercent3;
    private ConstraintLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bill1 = findViewById(R.id.Bill1);
        Diners1 = findViewById(R.id.Diners1);
        BillPer = findViewById(R.id.BillPer);
        TipPer = findViewById(R.id.TipPer);
        TipPercent1 = findViewById(R.id.TipPercent1);
        TipPercent2 = findViewById(R.id.TipPercent2);
        TipPercent3 = findViewById(R.id.TipPercent3);
    }

    public void colorPressed(View v) {
        Intent i = new Intent(this, ColorActivity.class);
        startActivityForResult(i, 1);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        int color = data.getIntExtra("COLOR", 0xffffffff);
        layout.setBackgroundColor(color);
    }

    public void convert(View v){
        double Tip;
        int diners;
        double priceper;
        if(TipPercent1.isChecked()){
            String input = Bill1.getText().toString();
            String input2 = Diners1.getText().toString();
            if(input.length()>0 && input2.length()>0){
                double BillValue = Double.parseDouble(input);
                diners = Integer.parseInt(input2);
                priceper = BillValue/diners;
                BillPer.setText("$ " + String.format("%.1f", priceper));
                Tip = BillValue *.10;
                TipPer.setText("$ " + String.format("%.1f",Tip));
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
        else if(TipPercent2.isChecked()){
            String input = Bill1.getText().toString();
            String input2 = Diners1.getText().toString();
            if(input.length()>0 && input2.length()>0){
                double BillValue = Double.parseDouble(input);
                diners = Integer.parseInt(input2);
                priceper = BillValue/diners;
                BillPer.setText("$ " + String.format("%.1f", priceper));
                Tip = BillValue *.15;
                TipPer.setText("$ " + String.format("%.1f",Tip));
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
        else if(TipPercent3.isChecked()){
            String input = Bill1.getText().toString();
            String input2 = Diners1.getText().toString();
            if(input.length()>0 && input2.length()>0){
                double BillValue = Double.parseDouble(input);
                diners = Integer.parseInt(input2);
                priceper = BillValue/diners;
                BillPer.setText("$ " + String.format("%.1f", priceper));
                Tip = BillValue * .20;
                TipPer.setText("$ "+ String.format("%.1f",Tip));
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
