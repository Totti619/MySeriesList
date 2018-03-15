package com.example.antonio.project.api;

import org.json.JSONException;
import org.json.JSONObject;
import java.net.*;
import java.io.*;

import java.util.Map;

/**
 * Created by Antonio Ortiz on 13/03/2018.
 */

public class OMDBAPI extends API implements RESTRequestable {

    private static final String URL = "http://www.omdbapi.com/";
    private JSONObject json;

    private OMDBAPI() {
        super();
    }

    public JSONObject getJson() {
        return json;
    }

    public static OMDBAPI getInstance() {
        if(INSTANCE==null)
            INSTANCE=new OMDBAPI();
        return (OMDBAPI) INSTANCE;
    }

    @Override
    public OMDBAPI clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public OMDBAPI createRequest(Map<String, String> params) {
        super.createRequest(URL, params);
        request=request.replace(" ","+");
        return this;
    }

    @Override
    public OMDBAPI send() {
        URL url=null;
        BufferedReader bufferedReader=null;
        StringBuffer stringBuffer=new StringBuffer();
        try {
            url = new URL(request);
            bufferedReader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String string;
            while((string=bufferedReader.readLine())!=null)
                stringBuffer.append(string);
            bufferedReader.close();
            json=new JSONObject(
                    stringBuffer.toString()
            );
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public static class Param {
        public static final String
            // By ID or Title
            ID = "i",
            TITLE = "t",
            TYPE="type",
            YEAR = "y",
            PLOT="plot",
            DATA_TYPE="r",
            CALLBACK="callback",
            API_VERSION="v",
            // By Search
            SEARCH="s",
            PAGE="page",
            API =   "apikey"
        ;
    }
    public static class Option {
        public static final String
            TYPE_MOVIE="movie",
            TYPE_SERIES="series",
            TYPE_EPISODE="episode",
            API_VALUE = "34ab1e6f",
            DATA_TYPE_JSON="json",
            DATA_TYPE_XML="xml"
        ;
    }
}
