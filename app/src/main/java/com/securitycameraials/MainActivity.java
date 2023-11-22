package com.securitycameraials;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirestoreRecyclerAdapter<Images, ImageViewHolder> adapter;
    private FirebaseFirestore db;
    private EditText emailEditText;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        emailEditText = findViewById(R.id.editTextText3);
        searchButton = findViewById(R.id.button2);

        db = FirebaseFirestore.getInstance();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchImagesByEmail();
            }
        });
    }

    private void searchImagesByEmail() {
        String correo = emailEditText.getText().toString().trim();
        if (!correo.isEmpty()) {
            Query query = db.collection("detections").whereEqualTo("correo", correo.toLowerCase());

            FirestoreRecyclerOptions<Images> options = new FirestoreRecyclerOptions.Builder<Images>()
                    .setQuery(query, Images.class)
                    .build();

            adapter = new FirestoreRecyclerAdapter<Images, ImageViewHolder>(options) {
                @Override
                protected void onBindViewHolder(@NonNull ImageViewHolder holder, int position, @NonNull Images model) {
                    // Configura la vista para cada elemento
                    holder.bindData(model);
                }

                @NonNull
                @Override
                public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagenes_maleante, parent, false);
                    return new ImageViewHolder(view);
                }
            };

            recyclerView.setAdapter(adapter);
            adapter.startListening();
        } else {
            Toast.makeText(MainActivity.this, "El correo está vacío", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}