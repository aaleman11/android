package com.thenerdjock.aaleman.messingaround;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button answerYesButton, answerNoButton;
    private EditText usersNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answerYesButton = (Button) findViewById(R.id.answer_yes_button);
        answerNoButton = (Button) findViewById(R.id.answer_no_button);
        usersNameEditText = (EditText) findViewById(R.id.users_name_edit_text);
    }

    public void onYesButton(View view) {

        //Retrive text
        String usersName = String.valueOf(usersNameEditText.getText());

        String yourYesResponse = "That is great, " + usersName + "!";

        Toast.makeText(this, yourYesResponse, Toast.LENGTH_SHORT).show();

    }

    public void onNoButton(View view) {

        //Retrive text
        String usersName = String.valueOf(usersNameEditText.getText());

        String yourNoResponse = "That sucks, " + usersName + " :(";

        Toast.makeText(this, yourNoResponse, Toast.LENGTH_SHORT).show();
    }
}
