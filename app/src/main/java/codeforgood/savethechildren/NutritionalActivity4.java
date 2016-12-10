package codeforgood.savethechildren;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NutritionalActivity4 extends AppCompatActivity {
    private WeeklyReport report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritional4);
        report = (WeeklyReport) getIntent().getSerializableExtra("report");
        setTitle("");
    }


    public void finish(View v) {
        EditText EText = (EditText) findViewById(R.id.promoted_no);
        String promotedNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.recovered_no);
        String recoveredNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.death_no);
        String deathNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.confirmed_defaulter_no);
        String confirmedDeafaulterNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.unconfirmed_defaulter_no);
        String unconfirmedDefaulterNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.medical_referral_no);
        String medicalReferralNo = EText.getText().toString();
        EText = (EditText) findViewById(R.id.non_response_no);
        String nonResponseNo = EText.getText().toString();

        report.setNutritional4(promotedNo,recoveredNo, deathNo,unconfirmedDefaulterNo,confirmedDeafaulterNo,medicalReferralNo,nonResponseNo);
        report.sendReport();
        finish();
        Toast.makeText(this, "Report sent!", Toast.LENGTH_SHORT).show();
    }
}
