package com.example.antonio.project.api;

import java.util.Map;

/**
 * Created by Antonio Ortiz on 13/03/2018.
 */

public abstract class API implements Singletonable, Requestable { // TODO create class Params for improving code

    protected static API INSTANCE;
    protected String request;

    protected API(){}

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public abstract API clone() throws CloneNotSupportedException;

    @Override
    public API createRequest(String url, Map<String, String> params) {
        StringBuffer urlBuffer = new StringBuffer(url);
        boolean first=true;
        for (Map.Entry<String, String> entry: params.entrySet()) {
            urlBuffer
                    .append(first?'?':'&')
                    .append(entry.getKey())
                    .append('=')
                    .append(entry.getValue())
            ;
            first=false;
        }
        request=urlBuffer.toString();
        return this;
    }
}
