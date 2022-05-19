package ru.vlad.proect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class EndActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        int scores = getIntent().getIntExtra("scores", 0);
        TextView result = findViewById(R.id.textView);
        TextView message = findViewById(R.id.textView3);
        String resultMessage = "Вы набрали " + scores + " очков!";
        String messageText = "";
        result.setText(resultMessage);
        if (scores > 40) {
            messageText = "Вы спец по музыке!";
        }
        else {
            messageText = "Вам нужно потренироваться!";
        }
        message.setText(messageText);
        Button btnHome = findViewById(R.id.home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EndActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
