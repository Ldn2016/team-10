package codeforgood.savethechildren;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class NutritionalActivity3 extends AppCompatActivity {
    private WeeklyReport report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritional3);
        report = (WeeklyReport) getIntent().getSerializableExtra("report");
    }

    public void openNutritional4(View v){
        EditText EText = (EditText) findViewById(R.id.from_sc_no);
        String scNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.other_no);
        String otherNo = EText.getText().toString();

        report.setNutritional3(scNo, otherNo);

        Intent intent = new Intent(this.getApplicationContext(), NutritionalActivity4.class);
        intent.putExtra("report", report);
        startActivity(intent);
    }
}
