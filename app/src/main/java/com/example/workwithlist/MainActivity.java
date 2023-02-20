package com.example.workwithlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Image> images = new ArrayList<Image>(); @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);

        setData();
        RecyclerView recyclerView = findViewById(R.id.review1); CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(this,
                images);
        recyclerView.setAdapter(adapter);
    }

    private void setData(){

        images.add(new Image ("cat1", R.drawable.image1)); images.add(new Image ("cat2", R.drawable.image2)); images.add(new Image ("mycat", R.drawable.image3)); images.add(new Image ("nyancat", R.drawable.image4));

    }



    public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

        private final LayoutInflater inflater;
        private final List<Image> images;

        CustomRecyclerAdapter(Context context, List<Image> images) {
            this.images = images;
            this.inflater = LayoutInflater.from(context);
        }

        public void onBindViewHolder(CustomRecyclerAdapter.ViewHolder holder, int position) {
            Image image = images.get(position);
            holder.text.setText(image.getName());
            holder.image.setImageResource(image.getImageResource());

        }

        @NonNull
        @Override
        public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            final ImageView image;
            final TextView text;

            ViewHolder(View view) {
                super(view);
                image = view.findViewById(R.id.imageView);
                text = view.findViewById(R.id.textView);
            }
        }
    }


    public class Image {

        private String name; // название
        private int imageRes; // картинка


        public Image(String name, int image) {

            this.name = name;
            this.imageRes = image;

        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public int getImageResource() {
            return this.imageRes;
        }

        public void setImageResource(int flagResource) {
            this.imageRes = flagResource;
        }
    }
}


