package com.example.antonio.project;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.antonio.project.api.OMDBAPI;
import com.example.antonio.project.api.SendRequestTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ResultActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private OMDBAPI omdbapi = OMDBAPI.getInstance();
    private Map<String, String> params;
    private JSONObject json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mRecyclerView = (RecyclerView) findViewById(R.id.activity_result_recycler_view);

        Bundle bundle = getIntent().getExtras();

        params = new HashMap<String, String>();
        params.put(OMDBAPI.Param.API, OMDBAPI.Option.API_VALUE);
        params.put(OMDBAPI.Param.SEARCH, bundle.getString("search"));
        params.put(OMDBAPI.Param.TYPE,  bundle.getString("type"));

        try {
            json = new SendRequestTask(params)
                .execute()
                .get()
            ;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        try {
            mAdapter = new ResultActivityAdapter(json.getJSONArray("Search"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        mAdapter = new ResultActivityAdapter((String[]) myDataset.toArray());
        mRecyclerView.setAdapter(mAdapter);
    }


}
