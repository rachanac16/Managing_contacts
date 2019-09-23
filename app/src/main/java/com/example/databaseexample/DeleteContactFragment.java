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


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteContactFragment extends Fragment {

    private Button delete_contact;
    private EditText deleteID;
    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_delete_contact, container, false);

        delete_contact=view.findViewById(R.id.delete_button);
        deleteID=view.findViewById(R.id.delete_id);
        delete_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=deleteID.getText().toString();

                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase database=contactDbHelper.getWritableDatabase();
                contactDbHelper.deleteContact(Integer.parseInt(id), database);
                contactDbHelper.close();

                deleteID.setText("");
                Toast.makeText(getActivity(), "Contact deleted...", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
