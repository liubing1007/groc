package com.ginkodrop.grpc;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.login.LoginReply;
import io.grpc.examples.login.LoginRequest;
import io.grpc.examples.login.LoginServerGrpc;

/**
 * @Descripition
 * @Auther liubing
 * @CreateTime 2019/3/5
 * @Version
 * @Since
 */

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUser;
    private EditText editTextPwd;
    private TextView loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUser = (EditText) findViewById(R.id.edit_text_user);
        editTextPwd = (EditText) findViewById(R.id.edit_text_pwd);
        loginBtn = (TextView) findViewById(R.id.btn_login_confirm);
        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String passwd = editTextPwd.getText().toString().trim();
                String userName = editTextUser.getText().toString().trim();
                new GrpcTask(LoginActivity.this)
                        .execute(userName, passwd);

            }
        });
    }

    private static class GrpcTask extends AsyncTask<String, Void, LoginReply> {
        private final WeakReference<Activity> activityReference;
        private ManagedChannel channel;

        private GrpcTask(Activity activity) {
            this.activityReference = new WeakReference<Activity>(activity);
        }

        @Override
        protected LoginReply doInBackground(String... params) {
            String userName = params[0];
            String passwd = params[1];
            try {
                channel = ManagedChannelBuilder.forAddress("192.168.10.113", 23333).usePlaintext(true).build();
                LoginServerGrpc.LoginServerBlockingStub stub = LoginServerGrpc.newBlockingStub(channel);
                LoginRequest request = LoginRequest.newBuilder().setUserName(userName).setPwd(passwd).build();
                LoginReply reply = stub.login(request);
                return reply;
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                pw.flush();
                Log.d("liubing", String.format("Failed... : %n%s", sw));
                return null;
            }
        }

        @Override
        protected void onPostExecute(LoginReply result) {
            try {
                channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Activity activity = activityReference.get();
            if (activity == null) {
                return;
            }
            if(result.getCode() == 0){
                Toast.makeText(activity, "登录成功", Toast.LENGTH_LONG).show();
                activity.startActivity(new Intent(activity, JWTActivity.class));
            }else {
                Toast.makeText(activity, result.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
