package com.thenerdjock.aaleman.switchingscreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Event handler for onNameClick Button
    public void onGetNameClick(View view) {

        //Create SecondScreen class in java folder
        Intent getNameScreenIntent = new Intent(this, SecondScreen.class);

        final int result = 1;

        getNameScreenIntent.putExtra("CallingActivityKey", "MainActivity");

        //If you want data back from the screen
        startActivityForResult(getNameScreenIntent, result);

    }

    //Handle info being sent back by second activity

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Create TextView to put user's name inside of it
        TextView usersNameMessage = (TextView) findViewById(R.id.user_name_message);

        String nameSentBack = data.getStringExtra("UserNameKey");

        usersNameMessage.append(" " + nameSentBack);
    }
}
