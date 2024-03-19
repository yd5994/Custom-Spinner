package com.example.customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StateAdapter extends ArrayAdapter<State> {
    private Context context;
    private ArrayList<State> stateList;
    LayoutInflater inflater;

    public StateAdapter(@NonNull Context context, ArrayList<State> stateList) {
        super(context, R.layout.custom_spinner, stateList);
        this.context = context;
        this.stateList = stateList;
        inflater = (LayoutInflater.from(context));
    }

    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        view = inflater.inflate(R.layout.custom_spinner,parent,false);

        ImageView iVStateFlag = view.findViewById(R.id.iV);
        TextView tVStateName = view.findViewById(R.id.tV);
        TextView tVStateCapital = view.findViewById(R.id.textView5);

        State state = this.stateList.get(position);

        iVStateFlag.setImageResource(state.getStateImageId());
        tVStateName.setText(state.getStateName());
        tVStateCapital.setText(state.getStateCapital());

        return view;
    }
}
