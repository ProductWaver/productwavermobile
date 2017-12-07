package com.example.test.isrty.produitprosoftmobile;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;




import org.json.JSONException;
import org.json.JSONObject;



/**
 * Created by isrty on 26-Nov-17.
 */

public class Ajout extends AppCompatActivity {
    EditText ean13;
    EditText ref;
    EditText prix;
    EditText name;
    EditText discription;
    Button btnadd;
    TabHost tabHost;
    putajout x=new putajout();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.odoocolor));
       /* ActionBar actionBar = getActionBar();
        actionBar.show();*/

        TabHost host = (TabHost)findViewById(R.id.xm);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Tab One");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab Two");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab Three");
        host.addTab(spec);
         ean13=(EditText)findViewById(R.id.editean13);
         ref=(EditText)findViewById(R.id.editref);
         prix=(EditText)findViewById(R.id.editprix);
         name=(EditText)findViewById(R.id.editproductname);
         discription=(EditText)findViewById(R.id.editdiscription);
         btnadd=(Button)findViewById(R.id.btnaddproductx);

         btnadd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
//              x.dowhenexe();

                     JSONObject postData = new JSONObject();
                     try {
                         postData.put("ean13", ean13.getText().toString());
                         postData.put("referance", ref.getText().toString());
                         postData.put("prix", prix.getText().toString());
                         postData.put("name", name.getText().toString());
                         postData.put("discription", discription.getText().toString());



                         //new SendDeviceDetails().execute("http://192.168.43.89:8099/addProduct", postData.toString());
                         new SendDeviceDetails().execute("http://192.168.137.1:3000/posts/1", postData.toString());
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }

             }
         });


    }
   /* public  String POST(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("name", ean13.getText().toString());
            jsonObject.accumulate("referance", ref.getText().toString());
            jsonObject.accumulate("prix", prix.getText().toString());
            jsonObject.accumulate("name", name.getText().toString());
            jsonObject.accumulate("discription", discription.getText().toString());

            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // ** Alternative way to convert Person object to JSON string usin Jackson Lib
            // ObjectMapper mapper = new ObjectMapper();
            // json = mapper.writeValueAsString(person);

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);

            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        // 11. return result
        return result;
    }
    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {



            return POST(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Data Sent!", Toast.LENGTH_LONG).show();
        }
    }*/
}
