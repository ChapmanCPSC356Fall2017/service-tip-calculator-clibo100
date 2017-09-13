package com.idkdude.tipcalc;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView priceTextView;
    private EditText priceEditText;
    private EditText rateEditText;
    private Button priceButton;
    private Button rateButton;
    private Button tryAgainButton;
    private TextView rateTextView;
    private TextView tipTextView;
    private TextView totalTextView;
    private Float price;
    private int rate;
    private Float tip;
    private Float total;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.priceTextView = (TextView) findViewById(R.id.tv_enterprice);
        this.priceEditText = (EditText) findViewById(R.id.et_enterprice);
        this.rateEditText = (EditText) findViewById(R.id.et_enterrate);
        this.priceButton = (Button) findViewById(R.id.btn_enterprice);
        this.rateButton = (Button) findViewById(R.id.btn_enterrate);
        this.tryAgainButton = (Button) findViewById(R.id.btn_tryagain);
        this.rateTextView = (TextView) findViewById(R.id.tv_displayrate);
        this.tipTextView = (TextView) findViewById(R.id.tv_displaytip);
        this.totalTextView = (TextView) findViewById(R.id.tv_displaytotal);

        rateEditText.setVisibility(View.GONE);
        rateButton.setVisibility(View.GONE);
        tryAgainButton.setVisibility(View.GONE);
        rateTextView.setVisibility(View.GONE);
        tipTextView.setVisibility(View.GONE);
        totalTextView.setVisibility(View.GONE);


        this.priceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (priceEditText.getText().toString().equals(""))
                {
                    priceTextView.setText("You must enter a number");
                }
                else
                {
                    price = Float.valueOf(priceEditText.getText().toString());
                    priceEditText.setVisibility(View.GONE);
                    rateEditText.setVisibility(View.VISIBLE);
                    priceTextView.setText("On a scale of 1-10, how do you rate your meal?");
                    priceButton.setVisibility(View.GONE);
                    rateButton.setVisibility(View.VISIBLE);
                }
            }
        });

        this.rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rateEditText.getText().toString().equals(""))
                {
                    priceTextView.setText("You must enter a number");
                }
                else
                {
                    rate = Integer.valueOf(rateEditText.getText().toString());
                    rateEditText.setText("");

                    rateButton.setVisibility(View.GONE);
                    if (rate >= 1 && rate <= 10) {
                        if (rate >= 1 && rate < 3) {
                            tip = Float.valueOf(10);
                        } else if (rate >= 4 && rate < 5) {
                            tip = Float.valueOf(13);
                        } else if (rate >= 6 && rate < 7) {
                            tip = Float.valueOf(15);
                        } else if (rate >= 8 && rate < 9) {
                            tip = Float.valueOf(20);
                        } else if (rate == 10) {
                            tip = Float.valueOf(25);
                        }


                        rateEditText.setVisibility(View.GONE);
                        priceTextView.setText("Initial price: $" + price);

                        rateTextView.setVisibility(View.VISIBLE);
                        rateTextView.setText("Your Rating: " + rate);

                        tipTextView.setVisibility(View.VISIBLE);
                        tipTextView.setText("Tip percent: %" + tip);

                        totalTextView.setVisibility(View.VISIBLE);

                        total = ((tip / 100) * price) + price;
                        String roundtotal = String.format("%.2f", total);

                        totalTextView.setText("Your Total: $" + roundtotal);

                        tryAgainButton.setVisibility(View.VISIBLE);
                    } else {
                        rateButton.setVisibility(View.VISIBLE);
                    }
                }

            }
        });

        this.tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                priceTextView.setText("Enter Price of your meal");
                rateTextView.setVisibility(View.GONE);
                tipTextView.setVisibility(View.GONE);
                totalTextView.setVisibility(View.GONE);

                priceButton.setVisibility(View.VISIBLE);
                priceEditText.setVisibility(View.VISIBLE);
                priceEditText.setText("");
                tryAgainButton.setVisibility(View.GONE);
            }
        });


    }


}
