package com.example.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button Demo1, Demo2, Demo3, Ex3, Demo4, Demo5;
    TextView tvDemo2, tvDemo3, tvEx3, tvDemo4, tvDemo5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Demo1 = findViewById(R.id.btnDemo1);
        Demo2 = findViewById(R.id.btnDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        Demo3 = findViewById(R.id.btnDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        Ex3 =findViewById(R.id.btnEx3);
        tvEx3 = findViewById(R.id.textViewEx3);
        Demo4 = findViewById(R.id.btnDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        Demo5 = findViewById(R.id.btnDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);

//      Demo 1
        Demo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

//                myBuilder.setTitle("Demo 1-Simple Dialog");
//                myBuilder.setMessage("I can develop android apps");
//                myBuilder.setCancelable(false);
//                myBuilder.setPositiveButton("Close",null);

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple dialog box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
//      Demo 2
        Demo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the buttons below.");
                myBuilder.setCancelable(false);

                //1st option(changes tvdemo2's contents)
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You selected Positive.");
                    }
                });

                //2nd option(changes tvdemo2's contents)
                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You selected Negative.");
                    }
                });

                //3rd option
                myBuilder.setNeutralButton("Cancel",null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });
//      Demo 3
        Demo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
//      Exercise 3
        Ex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.exercise3, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextNum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String place1 = etInput1.getText().toString();
                        String place2 = etInput2.getText().toString();

                        int test = Integer.parseInt(place1);
                        int test2 = Integer.parseInt(place2);

                        // Extract the text entered by the user
                        String message = String.valueOf(test + test2);
                        // Set the text to the TextView
                        tvEx3.setText(" The sum is "+message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
//      Demo 4
        Demo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the Listener to set the data
                Calendar.getInstance().get(Calendar.YEAR);
                Calendar.getInstance().get(Calendar.MONTH);
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH);



                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                };
                // Create the Date picker Dialog
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,myDateListener,Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH);
                myDateDialog.show();
            }
        });
//      Demo 5
        Demo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String time ="";
                        if(hourOfDay>=0 && hourOfDay<12){
                            time = hourOfDay + " : " + minute + " AM";
                        } else {
                            if(hourOfDay == 12){
                                time = hourOfDay + " : " + minute + "PM";

                            }else{
                                hourOfDay = hourOfDay -12;
                                time = hourOfDay + " : " + minute + "PM";
                            }
                        }
                        tvDemo5.setText("Time: "+time);
                    }
                };
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, 20, 00,false);
                myTimeDialog.show();

            }
        });

    }
}