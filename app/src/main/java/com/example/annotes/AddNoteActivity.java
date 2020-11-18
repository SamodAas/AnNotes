package com.example.annotes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.OutputStreamWriter;

import static com.example.annotes.MainActivity.forNotes;

public class AddNoteActivity extends AppCompatActivity {

    EditText noteText;
    EditText nameText;
    public static Boolean first = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);
        noteText = findViewById(R.id.noteContent);
        nameText = findViewById(R.id.noteName);
    }

    public void cancelNote(View view) {
        finish();
    }

    public void saveAndCloseNote(View view) {
        if(this.noteText.getText().toString().isEmpty() || nameText.getText().toString().isEmpty()){
            Context context = getApplicationContext();
            CharSequence text = "Please do not leave the fields empty";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
            SharedPreferences.Editor editor = MainActivity.sharedPref.edit();
            editor.putString(MainActivity.forNotes, this.noteText.getText().toString());
            editor.apply();

            SharedPreferences.Editor nameEditor = MainActivity.sharedPrefNames.edit();
            nameEditor.putString(MainActivity.forNames, this.nameText.getText().toString());
            nameEditor.apply();
            first=true;
            finish();
        }
}
