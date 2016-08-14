package com.alouette.dominocounter;

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
        setLeftSubTotal(-1);
        setRightSubTotal(-1);
        this.leftDominoView = (TextView)findViewById(R.id.sub_domino_left);
        this.leftDominoView.setText("-1");
        this.rightDominoView = (TextView)findViewById(R.id.sub_domino_right);
        this.rightDominoView.setText("-1");
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

    public void uptateTotal()
    {
        // Updates the total score with the left and right values
        // Add to totals
        addToTotal(getLeftSubTotal() + getRightSubTotal());

        // Clear subtotals
        setLeftSubTotal(0);
        setRightSubTotal(0);
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
    }
}
