package com.example.msi.fastparking;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by msi on 6/26/2016.
 */
public class LogInRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://123name.comxa.com/getUser.php";
    private Map<String, String> params;

    public LogInRequest(String username, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
