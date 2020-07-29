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
import android.widget.Toast;

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

    boolean result_displayed = false;

    // Check list - What to measure?
    boolean pressure_mode = false;
    boolean vFlow_mode = false;
    boolean length_mode= false;
    boolean velocity_mode = false;

    // Adapters, are used to put arrays in to spinners
    ArrayAdapter<String> measurementAdapter;
    ArrayAdapter<String> unitAdapter;

    // calculation result
    double cal_result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mapping the variable to the widgets

        // numeric buttons
        button0 = (Button) findViewById(R.id.btn0);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);
        button3 = (Button) findViewById(R.id.btn3);
        button4 = (Button) findViewById(R.id.btn4);
        button5 = (Button) findViewById(R.id.btn5);
        button6 = (Button) findViewById(R.id.btn6);
        button7 = (Button) findViewById(R.id.btn7);
        button8 = (Button) findViewById(R.id.btn8);
        button9 = (Button) findViewById(R.id.btn9);

        // other buttons

        button_decimal = (Button) findViewById(R.id.btn_decimal);
        button_deleteOne = (Button) findViewById(R.id.btn_deleteOne);
        button_run = (Button) findViewById(R.id.btn_run);
        button_allClear = (Button) findViewById(R.id.btn_allClear);

        // Screens
        input_screen = (TextView) findViewById(R.id.screen);
        result_screen = (TextView) findViewById(R.id.resultScreen);


        // setup the spinner
        spinner_measurement = (Spinner) findViewById(R.id.sp_measure_type);
        spinner_unit_input = (Spinner) findViewById(R.id.sp_input_unit);
        spinner_unit_output = (Spinner) findViewById(R.id.sp_output_unit);

        // Set the on click actions

        // On-click action
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
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
                }
                result_screen.setTextColor(Color.GRAY);

                input_screen.setText(input_screen.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                }
                result_screen.setTextColor(Color.GRAY);

                input_screen.setText(input_screen.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                }
                result_screen.setTextColor(Color.GRAY);

                input_screen.setText(input_screen.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                }
                result_screen.setTextColor(Color.GRAY);

                input_screen.setText(input_screen.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                }
                result_screen.setTextColor(Color.GRAY);
                input_screen.setText(input_screen.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                }
                result_screen.setTextColor(Color.GRAY);

                input_screen.setText(input_screen.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                }
                result_screen.setTextColor(Color.GRAY);
                input_screen.setText(input_screen.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                }
                result_screen.setTextColor(Color.GRAY);

                input_screen.setText(input_screen.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (result_displayed){
                    input_screen.setText("");
                    result_displayed = false;
                }
                result_screen.setTextColor(Color.GRAY);

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
                    String remainingText = inputText.substring(0, inputText.length() - 1);
                    input_screen.setText(remainingText); // take off the last char
                }
            }
        });

        button_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_screen.setText(input_screen.getText() + ".");
                result_displayed = false;
                result_screen.setTextColor(Color.GRAY);
            }
        });

        button_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the user inputs
                String user_inputs = input_screen.getText().toString();
                String unit_first;
                String unit_second;
                if (user_inputs.length() != 0) {

                    // process the inputs
                    unit_first = spinner_unit_input.getSelectedItem().toString();
                    unit_second = spinner_unit_output.getSelectedItem().toString();
                    double value = Double.parseDouble(user_inputs);

                    if (pressure_mode){
                        if (unit_first.equals(unit_second)){
                            cal_result = value;
                        } else if (unit_first.equals("Pa")){
                            if (unit_second.equals("kPa")){
                                cal_result = pa_to_kpa(value);
                            } else if (unit_second.equals("mmHg")){
                                cal_result = pa_to_mmhg(value);
                            }
                        } else if (unit_first.equals("kPa")){
                            if (unit_second.equals("Pa")){
                                cal_result = 1/pa_to_kpa(value);
                            } else if (unit_second.equals("mmHg")){
                                cal_result = kpa_to_mmhg(value);
                            }
                        } else if (unit_first.equals("mmHg")) {
                            if (unit_second.equals("Pa")) {
                                cal_result = 1 / pa_to_mmhg(value);
                            } else if (unit_second.equals("kPa")) {
                                cal_result = 1 / kpa_to_mmhg(value);
                            }
                        }
                    } else if (velocity_mode){
                        if (unit_first.equals(unit_second)){
                            cal_result = value;
                        } else if (unit_first.equals("m/s")){
                            if (unit_second.equals("km/h")){
                                cal_result = mps_to_kmh(value);
                            } else if (unit_second.equals("mi/h")){
                                cal_result = mps_to_mih(value);
                            }
                        } else if (unit_first.equals("km/h")){
                            if (unit_second.equals("m/s")){
                                cal_result = 1/mps_to_kmh(value);
                            } else if (unit_second.equals("mi/h")){
                                cal_result = kmh_to_mih(value);
                            }
                        } else if (unit_first.equals("mi/h")) {
                            if (unit_second.equals("km/h")) {
                                cal_result = 1 / kmh_to_mih(value);
                            } else if (unit_second.equals("m/s")) {
                                cal_result = 1 / mps_to_mih(value);
                            }
                        }
                    } else if (vFlow_mode){
                        if (unit_first.equals(unit_second)){
                            cal_result = value;
                        } else if (unit_first.equals("m3/s")){
                            if (unit_second.equals("L/min")){
                                cal_result = m3s_to_Lmin(value);
                            } else if (unit_second.equals("ft3/s")){
                                cal_result = m3s_to_ft3s(value);
                            }
                        } else if (unit_first.equals("L/min")){
                            if (unit_second.equals("m3/s")){
                                cal_result = 1/m3s_to_Lmin(value);
                            } else if (unit_second.equals("ft3/s")){
                                cal_result = 1/ft3s_to_Lmin(value);
                            }
                        } else if (unit_first.equals("ft3/s")) {
                            if (unit_second.equals("m3/s")) {
                                cal_result = 1 / m3s_to_ft3s(value);
                            } else if (unit_second.equals("L/min")) {
                                cal_result = ft3s_to_Lmin(value);
                            }
                        }

                    } else if (length_mode){
                        if (unit_first.equals(unit_second)){
                            cal_result = value;
                        } else if (unit_first.equals("m")){
                            if (unit_second.equals("inch")){
                                cal_result = m_to_in(value);
                            } else if (unit_second.equals("foot")){
                                cal_result = m_to_ft(value);
                            }
                        } else if (unit_first.equals("inch")){
                            if (unit_second.equals("m")){
                                cal_result = 1/m_to_in(value);
                            } else if (unit_second.equals("foot")){
                                cal_result = in_to_ft(value);
                            }
                        } else if (unit_first.equals("foot")) {
                            if (unit_second.equals("m")) {
                                cal_result = 1 /m_to_ft(value);
                            } else if (unit_second.equals("inch")) {
                                cal_result = 1/in_to_ft(value);
                            }
                        }
                    }


                    cal_result = round_dp(cal_result, 12); // round the output to 12 decimal points

                    // set the result on the screen
                    result_screen.setTextColor(Color.parseColor("#C0C0C0"));
                    result_screen.setText("= " + String.valueOf(cal_result));
                    result_displayed = true;
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

        if (itemSelected.equals("Pressure")){
           unitAdapter = new ArrayAdapter<>(MainActivity.this,
                   android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.pressure_units));
           unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
           spinner_unit_input.setAdapter(unitAdapter);
           spinner_unit_input.setOnItemSelectedListener(this);
           spinner_unit_output.setAdapter(unitAdapter);
           spinner_unit_output.setOnItemSelectedListener(this);
           pressure_mode = true;
           velocity_mode = length_mode = vFlow_mode = false;
           input_screen.setText(""); // reset the input screen to avoid confusion
        } else if(itemSelected.equals("Velocity")) {
            unitAdapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.velocity_units));
            unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_unit_input.setAdapter(unitAdapter);
            spinner_unit_input.setOnItemSelectedListener(this);
            spinner_unit_output.setAdapter(unitAdapter);
            spinner_unit_output.setOnItemSelectedListener(this);
            velocity_mode = true;
            pressure_mode = length_mode = vFlow_mode = false;
            input_screen.setText("");
        } else if (itemSelected.equals("Length")){
            unitAdapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.length_units));
            unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_unit_input.setAdapter(unitAdapter);
            spinner_unit_input.setOnItemSelectedListener(this);
            spinner_unit_output.setAdapter(unitAdapter);
            spinner_unit_output.setOnItemSelectedListener(this);
            length_mode = true;
            pressure_mode =  velocity_mode = vFlow_mode = false;
            input_screen.setText("");
        } else if (itemSelected.equals("Volumetric flow rate")){
            unitAdapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.v_flow_units));
            unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_unit_input.setAdapter(unitAdapter);
            spinner_unit_input.setOnItemSelectedListener(this);
            spinner_unit_output.setAdapter(unitAdapter);
            spinner_unit_output.setOnItemSelectedListener(this);
            vFlow_mode = true;
            pressure_mode =  velocity_mode = length_mode = false;
            input_screen.setText("");
        }

    } // onItemSelected method

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // does nothing, required to be here (interface method), can be added later if necessary
    }


    // convert a string to a better looking string
    public double round_dp (double value, int places){
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    // Pressure conversion methods
    private double pa_to_kpa(double value){
        return value/1000.0;
    }

    private double pa_to_mmhg(double value){
        return value/101325*760;
    }

    private double kpa_to_mmhg (double value){
        return value/101.325*760;
    }

    // Velocity conversion methods

    private double mps_to_kmh (double value){
        return value * 3.6;
    }

    private double mps_to_mih (double value){
        return value * 2.24;
    }

    private double kmh_to_mih (double value){
        return mps_to_mih(1/mps_to_kmh(value));
    }

    // Length conversion methods

    private double m_to_in (double value){
        return value * 39.37;
    }

    private double in_to_ft (double value){
        return value/12;
    }

    private double m_to_ft (double value){
        return in_to_ft(m_to_in(value));
    }

    // Volumetric flow rate methods

    private double m3s_to_ft3s(double value){
        return Math.pow(m_to_ft(value),3);
    }

    private double m3s_to_Lmin (double value){
        return value*1000*60;
    }

    private double ft3s_to_Lmin (double value){
        return m3s_to_Lmin(1/m3s_to_ft3s(value));
    }

}



