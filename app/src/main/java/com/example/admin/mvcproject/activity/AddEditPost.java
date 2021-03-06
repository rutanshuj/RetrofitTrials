package com.example.admin.mvcproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.mvcproject.R;
import com.example.admin.mvcproject.model.Post;
import com.example.admin.mvcproject.rest.ApiInterface;
import com.example.admin.mvcproject.rest.PostClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddEditPost extends AppCompatActivity{
    private TextView mResponseTv, mPutResponse;
    private ApiInterface apiService;
    private Button b1;
    private static final String TAG = AddEditPost.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addeditpost);

        final EditText titleEt = (EditText) findViewById(R.id.et_title);
        final EditText bodyEt = (EditText) findViewById(R.id.et_body);
        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        b1 = (Button) findViewById(R.id.update_bttn);
        mResponseTv = (TextView) findViewById(R.id.tv_response);
        mPutResponse = (TextView) findViewById(R.id.put_response);

        apiService = PostClient.getClient().create(ApiInterface.class);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                    sendPost(title, body);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                    putResponse(title, body);
                }
            }
        });
    }

    private void putResponse(String title, String body) {
        apiService.updatePost(12, title, body, 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(mPutResponse.getVisibility() == View.GONE) {
                    mPutResponse.setVisibility(View.VISIBLE);
                }
                mPutResponse.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public void sendPost(String title, String body) {
        apiService.savePost(title, body,1).enqueue(new Callback<Post>() {

            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                showResponse(response.body().toString());
                Log.i(TAG, "post submitted to API." + response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }

    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}
