package com.example.msi.fastparking;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePage extends AppCompatActivity implements View.OnClickListener{
    ExpandableListView expandableListView;
    private TabHost tabHost;
    TextView inLevel,inlv;
    Button button;
    List<Button> buttons = new ArrayList<>();
    List<String> available = new ArrayList<>();
    List<String> all = new ArrayList<>();
    List<String> users = new ArrayList<>();
    HashMap<String,List<String>> seats = new HashMap<>();
    public static User user = new User("default");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        // get user detail in homepage
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                user.setName(extras.getString("Name"));
                user.setUsername(extras.getString("Username"));
                user.setSpecial(extras.getInt("Special"));
            }
        }
        else {
            user.setName((String) savedInstanceState.getSerializable("Name"));
            user.setUsername((String) savedInstanceState.getSerializable("Username"));
            user.setSpecial((int)savedInstanceState.getSerializable("Special"));
        }
        // get seat taken stats
        synUser(user.getUsername());
        //
        inLevel = (TextView)findViewById(R.id.inLevel);
        inlv = (TextView)findViewById(R.id.inLv);
        if(user.getSpecial()==1){
            inLevel.setText("1(Normal account)");
            inlv.setText("1(Normal account)");
        }
        else if(user.getSpecial()==2){
            inLevel.setText("2(Special account)");
            inlv.setText("2(Special account)");
        }
        else if(user.getSpecial()==3){
            inLevel.setText("3(Reserved account)");
            inlv.setText("3(Reserved account)");
        }
        // expandableListView set content
        List<String> MainHead = new ArrayList<>();
        MainHead.add("Avaliable parking slot List");
        MainHead.add("All parking slot List");
        MainHead.add("User's parking slot");
        //put data in to subTitles
        seats.put(MainHead.get(0),available);
        seats.put(MainHead.get(1),all);
        seats.put(MainHead.get(2),users);
        //put data
        synSeat(MainHead);
        // set tabs
        setTabHosts();
    }
    public void synUser(String username){
        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonReturn = new JSONObject(response);
                    boolean success = jsonReturn.getBoolean("success");
                    if(success){
                        String seatTaken = jsonReturn.getString("seatTaken");
                        user.setSeatTaken(seatTaken);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                        builder.setMessage("Syn error");
                        builder.setNegativeButton("OK",null);
                        builder.create();
                        builder.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        SynUserSeatStatsRequest synUserSeatStatsRequest = new SynUserSeatStatsRequest(username,responseListener);
        RequestQueue queue = Volley.newRequestQueue(HomePage.this);
        queue.add(synUserSeatStatsRequest);
    }
    public void synSeat(final List<String> MainHead){
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
                            all.add(temp.getString("Position"));
                            if(temp.getInt("Available")==1){
                                if(temp.getInt("Special")==1){
                                    available.add(temp.getString("Position"));
                                }
                                else if(user.getSpecial()==temp.getInt("Special")){
                                    available.add(temp.getString("Position"));
                                }
                                slotStats.add(new ParkingSlots(temp.getString("Position"),temp.getInt("Special")));
                            }
                            else{
                                if(temp.getString("TakenBy").equalsIgnoreCase(user.getUsername())){
                                    users.add(temp.getString("Position"));
                                }
                                slotStats.add(new ParkingSlots(temp.getString("Position"), false,temp.getString("TakenBy"),temp.getInt("Special")));
                            }
                        }
                        setMinMapView(slotStats);
                        setListViewTab(MainHead,seats,slotStats);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
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
        RequestQueue queue = Volley.newRequestQueue(HomePage.this);
        queue.add(synSeatsRequest);
    }
    @Override
    public void onClick(View v) {
        int clicked = v.getId();
        Button clickedButton = ((Button) findViewById(clicked));
        if(user.getSeatTaken().contains("A")){
            AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
            builder.setMessage("This account already taken one seat. Please leave you seat before taken other seat.");
            builder.setNegativeButton("OK",null);
            builder.create();
            builder.show();
        }
        else{
            Intent intent = new Intent(HomePage.this, Select_Parking_Slot.class);
            intent.putExtra("Position",clickedButton.getText());
            intent.putExtra("User",user.getUsername());
            startActivity(intent);
            finish();
        }
    }
    public void setMinMapView( List<ParkingSlots>availablity){
        Drawable drawableGreen = ResourcesCompat.getDrawable(getResources(), R.drawable.button_border_green, null);
        Drawable drawableRed = ResourcesCompat.getDrawable(getResources(), R.drawable.button_border_red, null);
        Drawable drawableYellow = ResourcesCompat.getDrawable(getResources(), R.drawable.button_border_yellow, null);
        Drawable drawableBlue = ResourcesCompat.getDrawable(getResources(), R.drawable.button_border_blue, null);
        Drawable drawablePurple = ResourcesCompat.getDrawable(getResources(), R.drawable.button_border_purple, null);
        for(int i=1; i<3; i++) {
            for(int j=1; j<11; j++) {
                String buttonID = "btR" + i + "C" + j;
                int resID = getResources().getIdentifier(buttonID, "id", "com.example.msi.fastparking");
                button = ((Button) findViewById(resID));
                button.setOnClickListener(this);
                button.setBackground(drawableGreen);
                buttons.add(button);
            }
        }
        for(int i = 3;i<5;i++){
            for(int j = 1;j<9;j++){
                String buttonID = "btR" + i + "C" + j;
                int resID = getResources().getIdentifier(buttonID, "id", "com.example.msi.fastparking");
                button = ((Button) findViewById(resID));
                button.setOnClickListener(this);
                button.setBackground(drawableGreen);
                buttons.add(button);
            }
        }
        for(int i =0;i<availablity.size();i++){
            if(user.getUsername().equalsIgnoreCase(availablity.get(i).getUsedBy())){
                final String pos = availablity.get(i).getPosition();
                final String  usedBy = availablity.get(i).getUsedBy();
                buttons.get(i).setBackground(drawableYellow);
                buttons.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomePage.this, Leaving_Parking_Slot.class);
                        intent.putExtra("Position",pos);
                        intent.putExtra("UsedBy", usedBy);
                        startActivity(intent);
                        finish();
                    }
                });
            }
            else if(availablity.get(i).isAvailable()){
                if(availablity.get(i).getSpecial()==2){
                    final String pos = availablity.get(i).getPosition();
                    buttons.get(i).setBackground(drawableBlue);
                    buttons.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(user.getSpecial()==2){
                                Intent intent = new Intent(HomePage.this, Select_Parking_Slot.class);
                                intent.putExtra("Position", pos);
                                intent.putExtra("User",user.getUsername());
                                startActivity(intent);
                                finish();
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                                builder.setMessage("This slot is special slot, please try another slot");
                                builder.setNegativeButton("OK",null);
                                builder.create();
                                builder.show();
                            }
                        }
                    });
                }
                else if(availablity.get(i).getSpecial()==3){
                    final String pos = availablity.get(i).getPosition();
                    buttons.get(i).setBackground(drawablePurple);
                    buttons.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(user.getSpecial()==3){
                                Intent intent = new Intent(HomePage.this, Select_Parking_Slot.class);
                                intent.putExtra("Position", pos);
                                intent.putExtra("User",user.getUsername());
                                startActivity(intent);
                                finish();
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                                builder.setMessage("This slot is reserved slot, please try another slot");
                                builder.setNegativeButton("OK",null);
                                builder.create();
                                builder.show();
                            }
                        }
                    });
                }
                // add more functions
                else{
                    buttons.get(i).setBackground(drawableGreen);
                }
            }
            else{
                buttons.get(i).setBackground(drawableRed);
                buttons.get(i).setClickable(false);
            }
            buttons.get(i).setText(all.get(i));
        }
    }
    public void setListViewTab(List<String>MainHead, HashMap<String,List<String>>subTitles, final List<ParkingSlots>slotStat){
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        ELVAdapter elvAdapter = new ELVAdapter(this,MainHead,subTitles);
        expandableListView.setAdapter(elvAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ParkingSlots currentParkingSlots = slotStat.get(Integer.parseInt(parent.getExpandableListAdapter().getChild(groupPosition,childPosition).toString().substring(1))-1);
                if(currentParkingSlots.isAvailable()){
                    if(user.getSeatTaken().contains("A")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                        builder.setMessage("This account already taken one seat. Please leave you seat before taken other seat.");
                        builder.setNegativeButton("OK",null);
                        builder.create();
                        builder.show();
                    }
                    else if(currentParkingSlots.getSpecial()==2){
                        if(user.getSpecial()==2){
                            Intent intent = new Intent(HomePage.this, Select_Parking_Slot.class);
                            intent.putExtra("Position", parent.getExpandableListAdapter().getChild(groupPosition,childPosition).toString());
                            intent.putExtra("User",user.getUsername());
                            startActivity(intent);
                            finish();
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                            builder.setMessage("This slot is special slot, please try another slot");
                            builder.setNegativeButton("OK",null);
                            builder.create();
                            builder.show();
                        }
                    }
                    else if (currentParkingSlots.getSpecial()==3){
                        if(user.getSpecial()==3){
                            Intent intent = new Intent(HomePage.this, Select_Parking_Slot.class);
                            intent.putExtra("Position", parent.getExpandableListAdapter().getChild(groupPosition,childPosition).toString());
                            intent.putExtra("User",user.getUsername());
                            startActivity(intent);
                            finish();
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                            builder.setMessage("This slot is reserved slot, please try another slot");
                            builder.setNegativeButton("OK",null);
                            builder.create();
                            builder.show();
                        }
                    }
                    //add more functions
                    else{
                        Intent intent = new Intent(HomePage.this, Select_Parking_Slot.class);
                        intent.putExtra("Position", parent.getExpandableListAdapter().getChild(groupPosition,childPosition).toString());
                        intent.putExtra("User",user.getUsername());
                        startActivity(intent);
                        finish();
                    }
                }
                else{
                    if(currentParkingSlots.getUsedBy().equalsIgnoreCase(user.getUsername())){
                        Intent intent = new Intent(HomePage.this, Leaving_Parking_Slot.class);
                        intent.putExtra("Position", parent.getExpandableListAdapter().getChild(groupPosition,childPosition).toString());
                        intent.putExtra("UsedBy",user.getUsername());
                        startActivity(intent);
                        finish();
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(HomePage.this);
                        builder.setMessage("This slot is taken");
                        builder.setNegativeButton("OK",null);
                        builder.create();
                        builder.show();
                    }
                }
                return true;
            }
        });
    }
    public void setTabHosts(){
        tabHost = (TabHost)findViewById(R.id.contentSwitch);
            tabHost.setup();
            //Tab 1
             TabHost.TabSpec spec = tabHost.newTabSpec("Min Map View");
            spec.setContent(R.id.MapView);
            spec.setIndicator("Min Map View");
            tabHost.addTab(spec);
            //Tab 2
            spec = tabHost.newTabSpec("List View");
            spec.setContent(R.id.ListView);
            spec.setIndicator("List View");
            tabHost.addTab(spec);
    }
}
