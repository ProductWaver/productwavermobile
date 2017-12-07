package com.example.test.isrty.produitprosoftmobile;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by isrty on 01-Dec-17.
 */

public class SendDeviceDetails extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {

        String data = "";

        HttpURLConnection httpURLConnection = null;
        try {

            httpURLConnection = (HttpURLConnection) new URL(params[0]).openConnection();
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Cache-Control", "no-cache");




            DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
            JSONObject jsonObj = new JSONObject(params[1]);
            wr.writeBytes(
                    "ean13="+jsonObj.getString("ean13")+
                      "&referance="+jsonObj.getString("referance")+
                      "&prix="+jsonObj.getString("prix")+
                      "&name="+jsonObj.getString("name")+
                      "&discription="+jsonObj.getString("discription")
            );


            System.out.println(params[1]);
            wr.flush();
            wr.close();

            InputStream in = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);

            int inputStreamData = inputStreamReader.read();
            while (inputStreamData != -1) {
                char current = (char) inputStreamData;
                inputStreamData = inputStreamReader.read();
                data += current;
            }
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return data;



    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.e("TAG", result); // this is expecting a response code to be sent from your server upon receiving the POST data
    }
}
