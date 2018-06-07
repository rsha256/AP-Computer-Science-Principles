package com.rahul.chatbot.chatbot.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Get the Intent that started this activity and extract the string
        EditText txtDescription = findViewById(R.id.editText);
        String message = txtDescription.getText().toString();
        String finalWord;

        Bot theo = new Bot();

        finalWord = theo.getResponse(message);

        if (message.contains("Bye"))
        {
            finalWord = "Bye, thanks for using this app!";
        }

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.response);
        textView.setText(finalWord);
    }
}
