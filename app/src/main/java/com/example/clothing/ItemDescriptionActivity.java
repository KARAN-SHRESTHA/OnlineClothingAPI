package com.example.clothing;

import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;


public class ItemDescriptionActivity extends AppCompatActivity {
    ImageView Image;
    TextView txtname,txtprice,txtdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);
        txtname=findViewById(R.id.tvName);
        txtprice=findViewById(R.id.tvPrice);
        txtdesc=findViewById(R.id.tvDesc);
        Image=findViewById(R.id.Image);


        StrictMode();
        Bundle bundle =getIntent().getExtras();
        if(bundle !=null){
            String a = bundle.getString("image");
            StrictMode();

            try{
                URL url = new URL(a);
                Image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            txtname.setText(bundle.getString("name"));
            txtprice.setText("रू "+bundle.getString("price"));
            txtdesc.setText(bundle.getString("desc"));

        }
    }

    private void StrictMode()
    {
        android.os.StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);
    }
}
