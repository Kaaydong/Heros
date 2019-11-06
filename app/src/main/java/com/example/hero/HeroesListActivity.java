package com.example.hero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.heros.R;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class HeroesListActivity extends AppCompatActivity {

    private String jsonFileText;
    private Heros[] heroes;
    private List<Heros> heroList;
    private TextView test;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_list);

        wireWidgets();
        // https://stackoverflow.com/questions/15912825/how-to-read-file-from-res-raw-by-name#new-answer?newreg=ff2c26d632b245888d8a8c5b3de3dd06
        InputStream jsonInputStream = getResources().openRawResource(R.raw.heroes);
        jsonFileText = readTextFile(jsonInputStream);

        createGson();

        HeroAdapter heroAdapter = new HeroAdapter(heroList);

        listView.setAdapter(heroAdapter);
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

    public void createGson() {
        Gson gson = new Gson();
// read your json file into an array of questions
        heroes = gson.fromJson(jsonFileText, Heros[].class);
// convert your array to a list using the Arrays utility class
        heroList = Arrays.asList(heroes);
// verify that it read everything properly
        Log.d("O no", "onCreate: " + heroList.toString());
    }

    public void wireWidgets() {
      //  test = findViewById(R.id.textView_main_test);
        listView = findViewById(R.id.listView_main_listview);
    }




    private class HeroAdapter extends ArrayAdapter<Heros> {
        // make an instance variable to keep track of the hero list
        private List<Heros> heroesList;

        public HeroAdapter(List<Heros> heroesList) {
            // since we're in the HeroListActivity class, we already have the context
            // we're hardcoding in a particular layout, so don't need to put it in
            // the constructor either
            // we'll send a placeholder resource to the superclass of -1
            super(HeroesListActivity.this, -1, heroesList);
            this.heroesList = heroesList;
        }

        // The goal of the adapter is to link the your list to the listview
        // and tell the listview where each aspect of the list item goes.
        // so we override a method called getView


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 1. inflate a layout
            LayoutInflater inflater = getLayoutInflater();

            // check if convertview is null, if so, replace it
            if (convertView == null) {
                // R.layout.item_hero is a custom layout we make that represents
                // what a single item would look like in our listview
                convertView = inflater.inflate(R.layout.item_hero, parent, false);
            }

            // 2. wire widgets & link the hero to those widgets
            // instead of calling findViewById at the activity class level,
            // we're calling it from the inflated layout to find THOSE widgets
            TextView textViewName = convertView.findViewById(R.id.textView_heroItem_name);
            TextView textViewDesctiption = convertView.findViewById(R.id.textView_heroItem_description);
            TextView textViewNumber = convertView.findViewById(R.id.textView_heroItem_number);
            // do this for as many widgets as you need

            // set the values for each widget. use the position parameter variable
            // to get the hero that you need out of the list
            // and set the values for widgets.


            // 3. return inflated view
            return convertView;
        }
    }
}
