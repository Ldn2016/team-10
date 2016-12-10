package codeforgood.savethechildren;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NutritionalActivity4 extends AppCompatActivity {
    private WeeklyReport report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritional4);
        report = (WeeklyReport) getIntent().getSerializableExtra("report");
    }


    void openNutritional5(View v) {
        report.sendReport();
        finish();
    }
}
