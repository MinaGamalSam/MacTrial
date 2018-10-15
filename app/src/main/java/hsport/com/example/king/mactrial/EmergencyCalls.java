package hsport.com.example.king.mactrial;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EmergencyCalls extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_calls);

    }

    public void callPolice(View view) {
        Intent calls =new Intent(Intent.ACTION_CALL , Uri.parse("tel:122"));
        startActivity(calls);
    }

    public void callAmbulance(View view) {
        Intent calls =new Intent(Intent.ACTION_CALL , Uri.parse("tel:122"));
        startActivity(calls);
    }

    public void callFire(View view) {
        Intent calls =new Intent(Intent.ACTION_CALL , Uri.parse("tel:122"));
        startActivity(calls);
    }

    public void callElec(View view) {
        Intent calls =new Intent(Intent.ACTION_CALL , Uri.parse("tel:122"));
        startActivity(calls);
    }
}
