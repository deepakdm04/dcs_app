package com.example.photohub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Register extends AppCompatActivity {

    private final int GALLERY_REQ_CODE = 1000;
    ImageView imgcamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgcamera = findViewById(R.id.imgcamera);
        Button btnCamera = findViewById(R.id.btnCamera);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCamera = new Intent(Intent.ACTION_PICK);
                iCamera.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iCamera,GALLERY_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK)
        {
            if (requestCode==GALLERY_REQ_CODE)
            {

            }
            imgcamera.setImageURI(data.getData());
        }
    }

    public void onClick(View view) {
        Intent myint = new Intent(Register.this, MainActivity.class);
        startActivity(myint);
    }
}