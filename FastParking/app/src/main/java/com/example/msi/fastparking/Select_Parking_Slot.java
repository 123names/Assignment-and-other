package com.example.msi.fastparking;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Select_Parking_Slot extends AppCompatActivity {

    Button choiceY,choiceN;
    TextView position;
    String positionID,usedBy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__parking__slot);

        boolean statusOfseat;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                positionID= null;
                usedBy =null;
            } else {
                positionID= extras.getString("Position");
                usedBy = extras.getString("User");
            }
        } else {
            positionID= (String) savedInstanceState.getSerializable("Position");
            usedBy= (String) savedInstanceState.getSerializable("User");
        }
        position = (TextView)findViewById(R.id.fieldPosition);
        position.setText(positionID);
        choiceY = (Button)findViewById(R.id.choiceYes);
        choiceY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonReturn = new JSONObject(response);
                            boolean success = jsonReturn.getBoolean("success");
                            if(success){
                                Toast.makeText(Select_Parking_Slot.this, "Seat " + positionID+ " Register successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Select_Parking_Slot.this,HomePage.class));
                                finish();
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Select_Parking_Slot.this);
                                builder.setMessage("Error occur during process,this slot maybe taken by someone, please try another slot");
                                builder.setNegativeButton("OK",null);
                                builder.create();
                                builder.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterSeatRequest registerSeatRequest = new RegisterSeatRequest(positionID,usedBy,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Select_Parking_Slot.this);
                queue.add(registerSeatRequest);
            }
        });

        choiceN = (Button)findViewById(R.id.choiceNo);
        choiceN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Select_Parking_Slot.this,HomePage.class));
            }
        });
    }
}
