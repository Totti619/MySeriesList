package com.example.antonio.project;

import com.example.antonio.project.api.API;
import com.example.antonio.project.api.OMDBAPI;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void api_request_test() {

        Map<String, String> map = new HashMap<String, String>();
        map.put(OMDBAPI.Param.API, OMDBAPI.Option.API_VALUE);
        map.put(OMDBAPI.Param.TITLE, "Finding Nemo");
        API api = OMDBAPI.getInstance()
            .createRequest(map)
        ;
        assertEquals("http://www.omdbapi.com/?apikey=34ab1e6f&t=Finding+Nemo",api.getRequest());
    }
    @Test
    public void api_json_test() {
        JSONObject json=null;
        try {
            json = new JSONObject("{\n" +
                    "  \"Search\": [\n" +
                    "    {\n" +
                    "      \"Title\": \"Fantastic Beasts and Where to Find Them\",\n" +
                    "      \"Year\": \"2016\",\n" +
                    "      \"imdbID\": \"tt3183660\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjMxOTM1OTI4MV5BMl5BanBnXkFtZTgwODE5OTYxMDI@._V1_SX300.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Title\": \"Find Me Guilty\",\n" +
                    "      \"Year\": \"2006\",\n" +
                    "      \"imdbID\": \"tt0419749\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTc4MzI2NzA0N15BMl5BanBnXkFtZTcwNTc2OTIzMQ@@._V1_SX300.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Title\": \"Come and Find Me\",\n" +
                    "      \"Year\": \"2016\",\n" +
                    "      \"imdbID\": \"tt2597768\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMjIzMTMzMjgzMV5BMl5BanBnXkFtZTgwODg2ODI0MDI@._V1_SX300.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Title\": \"Tum Bin...: Love Will Find a Way\",\n" +
                    "      \"Year\": \"2001\",\n" +
                    "      \"imdbID\": \"tt0290326\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BZGM0MzY0NmQtZTVmNy00MTA0LWFiZTQtNDYxNjA5ZjEyYzhkXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Title\": \"Find Me\",\n" +
                    "      \"Year\": \"2014\",\n" +
                    "      \"imdbID\": \"tt3027188\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BOTcxNjQ1NjY1NF5BMl5BanBnXkFtZTgwNTM5MjI1MDE@._V1_SX300.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Title\": \"You'll Find Out\",\n" +
                    "      \"Year\": \"1940\",\n" +
                    "      \"imdbID\": \"tt0033283\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"http://ia.media-imdb.com/images/M/MV5BNDQxZDQxMTUtZTdkOS00YjQ3LThhNmQtZWU5YjQxMzRjZDE1XkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_SX300.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Title\": \"Somewhere I'll Find You\",\n" +
                    "      \"Year\": \"1942\",\n" +
                    "      \"imdbID\": \"tt0035356\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BZTZkOTg0YWQtOTMzNi00NDY1LThjNmUtOGMyMTUzOWE1ZTExXkEyXkFqcGdeQXVyMTk2MzI2Ng@@._V1_SX300.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Title\": \"Precious Find\",\n" +
                    "      \"Year\": \"1996\",\n" +
                    "      \"imdbID\": \"tt0117373\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTI1NzYyODEzM15BMl5BanBnXkFtZTYwNDM4Mzk4._V1_SX300.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Title\": \"Someday You'll Find Her, Charlie Brown\",\n" +
                    "      \"Year\": \"1981\",\n" +
                    "      \"imdbID\": \"tt0174226\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMTg0ODQxMzU0NV5BMl5BanBnXkFtZTcwMTE0ODgyMQ@@._V1_SX300.jpg\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"Title\": \"Gold Is Where You Find It\",\n" +
                    "      \"Year\": \"1938\",\n" +
                    "      \"imdbID\": \"tt0030192\",\n" +
                    "      \"Type\": \"movie\",\n" +
                    "      \"Poster\": \"https://images-na.ssl-images-amazon.com/images/M/MV5BMzM3Nzg2ZDktOGZhOC00MjhjLWExMWUtMzFmZjQ5ZjdmZTdkXkEyXkFqcGdeQXVyNjc0MzMzNjA@._V1_SX300.jpg\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"totalResults\": \"299\",\n" +
                    "  \"Response\": \"True\"\n" +
                    "}");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put(OMDBAPI.Param.API, OMDBAPI.Option.API_VALUE);
        map.put(OMDBAPI.Param.SEARCH, "Find");
        JSONObject json2 = OMDBAPI.getInstance()
                .createRequest(map)
                .send()
                .getJson()
                ;

            assertEquals(json,json2);

    }
}