package com.example.test.isrty.produitprosoftmobile;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Toast;

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
import java.nio.Buffer;
import java.util.ArrayList;

import static com.example.test.isrty.produitprosoftmobile.Consulter.rechechfilter;

/**
 * Created by isrty on 19-Nov-17.
 */

public class fetchdata extends AsyncTask<Void,Void,Void> {
    String data ="";
    String parseddata ="";
    String data1 ="";
    String parseddata1 ="";
    public static ArrayList<String> x=new ArrayList<String>();
   public static ArrayAdapter<String> m;
    @Override
    public Void doInBackground(Void... voids) {

        try {


            URL url = new URL("https://api.myjson.com/bins/1g6nov");
            //URL url = new URL("http://192.168.43.89:8099/listProduct");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
            String line ="";
            while (line !=null)            {
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONArray j =new JSONArray(data);
            for (int i = 0; i <j.length() ; i++) {
                JSONObject jo = j.getJSONObject(i);
                String id = jo.getString("id");
                String produit = jo.getString("name_template");
                x.add("id="+id+" nom produit="+produit +"\n");
            }


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

      m=new ArrayAdapter<String>(Consulter.context,android.R.layout.simple_list_item_1,x);
        Consulter.data.setAdapter(m);
       /* rechechfilter.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                m.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { }

            @Override
            public void afterTextChanged(Editable arg0) {}
        });*/

    }


}
