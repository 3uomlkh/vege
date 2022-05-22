package com.example.restaurant_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.restaurant_list.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    RestaurantAdapter adapter;
    static RequestQueue requestQueue;
    ArrayList<Rest> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        CheckBox ch = findViewById(R.id.starCheckBox);
//        if(ch.isChecked()){
//            Toast.makeText(this, "즐겨찾기 되었습니다.", Toast.LENGTH_SHORT).show();
//        }

/*        binding.requestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThreadProc();

            }
        });*/

        ThreadProc();

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.RecyclerView.setLayoutManager(layoutManager);

        adapter = new RestaurantAdapter();
        binding.RecyclerView.setAdapter(adapter);
    }

    private void ThreadProc() {
        new Thread() {
            @Override
            public void run() {
                String str, receiveMsg = "";
                String urlStr = "http://mygomhosting.dothome.co.kr/restaurant.php";
                try {
                    URL url = new URL(urlStr);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

                    if (conn.getResponseCode() == conn.HTTP_OK) {
                        InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                        BufferedReader reader = new BufferedReader(tmp);
                        StringBuffer buffer = new StringBuffer();
                        while ((str = reader.readLine()) != null) {
                            buffer.append(str);
                        }
                        receiveMsg = buffer.toString();
                        reader.close();

                        Bundle bun = new Bundle();
                        bun.putString("jsonGap", receiveMsg);
                        Message msg = handler.obtainMessage();
                        msg.setData(bun);
                        handler.sendMessage(msg);
                    } else {
                        Log.d("b1a2", "통신 결과 : " + conn.getResponseCode() + "에러");
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void jsonParsing(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray restArr = jsonObject.getJSONArray("restaurant");

            for(int i = 0; i < restArr.length();i++) {
                JSONObject restObj = restArr.getJSONObject(i);

                Rest rest = new Rest();
                rest.setName(restObj.getString("name"));
                rest.setAddress(restObj.getString("address"));
                rest.setImage(restObj.getString("image"));

                adapter.addItem(rest);
            }
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("JSON Parsing Error",e.getMessage());
        }
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Bundle bun = msg.getData();
            String str = bun.getString("jsonGap");

            jsonParsing(str);
            return true;
        }
    });

/*    public void makeRequest() {
        String url = binding.editText.getText().toString();

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답 -> " + response);

                        processResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                println("에러 -> " + error.getMessage());
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
        println("요청 보냄.");
    }

    public void println(String data) {
        Log.d("b1a4", data);
    }


    public void processResponse(String response) {
        Gson gson = new Gson();
        RestaurantList RestaurantList = gson.fromJson(response, RestaurantList.class);

        println("식당 수 : " + RestaurantList.restaurant.size());

        for (int i = 0; i < RestaurantList.restaurant.size(); i++) {
            Rest rest = RestaurantList.restaurant.get(i);

            println("출력 : " + rest);
        }
        adapter.notifyDataSetChanged();
    }*/
}
