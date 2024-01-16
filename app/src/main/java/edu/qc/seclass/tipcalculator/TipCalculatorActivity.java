package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    // References
    Button buttonCompute;

    EditText checkAmountValue;
    EditText partySizeValue;

    TextView fifteenPercentTipValue;
    TextView twentyPercentTipValue;
    TextView twentyfivePercentTipValue;

    TextView fifteenPercentTotalValue;
    TextView twentyPercentTotalValue;
    TextView twentyfivePercentTotalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipcalculator);

        // Compute Button
        buttonCompute = (Button) findViewById(R.id.buttonCompute);

        // Input Check Amount + Party Size
        checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
        partySizeValue  = (EditText) findViewById(R.id.partySizeValue);

        // Tips
        fifteenPercentTipValue = (TextView) findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTipValue = (TextView) findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTipValue = (TextView) findViewById(R.id.twentyfivePercentTipValue);

        // Total
        fifteenPercentTotalValue = (TextView) findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotalValue = (TextView) findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotalValue = (TextView) findViewById(R.id.twentyfivePercentTotalValue);



        // Set a listener to a button

        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              // Validate Check Amount
              if(checkAmountValue.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter Check Amount!",
                            Toast.LENGTH_SHORT).show();
                    checkAmountValue.requestFocus();
                    return;
                }

                // Validate Party Size
                if(partySizeValue.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter Party Size",
                            Toast.LENGTH_SHORT).show();
                    partySizeValue.requestFocus();
                    return;
                }

                double checkAmount = Float.parseFloat(checkAmountValue.getText().toString());
                int partySize = Integer.parseInt(partySizeValue.getText().toString());
                double perPersonShare = checkAmount / partySize;


                if(checkAmount == 0){
                    Toast.makeText(getApplicationContext(),
                            "Check Amount must be greater than 0",
                            Toast.LENGTH_SHORT).show();
                    checkAmountValue.requestFocus();
                    return;
                }

                if(partySize == 0){
                    Toast.makeText(getApplicationContext(),
                            "Party Size must be greater than 0 ",
                            Toast.LENGTH_SHORT).show();
                    partySizeValue.requestFocus();
                    return;
                }

                //Tip and Total Amount Calculation for 15%
                fifteenPercentTipValue.setText(String.valueOf(Math.round(perPersonShare * 0.15)));
                fifteenPercentTotalValue.setText(String.valueOf((Math.round(perPersonShare * 0.15 + perPersonShare))));

                // Tip and Total Amount Calculation for 20%
                twentyPercentTipValue.setText(String.valueOf((Math.round(perPersonShare * 0.20))));
                twentyPercentTotalValue.setText(String.valueOf((Math.round((perPersonShare * 0.20) + perPersonShare))));

                // Tip and Total Amount Calculation for 25%
                twentyfivePercentTipValue.setText(String.valueOf((Math.round(perPersonShare * 0.25))));
                twentyfivePercentTotalValue.setText(String.valueOf((Math.round((perPersonShare * 0.25) + perPersonShare))));
            }
        });
    }
}