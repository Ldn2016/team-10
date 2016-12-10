package codeforgood.savethechildren;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class NutritionalActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritional2);
    }

    public void onClick(Void v)
    {
        WeeklyReport report = new WeeklyReport();
        Spinner spinner = (Spinner) findViewById(R.id.nut_1_spinner);
        String age = spinner.getSelectedItem().toString();

        EditText EText = (EditText) findViewById(R.id.wfh_bmi_no);
        String bmiBelow = EText.toString();
        EText = (EditText) findViewById(R.id.muac_no);
        String muacNo = EText.toString();
        EText = (EditText) findViewById(R.id.odema_no);
        String odemaNo = EText.toString();
        EText = (EditText) findViewById(R.id.relapse_no);
        String relapseNo = EText.toString();
        EText = (EditText) findViewById(R.id.re_admission_no);
        String readmissionNo = EText.toString();

        report.setNutritional2(bmiBelow, muacNo, odemaNo, relapseNo, readmissionNo);

        Intent intent = new Intent(this.getApplicationContext(), NutritionalActivity2.class);
        startActivity(intent);

    }
}
