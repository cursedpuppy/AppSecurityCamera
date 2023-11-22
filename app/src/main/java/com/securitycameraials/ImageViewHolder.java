package com.securitycameraials;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;

    public ImageViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView2);
    }

    public void bindData(Images currentImage) {
        Log.v("Picasso", "ImageViewHolder bindata activo");
        Picasso.get()
                .load(currentImage.getImageUrl())  // Cambiado de model.getImageUrl() a currentImage.getImageUrl()
                .error(R.drawable.placeholder_image) // Asegúrate de que R.drawable.error_placeholder esté definido
                .into(imageView, new Callback() {  // Cambiado de holder.imageView a imageView
                    @Override
                    public void onSuccess() {
                        // La imagen se cargó correctamente
                        Log.v("Picasso", "Image loaded successfully");
                    }

                    @Override
                    public void onError(Exception e) {
                        // Manejar el error aquí
                        Log.e("Picasso", "Error loading image: " + e.getMessage());
                    }
                });
    }
}
