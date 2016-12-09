package codeforgood.savethechildren;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

public class NutritionalActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritiona1l);
    }

    public void onClick(Void v) {
        WeeklyReport report = new WeeklyReport();
        Spinner spinner = (Spinner) findViewById(R.id.nut_1_spinner);
        String age = spinner.getSelectedItem().toString();

        EditText EText = (EditText) findViewById(R.id.total_beginning_children);
        String children = EText.toString();

        report.setNutritional1(age, children);

        Intent intent = new Intent(this.getApplicationContext(), NutritionalActivity2.class);

    }
}
