package com.example.mygame;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean playHeals = false;
    boolean playHealsCheck = false;
    boolean isTrue = false;
    boolean timeStart = false;
    Integer resultNum = 0;
    TextView AnswerText, QuestionText, ResultText, textViewTimer, textHeal;
    Button buttonYes, buttonNo;
    ProgressBar progressBar;
    int selectedTimeInMillis = 60000;
    int numHeals = 3;
    CountDownTimer countDownTimer;
    CheckBox themeCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ResultText = findViewById(R.id.ResultView);
        QuestionText = findViewById(R.id.QuestionText);
        AnswerText = findViewById(R.id.TextAnswer);
        textViewTimer = findViewById(R.id.textViewTimer);
        buttonYes = findViewById(R.id.buttonYes);
        buttonNo = findViewById(R.id.buttonNo);
        progressBar = findViewById(R.id.progressBarTime);
        textHeal = findViewById(R.id.textViewHeal);

        themeCheckBox = findViewById(R.id.checkBoxFon);

        themeCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            playHealsCheck = isChecked;
        });
        Spinner timeSpinner = findViewById(R.id.spinnerTime);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.game_times, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(adapter);


        timeSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                switch (position) {
                    case 0: // 30 хвилина
                        selectedTimeInMillis = 30000;
                        break;
                    case 1: // 1 хвилини
                        selectedTimeInMillis = 60000;
                        break;
                    case 2: // 3 хвилин
                        selectedTimeInMillis = 180000;
                        break;
                }
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
            }
        });

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

    public void setRandQuestion(TextView textView) {
        textHeal.setText("Життів: " + numHeals);
        Random random = new Random();
        int randomNumber = random.nextInt(20) + 1;

        switch (randomNumber) {
            case 1:
                textView.setText("Наполеон Бонапарт був імператором Франції?");
                isTrue = true;
                break;
            case 2:
                textView.setText("Єгипетські піраміди були побудовані в середньовіччі?");
                isTrue = false;
                break;
            case 3:
                textView.setText("Перша світова війна почалася у 1914 році?");
                isTrue = true;
                break;
            case 4:
                textView.setText("Друга світова війна закінчилася у 1941 році?");
                isTrue = false;
                break;
            case 5:
                textView.setText("Римська імперія була однією з найбільших у світі?");
                isTrue = true;
                break;
            case 6:
                textView.setText("Велика французька революція розпочалася у 1900 році?");
                isTrue = false;
                break;
            case 7:
                textView.setText("Монголи захопили всю Європу?");
                isTrue = false;
                break;
            case 8:
                textView.setText("Колумб відкрив Америку у 1492 році?");
                isTrue = true;
                break;
            case 9:
                textView.setText("Київ був заснований раніше, ніж Москва?");
                isTrue = true;
                break;
            case 10:
                textView.setText("Ісаак Ньютон винайшов телескоп Хаббл?");
                isTrue = false;
                break;
            case 11:
                textView.setText("Піраміди в Гізі є одним із семи чудес світу, що збереглися?");
                isTrue = true;
                break;
            case 12:
                textView.setText("Давня Греція була частиною Римської імперії з моменту її створення?");
                isTrue = false;
                break;
            case 13:
                textView.setText("Перший політ людини в космос відбувся у 1961 році?");
                isTrue = true;
                break;
            case 14:
                textView.setText("Перша людина висадилася на Місяць у 1800 році?");
                isTrue = false;
                break;
            case 15:
                textView.setText("Чорнобильська катастрофа сталася у 1986 році?");
                isTrue = true;
                break;
            case 16:
                textView.setText("Чорнобильська АЕС знаходиться в Росії?");
                isTrue = false;
                break;
            case 17:
                textView.setText("Середньовічна Європа пережила Чорну смерть у XIV столітті?");
                isTrue = true;
                break;
            case 18:
                textView.setText("США стали незалежними від Великобританії у XIX столітті?");
                isTrue = false;
                break;
            case 19:
                textView.setText("Магеллан здійснив першу подорож навколо світу?");
                isTrue = true;
                break;
            case 20:
                textView.setText("Інквізиція була створена в епоху Відродження?");
                isTrue = false;
                break;
            default:
                textView.setText("Невідомий");
                break;
        }

    }

    public void onClickButtonYes() {
        if (!playHeals && playHealsCheck) {
            numHeals = 3;
            playHeals = true;
        }
        if (timeStart) {
            if (isTrue) {
                AnswerText.setText("Відповідь вірна!");
                AnswerText.setTextColor(Color.GREEN);
                resultNum++;
            } else {
                AnswerText.setText("Відповідь невірна!");
                AnswerText.setTextColor(Color.RED);
                if(playHeals) numHeals--;
            }
        } else TimerStart();

        setRandQuestion(QuestionText);
        ResultText.setText("Результат: " + resultNum);
    }

    public void onClickButtonNo() {
        if (!playHeals && playHealsCheck) {
            numHeals = 3;
            playHeals = true;
        }
        if (timeStart) {
            if (!isTrue) {
                AnswerText.setText("Відповідь вірна!");
                AnswerText.setTextColor(Color.GREEN);
                resultNum++;
            } else {
                AnswerText.setText("Відповідь невірна!");
                AnswerText.setTextColor(Color.RED);
                if(playHeals) numHeals--;

            }
        } else TimerStart();

        setRandQuestion(QuestionText);
        ResultText.setText("Результат: " + resultNum);
    }

    public void TimerStart() {
        resultNum = 0;
        timeStart = true;

        progressBar.setMax(selectedTimeInMillis / 1000);

        countDownTimer = new CountDownTimer(selectedTimeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTimer.setText("Час: " + millisUntilFinished / 1000 + " сек.");
                textHeal.setText("Життів: " + numHeals);
                int progress = (int) (selectedTimeInMillis - millisUntilFinished) / 1000;
                progressBar.setProgress(progress);

                if (numHeals <= 0 && playHealsCheck) {
                    countDownTimer.cancel();
                    timeStart = false;

                    QuestionText.setText("Гра завершена! Натисніть кнопку, щоб почати заново.");
                    textViewTimer.setText("Таймер зупинено!");

                    progressBar.setProgress(0);

                    playHeals = false;
                }
            }

            @Override
            public void onFinish() {
                QuestionText.setText("Натисніть на будь-яку кнопку, щоб почати заново!");
                textViewTimer.setText("Час вийшов!");
                timeStart = false;

                progressBar.setProgress(selectedTimeInMillis / 1000);
                numHeals = 3;

            }
        }.start();
    }




}