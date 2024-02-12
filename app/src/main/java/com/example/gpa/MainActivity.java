package com.example.gpa;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button compute;
    EditText sub1, sub2, sub3, sub4, sub5, total, avg;
    View backgroundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sub1 = (EditText) findViewById(R.id.s1);
        sub2 = (EditText) findViewById(R.id.s2);
        sub3 = (EditText) findViewById(R.id.s3);
        sub4 = (EditText) findViewById(R.id.s4);
        sub5 = (EditText) findViewById(R.id.s5);
        total = (EditText) findViewById(R.id.t);
        avg = (EditText) findViewById(R.id.a);
        compute = (Button) findViewById(R.id.btn);
        backgroundView = findViewById(R.id.mainLayout);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (compute.getText().toString().equalsIgnoreCase("Clear Form")) {
                    clearForm();
                } else {
                    if (validateFields()) {
                        double n1 = Double.parseDouble(sub1.getText().toString());
                        double n2 = Double.parseDouble(sub2.getText().toString());
                        double n3 = Double.parseDouble(sub3.getText().toString());
                        double n4 = Double.parseDouble(sub4.getText().toString());
                        double n5 = Double.parseDouble(sub5.getText().toString());
                        double sum = n1 + n2 + n3 + n4 + n5;
                        double average = sum / 5;
                        total.setText(String.valueOf(sum));
                        avg.setText(String.valueOf(average));
                        updateBackgroundColor(average);
                        compute.setText("Clear Form");
                    }
                }
            }
        });
    }

    private boolean validateFields() {
        EditText[] fields = {sub1, sub2, sub3, sub4, sub5};
        for (EditText field : fields) {
            if (field.getText().toString().isEmpty()) {
                field.setError("Field cannot be empty");
                return false;
            }
        }
        return true;
    }

    private void updateBackgroundColor(double average) {
        if (average < 60) {
            backgroundView.setBackgroundColor(Color.RED);
        } else if (average >= 60 && average <= 79) {
            backgroundView.setBackgroundColor(Color.YELLOW);
        } else if (average >= 80) {
            backgroundView.setBackgroundColor(Color.GREEN);
        }
    }

    private void clearForm() {
        EditText[] fields = {sub1, sub2, sub3, sub4, sub5, total, avg};
        for (EditText field : fields) {
            field.setText("");
        }
        backgroundView.setBackgroundColor(Color.WHITE);
        compute.setText("Compute GPA");
    }
}
