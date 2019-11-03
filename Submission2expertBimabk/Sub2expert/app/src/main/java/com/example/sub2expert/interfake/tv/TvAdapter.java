package com.example.sub2expert.interfake.tv;

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
import com.example.sub2expert.interfake.detail.DetailTv;
import com.example.sub2expert.utils.Tvmovie;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvmovieViewHolder>{

    private ArrayList<Tvmovie> listFilm;
    private Context context;

    private ArrayList<Tvmovie> getListFilmData(){
        return listFilm;
    }
    public void setListFilmData(ArrayList<Tvmovie>listFilm){
        this.listFilm = listFilm;
    }

    public TvAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public TvmovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_tv, parent, false);
        return new TvmovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvmovieViewHolder holder, int position) {
        Tvmovie courseFilm = listFilm.get(position);
        Glide.with(holder.itemView.getContext())
                .load(courseFilm.getImagePath())
                .into(holder.imgPoster);

        holder.tvTitle.setText(courseFilm.getTitle());
        holder.tvDescription.setText(courseFilm.getDescription());
        holder.tvSutradara.setText(courseFilm.getCreator());
        holder.tvTahun.setText(courseFilm.getTahun());

        holder.itemView.setOnClickListener(new CustomOnitemClickListener(position, new CustomOnitemClickListener.OnItemClickCallBack() {

            @Override
            public void DataClick(View view, int position) {
                Intent intent = new Intent(context,DetailTv.class);
                intent.putExtra(DetailTv.EXTRA_COURSE,getListFilmData().get(position));
                context.startActivity(intent);
            }
        }));
        holder.btn1.setOnClickListener(new CustomOnitemClickListener(position, new CustomOnitemClickListener.OnItemClickCallBack() {
            @Override
            public void DataClick(View view, int position) {
                Toast.makeText(context,context.getString(R.string.suka1)
                                +getListFilmData().get(position).getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        }));
        holder.btn2.setOnClickListener(new CustomOnitemClickListener(position, new CustomOnitemClickListener.OnItemClickCallBack() {
            @Override
            public void DataClick(View view, int position) {
                Toast.makeText(context,context.getString(R.string.bagikan1)
                                +getListFilmData().get(position).getTitle(),
                        Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }

    class TvmovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvDescription;
        final TextView tvDate;
        final TextView tvTahun;
        final TextView tvSutradara;
        final ImageView imgPoster;
        final Button btn1,btn2;
        TvmovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title_tv);
            imgPoster = itemView.findViewById(R.id.img_poster_tv);
            tvDescription = itemView.findViewById(R.id.tv_item_description_tv);
            tvDate = itemView.findViewById(R.id.tv_item_sutradara_tv);
            tvTahun = itemView.findViewById(R.id.tv_item_tahun_tv);
            tvSutradara = itemView.findViewById(R.id.tv_item_sutradara_tv);
            btn1 = itemView.findViewById(R.id.btnSuka_tv);
            btn2 = itemView.findViewById(R.id.btnBagi_tv);
        }
    }
}
