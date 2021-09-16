package com.example.studentshub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.pinpoint.PinpointConfiguration;
import com.amazonaws.mobileconnectors.pinpoint.PinpointManager;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    private static PinpointManager pinpointManager;

    public static PinpointManager getPinpointManager(final Context applicationContext) {
        if (pinpointManager == null) {
            final AWSConfiguration awsConfig = new AWSConfiguration(applicationContext);
            AWSMobileClient.getInstance().initialize(applicationContext, awsConfig, new Callback<UserStateDetails>() {
                @Override
                public void onResult(UserStateDetails userStateDetails) {
                    Log.i("INIT", userStateDetails.getUserState().toString());
                }

                @Override
                public void onError(Exception e) {
                    Log.e("INIT", "Initialization error.", e);
                }
            });

            PinpointConfiguration pinpointConfig = new PinpointConfiguration(
                    applicationContext,
                    AWSMobileClient.getInstance(),
                    awsConfig);

            pinpointManager = new PinpointManager(pinpointConfig);

            FirebaseMessaging.getInstance().getToken()
                    .addOnCompleteListener(new OnCompleteListener<String>() {
                        @Override
                        public void onComplete(@NonNull Task<String> task) {
                            if (!task.isSuccessful()) {
                                Log.w("Amplify", "Fetching FCM registration token failed", task.getException());
                                return;
                            }
                            final String token = task.getResult();
                            Log.d("Amplify", "Registering push notifications token: " + token);
                            pinpointManager.getNotificationClient().registerDeviceToken(token);
                            Log.i("is this working?","2");
                            RemoteMessage message = new RemoteMessage.Builder("eyygc1B4SpqrpTPF9JCcky:APA91bGxWh7yh0aE9SP4_uIEqHRlIp6UpqLz3AIuLCMT-WynugPs9mhHvC30I7swbQTrpWQ44T8tluEEbvfvaZXFJbiSKitAxliFRha2OM5kVUOszRadrJ6dGLDUnenx2rRg_N63ku5Q@gcm.googleapis.com").addData("title","This is a title").setTtl(5).build();
                            FirebaseMessaging.getInstance().send(message);
                            
                        }
                    });
        }

        return pinpointManager;
    }

    File fileTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSS3StoragePlugin());
            Amplify.configure(getApplicationContext());
            getPinpointManager(getApplicationContext());

            Log.i("MyAmplifyApp", "Initialized Amplify");

        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
        }



        //check if password satisfies the rules before calling the code
        // sign up activity (replace email, usuername, and password with the ones the user entered)
//        AuthSignUpOptions options = AuthSignUpOptions.builder()
//                .userAttribute(AuthUserAttributeKey.email(), "hanaamaratouk@gmail.com")
//                .build();
//        Amplify.Auth.signUp("maratouk", "Pass123456", options,
//                result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
//                error -> Log.e("AuthQuickStart", "Sign up failed", error)
//        );

        // sign up confirmation activity - ask the user for the code that he has received over email
//        Amplify.Auth.confirmSignUp(
//                "maratouk",
//                "633165",
//                result -> Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete"),
//                error -> Log.e("AuthQuickstart", error.toString())
//        );


        // Signin Activity , ask for username and password, pass them to this code
        Amplify.Auth.signInWithWebUI(
                this,
                result -> {Log.i("AuthQuickStart", result.toString());
                    pickFile();
//                    Amplify.Storage.downloadFile(
//                            "ExampleKey",
//                            new File(getApplicationContext().getFilesDir() + "/download.jpg"),
//                            result2 -> Log.i("MyAmplifyApp", "Successfully downloaded: " + result2.getFile().getName()),
//                            error -> Log.e("MyAmplifyApp",  "Download Failure", error)
//                    );
                },
                error -> Log.e("AuthQuickStart", error.toString())
        );



//        Amplify.Auth.signOut(
//                () ->{
        //navigate the user somewhere
//                Log.i("AuthQuickstart", "Signed out successfully")    // web UI, sign in},
//                error -> Log.e("AuthQuickstart", error.toString())
//        );


//        Amplify.Auth.fetchAuthSession(
//                result -> Log.i("AmplifyQuickstart", result.toString()),
//                error -> Log.e("AmplifyQuickstart", error.toString())
//        );

        // move to on resume
        String welcomeMessage = "Welcome ";
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String instructorName = sharedPreferences.getString("instructorName", "Instructor");

        TextView instructorNameView = findViewById(R.id.welcomeMessage);
        instructorNameView.setText(welcomeMessage + instructorName);
        // ---- end of code to add to on resume ----

        Button addStudentButton = findViewById(R.id.addStudentButton);
        Button allStudents = findViewById(R.id.allStudentsButton);
        Button instructorPage = findViewById(R.id.instructorPageButton);
        Button addMajor = findViewById(R.id.adddMajor);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddStudent = new Intent(MainActivity.this, AddStudentActivity.class);
                goToAddStudent.putExtra("id","b6799fa3-0414-46e2-9a74-2454028db2f7");
                startActivity(goToAddStudent);
            }
        });

        allStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHub = new Intent(MainActivity.this, TheHubActivity.class);
                startActivity(goToHub);
            }
        });

        instructorPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToInstructorPage = new Intent(MainActivity.this, InstructorPage.class);
                startActivity(goToInstructorPage);
            }
        });

        addMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToAddMajor = new Intent(MainActivity.this, AddMajor.class);
                startActivity(goToAddMajor);
            }
        });


    }

    private void pickFile() {
        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
        chooseFile.setType("*/*");  //any
        chooseFile = Intent.createChooser(chooseFile, "Choose a file");
        startActivityForResult(chooseFile, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

//        Uri returnUri = data.getData();
//        Cursor returnCursor = getContentResolver().query(returnUri, null, null, null, null);
//        int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
//        returnCursor.moveToFirst();
//        String fileName = returnCursor.getString(nameIndex);
//        File file = new File(getApplicationContext().getFilesDir(), "copied");

        try {
            //resultData.setType(  getContentResolver().getType(resultData.getData()));
            InputStream inputStream =  getContentResolver().openInputStream(data.getData());
//            OutputStream outputStream = new FileOutputStream(file);
//            byte[] buf = new byte[1024];
//            int len;
//            while ((len = inputStream.read (buf)) >0){
//                outputStream.write(buf, 0, len);
//            }
//            inputStream.close();
//            outputStream.close();

//            Amplify.Storage.uploadFile(
//                    "theimage",
//                    file,
//                    result -> Log.i("MyAmplifyApp", "Successfully uploaded: " + result.getKey()),
//                    storageFailure -> Log.e("MyAmplifyApp", "Upload failed", storageFailure)
//            );

            Amplify.Storage.uploadInputStream(
                    "ExampleKey",
                    inputStream,
                    result ->{ Log.i("MyAmplifyApp", "Successfully uploaded: " + result.getKey());
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    },
                    storageFailure -> Log.e("MyAmplifyApp", "Upload failed", storageFailure)
            );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //

        super.onActivityResult(requestCode, resultCode, data);
    }
}