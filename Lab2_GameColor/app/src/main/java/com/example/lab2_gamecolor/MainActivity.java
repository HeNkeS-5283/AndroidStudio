package com.example.lab2_gamecolor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean isTrue = false;
    TextView AnswerText, ColorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ColorText = findViewById(R.id.ColorView);
        AnswerText = findViewById(R.id.TextAnswer);
        Button buttonYes = findViewById(R.id.buttonYes);
        Button buttonNo = findViewById(R.id.buttonNo);

        setRandomTextViewProperties(ColorText);

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonYes();
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickButtonNo();
            }
        });
    }

    public void setRandomTextViewProperties(TextView textView) {
        Random random = new Random();
        int randomNumber = random.nextInt(15) + 1;

        switch (randomNumber) {
            case 1:
                textView.setText("Червоний");
                textView.setTextColor(Color.RED);
                isTrue = true;
                break;
            case 2:
                textView.setText("Зелений");
                textView.setTextColor(Color.RED);
                isTrue = false;
                break;
            case 3:
                textView.setText("Синій");
                textView.setTextColor(Color.BLUE);
                isTrue = true;
                break;
            case 4:
                textView.setText("Жовтий");
                textView.setTextColor(Color.BLUE);
                isTrue = false;
                break;
            case 5:
                textView.setText("Фіолетовий");
                textView.setTextColor(Color.MAGENTA);
                isTrue = true;
                break;
            case 6:
                textView.setText("Оранжевий");
                textView.setTextColor(Color.GREEN);
                isTrue = false;
                break;
            case 7:
                textView.setText("Білий");
                textView.setTextColor(Color.MAGENTA);
                isTrue = false;
                break;
            case 8:
                textView.setText("Сірий");
                textView.setTextColor(Color.GRAY);
                isTrue = true;
                break;
            case 9:
                textView.setText("Чорний");
                textView.setTextColor(Color.GREEN);
                isTrue = false;
                break;
            case 10:
                textView.setText("Коричневий");
                textView.setTextColor(Color.rgb(139, 69, 19));
                isTrue = true;
                break;
            case 11:
                textView.setText("Бірюзовий");
                textView.setTextColor(Color.rgb(64, 224, 208));
                isTrue = true;
                break;
            case 12:
                textView.setText("Рожевий");
                textView.setTextColor(Color.CYAN);
                isTrue = false;
                break;
            case 13:
                textView.setText("Зелений");
                textView.setTextColor(Color.GREEN);
                isTrue = true;
                break;
            case 14:
                textView.setText("Жовтий");
                textView.setTextColor(Color.YELLOW);
                isTrue = true;
                break;
            case 15:
                textView.setText("Блакитний");
                textView.setTextColor(Color.CYAN);
                isTrue = true;
                break;
            default:
                textView.setText("Невідомий");
                textView.setTextColor(Color.BLACK);
                break;
        }

    }

    public void onClickButtonYes() {
        if (isTrue) {
            AnswerText.setText("Відповідь вірна!");
            AnswerText.setTextColor(Color.GREEN);
        } else {
            AnswerText.setText("Відповідь невірна!");
            AnswerText.setTextColor(Color.RED);
        }
        setRandomTextViewProperties(ColorText);
    }
    public void onClickButtonNo() {
        if (!isTrue) {
            AnswerText.setText("Відповідь вірна!");
            AnswerText.setTextColor(Color.GREEN);
        } else {
            AnswerText.setText("Відповідь невірна!");
            AnswerText.setTextColor(Color.RED);
        }
        setRandomTextViewProperties(ColorText);
    }

}