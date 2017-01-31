package com.thenerdjock.aaleman.switchingscreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by aaleman on 1/30/17.
 */

public class SecondScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Pick layout we want to view
        setContentView(R.layout.second_layout);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("CallingActivityKey");

        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_textview_info);

        callingActivityMessage.append(" " + previousActivity);


    }

    public void onSendUsersName(View view) {

        EditText userNameEditText = (EditText) findViewById(R.id.users_name_edit_text);

        String userName = String.valueOf(userNameEditText.getText());

        //Send it back to the first screen
        Intent goBack = new Intent();

        goBack.putExtra("UserNameKey", userName);

        setResult(RESULT_OK, goBack);

        finish();       //Close screen when it's done working

    }
}
