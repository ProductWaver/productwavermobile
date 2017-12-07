package com.example.test.isrty.produitprosoftmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by isrty on 27-Nov-17.
 */

public class gabareproduit extends AppCompatActivity {
  ImageView E;
  Button b;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gabareproduit);
        E=(ImageView) findViewById(R.id.imgprod);
        b=(Button) findViewById(R.id.button5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DownloadImageTask(E).execute("http://192.168.137.1:8069/web/binary/image?model=product.template&id=9&field=image_medium&t=1511821108711");
            }
        });

    }
}
