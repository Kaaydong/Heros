package com.example.hero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heros.R;

public class HeroDetailActivity extends AppCompatActivity {

    private TextView textViewName,textViewDescriptionText,textViewSuperPowerText,textViewRankingNumber;
    private TextView textViewDescription,textViewSuperPower,textViewRanking;
    private ImageView imageViewPicture;
    private Heros hero;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);

        wireWidgets();

        Intent lastIntent = getIntent();

        hero = lastIntent.getParcelableExtra(HeroesListActivity.EXTRA_LIST);

        setWidgets();

        setListeners();
    }

    public void wireWidgets()
    {
        textViewName = findViewById(R.id.textView_detail_name);
        textViewDescription = findViewById(R.id.textView_detail_description);
        textViewDescriptionText = findViewById(R.id.textView_detail_descriptionText);
        textViewSuperPower = findViewById(R.id.textView_detail_superpower);
        textViewSuperPowerText = findViewById(R.id.textView_detail_superpowerText);
        textViewRanking = findViewById(R.id.textView_detail_ranking);
        textViewRankingNumber = findViewById(R.id.textView_detail_rankNumber);
        imageViewPicture = findViewById(R.id.imageView_detail_image);
        backButton = findViewById(R.id.button_detail_back);
    }
    public void setWidgets()
    {
        textViewName.setText(hero.getName());
        textViewDescriptionText.setText(hero.getDescription());
        textViewSuperPowerText.setText(hero.getSuperpower());
        textViewRankingNumber.setText(hero.getRanking() + "");

        int resourceImage = getResources().getIdentifier(hero.getImage(), "drawable", getPackageName());
        imageViewPicture.setImageDrawable(getResources().getDrawable(resourceImage));

    }

    public void setListeners()
    {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent targetIntent = new Intent(HeroDetailActivity.this, HeroesListActivity.class);

                startActivity(targetIntent);
                finish();
            }
        });
    }
}
