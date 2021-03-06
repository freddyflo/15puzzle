package com.telecom_sudparis.abdallah.puzzle15v2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Fred on 05-Feb-16.
 */
public class GameLevel extends AppCompatActivity {

    Button snailbtn;
    Button walkbtn;
    Button runbtn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_game_level);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        final Context context = this;
        snailbtn = (Button) findViewById(R.id.snailId);
        walkbtn = (Button) findViewById(R.id.walkId);
        runbtn = (Button) findViewById(R.id.runId);
        // Snail Mode ( Easy Mode )
        snailbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                MainActivity.random = 4;
                MainActivity.seed = 2;
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }

        });

        // Walk Mode ( Mode Mode )
        walkbtn.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View arg0) {
                MainActivity.random = 25;
                MainActivity.seed = 1;
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }

        });
        runbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                MainActivity.random = 27;
                MainActivity.seed = 1;
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}
