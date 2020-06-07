package com.hrishique.contactsapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
   List<Contacts> contactsList;
   private Context context;

   public ContactAdapter(List<Contacts> contactsList,Context context){
        this.context=context;
        this.contactsList=contactsList;
   }

    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.contactlistview,parent,false);
        return new ContactViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder holder, int position) {
        Contacts data= contactsList.get(position);
      //  holder.contactnameview.setText(data.getContactname());
        holder.contactnumberview.setText(data.getContactnumber());

    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

       TextView contactnameview,contactnumberview;

       public ContactViewHolder(@NonNull View itemView) {
           super(itemView);

         //  contactnameview=itemView.findViewById(R.id.contact_name_view);
           contactnumberview=itemView.findViewById(R.id.contact_number_view);

        }
    }
}
