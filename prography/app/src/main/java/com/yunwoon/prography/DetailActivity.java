package com.yunwoon.prography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView title, description, director, producer, release_date, rt_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        director = findViewById(R.id.director);
        producer = findViewById(R.id.producer);
        release_date = findViewById(R.id.release_date);
        rt_score = findViewById(R.id.rt_score);

        Intent intent = getIntent();
        title.setText(intent.getExtras().getString("title"));
        description.setText(intent.getExtras().getString("description"));
        director.setText(intent.getExtras().getString("director"));
        producer.setText(intent.getExtras().getString("producer"));
        release_date.setText(intent.getExtras().getString("release_date"));
        rt_score.setText(intent.getExtras().getString("rt_score") + "점");
    }
}
