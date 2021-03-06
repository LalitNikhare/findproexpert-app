package com.example.com.findproexperttabbed;

import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by HP on 3/10/2017.
 */
public class JSONNotification {
    private static final String JSON_ARRAY1 = "result";
    private static final String KEY_ACCEPT = "accept";
    private static final String KEY_REQUEST_STR = "request_string";
    private static final String KEY_REQUEST_ID = "srno";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_FNAME = "first_name";
    private static final String KEY_LNAME = "last_name";
    private static final String KEY_DOMAIN = "profession_name";
    private static final String KEY_CUST_USERNAME = "cust_username";
    private static final String KEY_PROF_USERNAME = "prof_username";
    private static final String KEY_PRICE = "price";
    private static final String KEY_JOB_ACCEPTED = "job_accepted";
    private static final String KEY_JOB_DONE = "job_done";

    public static int[] request_id;
    public static String[] request;
    public static String[] request_prof;
    public static  int[] accept;
    public static String[] prof_username;
    public static String[] cust_username;
    public static String[] fname;
    public static String[] lname;
    public static String[] domain;
    public static String[] price;
    public static int[] job_done;
    public static int[] job_accepted;
    private JSONArray users = null;
    private String json;

    public JSONNotification(String json) {
        this.json = json;
    }

    public void parseJSONforCustNot() {
        JSONObject jsonObject;
        try {

            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY1);
            request = new String[users.length()];
            accept = new int[users.length()];
            request_id=new int[users.length()];
            domain=new String[users.length()];

            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                request[i] = jo.getString(KEY_REQUEST_STR);
                accept[i] = Integer.parseInt(jo.getString(KEY_ACCEPT));
                request_id[i]=Integer.parseInt(jo.getString(KEY_REQUEST_ID));
                domain[i]=jo.getString(KEY_DOMAIN);
            }
        } catch (JSONException e) {
            Log.d("Error", "Bug in JSONProfessional");
            e.printStackTrace();
        }
    }
    public void parseJSONforProfNot() {
        JSONObject jsonObject;
        try {

            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY1);
            request_prof = new String[users.length()];
            fname=new String[users.length()];
            lname=new String[users.length()];
            cust_username=new String[users.length()];


            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                request_prof[i] = jo.getString(KEY_REQUEST_STR);
                fname[i]=jo.getString(KEY_FNAME);
                lname[i]=jo.getString(KEY_LNAME);
                cust_username[i]=jo.getString(KEY_CUST_USERNAME);
            }
        } catch (JSONException e) {
            Log.d("Error", "Bug in JSONProfessional");
            e.printStackTrace();
        }
    }
    public void parseForProfessionalResponded() {
        JSONObject jsonObject;
        try {

            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY1);
            prof_username = new String[users.length()];
            price=new String[users.length()];
            fname = new String[users.length()];
            lname=new String[users.length()];
            job_done=new int[users.length()];
            job_accepted=new int[users.length()];

            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                job_accepted[i]=jo.getInt(KEY_JOB_ACCEPTED);
                job_done[i]=jo.getInt(KEY_JOB_DONE);
                price[i]=String.valueOf(jo.getInt(KEY_PRICE));
                prof_username[i] = jo.getString(KEY_USERNAME);
                fname[i] = (jo.getString(KEY_FNAME));
                lname[i]=(jo.getString(KEY_LNAME));
            }
        } catch (JSONException e) {
            Log.d("Error", "Bug in JSONProfessional");
            e.printStackTrace();
        }
    }
    public void parseJSONforFeedBack() {
        JSONObject jsonObject;
        try {

            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY1);
            prof_username = new String[users.length()];
            request=new String[users.length()];
            request_id=new int[users.length()];
            fname = new String[users.length()];
            lname=new String[users.length()];

            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                prof_username[i] = jo.getString(KEY_PROF_USERNAME);
                fname[i] = (jo.getString(KEY_FNAME));
                lname[i]=(jo.getString(KEY_LNAME));
                request[i]=jo.getString(KEY_REQUEST_STR);
                request_id[i]= Integer.parseInt(jo.getString(KEY_REQUEST_ID));
            }
        } catch (JSONException e) {
            Log.d("Error", "Bug in JSONProfessional");
            e.printStackTrace();
        }
    }

}
