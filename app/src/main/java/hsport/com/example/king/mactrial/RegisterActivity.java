package hsport.com.example.king.mactrial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;

public class RegisterActivity extends AppCompatActivity {

    private static final int PHOTOREQ = 0;
    private TextView nameView, emailView, passwordView;
    private RadioGroup radioGroup;
    private RadioButton male, female;
    private Button register;
    private String name, email, password;
    private AlertDialog.Builder alert;
    private String gender;
    private Bitmap image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameView = findViewById(R.id.t_name);
        emailView = findViewById(R.id.t_email);
        passwordView = findViewById(R.id.t_password);
        radioGroup = findViewById(R.id.radioGroup);
        male = findViewById(R.id.rd_male);
        female = findViewById(R.id.rd_female);
        radioGroup = findViewById(R.id.radioGroup);
        register = findViewById(R.id.b_register);

        alert = new AlertDialog.Builder(RegisterActivity.this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInput = nameView.getText().toString();
                String alertMessage = "";
                if (!nameInput.equals("") && nameInput.length() > 3) {
                    name = nameInput;
                } else {
                    alertMessage = alertMessage + "Invalid Name" + "\n";
                }
                if (!emailView.equals("") && emailView.length() > 10) {
                    email = emailView.getText().toString();
                } else {
                    alertMessage = alertMessage + "Invalid Email" + "\n";
                }
                if (!passwordView.equals("") && passwordView.length() > 7) {
                    password = passwordView.getText().toString();
                } else {
                    alertMessage = alertMessage + "Invalid Password " + "\n";
                }
                if (male.isChecked()) {
                    gender = "Male";
                } else if (female.isChecked()) {
                    gender = "Female";
                } else {
                    alertMessage = alertMessage + "Choose Your Gender" + "\n";
                }

                if (!alertMessage.equals("")) {
                    alert.setTitle("Error");
                    alert.setMessage(alertMessage);
                    alert.setPositiveButton("ok,I got it", null);
                    alert.show();
                } else {
                    Intent startProfile = new Intent(getBaseContext(), ProfileActivity.class);
                    //startProfile.putExtra("namek",name);
                    startProfile.putExtra("namek", name);
                    startProfile.putExtra("emailk", email);
                    startProfile.putExtra("passwordk", password);
                    startProfile.putExtra("genderk", gender);
                    startProfile.putExtra("imageFile", image);
                    startActivity(startProfile);
                }


            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       /* MenuInflater inflater =getMenuInflater();*/
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.camera_id:
                takePhotos();
                break;
            case R.id.exit_id:
                finish();
                break;

        }
        return true;
    }

    private void takePhotos() {
        Intent photo = new Intent((android.provider.MediaStore.ACTION_IMAGE_CAPTURE));
        startActivityForResult(photo, PHOTOREQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTOREQ && resultCode == RESULT_OK) {
            image = (Bitmap) data.getExtras().get("data");

        }
    }
}
