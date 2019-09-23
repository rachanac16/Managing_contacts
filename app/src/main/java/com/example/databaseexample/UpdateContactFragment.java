package com.example.databaseexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateContactFragment extends Fragment {

    private Button update;
    private EditText id, name, email;
    public UpdateContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_contact, container, false);

        update=view.findViewById(R.id.update_button);
        id=view.findViewById(R.id.update_id);
        name=view.findViewById(R.id.update_name);
        email=view.findViewById(R.id.update_email);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedID=id.getText().toString();
                String updatedName=name.getText().toString();
                String updatedEmail=email.getText().toString();

                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase database=contactDbHelper.getWritableDatabase();
                contactDbHelper.updateContact(Integer.parseInt(updatedID), updatedName, updatedEmail, database);
                contactDbHelper.close();
                id.setText("");
                name.setText("");
                email.setText("");
                Toast.makeText(getActivity(), "Contact updated", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
