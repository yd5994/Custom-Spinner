package com.example.customspinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener , AdapterView.OnItemClickListener{
    Spinner spin;
    CustomAdapter customAdapter;
    private ArrayList<State> states;
    public String[] countries= {"Israel","France","Spain","United States","Italy","Greece","Germany"};
    public String[] capital_city={"Jerusalem","Paris","Madrid","Washington, D.C.","Rome ","Athens","Berlin"};
    public String[] population_size={"9.364 million","67.75 million","47.42 million","331.9 million","59.11 million","10.64 million","83.2 million"};

    TextView countriestv,capital_citytv,population_sizetv;
    private StateAdapter stateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] imgs={R.drawable.isreal,R.drawable.france,R.drawable.spain,R.drawable.united_states,R.drawable.italy,R.drawable.greece,R.drawable.germany};

        countriestv=findViewById(R.id.textView3);
        capital_citytv=findViewById(R.id.textView5);
        population_sizetv=findViewById(R.id.textView7);

        spin=findViewById(R.id.spinner);
//        spin.setOnItemSelectedListener(this);
//        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
//                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,countries);
//        spin.setAdapter(adp);
        states = new ArrayList<>();
        for (int i = 0; i < countries.length; i++) {
            states.add(new State(countries[i],capital_city[i],imgs[i]));
        }
//        customAdapter = new CustomAdapter(this, imgs, countries);
//        spin.setAdapter(customAdapter);

        stateAdapter = new StateAdapter(this, states);
        spin.setAdapter(stateAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        State state = states.get(position);
        Toast.makeText(this, "The capital of "+state.getStateName()+" is "+state.getStateCapital(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        countriestv.setText(countries[position]);
        capital_citytv.setText(capital_city[position]);
        population_sizetv.setText(population_size[position]);

        int mainposition = (int) customAdapter.getItem(position);
        countriestv.setText(countries[mainposition]);
        capital_citytv.setText(capital_city[mainposition]);
        population_sizetv.setText(population_size[mainposition]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}