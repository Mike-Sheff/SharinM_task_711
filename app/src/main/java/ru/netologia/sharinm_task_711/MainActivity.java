package ru.netologia.sharinm_task_711;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final int MORNING_START_TIME_HOUR = 6;
    private static final int AFTERNOON_START_TIME_HOUR = 14;
    private static final int EVENING_START_TIME_HOUR = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSyn = findViewById(R.id.buttonSynchnization);

        btnSyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SYNC);

                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                int minut = Calendar.getInstance().get(Calendar.MINUTE);

                if ((hour > MORNING_START_TIME_HOUR) && (hour < AFTERNOON_START_TIME_HOUR)) {
                    intent.setData(Uri.parse("http://morning"));
                } else if ((hour >= AFTERNOON_START_TIME_HOUR) && (hour <= EVENING_START_TIME_HOUR)) {
                    intent.setData(Uri.parse("http://afternoon"));
                } else if ((hour > EVENING_START_TIME_HOUR) || (hour < MORNING_START_TIME_HOUR)) {
                    intent.setData(Uri.parse("http://evening"));
                }

                startActivity(intent);
            }
        });
    }
}
