package com.example.antonio.project.api;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Antonio Ortiz on 14/03/2018.
 */

public class SendRequestTask extends AsyncTask<String, String, JSONObject> {

    Map<String, String> params;

    public SendRequestTask(Map<String, String> params) {
        this.params=params;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {
        return OMDBAPI.getInstance()
                .createRequest(params)
                .send()
                .getJson()
                ;
    }
}
