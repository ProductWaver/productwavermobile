package com.example.test.isrty.produitprosoftmobile;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by isrty on 24-Nov-17.
 */

public class fetchauthontification extends AsyncTask<Void,Void,Void> {

    String data1="";
    String loginn="";
    String password="";
    String usertype="";
   String log;
    String pwd;
    String testurl;
    public fetchauthontification(String log,String pwd)         // construteur pour parametrer le lien
    {
        this.log=log;
        this.pwd=pwd;
    }
    @Override
    protected Void doInBackground(Void... voids) {

        try {


          // URL url = new URL("http://192.168.43.89:8099/getUser/"+log+"/"+pwd);//lien parametrable
            URL url = new URL("https://api.myjson.com/bins/17bhkf");
           // testurl="http://192.168.8.8:8099/"+log+"/"+pwd;
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
            String line ="";
            while (line !=null)            {
                line = bufferedReader.readLine();
                data1 = data1 + line;
            }
                JSONObject j =new JSONObject(data1);

                loginn = j.getString("username");
                password = j.getString("password");
                usertype = j.getString("signature");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void aVoid) {

        auth.loginS=loginn;
        auth.pwdS=password;
        MainActivity.usertypestatic=usertype;
        System.out.println(testurl);


    }

}
