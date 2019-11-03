package com.example.sub2expert.interfake.film;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sub2expert.CustomOnitemClickListener;
import com.example.sub2expert.R;
import com.example.sub2expert.interfake.detail.DetailFilm;
import com.example.sub2expert.utils.Film;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    private ArrayList<Film> listFilm;
    private Context context;

    private ArrayList<Film> getListFilmData(){
        return listFilm;
    }
    public void setListFilmData(ArrayList<Film>listFilm){
        this.listFilm = listFilm;
    }

    public FilmAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_film,parent,false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FilmViewHolder holder, int position) {
       Film film = listFilm.get(position);
        Glide.with(holder.itemView.getContext())
                .load(film.getImagePath())
                .into(holder.imgPoster);

        holder.tvTitle.setText(film.getTitle());
        holder.tvDescription.setText(film.getDescription());
        holder.tvSutradara.setText(film.getSutradara());
        holder.tvTahun.setText(film.getTahun());

        holder.itemView.setOnClickListener(new CustomOnitemClickListener(position,((view, position1) -> {
            Intent intent = new Intent(context,DetailFilm.class);
            intent.putExtra(DetailFilm.EXTRA_COURSE,getListFilmData().get(position));
            context.startActivity(intent);
        })));

        holder.btn1.setOnClickListener(new CustomOnitemClickListener(position,((view, position1) -> {
            Toast.makeText(context,context.getString(R.string.suka1)
                            +getListFilmData().get(position).getTitle(),
                    Toast.LENGTH_SHORT).show();
        })));

       holder.btn2.setOnClickListener(new CustomOnitemClickListener(position,((view, position1) -> {
           Toast.makeText(context,context.getString(R.string.bagikan1)
                           +getListFilmData().get(position).getTitle(),
                   Toast.LENGTH_SHORT).show();
       })));

    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    class FilmViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final TextView tvSutradara;
        final ImageView imgPoster;
        final TextView tvTahun;
        final Button btn1;
        final Button btn2;
        FilmViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title_film);
            imgPoster = itemView.findViewById(R.id.img_poster_film);
            tvDescription = itemView.findViewById(R.id.tv_item_description_film);
            tvSutradara = itemView.findViewById(R.id.tv_item_sutradara_film);
            tvTahun = itemView.findViewById(R.id.tv_item_tahun_film);
            btn1 = itemView.findViewById(R.id.btnSuka_film);
            btn2 = itemView.findViewById(R.id.btnBagi_film);
        }
    }
}
