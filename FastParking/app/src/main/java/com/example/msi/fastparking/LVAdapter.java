package com.example.msi.fastparking;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msi on 7/14/2016.
 */
public class LVAdapter extends BaseAdapter {

    public List<User>userList = new ArrayList<>();
    private Context context;
    TextView txtName,txtUsername,txtPassword,txtSlotTaken,txtLevel;
    public LVAdapter(Context context, List<User>userList){
        super();
        this.context=context;
        this.userList=userList;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listrow_use_detail,null);
        }

        txtName=(TextView) convertView.findViewById(R.id.Name);
        txtUsername=(TextView) convertView.findViewById(R.id.Username);
        txtPassword=(TextView) convertView.findViewById(R.id.Password);
        txtSlotTaken=(TextView) convertView.findViewById(R.id.TakenSlotStats);
        txtLevel = (TextView) convertView.findViewById(R.id.Level);

        User user =userList.get(position);
        txtName.setText(user.getName());
        txtUsername.setText(user.getUsername());
        txtPassword.setText(user.getPassword());
        txtSlotTaken.setText(user.getSeatTaken());
        txtLevel.setText(String.valueOf(user.getSpecial()));
        return convertView;
    }
}
