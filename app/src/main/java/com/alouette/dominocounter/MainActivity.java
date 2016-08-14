package com.alouette.dominocounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alouette.dominocounter.lib.ParameterOnClickListener;

public class MainActivity extends AppCompatActivity
{
    // Constants

    // Class Attributes
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private int total;
    private int leftSubTotal; // -1 by default if not set
    private int rightSubTotal; // -1 by default if not set
    private TextView leftDominoView;
    private TextView rightDominoView;

    // Constructors
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set domino onclick listners
        initiateButtons();

        // Set left and right domino values
        this.leftDominoView = (TextView)findViewById(R.id.sub_domino_left);
        this.rightDominoView = (TextView)findViewById(R.id.sub_domino_right);
        clearSubtotal(null);
    }

    // Getters and Setters
    public int getTotal()
    {
        return this.total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    public int getLeftSubTotal()
    {
        return this.leftSubTotal;
    }

    public void setLeftSubTotal(int subTotal)
    {
        this.leftSubTotal = subTotal;
    }

    public int getRightSubTotal()
    {
        return this.rightSubTotal;
    }

    public void setRightSubTotal(int subTotal)
    {
        this.rightSubTotal = subTotal;
    }

    // Public Methods
    public void addToTotal(int increment)
    {
        // Addds a value to total score
        this.total += increment;
    }

    public void clearSubtotal(View view)
    {
        // Reset domino view
        this.leftDominoView.setText("_");
        this.rightDominoView.setText("_");
        // Rest values
        setLeftSubTotal(-1);
        setRightSubTotal(-1);
    }

    public void updateSubTotal(int subTotal)
    {
        // Updates the subtotal value with the slected left or right domino
        if(getLeftSubTotal() < 0)
        {
            setLeftSubTotal(subTotal);
            this.leftDominoView.setText(String.valueOf(subTotal));
        }

        else
        {
            setRightSubTotal(subTotal);
            this.rightDominoView.setText(String.valueOf(subTotal));

        }
    }

    public void updateTotal(View view)
    {
        // Updates the total score with the left and right values
        // Add to totals
        addToTotal(getLeftSubTotal() + getRightSubTotal());

        // Clear subtotals
        clearSubtotal(null);
    }

    public void showTotal(View view)
    {
        // Show the score page with the total score
        Intent intent = new Intent(this, ResultsActivity.class);
        String message = String.valueOf(getTotal());
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    // Private Methods
    private void initiateButtons()
    {
        // Initiates custom onClick listener for all domino buttons
        Button dominoZero = (Button) findViewById(R.id.domino_zero);
        dominoZero.setOnClickListener(new ParameterOnClickListener(0) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoOne = (Button) findViewById(R.id.domino_one);
        dominoOne.setOnClickListener(new ParameterOnClickListener(1) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoTwo = (Button) findViewById(R.id.domino_two);
        dominoTwo.setOnClickListener(new ParameterOnClickListener(2) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoThree = (Button) findViewById(R.id.domino_three);
        dominoThree.setOnClickListener(new ParameterOnClickListener(3) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoFour = (Button) findViewById(R.id.domino_four);
        dominoFour.setOnClickListener(new ParameterOnClickListener(4) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoFive = (Button) findViewById(R.id.domino_five);
        dominoFive.setOnClickListener(new ParameterOnClickListener(5) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoSix = (Button) findViewById(R.id.domino_six);
        dominoSix.setOnClickListener(new ParameterOnClickListener(6) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoSeven = (Button) findViewById(R.id.domino_seven);
        dominoSeven.setOnClickListener(new ParameterOnClickListener(7) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoEight = (Button) findViewById(R.id.domino_eight);
        dominoEight.setOnClickListener(new ParameterOnClickListener(8) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoNine = (Button) findViewById(R.id.domino_nine);
        dominoNine.setOnClickListener(new ParameterOnClickListener(9) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoTen = (Button) findViewById(R.id.domino_ten);
        dominoTen.setOnClickListener(new ParameterOnClickListener(10) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoEleven = (Button) findViewById(R.id.domino_eleven);
        dominoEleven.setOnClickListener(new ParameterOnClickListener(11) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
        Button dominoTwelve = (Button) findViewById(R.id.domino_twelve);
        dominoTwelve.setOnClickListener(new ParameterOnClickListener(12) {
            @Override
            public void onClick(View v){
                updateSubTotal(this.getIntegerParameter());
            }
        });
    }
}
