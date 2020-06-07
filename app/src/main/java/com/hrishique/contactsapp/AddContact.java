package com.hrishique.contactsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddContact extends AppCompatActivity {
    DatabaseReference dRef;
    Button addcontactbutton;
    EditText contactname,contactnumber,contactemail;
    String contactnamesend,contactnumbersend,contactemailsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        dRef= FirebaseDatabase.getInstance().getReference();

        contactname=findViewById(R.id.contact_name);
        contactnumber=findViewById(R.id.contact_number);
        contactemail=findViewById(R.id.contact_email);
        addcontactbutton=findViewById(R.id.add_contact_button);
    }

    public void AddContact(View view) {
        contactnamesend=contactname.getText().toString();
        contactnumbersend=contactnumber.getText().toString();
        contactemailsend=contactemail.getText().toString();

        if (TextUtils.isEmpty(contactemailsend) || TextUtils.isEmpty(contactnumbersend) || TextUtils.isEmpty(contactnamesend)){
            return;
        }
        AddNotesInDatabase(contactemailsend,contactnumbersend,contactnamesend);
    }

    private void AddNotesInDatabase(String contactemailsend, String contactnumbersend, String contactnamesend) {
        String id =dRef.push().getKey();
        Contacts contact=new Contacts(id,contactemailsend,contactnumbersend,contactnamesend);
        dRef.child("Contacts").child(id).setValue(contact).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Contact Added",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Try again",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
