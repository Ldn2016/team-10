package codeforgood.savethechildren;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class NutritionalActivity2 extends AppCompatActivity {

    private WeeklyReport report;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritional2);
        report = (WeeklyReport) getIntent().getSerializableExtra("report");
    }

    public void openNutritional3(View v) {

        EditText EText = (EditText) findViewById(R.id.wfh_bmi_no);
        String bmiBelow = EText.getText().toString();
        EText = (EditText) findViewById(R.id.muac_no);
        String muacNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.oedema_no);
        String oedemaNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.relapse_no);
        String relapseNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.re_admission_no);
        String readmissionNo = EText.getText().toString();


        report.setNutritional2(bmiBelow, muacNo, oedemaNo, relapseNo, readmissionNo);
        Intent intent = new Intent(this.getApplicationContext(), NutritionalActivity3.class);
        intent.putExtra("report", report);

        startActivity(intent);

    }
}
