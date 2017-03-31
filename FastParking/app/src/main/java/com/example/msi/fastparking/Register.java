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

public class Register extends AppCompatActivity implements View.OnClickListener{

    Button bRegister;
    EditText eName,eUsername,ePassword,ecPassword;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eName = (EditText)findViewById(R.id.etRealname);
        eUsername=(EditText)findViewById(R.id.etUsernameR);
        ePassword = (EditText)findViewById(R.id.etPasswordR);
        ecPassword = (EditText)findViewById(R.id.etPasswordRC);

        textView = (TextView)findViewById(R.id.LogInSwitch) ;
        textView.setOnClickListener(this);

        bRegister = (Button)findViewById(R.id.btRegisterR);
        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.LogInSwitch){
            startActivity(new Intent(Register.this,LogIn.class));
        }
        else if(v.getId()==R.id.btRegisterR){
            String name = eName.getText().toString();
            String username = eUsername.getText().toString();
            String password = ePassword.getText().toString();
            String confirm_password = ecPassword.getText().toString();
            if(!password.equals(confirm_password)){
                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                builder.setMessage("The password is different from confirm password, please try again");
                builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(Register.this,Register.class));
                        finish();
                    }
                });
                builder.create();
                builder.show();
            }
            else{
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonReturn = new JSONObject(response);
                            boolean success = jsonReturn.getBoolean("success");
                            if(success){
                                Toast.makeText(Register.this, "Signup successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Register.this,LogIn.class));
                                finish();
                            }
                            else{
                                boolean exist = jsonReturn.getBoolean("exist");
                                if(exist){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                    builder.setMessage("User already exist");
                                    builder.setNegativeButton("Retry",null);
                                    builder.create();
                                    builder.show();
                                }
                                else{
                                    AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                                    builder.setMessage("Fail to insert data into database");
                                    builder.setNegativeButton("Retry",null);
                                    builder.create();
                                    builder.show();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            System.out.print(response);
                        }
                    }
                };
                RegisterUserRequest registerUserRequest = new RegisterUserRequest(name,username,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Register.this);
                queue.add(registerUserRequest);
            }
        }
    }
}
