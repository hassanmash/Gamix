package com.example.gamix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameList extends AppCompatActivity {
TextView textButton,logOut;
Button cod,val,csgo,amngus,mine,gta5,fifa,pes,re,nfs;
Bundle b;
String gameName;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_list);
        b = this.getIntent().getExtras();

        textButton = findViewById(R.id.textButton);
        logOut = findViewById(R.id.logOut);

        cod = findViewById(R.id.cod);
        val = findViewById(R.id.val);
        csgo = findViewById(R.id.csgo);
        amngus = findViewById(R.id.amngus);
        mine = findViewById(R.id.mine);
        gta5 = findViewById(R.id.gta5);
        fifa = findViewById(R.id.fifa);
        pes = findViewById(R.id.pes);
        re = findViewById(R.id.re);
        nfs = findViewById(R.id.nfs);

        String userName = b.getString("userName");
        textButton.setText(userName);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(GameList.this,MainActivity.class);
//                startActivity(i);
                onBackPressed();
            }
        });
        cod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "cod";
                b.putString("gameNames",gameName);
//                b.putString("userNames",b.getString(userName));
                i.putExtras(b);
                startActivity(i);
            }
        });
        val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "val";
                b.putString("gameNames",gameName);
//                b.putString("userNames",b.getString(userName));
                i.putExtras(b);
                startActivity(i);
            }
        });
        csgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "csgo";
                b.putString("gameNames",gameName);
//                b.putString("userNames",b.getString(userName));
                i.putExtras(b);
                startActivity(i);
            }
        });
        amngus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "amngus";
                b.putString("gameNames",gameName);
//                b.putString("userNames",b.getString(userName));
                i.putExtras(b);
                startActivity(i);
            }
        });
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "mine";
                b.putString("gameNames",gameName);
//                b.putString("userNames",b.getString(userName));
                i.putExtras(b);
                startActivity(i);
            }
        });
        gta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "gta5";
                b.putString("gameNames",gameName);
//                b.putString("userNames",b.getString(userName));
                i.putExtras(b);
                startActivity(i);
            }
        });
        fifa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "fifa";
                b.putString("gameNames",gameName);
//                b.putString("userNames",b.getString(userName));
                i.putExtras(b);
                startActivity(i);
            }
        });
        pes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "pes";
                b.putString("gameNames",gameName);
//                b.putString("userNames",b.getString(userName));
                i.putExtras(b);
                startActivity(i);
            }
        });
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "re";
                b.putString("gameNames",gameName);
                i.putExtras(b);
                startActivity(i);
            }
        });
        nfs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameList.this,GameDetails.class);
                Bundle b = new Bundle();
                gameName = "nfs";
                b.putString("gameNames",gameName);
//                b.putString("userNames",b.getString(userName));
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
