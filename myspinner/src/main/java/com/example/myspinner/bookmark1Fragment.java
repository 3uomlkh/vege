package com.example.myspinner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bookmark1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bookmark1Fragment extends Fragment {
    private RecyclerView.LayoutManager layoutManager;
    BookmarkAdapter adapter;
    TestItem dataList;
    List<Data> dataInfo;
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public bookmark1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment bookmark1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static bookmark1Fragment newInstance(String param1, String param2) {
        bookmark1Fragment fragment = new bookmark1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_bookmark1, container, false);
        dataInfo = new ArrayList<>();
        recyclerView = view.findViewById(R.id.bookmark1_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);
        Call<TestItem> call = apiInterface.getData();
        call.enqueue(new Callback<TestItem>() {

            @Override
            public void onResponse(Call<TestItem> call, Response<TestItem> response) {
                dataList = response.body();
                Log.d("bookmark1Fragment", dataList.toString());

                dataInfo = dataList.restaurant;

                adapter = new BookmarkAdapter(getContext(), dataInfo);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<TestItem> call, Throwable t) {
                Log.d("bookmark1Fragment", t.toString());
            }
        });
        return view;
    }
}