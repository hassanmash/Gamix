package com.example.gamix;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameList extends AppCompatActivity {
TextView textbutton ;
Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_list);
        b = this.getIntent().getExtras();

        textbutton = findViewById(R.id.textbutton);

        textbutton.setText(b.getString("userName","This is default!"));
    }
}
