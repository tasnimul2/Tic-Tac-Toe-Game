package com.example.connect3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    boolean player1 = true; //if want to extend game to a 3rd player, change this to an int and check if it is 1,2 or 3.
    boolean player2 = false;
    boolean gameInProgress = true;
    boolean player1Win = false;
    boolean player2Win = false;


    int[] board = {0,0,0,0,0,0,0,0,0}; //the board is set to 0 to represent the board  is empty.
    Winner winner = new Winner(board); //Winner class that checks the requirements to win the game
    int turnCounter = 0; //if this counts up to 9, there all boxes are filled up without anyone winning, hence, the game is a draw.

    public void DropIn(View view){
        //================================= VARIABLE INITIATION ========================================
        ImageView blueWins = (ImageView) findViewById(R.id.blueWinsImageView);
        ImageView redWins = (ImageView) findViewById(R.id.redWinsImageView);
        ImageView tieGame = (ImageView) findViewById(R.id.tieImageView);
        ImageView player1turn = (ImageView) findViewById(R.id.player1turn);
        ImageView player2turn = (ImageView) findViewById(R.id.player2turn);
        ImageView accessView = (ImageView) view; //this variable allows you to access the "view" in public void DropIn(View "view"){
        accessView.setTranslationY(-1500); // puts the image outside the screen so users can not see, until tapped in
        Log.i("Tag # ",accessView.getTag().toString());

        int tapCounter = Integer.parseInt(accessView.getTag().toString()); //converts tag to an int


        if(gameInProgress) {
            //==============================PLAYER 1 INTERACTIONS=========================
            if (player1) { //if it is the 1st player then drop the letter 0
                accessView.setImageResource(R.drawable.o);
                accessView.animate().translationYBy(1500).rotationBy(3600).setDuration(500);
                board[tapCounter] = 1; //change the tapCounter-ith element  from 0 to 1 if player 1 is in that spot on the board
                player1 = false; //no longer players 1's turn

                turnCounter++;
                if (winner.player1Win(board)) {
                    blueWins.setTranslationY(-100);
                    blueWins.setVisibility(View.VISIBLE);
                    blueWins.animate().translationYBy(100).setDuration(500);
                    player1turn.setVisibility(View.INVISIBLE);
                    player1Win = true;
                    gameInProgress = false;

                }
                if(!(winner.player1Win(board))){
                    player2turn.setTranslationY(-100);
                    player1turn.setVisibility(View.INVISIBLE);
                    player2turn.setVisibility(View.VISIBLE);
                    player2turn.animate().translationYBy(100).setDuration(500);
                }
                //========================PLAYER 2 INTERACTIONS======================
            } else { //or else drop the letter x.
                accessView.setImageResource(R.drawable.x);
                accessView.animate().translationYBy(1500).rotationBy(3600).setDuration(500);
                board[tapCounter] = 2;// change  the tapCounter-ith element  from 0 to 2 if player 2 is in that spot on the board
                player1 = true; //it is again player 1s turn
                turnCounter++;
                if (winner.player2Win(board)) {
                    redWins.setTranslationY(-100);
                    redWins.setVisibility(View.VISIBLE);
                    redWins.animate().translationYBy(100).setDuration(500);
                    player2turn.setVisibility(View.INVISIBLE);
                    player2Win = true;
                    gameInProgress = false;
                }
                if(!(winner.player2Win(board))){
                    player1turn.setTranslationY(-100);
                    player1turn.setVisibility(View.VISIBLE);
                    player2turn.setVisibility(View.INVISIBLE);
                    player1turn.animate().translationYBy(100).setDuration(500);
                }
            }
            //========================== IF THE GAME IS A TIE ==========================================================
            if (turnCounter == 9 && !(player1Win) && !(player2Win)) {//if all turns were used up w/o any one winning
                player2turn.setVisibility(View.INVISIBLE);
                player1turn.setVisibility(View.INVISIBLE);
                tieGame.setTranslationY(-100);
                tieGame.setVisibility(View.VISIBLE);
                tieGame.animate().translationYBy(100).setDuration(500);
                gameInProgress = false;
            }
        }
        //============================ PLAY AGAIN BUTTON INTERACTIONS ===================================================
        ImageButton playAgain = (ImageButton) findViewById(R.id.playAgainImageBtn);

        if(!gameInProgress){
            playAgain.setVisibility(View.VISIBLE);
            playAgain.animate().rotationBy(360).setDuration(500);
            //playAgain.animate().translationYBy(-500).setDuration(2000);

        }


    }

    public void restartGame(View view){ //on click function for play again button
     /* ImageButton playAgain = (ImageButton) findViewById(R.id.playAgainImageBtn);
        ImageView player1turn = (ImageView) findViewById(R.id.player1turn);
        ImageView blueWins = (ImageView) findViewById(R.id.blueWinsImageView);
        ImageView redWins = (ImageView) findViewById(R.id.redWinsImageView);
        ImageView tieGame = (ImageView) findViewById(R.id.tieImageView);
        android.support.v7.widget.GridLayout grid = findViewById(R.id.gridLayout); //the grid layout used to but 9 different ImageViews (X's and O's)

        player1turn.setVisibility(View.VISIBLE);
        blueWins.setVisibility(View.INVISIBLE);
        redWins.setVisibility(View.INVISIBLE);
        tieGame.setVisibility(View.INVISIBLE);

        playAgain.animate().translationYBy(500).setDuration(2000);
        playAgain.animate().rotationBy(3600).setDuration(2000);

        //loop through each object on the grid Layout (the X's and and O's) and remove the "source" to make it invisible
        for(int i = 0; i < grid.getChildCount();i++){
            ImageView accessView = (ImageView) grid.getChildAt(i);
            accessView.setImageDrawable(null);
        }

        //resent the board to all 0's
        for(int j = 0; j < board.length; j++){
            board[j] = 0;
        }

        gameInProgress = true;

            */




        recreate();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ImageView player1turn = (ImageView) findViewById(R.id.player1turn);

            player1turn.setVisibility(View.INVISIBLE);
            player1turn.setTranslationY(-200);
            player1turn.setVisibility(View.VISIBLE);
            player1turn.animate().translationYBy(200).setDuration(1000);


    }
}
