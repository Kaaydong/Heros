package com.example.heros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class HeroesListActivity extends AppCompatActivity {

    private String jsonFileText;
    private Hero[] heroes;
    private List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_list);

    // https://stackoverflow.com/questions/15912825/how-to-read-file-from-res-raw-by-name#new-answer?newreg=ff2c26d632b245888d8a8c5b3de3dd06
        InputStream jsonInputStream = getResources().openRawResource(R.raw.heroes);
        jsonFileText = readTextFile(jsonInputStream);

        createGson();
    }

    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }
    public void createGson()
    {
        Gson gson = new Gson();
// read your json file into an array of questions
        heroes =  gson.fromJson(jsonFileText, Hero[].class);
// convert your array to a list using the Arrays utility class
        heroList = Arrays.asList(heroes);
// verify that it read everything properly
        Log.d("O no", "onCreate: " + heroList.toString());
    }

    public void wireWidgets()
    {

    }
}
