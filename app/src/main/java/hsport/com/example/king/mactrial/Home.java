package hsport.com.example.king.mactrial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    private Button converter ,emegency;
    private ImageView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);
        converter =findViewById(R.id.converter_bt);
        emegency=findViewById(R.id.emergency_bt);
        register=findViewById(R.id.imageView9);
        converterApp();
        emergencyApp();
        registration();
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
    private void registration(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startRegister =new Intent(Home.this ,RegisterActivity.class);
                startActivity(startRegister);
            }
        });

    }
}
