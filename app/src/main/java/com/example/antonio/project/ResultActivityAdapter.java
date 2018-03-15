package com.example.antonio.project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by Antonio Ortiz on 13/03/2018.
 */
// TODO finish recycler view adapter (https://developer.android.com/guide/topics/ui/layout/recyclerview.html#java)
public class ResultActivityAdapter extends RecyclerView.Adapter<ResultActivityAdapter.ViewHolder> {
    private JSONArray jsonArray;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        CardView cardView;


        public ViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            this.cardView = linearLayout.findViewById(R.id.card_view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ResultActivityAdapter(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ResultActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LinearLayout linearLayout= (LinearLayout)  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        ViewHolder vh = new ViewHolder(linearLayout);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        CardView cardView = holder.cardView;

        ImageView imageView = (ImageView) cardView.findViewById(R.id.fragment_item_thumbnail);
        TextView titleTextView=(TextView)cardView.findViewById(R.id.fragment_item_title);
        TextView yearTextView =(TextView)cardView.findViewById(R.id.fragment_item_year);
        Button button=(Button)cardView.findViewById(R.id.fragment_item_button);


        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);

            titleTextView.setText(jsonObject.getString("Title"));
            yearTextView.setText(jsonObject.getString("Year"));
            new DownloadImageTask(imageView).execute(jsonObject.getString("Poster"));

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        v.getContext().startActivity(new Intent(v.getContext(), ItemActivity.class)
                            .putExtra("imdbID", jsonObject.getString("imdbID"))
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}