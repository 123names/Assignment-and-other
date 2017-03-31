package com.example.msi.fastparking;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Manage_parking_slots extends AppCompatActivity {

    String positionID,usedBy;
    int level;
    boolean available;
    TextView position,availability,user,specialLevel;
    Button button,btcal;
    EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_parking_slots);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                positionID = null;
                usedBy = null;
                level = 1;
                available = true;
            } else {
                positionID = extras.getString("Position");
                available = extras.getBoolean("Available");
                usedBy = extras.getString("UsedBy");
                level = extras.getInt("SlotLevel");
            }
        } else {
            positionID = (String) savedInstanceState.getSerializable("Position");
            available = (boolean) savedInstanceState.getSerializable("Available");
            usedBy = (String) savedInstanceState.getSerializable("UsedBy");
            level = (int) savedInstanceState.getSerializable("SlotLevel");
        }
        position = (TextView) findViewById(R.id.fieldPosition);
        position.setText(positionID);
        availability = (TextView) findViewById(R.id.fieldAvailability);
        if (available) {
            availability.setText("True");
        } else {
            availability.setText("False");
        }
        user = (TextView) findViewById(R.id.fieldUser);
        user.setText(usedBy);
        specialLevel = (TextView) findViewById(R.id.fieldLevel);
        if (level == 0) {
            specialLevel.setText("Manager Account(Level 0)");
        } else if (level == 1) {
            specialLevel.setText("Normal Account(Level 1)");
        } else if (level == 2) {
            specialLevel.setText("Special Account(Level 2)");
        } else if (level == 3) {
            specialLevel.setText("Reserved Account(Level 3)");
        } else {
            specialLevel.setText("Unknown Account(Level ???)");
        }
        button = (Button) findViewById(R.id.btBHP);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Manage_parking_slots.this, ManagerHomePage.class);
                startActivity(intent);
                finish();
            }
        });
        btcal = (Button) findViewById(R.id.btCAL);
        btcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Manage_parking_slots.this);
                builder.setTitle("Slot Level Change Operation");
                builder.setMessage("Please input the level you want to change on current slot: ");
                input = new EditText(Manage_parking_slots.this);
                builder.setView(input);
                builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String text = input.getText().toString();
                        if (text.equalsIgnoreCase("1") || text.equalsIgnoreCase("2") || text.equalsIgnoreCase("3") || text.equalsIgnoreCase("0")) {
                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonReturn = new JSONObject(response);
                                        boolean success = jsonReturn.getBoolean("success");
                                        if (success) {
                                            Toast.makeText(Manage_parking_slots.this, "Operation successful", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(Manage_parking_slots.this, ManagerHomePage.class));
                                            finish();
                                        } else {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(Manage_parking_slots.this);
                                            builder.setMessage("Operation fail, please try again");
                                            builder.setNegativeButton("OK", null);
                                            builder.create();
                                            builder.show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            ChangeSlotLevelRequest changeSlotLevelRequest = new ChangeSlotLevelRequest(text, positionID, responseListener);
                            RequestQueue queue = Volley.newRequestQueue(Manage_parking_slots.this);
                            queue.add(changeSlotLevelRequest);
                        } else {
                            Toast.makeText(Manage_parking_slots.this, "Operation fail because you not inputting a valid level ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create();
                builder.show();
            }
        });
    }
}
