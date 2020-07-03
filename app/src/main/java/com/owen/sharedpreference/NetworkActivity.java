package com.owen.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NetworkActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CatsAdapter mCatsAdapter;
    private ArrayList<CatsShowGrounds> mCatsLits;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mCatsLits = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);

        //call the JSON method
        parseJsonData();

    }

    public void parseJsonData()
    {
        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONArray jsonArray = response.getJSONArray("hits");
                            //get all json objects

                            for (int i = 0 ;i<jsonArray.length(); i++)
                            {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String creatorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int likesCount = hit.getInt("likes");

                                mCatsLits.add(new CatsShowGrounds(imageUrl, creatorName, likesCount));
                            }
                            mCatsAdapter = new CatsAdapter(NetworkActivity.this, mCatsLits);
                            mRecyclerView.setAdapter(mCatsAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        mRequestQueue.add(request);

    }

}