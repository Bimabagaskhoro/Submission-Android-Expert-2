package com.example.sub2expert.interfake.film;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.sub2expert.R;
import com.example.sub2expert.data.DataDummy;


public class FilmFrag extends Fragment {
    private RecyclerView rvCourse;
    private ProgressBar progressBar;
    private FilmAdapter filmAdapter;


    public FilmFrag() {
        // Required empty public constructor
    }
    public static Fragment newInstance() {
        return new FilmFrag();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCourse = view.findViewById(R.id.rv_film);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity()!=null){
            filmAdapter = new FilmAdapter(getActivity());
            filmAdapter.setListFilmData(DataDummy.generateDummyFilm());

            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
            rvCourse.setHasFixedSize(true);
            rvCourse.setAdapter(filmAdapter);

        }
    }
}
