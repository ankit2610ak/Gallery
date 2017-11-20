package com.example.ankit.gallery;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    Gallery ga;
    ImageView iv;
    int m;
    int str[]=
            {
                    R.drawable.ab,
                    R.drawable.ac,
                    R.drawable.ae,
                    R.drawable.af,
                    R.drawable.ag,
                    R.drawable.ah,
                    R.drawable.aj,
                    R.drawable.ad,

            };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ga= (Gallery) findViewById(R.id.myGallery);
        iv= (ImageView) findViewById(R.id.imageView);
        ga.setAdapter(new CustomAdapter());
        ga.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                iv.setImageResource(str[position]);
            }
        });


    }


    class CustomAdapter extends BaseAdapter
    {
        public CustomAdapter()
        {
            TypedArray ta=obtainStyledAttributes(R.styleable.Gallery);
            m=ta.getResourceId(R.styleable.Gallery_android_galleryItemBackground,0);
            ta.recycle();
        }

        @Override
        public int getCount() {
            return str.length;
        }

        @Override
        public Object getItem(int arg0) {
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView image=new ImageView(getApplicationContext());
            image.setImageResource(str[position]);
            image.setBackgroundResource(m);
            return image;
        }




    }


}
