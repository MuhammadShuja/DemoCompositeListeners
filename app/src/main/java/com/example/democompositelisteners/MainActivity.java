package com.example.democompositelisteners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvOne, tvTwo, tvEventsOne, tvEventsTwo;
    private Button btnFireEvent, btnUpdateValues;
    private Button btnAddA, btnAddB, btnRemoveA, btnRemoveB;
    private SubA subA;
    private SubB subB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }

    private void initViews(){
        tvOne = findViewById(R.id.value_one);
        tvTwo = findViewById(R.id.value_two);
        tvEventsOne = findViewById(R.id.registered_events_one);
        tvEventsTwo = findViewById(R.id.registered_events_two);

        btnAddA = findViewById(R.id.add_a);
        btnAddB = findViewById(R.id.add_b);
        btnRemoveA = findViewById(R.id.remove_a);
        btnRemoveB = findViewById(R.id.remove_b);

        btnFireEvent = findViewById(R.id.fire_event);
        btnUpdateValues = findViewById(R.id.update_values);
    }

    private void initEvents(){
        subA = SubA.init();
        subB = SubB.init();

        btnUpdateValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvOne.setText(subA.getValue());
                tvTwo.setText(subB.getValue());
                tvEventsOne.setText(subA.getRegisteredEvents());
                tvEventsTwo.setText(subB.getRegisteredEvents());
            }
        });

        btnFireEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = new Event();
                int counter = event.fire();

                tvOne.setText(subA.getValue());
                tvTwo.setText(subB.getValue());

                btnFireEvent.setText("Fire event: "+counter);
            }
        });

        btnAddA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subA.addEvent();
                tvEventsOne.setText(subA.getRegisteredEvents());
            }
        });

        btnAddB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subB.addEvent();
                tvEventsTwo.setText(subB.getRegisteredEvents());
            }
        });

        btnRemoveA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subA.removeEvent();
                tvEventsOne.setText(subA.getRegisteredEvents());
            }
        });

        btnRemoveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subB.removeEvent();
                tvEventsTwo.setText(subB.getRegisteredEvents());
            }
        });
    }
}