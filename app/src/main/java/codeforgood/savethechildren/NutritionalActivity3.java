package codeforgood.savethechildren;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NutritionalActivity3 extends AppCompatActivity {
    private WeeklyReport report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritional3);
        report = (WeeklyReport) getIntent().getSerializableExtra("WeeklyReport");
    }

    public void openNutritional4(View v){


        Intent intent = new Intent(this.getApplicationContext(), NutritionalActivity4.class);
        intent.putExtra("WeeklyReport", report);
        startActivity(intent);
    }
}