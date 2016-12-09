package codeforgood.savethechildren;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNutrition(View v) {
        Intent intent = new Intent(this.getApplicationContext(), NutritionalActivity.class);
        startActivity(intent);
    }

    public void openStock(View v) {
        Intent intent = new Intent(this.getApplicationContext(), StockActivity.class);
        startActivity(intent);
    }

    public void openGraph(View v) {
        Intent intent = new Intent(this.getApplicationContext(), GraphActivity.class);
        startActivity(intent);
    }

}
