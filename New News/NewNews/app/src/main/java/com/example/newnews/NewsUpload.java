package com.example.newnews;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NewsUpload extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView imageViewCard;
    private EditText editTextTitle, editTextContent;
    private TextView txtResult;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        imageViewCard = findViewById(R.id.imageViewCard);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        txtResult = findViewById(R.id.txt_result);
        Button btnUpload = findViewById(R.id.btnUpload);
        Button btnUploadNews = findViewById(R.id.btnUploadNews);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        btnUploadNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResult();
            }
        });
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            imageViewCard.setImageURI(imageUri);
            imageViewCard.setVisibility(View.VISIBLE);
        }
    }

    private void getResult() {
        String title = editTextTitle.getText().toString();
        String content = editTextContent.getText().toString();
        String imagePath = imageUri != null ? imageUri.toString() : "No image selected";

        String result = "Judul: " + title + "\nIsi: " + content + "\nGambar: " + imagePath;
        txtResult.setText(result);
    }
}
