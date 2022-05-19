package ru.vlad.proect;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SSSR extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private Button playButton;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private TextView scoresView;



    private int scores = 0;
    private Game game;

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        answer1 = (Button)findViewById(R.id.button7);
        answer2 = (Button)findViewById(R.id.button6);
        answer3 = (Button)findViewById(R.id.button8);
        answer4 = (Button)findViewById(R.id.button2);
        //////////////////////

        RightClickListener rightClickListener = new RightClickListener();
        WrongClickListener wrongClickListener = new WrongClickListener();
        answer1.setOnClickListener(rightClickListener);
        answer2.setOnClickListener(wrongClickListener);
        answer3.setOnClickListener(wrongClickListener);
        answer4.setOnClickListener(wrongClickListener);

        game = new Game();
        Level level = game.getCurrentLevel();
//        mPlayer= MediaPlayer.create(this, Integer.parseInt(level.getRightMusicText()));
//        mPlayer= MediaPlayer.create(this, 2131689473);
        int drawableResourceId = this.getResources().getIdentifier(level.getRightMusicText(), "raw", this.getPackageName());
        mPlayer= MediaPlayer.create(this, drawableResourceId);
        scoresView = (TextView)findViewById(R.id.scoresView);
        scoresView.setText("0");
        scores = Integer.parseInt(scoresView.getText().toString());
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });
        playButton = findViewById(R.id.btnPlay);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayer.start();
            }
        });
    }

    private void stopPlay(){
        mPlayer.stop();
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
            playButton.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void changeButtons() {
        Level currentLevel = game.getCurrentLevel();
        int rightButtonNumber = (int)Math.round(Math.random() * 4);
        RightClickListener rightClickListener = new RightClickListener();
        WrongClickListener wrongClickListener = new WrongClickListener();
        int drawableResourceId = this.getResources().getIdentifier(currentLevel.getRightMusicText(), "raw", this.getPackageName());
        mPlayer= MediaPlayer.create(this, drawableResourceId);
        switch (rightButtonNumber) {
            case 1:
                answer1.setOnClickListener(rightClickListener);
                answer1.setText(currentLevel.getRightMusicText());

                answer2.setOnClickListener(wrongClickListener);
                answer2.setText(currentLevel.getWrongMusicTextList().get(0));

                answer3.setOnClickListener(wrongClickListener);
                answer3.setText(currentLevel.getWrongMusicTextList().get(1));

                answer4.setOnClickListener(wrongClickListener);
                answer4.setText(currentLevel.getWrongMusicTextList().get(2));
                break;
            case 2:
                answer1.setOnClickListener(wrongClickListener);
                answer1.setText(currentLevel.getWrongMusicTextList().get(0));

                answer2.setOnClickListener(rightClickListener);
                answer2.setText(currentLevel.getRightMusicText());

                answer3.setOnClickListener(wrongClickListener);
                answer3.setText(currentLevel.getWrongMusicTextList().get(1));

                answer4.setOnClickListener(wrongClickListener);
                answer4.setText(currentLevel.getWrongMusicTextList().get(2));
                break;
            case 3:
                answer1.setOnClickListener(wrongClickListener);
                answer1.setText(currentLevel.getWrongMusicTextList().get(0));

                answer2.setOnClickListener(wrongClickListener);
                answer2.setText(currentLevel.getWrongMusicTextList().get(1));

                answer3.setOnClickListener(rightClickListener);
                answer3.setText(currentLevel.getRightMusicText());

                answer4.setOnClickListener(wrongClickListener);
                answer4.setText(currentLevel.getWrongMusicTextList().get(2));
                break;
            case 4:
                answer1.setOnClickListener(wrongClickListener);
                answer1.setText(currentLevel.getWrongMusicTextList().get(0));

                answer2.setOnClickListener(wrongClickListener);
                answer2.setText(currentLevel.getWrongMusicTextList().get(1));

                answer3.setOnClickListener(wrongClickListener);
                answer3.setText(currentLevel.getWrongMusicTextList().get(2));

                answer4.setOnClickListener(rightClickListener);
                answer4.setText(currentLevel.getRightMusicText());
                break;
            default:
                return;
        }

    }

    private void endGame() {
        Intent intent = new Intent(SSSR.this, EndActivity.class);
        intent.putExtra("scores", game.getScores());
        startActivity(intent);
    }

    class RightClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            game.addScores();

            if (game.getLevelsSize() == game.getCurrentLevelNumber()) {
                endGame();
            }
            else {
                scoresView.setText(((Integer) game.getScores()).toString());
                stopPlay();
                changeButtons();
            }
        }
    }


    //Обработсик неправильного ответа
    class WrongClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            game.removeScores();
            if (game.getLevelsSize() == game.getCurrentLevelNumber()) {
                endGame();
            }
            else {
                scoresView.setText(((Integer) game.getScores()).toString());
                stopPlay();
                changeButtons();
            }
        }
    }


}



