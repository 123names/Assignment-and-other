package com.example.msi.fastparking;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    Button blogIn,bRegister;
    EditText eUsername,ePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        eUsername = (EditText)findViewById(R.id.etUsernameL);
        ePassword = (EditText)findViewById(R.id.etPasswordL);
        blogIn = (Button) findViewById((R.id.btlogIn));
        bRegister = (Button)findViewById(R.id.btRegisterL) ;
        blogIn.setOnClickListener(this);
        bRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btlogIn:
                String inUsername = eUsername.getText().toString();
                String inPassword = ePassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonReturn = new JSONObject(response);
                            boolean success = jsonReturn.getBoolean("success");
                            if(success){
                                String name = jsonReturn.getString("name");
                                int accountLevel = jsonReturn.getInt("accountLevel");
                                Toast.makeText(LogIn.this, "Welcome " + name, Toast.LENGTH_SHORT).show();
                                if(accountLevel==0){
                                    Intent intent = new Intent(LogIn.this,ManagerHomePage.class);
                                    intent.putExtra("Name",name);
                                    intent.putExtra("Username",jsonReturn.getString("username"));
                                    intent.putExtra("Special",accountLevel);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Intent intent = new Intent(LogIn.this,HomePage.class);
                                    intent.putExtra("Name",name);
                                    intent.putExtra("Username",jsonReturn.getString("username"));
                                    intent.putExtra("Special",accountLevel);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LogIn.this);
                                builder.setMessage("Username or password wrong, please try again");
                                builder.setNegativeButton("OK",null);
                                builder.create();
                                builder.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LogInRequest logInRequest = new LogInRequest(inUsername,inPassword,responseListener);
                RequestQueue queue = Volley.newRequestQueue(LogIn.this);
                queue.add(logInRequest);
                break;
            case R.id.btRegisterL:
                startActivity(new Intent(this,Register.class));
                break;
        }
    }
}

