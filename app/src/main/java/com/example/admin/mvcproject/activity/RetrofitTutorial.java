package com.example.admin.mvcproject.activity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.mvcproject.R;
import com.example.admin.mvcproject.model.Student;
import com.example.admin.mvcproject.rest.APIServiceTut;

import java.util.List;

import retrofit2.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTutorial extends AppCompatActivity {

    private Button getBttn, insertBttn;
    private EditText e1;
    private TextView t1;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofittutorial);

        getBttn = (Button) findViewById(R.id.getBttn1);
        insertBttn = (Button) findViewById(R.id.insertBttn1);
        e1 = (EditText) findViewById(R.id.editName);
        t1 = (TextView) findViewById(R.id.details);
        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Getting done");

        getBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        insertBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getPeopleDetails();
            }
        });
    }

    private void getPeopleDetails() {
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mytriangle.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIServiceTut apiServiceTut = retrofit.create(APIServiceTut.class);
        Call<List<Student>> listCall = apiServiceTut.getPeopleDetails();

        listCall.enqueue(new Callback<List<Student>>() {
            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {

                List<Student> students = response.body();
                String details = "";

                for(int i = 0; i < students.size() ; i++){
                    String name = students.get(i).getName();

                    details += "\n\nname" + name;
                }

                t1.setText(details);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }
}
