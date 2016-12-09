package codeforgood.savethechildren;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

//Checking I can commit
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // test
        // test comment john
    }

    public void openNutrition(View v) {
        Intent intent = new Intent(this, NutritionActivity.class);
        startActivity(intent);
    }

    public void openStock(View v) {
        Intent intent = new Intent(this, StockActivity.class);
        startActivity(intent);
    }

    public void openGraphs(View v) {
        Intent intent = new Intent(this, GraphActivity.class);
        startActivity(intent);
    }
}
