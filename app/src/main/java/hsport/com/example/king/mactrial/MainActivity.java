package hsport.com.example.king.mactrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private EditText temp;
    private TextView result;
    private RadioButton celisuis;
    private RadioButton fahrenheit;
    private Button convert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp = findViewById(R.id.et_temp);
        result = findViewById(R.id.result);
        convert = findViewById(R.id.b_convert);
         celisuis=findViewById(R.id.b_celsius);
         fahrenheit=findViewById(R.id.b_fahren);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double temperature =0;
                try {
                    temperature = Double.parseDouble(temp.getText().toString());
                } catch (Exception e) {
                    //e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Wrong Input", Toast.LENGTH_SHORT).show();
                }
                if(celisuis.isChecked()){
                    double celisuisTemp =(temperature - 32) * 5/9;
                    result.setText("Result is: "+ celisuisTemp +" C" );
                    
                }else if(fahrenheit.isChecked()){
                    double faherhnietTemp =  (temperature * 9/5) + 32;
                    result.setText("Result is: " + faherhnietTemp +" F" );
                }else {
                    Toast.makeText(MainActivity.this, "You don't choose the unit", Toast.LENGTH_SHORT).show();
                }

            }
        });






    }

   /* public void please(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);
        Toast.makeText(this, "gre"+ radioButton.getText(), Toast.LENGTH_SHORT).show();
    }*/
}
