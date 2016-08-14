package com.alouette.dominocounter.lib;

import android.view.View;

public class ParameterOnClickListener implements View.OnClickListener
{
    // Constants

    // Class Attributes 
    private int integerParameter;

    // Constructors
    public ParameterOnClickListener(int integerParameter)
    {
        this.integerParameter = integerParameter;
    }

    // Accessors and Setters
    public void setIntegerParameter(int integerParameter)
    {
        this.integerParameter = integerParameter;
    }

    public int getIntegerParameter()
    {
        return this.integerParameter;
    }

    // Overridden Methods
    @Override
    public void onClick(View v)
    {
        //read your lovely variable
        int test = 0;
        test++;
    }

    // Public Methods

    // Private Methods
}
