package com.example.test.isrty.produitprosoftmobile;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.text.TextWatcher;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by isrty on 25-Nov-17.
 */
public   class Consulter extends AppCompatActivity {
    public static ListView data;
    Button btn;
    public static Context context;
    public static ArrayList<String> m;
   public  static EditText rechechfilter;
    ArrayAdapter<String> adapt;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.odoocolor));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulter);
        data = (ListView) findViewById(R.id.Listarticle) ;
        btn =(Button) findViewById(R.id.Refresh);
        context = Consulter.this;
       final fetchdata pro =new fetchdata();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pro.execute();


            }

        });
         data.setTextFilterEnabled(true);
        System.out.println("zzcgckkckgkcghkg");


    }



}