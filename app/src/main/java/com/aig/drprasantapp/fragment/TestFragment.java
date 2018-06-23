package com.aig.drprasantapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aig.drprasantapp.R;
import com.aig.drprasantapp.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

import model.HorizotalitemsMenu;
import model.TestModel;


public class TestFragment extends Fragment {
    TestAdapter testAdapter;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        recyclerView = view.findViewById(R.id.recy_testclass);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<TestModel> listarray = lisdata();
        testAdapter = new TestAdapter(listarray,getActivity());
        recyclerView.setAdapter(testAdapter);
        return view;
    }

    private List<TestModel> lisdata() {
        List<TestModel> testModels = new ArrayList<>();
        testModels.add(new TestModel("Pshchiatry Grand Test","Syllabus","Covers entire Psychiatry Syllabus","100 Question","80 Minutes"));
        testModels.add(new TestModel("Pshchiatry Grand Test","Syllabus","Covers entire Psychiatry Syllabus","100 Question","80 Minutes"));
        testModels.add(new TestModel("Pshchiatry Grand Test","Syllabus","Covers entire Psychiatry Syllabus","100 Question","80 Minutes"));
        return  testModels;

    }

}
