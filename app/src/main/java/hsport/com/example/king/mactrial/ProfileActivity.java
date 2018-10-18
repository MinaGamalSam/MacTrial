package hsport.com.example.king.mactrial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView nameView, emailView, passwordView, genderView;
    private String name, email, password, gender;
    private ImageView personalPhoto;
    private Bitmap imageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nameView = findViewById(R.id.name_id);
        emailView = findViewById(R.id.email_id);
        passwordView = findViewById(R.id.pasword_id);
        genderView = findViewById(R.id.gender_id);
        personalPhoto = findViewById(R.id.profile_image_id);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            name = bundle.getString("namek");
            email = bundle.getString("emailk");
            password = bundle.getString("passwordk");
            gender = bundle.getString("genderk");
            Intent intent = getIntent();
            if(intent!=null){
                imageData = (Bitmap)intent.getParcelableExtra("imageFile");
               if(imageData!=null){
                   personalPhoto.setImageBitmap(imageData);
               }else {
                   personalPhoto.setImageResource(R.drawable.person);
               }
            }


            nameView.setText(name);
            emailView.setText(email);
            passwordView.setText(password);
            genderView.setText(gender);

        }

    }
}
