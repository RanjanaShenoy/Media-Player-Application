package com.example.allinoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Camera extends AppCompatActivity {

    ImageView mImageView;
    Button mChooseButton;
    Button toHome;


    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // VIEWS

        mImageView = findViewById(R.id.image_view);
        mChooseButton = findViewById(R.id.choose_image_btn);
        toHome=findViewById(R.id.backhome);

        //handle button click
        mChooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check runtime permission

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        //permission not granted, request it

                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                        requestPermissions(permissions, PERMISSION_CODE);

                    } else {
                        //permission already granted
                        pickImageFromGallery();

                    }
                }
                else {
                    //system os is less than marshmallow
                      pickImageFromGallery();

                }
            }
        });

        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_gal=new Intent(Camera.this,MainActivity.class);
                startActivity(intent_gal);
            }
        });

    }

    private void pickImageFromGallery()
    {
    //intert to pick image
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PICK_CODE);
    }
    //handle runtime permission

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull  int[] grantResults) {
      //handle result of pick

        switch(requestCode)
        {
            case PERMISSION_CODE: {
                if(grantResults.length > 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    //permission was granted
                    pickImageFromGallery();
                }
                else
                {
                    //permission was denied
                    Toast.makeText(this,"Permission denied!",Toast.LENGTH_SHORT).show();
                }

            }
        }

      // );

    }
      @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if(resultCode==RESULT_OK && requestCode == IMAGE_PICK_CODE)
        {
            //set image to image view
            mImageView.setImageURI(data.getData());
        }
    }

}