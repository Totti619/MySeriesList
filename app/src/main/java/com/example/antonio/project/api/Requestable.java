package com.example.antonio.project.api;

import java.util.Map;

/**
 * Created by Antonio Ortiz on 13/03/2018.
 */

interface Requestable {
    Requestable createRequest(String url, Map<String, String> params);
}
