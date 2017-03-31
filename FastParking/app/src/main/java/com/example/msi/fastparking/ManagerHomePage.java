package com.example.msi.fastparking;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManagerHomePage extends AppCompatActivity{

    TabHost tabHost;
    ListView listView;
    EditText input;
    List<Button> buttons = new ArrayList<>();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_home_page);
        //put data in to users page
        listView=(ListView)findViewById(R.id.UserList);
        synUser();
        //put data in to slots page
        synSeat();
        // set tabs
        setTabHosts();
    }
    public void setMinMapView( List<ParkingSlots>availability){
        Drawable drawableGreen = ResourcesCompat.getDrawable(getResources(), R.drawable.button_border_green, null);
        Drawable drawableRed = ResourcesCompat.getDrawable(getResources(), R.drawable.button_border_red, null);
        Drawable drawableBlue = ResourcesCompat.getDrawable(getResources(), R.drawable.button_border_blue, null);
        Drawable drawablePurple = ResourcesCompat.getDrawable(getResources(), R.drawable.button_border_purple, null);
        for(int i=1; i<3; i++) {
            for(int j=1; j<11; j++) {
                String buttonID = "btR" + i + "C" + j;
                int resID = getResources().getIdentifier(buttonID, "id", "com.example.msi.fastparking");
                button = ((Button) findViewById(resID));
                buttons.add(button);
            }
        }
        for(int i = 3;i<5;i++){
            for(int j = 1;j<9;j++){
                String buttonID = "btR" + i + "C" + j;
                int resID = getResources().getIdentifier(buttonID, "id", "com.example.msi.fastparking");
                button = ((Button) findViewById(resID));
                buttons.add(button);
            }
        }
        for(int i =0;i<availability.size();i++){
            if(availability.get(i).isAvailable()){
                if(availability.get(i).getSpecial()==2){
                    buttons.get(i).setBackground(drawableBlue);
                }
                else if(availability.get(i).getSpecial()==3){
                    buttons.get(i).setBackground(drawablePurple);
                }
                // add more functions
                else{
                    buttons.get(i).setBackground(drawableGreen);
                }
            }
            else{
                buttons.get(i).setBackground(drawableRed);
            }
            final String position = availability.get(i).getPosition();
            final boolean available = availability.get(i).isAvailable();
            final String usedBy = availability.get(i).getUsedBy();
            final int slotLevel = availability.get(i).getSpecial();

            buttons.get(i).setText(availability.get(i).getPosition());
            buttons.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ManagerHomePage.this, Manage_parking_slots.class);
                    intent.putExtra("Position", position);
                    intent.putExtra("Available",available);
                    intent.putExtra("UsedBy",usedBy);
                    intent.putExtra("SlotLevel",slotLevel);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
    public void synSeat(){
        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    List<ParkingSlots> slotStats = new ArrayList<>();
                    JSONObject jsonReturn = new JSONObject(response);
                    boolean success = jsonReturn.getBoolean("success");
                    if(success){
                        int count = jsonReturn.getInt("count");
                        for(int i = 0;i<count;i++){
                            JSONObject temp;
                            temp = jsonReturn.getJSONObject(i+"");
                            if(temp.getInt("Available")==1){
                                slotStats.add(new ParkingSlots(temp.getString("Position"),temp.getInt("Special")));
                            }
                            else{
                                slotStats.add(new ParkingSlots(temp.getString("Position"), false,temp.getString("TakenBy"),temp.getInt("Special")));
                            }
                        }
                        setMinMapView(slotStats);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(ManagerHomePage.this);
                        builder.setMessage("Error synchronizing data, please try again");
                        builder.setNegativeButton("OK",null);
                        builder.create();
                        builder.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        SynSeatsRequest synSeatsRequest = new SynSeatsRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(ManagerHomePage.this);
        queue.add(synSeatsRequest);
    }
    public void fillTable(final List<User> users){
        LVAdapter adapter =new LVAdapter(this, users);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ManagerHomePage.this);
                builder.setTitle("Account Level Change Operation");
                builder.setMessage("Please input the level you want to change on current account: ");
                input = new EditText(ManagerHomePage.this);
                builder.setView(input);
                builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String text = input.getText().toString();
                        if(text.equalsIgnoreCase("1")|| text.equalsIgnoreCase("2")||text.equalsIgnoreCase("3")||text.equalsIgnoreCase("0")){
                            Response.Listener<String> responseListener = new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonReturn = new JSONObject(response);
                                        boolean success = jsonReturn.getBoolean("success");
                                        if(success){
                                            Toast.makeText(ManagerHomePage.this, "Operation successful", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(ManagerHomePage.this,ManagerHomePage.class));
                                            finish();
                                        }
                                        else{
                                            AlertDialog.Builder builder = new AlertDialog.Builder(ManagerHomePage.this);
                                            builder.setMessage("Operation fail, please try again");
                                            builder.setNegativeButton("OK",null);
                                            builder.create();
                                            builder.show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            ChangeLevelRequest changeLevelRequest = new ChangeLevelRequest(text,users.get(position).getUsername(),responseListener);
                            RequestQueue queue = Volley.newRequestQueue(ManagerHomePage.this);
                            queue.add(changeLevelRequest);
                        }
                        else{
                            Toast.makeText(ManagerHomePage.this, "Operation fail because you not inputting a valid level ", Toast.LENGTH_SHORT).show();
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
    public void synUser(){
        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    List<User>accounts = new ArrayList<>();
                    JSONObject jsonReturn = new JSONObject(response);
                    boolean success = jsonReturn.getBoolean("success");
                    if(success){
                        int count = jsonReturn.getInt("count");
                        for(int i = 0;i<count;i++){
                            JSONObject temp;
                            temp = jsonReturn.getJSONObject(i+"");
                            User users = new User(temp.getString("name"),temp.getString("username"),temp.getString("seatTaken"));
                            users.setPassword(temp.getString("password"));
                            users.setSpecial(temp.getInt("level"));
                            accounts.add(users);
                        }
                        fillTable(accounts);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(ManagerHomePage.this);
                        builder.setMessage("Error synchronizing data, please try again");
                        builder.setNegativeButton("OK",null);
                        builder.create();
                        builder.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        SynUserRequest synUserRequest = new SynUserRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(ManagerHomePage.this);
        queue.add(synUserRequest);
    }
    public void setTabHosts(){
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        //Tab 1
        TabHost.TabSpec spec = tabHost.newTabSpec("User Detail");
        spec.setContent(R.id.UserDetail);
        spec.setIndicator("Users");
        tabHost.addTab(spec);
        //Tab 2
        spec = tabHost.newTabSpec("Slot Detail");
        spec.setContent(R.id.SlotDetail);
        spec.setIndicator("Slots");
        tabHost.addTab(spec);
    }
}
