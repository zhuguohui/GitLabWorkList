package org.example.api;

public class QueryBean {
   public final String baseUrl;
    public final   String token;
    public final  String name;
    public final  String startTime;
    public final  String endTime;

    public QueryBean(String baseUrl, String token, String name, String startTime, String endTime) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
