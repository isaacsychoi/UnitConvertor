// Author: Isaac Choi
// University of Ottawa
// SEG 2105 - Final Project
// Mobile app development - Unit converter on android

package com.example.unitconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    // declaration of instance variables

    // numeric keys
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    // Functional keys
    Button button_decimal;

    // Operations
    Button button_run, button_deleteOne, button_allClear;

    // The user input window and result display window
    TextView input_screen, result_screen;

    // Spinner
    Spinner spinner_measurement, spinner_unit_input, spinner_unit_output;

    // what to measure (mode: pressure, volumetric flow, length, velocity)
    String processMode = "";

    // boolean value that indicates whether this is
    boolean result_displayed = false;

    boolean decimal_input = false;

    // Adapters, are used to put arrays in to spinners
    ArrayAdapter<String> measurementAdapter;
    ArrayAdapter<String> unitAdapter;

    // calculation result
    double cal_result = 0.0;

    // Conversion constant: Pressure
    public final double KPA_TO_PA = 1000.0;
    public final double MMHG_TO_KPA = 101.325/760.0;

    // Conversion constant: velocity or speed
    public final double MPS_TO_KMH= 3.6;
    public final double MPS_TO_MIH = 2.24;

    // Conversion constant: length
    public final double M_To_IN = 39.37;
    public final double FT_TO_IN = 12.0;

    // Conversion constant: flow rate
    public final double M3S_TO_FT3S = 35.31;
    public final double M3S_TO_LMIN = 60000.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mapping the variable to the widgets

        // numeric buttons
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);

        // other buttons

        button_decimal = findViewById(R.id.btn_decimal);
        button_deleteOne = findViewById(R.id.btn_deleteOne);
        button_run = findViewById(R.id.btn_run);
        button_allClear = findViewById(R.id.btn_allClear);

        // Screens
        input_screen = findViewById(R.id.screen);
        result_screen = findViewById(R.id.resultScreen);


        // setup the spinner
        spinner_measurement = findViewById(R.id.sp_measure_type);
        spinner_unit_input = findViewById(R.id.sp_input_unit);
        spinner_unit_output = findViewById(R.id.sp_output_unit);

        // Set the on click actions

        // On-click action
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    decimal_input = false;
                    result_displayed = false;
                    result_screen.setTextColor(Color.GRAY);
                }
                input_screen.setText(input_screen.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                    decimal_input = false;
                    result_screen.setTextColor(Color.GRAY);
                }


                input_screen.setText(input_screen.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                    decimal_input = false;
                    result_screen.setTextColor(Color.GRAY);
                }
                input_screen.setText(input_screen.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                    decimal_input = false;
                    result_screen.setTextColor(Color.GRAY);
                }

                input_screen.setText(input_screen.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                    decimal_input = false;
                    result_screen.setTextColor(Color.GRAY);
                }

                input_screen.setText(input_screen.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                    decimal_input = false;
                    result_screen.setTextColor(Color.GRAY);
                }
                input_screen.setText(input_screen.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                    decimal_input = false;
                    result_screen.setTextColor(Color.GRAY);
                }

                input_screen.setText(input_screen.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                    decimal_input = false;
                    result_screen.setTextColor(Color.GRAY);
                }
                input_screen.setText(input_screen.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                    decimal_input = false;
                    result_screen.setTextColor(Color.GRAY);
                }

                input_screen.setText(input_screen.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                    decimal_input = false;
                    result_screen.setTextColor(Color.GRAY);
                }

                input_screen.setText(input_screen.getText() + "9");
            }
        });

        // Other buttons
        button_allClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_screen.setText("");
                result_screen.setText("");
                result_displayed = false;
                decimal_input = false;
            }
        });
        button_deleteOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // if there is existing calculation result on the output screen
                if (result_displayed)
                    result_displayed = false;

                // String on the input screen at the moment that the delete button is pressed
                String inputText = input_screen.getText().toString();

                if (inputText.length() != 0) { // if the input screen is not empty
                    String remainingText = inputText.substring(0, inputText.length() - 1); // not inclusive the last char
                    input_screen.setText(remainingText); // take off the last char

                    String removedChar = inputText.substring(inputText.length()- 1);

                    if(removedChar.equals(".")){
                        decimal_input = false;
                    }
                }
            }
        });

        button_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = input_screen.getText().toString();

                if (!decimal_input)
                    input_screen.setText(input_screen.getText() + ".");
                result_displayed = false;
                result_screen.setTextColor(Color.GRAY);

                decimal_input = true;

            }
        });

        button_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the user inputs
                String user_inputs = input_screen.getText().toString();
                String unit_first;
                String unit_second;
                boolean sec_unit = false;
                if (user_inputs.length() != 0) {

                    // process the inputs

                    double value = Double.parseDouble(user_inputs);
                    if (!spinner_measurement.getSelectedItem().toString().equals("Click to select a category:")) {
                        unit_first = spinner_unit_input.getSelectedItem().toString();
                        unit_second = spinner_unit_output.getSelectedItem().toString();

                        if (processMode.equals("Pressure")) {
                            if (unit_first.equals(unit_second)) {
                                cal_result = value;
                                sec_unit = true;
                            } else if (unit_first.equals("Pa")) {
                                if (unit_second.equals("kPa")) {
                                    cal_result = value / KPA_TO_PA;
                                    sec_unit = true;
                                } else if (unit_second.equals("mmHg")) {
                                    cal_result = value / (MMHG_TO_KPA * KPA_TO_PA);
                                    sec_unit = true;
                                }
                            } else if (unit_first.equals("kPa")) {
                                if (unit_second.equals("Pa")) {
                                    cal_result = value / KPA_TO_PA;
                                    sec_unit = true;
                                } else if (unit_second.equals("mmHg")) {
                                    cal_result = value / MMHG_TO_KPA;
                                    sec_unit = true;
                                }
                            } else if (unit_first.equals("mmHg")) {
                                if (unit_second.equals("Pa")) {
                                    cal_result = value * MMHG_TO_KPA * KPA_TO_PA;
                                    sec_unit = true;
                                } else if (unit_second.equals("kPa")) {
                                    cal_result = value * MMHG_TO_KPA;
                                    sec_unit = true;
                                }
                            }
                        } else if (processMode.equals("Velocity")) {
                            if (unit_first.equals(unit_second)) {
                                cal_result = value;
                                sec_unit = true;
                            } else if (unit_first.equals("m/s")) {
                                if (unit_second.equals("km/h")) {
                                    cal_result = value * MPS_TO_KMH;
                                    sec_unit = true;
                                } else if (unit_second.equals("mi/h")) {
                                    cal_result = value * MPS_TO_MIH;
                                    sec_unit = true;
                                }
                            } else if (unit_first.equals("km/h")) {
                                if (unit_second.equals("m/s")) {
                                    cal_result = value / MPS_TO_KMH;
                                    sec_unit = true;
                                } else if (unit_second.equals("mi/h")) {
                                    cal_result = value * MPS_TO_MIH / MPS_TO_KMH;
                                    sec_unit = true;
                                }
                            } else if (unit_first.equals("mi/h")) {
                                if (unit_second.equals("km/h")) {
                                    cal_result = value / (MPS_TO_MIH / MPS_TO_KMH);
                                    sec_unit = true;
                                } else if (unit_second.equals("m/s")) {
                                    cal_result = value / MPS_TO_MIH;
                                    sec_unit = true;
                                }
                            }
                        } else if (processMode.equals("vFlow")) {
                            if (unit_first.equals(unit_second)) {
                                cal_result = value;
                                sec_unit = true;
                            } else if (unit_first.equals("m3/s")) {
                                if (unit_second.equals("L/min")) {
                                    cal_result = value * M3S_TO_LMIN;
                                    sec_unit = true;
                                } else if (unit_second.equals("ft3/s")) {
                                    cal_result = value * M3S_TO_FT3S;
                                    sec_unit = true;
                                }
                            } else if (unit_first.equals("L/min")) {
                                if (unit_second.equals("m3/s")) {
                                    cal_result = value / M3S_TO_LMIN;
                                    sec_unit = true;
                                } else if (unit_second.equals("ft3/s")) {
                                    cal_result = value * M3S_TO_FT3S / M3S_TO_LMIN;
                                    sec_unit = true;
                                }
                            } else if (unit_first.equals("ft3/s")) {
                                if (unit_second.equals("m3/s")) {
                                    cal_result = value / M3S_TO_FT3S;
                                    sec_unit = true;
                                } else if (unit_second.equals("L/min")) {
                                    cal_result = value / M3S_TO_FT3S * M3S_TO_LMIN;
                                    sec_unit = true;
                                }
                            }

                        } else if (processMode.equals("Length")) {
                            if (unit_first.equals(unit_second)) {
                                cal_result = value;
                                sec_unit = true;
                            } else if (unit_first.equals("m")) {
                                if (unit_second.equals("inch")) {
                                    cal_result = value * M_To_IN;
                                    sec_unit = true;
                                } else if (unit_second.equals("foot")) {
                                    cal_result = value * M_To_IN / FT_TO_IN;
                                    sec_unit = true;
                                }
                            } else if (unit_first.equals("inch")) {
                                if (unit_second.equals("m")) {
                                    cal_result = value / M_To_IN;
                                    sec_unit = true;
                                } else if (unit_second.equals("foot")) {
                                    cal_result = value / FT_TO_IN;
                                    sec_unit = true;
                                }
                            } else if (unit_first.equals("foot")) {
                                if (unit_second.equals("m")) {
                                    cal_result = value * FT_TO_IN / M_To_IN;
                                    sec_unit = true;
                                } else if (unit_second.equals("inch")) {
                                    cal_result = value * FT_TO_IN;
                                    sec_unit = true;
                                }
                            }
                        }
                        if (sec_unit) {
                            cal_result = round_dp(cal_result, 8); // round the output to 8 decimal points
                            result_screen.setTextColor(Color.parseColor("#C0C0C0"));
                            result_screen.setText("= " + cal_result);
                            result_displayed = true;
                        }
                    } // if something is selected in measurement
                    else{
                        result_screen.setTextColor(Color.parseColor("#C0C0C0"));
                        result_screen.setText("Please select a category first !");
                        result_displayed = true;
                    }
                }
            }
        });


        // Spinner creation
        measurementAdapter  = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.measurement));

        measurementAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_measurement.setAdapter(measurementAdapter);
        spinner_measurement.setOnItemSelectedListener(this); // a method that waits for user to select an item

    }// on Create method


    // when changes are made to the drop down list (i.e. the spinners)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        // implemented from the AdaptView.OnItemSelectedListener interface
        String itemSelected = adapterView.getItemAtPosition(i).toString();

        // whenever changes to the selection in the check list, reset the output screen
        result_screen.setText("");
        result_displayed = false;

        if (itemSelected.equals("Click to select a category:")){
            unitAdapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.nothing));
            unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_unit_input.setAdapter(unitAdapter);
            spinner_unit_input.setOnItemSelectedListener(this);
            spinner_unit_output.setAdapter(unitAdapter);
            spinner_unit_output.setOnItemSelectedListener(this);
            input_screen.setText(""); // reset the input screen to avoid confusion
            decimal_input = false;

            processMode = "";
        }
        else if (itemSelected.equals("Pressure")){
           unitAdapter = new ArrayAdapter<>(MainActivity.this,
                   android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.pressure_units));
           unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner_unit_input.setAdapter(unitAdapter);
           spinner_unit_input.setOnItemSelectedListener(this);
           spinner_unit_output.setAdapter(unitAdapter);
           spinner_unit_output.setOnItemSelectedListener(this);
           if (!processMode.equals("Pressure")){
               input_screen.setText(""); // reset the input screen to avoid confusion//
               decimal_input = false;
               processMode = "Pressure";
           }
        } else if(itemSelected.equals("Velocity")) {
            unitAdapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.velocity_units));
            unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_unit_input.setAdapter(unitAdapter);
            spinner_unit_input.setOnItemSelectedListener(this);
            spinner_unit_output.setAdapter(unitAdapter);
            spinner_unit_output.setOnItemSelectedListener(this);
            if (!processMode.equals("Velocity")){
                input_screen.setText("");
                decimal_input = false;
                processMode = "Velocity";
            }
        } else if (itemSelected.equals("Length")){
            unitAdapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.length_units));
            unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_unit_input.setAdapter(unitAdapter);
            spinner_unit_input.setOnItemSelectedListener(this);
            spinner_unit_output.setAdapter(unitAdapter);
            spinner_unit_output.setOnItemSelectedListener(this);
            if (!processMode.equals("Length")){
                input_screen.setText("");
                decimal_input = false;
                processMode = "Length";
            }

        } else if (itemSelected.equals("Volumetric flow rate")){
            unitAdapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.v_flow_units));
            unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_unit_input.setAdapter(unitAdapter);
            spinner_unit_input.setOnItemSelectedListener(this);
            spinner_unit_output.setAdapter(unitAdapter);
            spinner_unit_output.setOnItemSelectedListener(this);
            if (!this.processMode.equals("vFlow")){
                input_screen.setText("");
                decimal_input = false;
                processMode = "vFlow";
            }
        }

    } // onItemSelected method

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // does nothing for now, just an interface method that is required to be here, can add functionality later if necessary
    }


    // convert a string to a better looking string
    private double round_dp (double value, int places){
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

} // end of class