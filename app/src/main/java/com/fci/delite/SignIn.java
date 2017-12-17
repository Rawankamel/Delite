package com.fci.delite;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fci.delite.Model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    EditText editPhone,editPassword ;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPhone =(MaterialEditText)findViewById(R.id.editPhone);
        editPassword =(MaterialEditText)findViewById(R.id.editPassword);
        btnSignIn =(Button)findViewById(R.id.btnSignIn);

        //init firebase

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
       final DatabaseReference tableUser=database.getReference("Users");

       btnSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

              final ProgressDialog mDialog=new ProgressDialog(SignIn.this) ;
               mDialog.setMessage("please waiting....");
               mDialog.show();


                   tableUser.addValueEventListener(new ValueEventListener() {
                       @Override
                       public void onDataChange(DataSnapshot dataSnapshot) {
                           //check if user not exist

                           if(dataSnapshot.child(editPhone.getText().toString()).exists())

                           {
                               //GetUser information

                               mDialog.dismiss();

                               Users Users = dataSnapshot.child(editPhone.getText().toString()).getValue(Users.class);
                               if (Users.getPassword().equals(editPassword.getText().toString())) {
                                   Toast.makeText(SignIn.this, "Sign in Successfully!", Toast.LENGTH_SHORT).show();
                               } else {
                                   Toast.makeText(SignIn.this, "Wrong Password!!!", Toast.LENGTH_SHORT).show();
                               }
                           }
                           else
                           {
                               mDialog.dismiss();
                              Toast.makeText(SignIn.this, "user not exist in Database ", Toast.LENGTH_SHORT).show();
                           }
                       }

                       @Override
                       public void onCancelled(DatabaseError databaseError) {

                       }
                   });
           }
       });




    }
}
