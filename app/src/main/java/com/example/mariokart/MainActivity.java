package com.example.mariokart;

import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private TextView myTextView;

    long randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myTextView = findViewById(R.id.textView2);
        myButton = findViewById(R.id.button);

        myButton.setOnClickListener(v -> {
            randomNumber = (long)(Math.floor(Math.random()*Math.pow(4,22)+1));
            String itemNumber = binary.encode(randomNumber,4);
            while (itemNumber.length() < 22){
                itemNumber += "0";
            }
            String itemPrint = "";
            for (int i = 0; i < 22; i++){
                itemPrint += itemNumber.charAt(i);
                switch (i){
                    case 5:
                        itemPrint += "    ";
                    case 11:
                        itemPrint += "    ";
                    case 17:
                        itemPrint += "    ";
                }
            }
            myTextView.setText(itemPrint);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}