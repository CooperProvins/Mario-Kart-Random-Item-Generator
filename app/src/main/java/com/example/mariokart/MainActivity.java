package com.example.mariokart;

import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private TextView myTextView;
    private ToggleButton myToggle;

    private int maxGenerated = 2;

    long randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.textView2);
        myButton = findViewById(R.id.button);
        myToggle = findViewById(R.id.toggleButton);

        // On = Team Mode
        // Off = Seperate Mode
        myToggle.setOnClickListener(v -> {
            if (myToggle.isChecked()) {
                maxGenerated = 4;
            }
            else {
                maxGenerated = 2;
            }
            int[] itemArray = new int[22];
            String itemText = "";
            for (int i = 0; i < 22; i++) {
                itemArray[i] = (int)(Math.random()*maxGenerated);
                itemText += itemArray[i] + " ";
                switch (i){
                    case 5:
                        itemText += "    ";
                    case 11:
                        itemText += "    ";
                    case 17:
                        itemText += "    ";
                }
            }
            myTextView.setText(itemText);
        });

        myButton.setOnClickListener(v -> {
            int[] itemArray = new int[22];
            String itemText = "";
            for (int i = 0; i < 22; i++) {
                itemArray[i] = (int)(Math.random()*maxGenerated);
                itemText += itemArray[i] + " ";
                switch (i){
                    case 5:
                        itemText += "    ";
                    case 11:
                        itemText += "    ";
                    case 17:
                        itemText += "    ";
                }
            }
            myTextView.setText(itemText);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}