package com.example.sub2expert.interfake.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sub2expert.R;
import com.example.sub2expert.utils.Film;

public class DetailFilm extends AppCompatActivity {
    public static final String EXTRA_COURSE = "extra_course";
    private ImageView imgFilm;
    private TextView tittleFilm;
    private TextView sutradaraFilm;
    private TextView tahunproFilm;
    private TextView deskripsiFilm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        //deklarasi
        imgFilm = findViewById(R.id.image_desc_fil);
        tittleFilm = findViewById(R.id.title_desc_film);
        sutradaraFilm = findViewById(R.id.sutradara_desc_film);
        tahunproFilm = findViewById(R.id.tahun_desc_film);
        deskripsiFilm = findViewById(R.id.desc_det_film);


        //ambil data parcelableExtra
        Film film = getIntent().getParcelableExtra(EXTRA_COURSE);
        Glide.with(this)
                .load(film.getImagePath())
                .into(imgFilm);

        tittleFilm.setText(film.getTitle());
        deskripsiFilm.setText(film.getDescription());
        tahunproFilm.setText(film.getTahun());
        sutradaraFilm.setText(film.getSutradara());



    }
}
