package com.example.msi.fastparking;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by msi on 6/26/2016.
 */
public class RegisterSeatRequest extends StringRequest {
    private static final String REGISTER_SEAT_REQUEST_URL = "http://123name.comxa.com/registerSeat.php";
    private Map<String,String> params;

    public RegisterSeatRequest (String Position, String User, Response.Listener<String> listener){
        super(Request.Method.POST,REGISTER_SEAT_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("position",Position);
        params.put("available","0");
        params.put("user",User);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
