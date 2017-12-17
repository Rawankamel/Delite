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

public class SignU extends AppCompatActivity {
    MaterialEditText editPhone,editName,editPassword,editEmail,editAddress;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_u);

        editName=(MaterialEditText)findViewById(R.id.editName);
        editPassword=(MaterialEditText)findViewById(R.id.editPassword);
        editEmail=(MaterialEditText)findViewById(R.id.editEmail);
        editPhone=(MaterialEditText)findViewById(R.id.editPhone);
        editAddress=(MaterialEditText)findViewById(R.id.editAddress);

        btnSignUp =(Button)findViewById(R.id.btnSignUp);

        //init firebase

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tableUser=database.getReference("Users");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog=new ProgressDialog(SignU.this) ;
                mDialog.setMessage("please waiting....");
                mDialog.show();

                tableUser.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //check if phone exist
                        if(dataSnapshot.child(editPhone.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(SignU.this, "phone is already register ", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            mDialog.dismiss();
                            Users users =new Users(editName.getText().toString(),editPassword.getText().toString(),editAddress.getText().toString(),editEmail.getText().toString());
                            tableUser.child(editPhone.getText().toString()).setValue(users);
                            Toast.makeText(SignU.this, "sign up successfully!! ", Toast.LENGTH_SHORT).show();
                            finish();

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
