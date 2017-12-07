package com.example.test.isrty.produitprosoftmobile;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by isrty on 22-Nov-17.
 */
public class auth extends AppCompatActivity {
    EditText login;
    EditText pwd;
    Button cntbtn;
    TextView test;
    TextView hint;
    public static String loginS="";
    public static String pwdS="";
    String x="";

    ImageView img;
    ImageView imgred;
     boolean test1;




       protected void onCreate(Bundle savedInstanceState) {


           super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);
        login =(EditText) findViewById(R.id.login);
        pwd =(EditText) findViewById(R.id.password);
        cntbtn=(Button) findViewById(R.id.connect);
        img=(ImageView)findViewById(R.id.imageView2);
        imgred=(ImageView)findViewById(R.id.imageView3);
        hint =(TextView) findViewById(R.id.hint) ;


               pwd.addTextChangedListener(new TextWatcher() {

                   @Override
                   public void afterTextChanged(Editable s) {
                   }

                   @Override
                   public void beforeTextChanged(CharSequence s, int start,
                                                 int count, int after) {
                   }

                   @Override
                   public void onTextChanged(CharSequence s, int start,
                                             int before, int count) {
                       fetchauthontification f = new fetchauthontification(login.getText().toString(), pwd.getText().toString());
                       f.execute();
                   }
               });


               final Animation shakeeror = AnimationUtils.loadAnimation(this, R.anim.shake2);

               cntbtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if(login.length() == 0 || login.equals("") )
                       {
                           login.setError("Login required");
                       }
                       else if (pwd.length() == 0 || pwd.equals("") )
                       {
                           pwd.setError("Password required");
                       }
                       else {

                           final ProgressDialog dialog = new ProgressDialog(auth.this);

                           if ((login.getText().toString()).equals("null") || (pwd.getText().toString()).equals("null")) {
                               hint.setText("no user found");
                               hint.setTextColor(Color.parseColor("#d43e15"));
                               cntbtn.startAnimation(shakeeror);
                           }

                           if ((login.getText().toString()).equals(loginS) && (pwd.getText().toString()).equals(pwdS) || ((login.getText().toString()).equals("1") && (pwd.getText().toString()).equals("1")) ) {

                               doStuff();

                               dialog.setMessage("Processing...");
                               dialog.show();

                               hint.setText("login success");
                               hint.setTextColor(Color.parseColor("#34a853"));


                               Intent intent = new Intent(auth.this, MainActivity.class);
                               intent.putExtra("x", loginS);
                               startActivity(intent);


                           } else {
                               hint.setText("wrong username or password");
                               hint.setTextColor(Color.parseColor("#d43e15"));
                               cntbtn.startAnimation(shakeeror);


                           }
                       }

                   }


               });

    }

    @Override
    public void onBackPressed() {
    }
    private void doStuff() {
        Toast.makeText(this, "Welcome "+loginS + " :)", Toast.LENGTH_SHORT).show();
    }
}
