package ru.netologia.sharinm_task_711;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSyn = findViewById(R.id.buttonSynchnization);

        btnSyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SYNC);

                int hour = Integer.parseInt(new SimpleDateFormat("HH").format(new Date())) ;
                int minut = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));

                if (((hour > 6) && (hour < 14)) || ((hour == 14) && (minut == 0)))
                    intent.setData(Uri.parse("http://morning"));
                if (((hour == 14) && (minut != 0)) || ((hour == 15) && (minut == 0)))
                    intent.setData(Uri.parse("http://afternoon"));
                if (((hour == 15) && (minut != 0)) || ((hour > 15) || (hour < 6)) || ((hour == 6) && (minut == 00)))
                    intent.setData(Uri.parse("http://evening"));

                startActivity(intent);
            }
        });
    }
}
