package com.example.gamix;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnSignUp,login,signin,back,back2;
    LinearLayout userPassL,userPassS;
    TextView btnLogin2,btnSignUp2;
    EditText txtUser,txtPass,emailId,uName,pWord;
    private MyDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Gamix App");
        }

        btnLogin = findViewById(R.id.btnLogin);             //Login Button
        btnSignUp = findViewById(R.id.btnSignUp);           //Signup Button
        userPassL = findViewById(R.id.userPassL);           //Login details
        btnLogin2 = findViewById(R.id.btnLogin2);           //login text button
        login = findViewById(R.id.login);                   //Enter button
        userPassS = findViewById(R.id.userPassS);           //Signup details
        btnSignUp2 = findViewById(R.id.btnSignUp2);         //signup text button
        signin = findViewById(R.id.signin);                 //Enter button
        back = findViewById(R.id.back);back2 = findViewById(R.id.back2);    //Go back
        txtUser = findViewById(R.id.txtUser);               //Login username
        txtPass = findViewById(R.id.txtPass);               //Login password
        emailId = findViewById(R.id.emailId);               //Sign in email
        uName = findViewById(R.id.uName);                   //Sign in username
        pWord = findViewById(R.id.pWord);                   //Sign in password
        
        myDb = new MyDatabase(MainActivity.this);   //Initialise database
        myDb.addSetting("abcd@mail.com","admin","adminpass");

//        String usrname = "admin";
//        Intent i = new Intent(MainActivity.this,GameList.class);
//        Bundle b = new Bundle();
//        b.putString("userName",usrname);
//        i.putExtras(b);
//        startActivity(i);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
//                    ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
////                    for(int i = 400; i >= 300; i--)
//                        p.setMargins(0,300,0,0);
//                    v.requestLayout();
//                }
                btnLogin.setTranslationY(-200);
                userPassL.setTranslationY(-200);
                userPassL.setVisibility(View.VISIBLE);
                userPassS.setVisibility(View.GONE);
                btnSignUp.setVisibility(View.GONE);
                txtUser.setText("");
                txtPass.setText("");
                emailId.setText("");
                uName.setText("");
                pWord.setText("");
            }
        });
        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogin.setTranslationY(-200);
                userPassL.setTranslationY(-200);
                userPassL.setVisibility(View.VISIBLE);
                userPassS.setVisibility(View.GONE);
                btnSignUp.setVisibility(View.GONE);
                btnLogin.setVisibility(View.VISIBLE);
                txtUser.setText("");
                txtPass.setText("");
                emailId.setText("");
                uName.setText("");
                pWord.setText("");
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
//                    ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
//                    p.setMargins(0,300,0,0);
//                    v.requestLayout();
//                }
                btnSignUp.setTranslationY(390);
                userPassS.setTranslationY(390);
                userPassS.setVisibility(View.VISIBLE);
                userPassL.setVisibility(View.GONE);
                btnLogin.setVisibility(View.GONE);
                txtUser.setText("");
                txtPass.setText("");
                emailId.setText("");
                uName.setText("");
                pWord.setText("");
            }
        });
        btnSignUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSignUp.setTranslationY(390);
                userPassS.setTranslationY(390);
                userPassS.setVisibility(View.VISIBLE);
                userPassL.setVisibility(View.GONE);
                btnLogin.setVisibility(View.GONE);
                btnSignUp.setVisibility(View.VISIBLE);
                txtUser.setText("");
                txtPass.setText("");
                emailId.setText("");
                uName.setText("");
                pWord.setText("");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            userPassL.setVisibility(View.GONE);
            userPassS.setVisibility(View.GONE);
            btnLogin.setVisibility(View.VISIBLE);
            btnSignUp.setVisibility(View.VISIBLE);
            btnSignUp.setTranslationY(0);
            btnLogin.setTranslationY(0);
            txtUser.setText("");
            txtPass.setText("");
            emailId.setText("");
            uName.setText("");
            pWord.setText("");
            }
        });
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPassL.setVisibility(View.GONE);
                userPassS.setVisibility(View.GONE);
                btnLogin.setVisibility(View.VISIBLE);
                btnSignUp.setVisibility(View.VISIBLE);
                btnSignUp.setTranslationY(0);
                btnLogin.setTranslationY(0);
            }
        });
        
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrname = txtUser.getText().toString();
                String pssword = txtPass.getText().toString();
//                Toast.makeText(MainActivity.this, "this is chck"+checkpass, Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, "this is wrtn"+pssword, Toast.LENGTH_SHORT).show();
                if (myDb.check(usrname,pssword)) {
                    Toast.makeText(MainActivity.this, "Login Succesfull!", Toast.LENGTH_SHORT).show();
                    txtUser.setText("");
                    txtPass.setText("");
                    Intent i = new Intent(MainActivity.this,GameList.class);
                    Bundle b = new Bundle();
                    b.putString("userName",usrname);
                    i.putExtras(b);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid User! Try creating one.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String usrname = uName.getText().toString();
                String pssword = pWord.getText().toString();
//                Toast.makeText(MainActivity.this, email+" is email", Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, usrname+" is user", Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this, pssword+" is pass", Toast.LENGTH_SHORT).show();
                if (email.equals("") || usrname.equals("") || pssword.equals("")){
                    Toast.makeText(MainActivity.this, "Text fields Cannot be Empty!", Toast.LENGTH_SHORT).show();
                }
                else if (myDb.doublEntryEmail(email)){
                    Toast.makeText(MainActivity.this, "This Email/Username already exists!", Toast.LENGTH_SHORT).show();
                }
                else if (myDb.doublEntryUser(usrname)){
                    Toast.makeText(MainActivity.this, "This Email/Username already exists!", Toast.LENGTH_SHORT).show();
                }
                else {
                    myDb.insert(email,usrname,pssword);
                    Toast.makeText(MainActivity.this, "Registered Succesfully!", Toast.LENGTH_SHORT).show();
                    emailId.setText("");
                    uName.setText("");
                    pWord.setText("");
                    Toast.makeText(MainActivity.this, "Login Using Registered Username", Toast.LENGTH_SHORT).show();
                    userPassL.setVisibility(View.GONE);
                    userPassS.setVisibility(View.GONE);
                    btnLogin.setVisibility(View.VISIBLE);
                    btnSignUp.setVisibility(View.VISIBLE);
                    btnSignUp.setTranslationY(0);
                    btnLogin.setTranslationY(0);
                }
            }
        });
    }
}