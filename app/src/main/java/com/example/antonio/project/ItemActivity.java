package com.example.antonio.project;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.antonio.project.api.OMDBAPI;
import com.example.antonio.project.api.SendRequestTask;
import com.example.antonio.project.media.DownloadImageTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Antonio Ortiz on 14/03/2018.
 */

public class ItemActivity extends Activity {

    private JSONObject jsonObject;
    private Map<String, String> params;
    private String imdbID;
    private ImageView posterImageView;
    private TextView
        titleTextView,
        yearTextView,
        genreTextView,
        plotTextView,
        directorTextView,
        actorsTextView,
        countryTextView
    ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        initViews();

        try {
            imdbID = getIntent()
                    .getExtras()
                    .getString("imdbID")
            ;

            params = new HashMap<String, String>();
            params.put(OMDBAPI.Param.API, OMDBAPI.Option.API_VALUE);
            params.put(OMDBAPI.Param.ID, imdbID);

            jsonObject = new SendRequestTask(params)
                    .execute()
                    .get()
            ;

            new DownloadImageTask(posterImageView).execute(jsonObject
                    .getString("Poster")
            );

            setTexts();
        } catch (NullPointerException | InterruptedException | ExecutionException | JSONException e) {
            e.printStackTrace();
        }

    }

    private void initViews() {
        posterImageView=(ImageView)findViewById(R.id.activity_item_posterImageView);
        titleTextView=(TextView)findViewById(R.id.activity_item_titleTextView);
        yearTextView=(TextView)findViewById(R.id.activity_item_yearTextView);
        genreTextView=(TextView)findViewById(R.id.activity_item_genreTextView);
        plotTextView=(TextView)findViewById(R.id.activity_item_plotTextView);
        directorTextView=(TextView)findViewById(R.id.activity_item_directorTextView);
        actorsTextView=(TextView)findViewById(R.id.activity_item_actorsTextView);
        countryTextView=(TextView)findViewById(R.id.activity_item_countryTextView);
    }
    private void setTexts() throws JSONException {
        titleTextView.setText(jsonObject
            .getString("Title")
        );
        yearTextView.setText(jsonObject
            .getString("Year")
        );
        genreTextView.setText("Genres: "+jsonObject
                .getString("Genre")
        );
        plotTextView.setText("\n\""+jsonObject
                .getString("Plot")+"\"\n"
        );
        directorTextView.setText("Director: "+jsonObject
                .getString("Director")
        );
        actorsTextView.setText("Actors: "+jsonObject
                .getString("Actors")
        );
        countryTextView.setText("Country: "+jsonObject
                .getString("Country")
        );
    }
}
