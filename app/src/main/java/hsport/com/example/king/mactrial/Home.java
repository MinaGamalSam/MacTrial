package hsport.com.example.king.mactrial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button converter ,emegency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);
        converter =findViewById(R.id.converter_bt);
        emegency=findViewById(R.id.emergency_bt);
        converterApp();
        emergencyApp();
    }
    private void converterApp(){
        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startConverter =new Intent(Home.this ,MainActivity.class);
                startActivity(startConverter);

            }
        });
    }

    private void emergencyApp(){
        emegency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startConverter =new Intent(Home.this ,EmergencyCalls.class);
                startActivity(startConverter);

            }
        });
    }
}
