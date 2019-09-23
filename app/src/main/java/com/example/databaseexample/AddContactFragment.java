package com.example.databaseexample;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment{

    private Button Save;
    private EditText Name, ID, Email;

    public AddContactFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_contact, container, false);

        Save=view.findViewById(R.id.save);
        ID=view.findViewById(R.id.c_id);
        Name=view.findViewById(R.id.c_name);
        Email=view.findViewById(R.id.c_email);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=ID.getText().toString();
                String name=Name.getText().toString();
                String email=Email.getText().toString();

                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase db=contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(id),name, email, db );
                contactDbHelper.close();
                ID.setText("");
                Name.setText("");
                Email.setText("");
                Toast.makeText(getActivity(), "Contact saved", Toast.LENGTH_LONG).show();
            }
        });
        return view;

    }

}
