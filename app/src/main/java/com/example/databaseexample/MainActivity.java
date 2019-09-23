package com.example.databaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements UserLayout.OnDbListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null){
                return;
            }

            UserLayout frag= new UserLayout();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, frag).commit();
        }

        }

    @Override
    public void OnDbPerformed(int method) {

        switch (method){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddContactFragment()).addToBackStack(null).commit();
                break;

            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ReadContactFragment()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UpdateContactFragment()).addToBackStack(null).commit();
                break;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DeleteContactFragment()).addToBackStack(null).commit();
                break;
        }

    }
}
