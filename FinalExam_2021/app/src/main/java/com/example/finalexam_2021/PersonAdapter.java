package com.example.finalexam_2021;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.finalexam_2021.PersonDbHelper;
import com.example.finalexam_2021.R;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private Context context;
    private Cursor cursor;

    public PersonAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView emailTextView;
        public TextView phoneTextView;

        public PersonViewHolder(View item_person) {
            super(item_person);
            nameTextView = item_person.findViewById(R.id.nameTextView);
            emailTextView = item_person.findViewById(R.id.emailTextView);
            phoneTextView = item_person.findViewById(R.id.phoneTextView);

            phoneTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phoneNumber = phoneTextView.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNumber));
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                }
            });

            emailTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String emailAddress = emailTextView.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + emailAddress));
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_person, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        if (!cursor.moveToPosition(position)) {
            return;
        }

        String name = cursor.getString(cursor.getColumnIndex(PersonDbHelper.COLUMN_NAME_NAME));
        String email = cursor.getString(cursor.getColumnIndex(PersonDbHelper.COLUMN_EMAIL_EMAIL));
        String phone = cursor.getString(cursor.getColumnIndex(PersonDbHelper.COLUMN_PHONE_PHONE));

        holder.nameTextView.setText(name);
        holder.emailTextView.setText(email);
        holder.phoneTextView.setText(phone);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }
}