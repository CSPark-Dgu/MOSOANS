package com.example.finalexam;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.ViewHolder> {
    private List<University> universities;
    private Context context;

    public UniversityAdapter(Context context, List<University> universities) {
        this.context = context;
        this.universities = universities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.university_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        University university = universities.get(position);
        holder.bind(university);
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View itemView) {
            super(itemView);
        }

        void bind(final University university) {
            TextView name = itemView.findViewById(R.id.name);
            TextView homepage = itemView.findViewById(R.id.homepage);
            final TextView phoneNumber = itemView.findViewById(R.id.phoneNumber);
            final TextView email = itemView.findViewById(R.id.email);
            ImageView image = itemView.findViewById(R.id.image);

            name.setText(university.getName());
            homepage.setText(university.getHomepage());
            phoneNumber.setText(university.getPhoneNumber());
            email.setText(university.getEmail());

            Glide.with(context)
                    .load(university.getImageUrl())
                    .into(image);

            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + university.getEmail()));
                    context.startActivity(intent);
                }
            });

            homepage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(university.getHomepage()));
                    context.startActivity(intent);
                }
            });

            phoneNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + university.getPhoneNumber()));
                    context.startActivity(intent);
                }
            });

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ImageActivity.class);
                    intent.putExtra("imageResId", university.getImageUrl());
                    context.startActivity(intent);
                }
            });
        }
    }
}