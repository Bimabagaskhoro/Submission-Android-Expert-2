package com.example.sub2expert.interfake.tv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sub2expert.R;
import com.example.sub2expert.data.DataDummy;


public class TvFrag extends Fragment {
    private RecyclerView rvCourse;
    private TvAdapter tvAdapter;


    public TvFrag() {
        // Required empty public constructor
    }
    public static Fragment newInstance() {
        return new TvFrag();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCourse = view.findViewById(R.id.rv_tvMovie);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity()!=null){
            tvAdapter = new TvAdapter(getActivity());
            tvAdapter.setListFilmData(DataDummy.generateDummyTv());

            rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
            rvCourse.setHasFixedSize(true);
            rvCourse.setAdapter(tvAdapter);

        }
    }
}
