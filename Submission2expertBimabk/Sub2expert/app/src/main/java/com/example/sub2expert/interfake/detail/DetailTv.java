package com.example.sub2expert.interfake.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sub2expert.R;
import com.example.sub2expert.utils.Tvmovie;

public class DetailTv extends AppCompatActivity {
    public static final String EXTRA_COURSE = "extra_course";
    private ImageView imgFilm;
    private TextView tittleFilm;
    private TextView sutradaraFilm;
    private TextView tahunproFilm;
    private TextView deskripsiFilm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        imgFilm = findViewById(R.id.image_desc_tv);
        tittleFilm = findViewById(R.id.title_desc_tv);
        sutradaraFilm = findViewById(R.id.sutradara_desc_tv);
        tahunproFilm = findViewById(R.id.tahun_desc_tv);
        deskripsiFilm = findViewById(R.id.desc_det_tv);

        Tvmovie courseFilm = getIntent().getParcelableExtra(EXTRA_COURSE);
        Glide.with(this)
                .load(courseFilm.getImagePath())
                .into(imgFilm);

        tittleFilm.setText(courseFilm.getTitle());
        deskripsiFilm.setText(courseFilm.getDescription());
        tahunproFilm.setText(courseFilm.getTahun());
        sutradaraFilm.setText(courseFilm.getCreator());
    }
}
