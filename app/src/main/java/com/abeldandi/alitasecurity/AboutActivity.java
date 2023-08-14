package com.abeldandi.alitasecurity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView backButton = findViewById(R.id.about_backbutton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kembali ke NavDrawerActivity
                Intent intent = new Intent(AboutActivity.this, NavDrawerActivity.class);
                startActivity(intent);
                finish(); // Optional, untuk menutup AboutActivity setelah pindah ke NavDrawerActivity
            }
        });
    }
}