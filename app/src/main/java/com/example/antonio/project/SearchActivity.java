package com.example.antonio.project;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.antonio.project.api.OMDBAPI;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SearchActivity extends Activity {

    private EditText editText;
    private RadioGroup radioGroup;
    private RadioButton
        movieRadio,
        seriesRadio
    ;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText=(EditText)findViewById(R.id.activity_search_editText);
        radioGroup=(RadioGroup)findViewById(R.id.activity_search_radioGroup);
        movieRadio=(RadioButton)findViewById(R.id.activity_search_movieRadio);
        seriesRadio=(RadioButton)findViewById(R.id.activity_search_seriesRadio);
        button = (Button)findViewById(R.id.activity_search_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String
                    search = editText.getText().toString()
                ,type;
                int checkedRadioId = radioGroup.getCheckedRadioButtonId();
                if(checkedRadioId == movieRadio.getId())
                    type = "movie";
//                if(checkedRadioId == seriesRadio.getId())
                else
                    type = "series";



                startActivity(new Intent(v.getContext(), ResultActivity.class)
                    .putExtra("search",search)
                    .putExtra("type",type)
                );

            }
        });

    }

}
