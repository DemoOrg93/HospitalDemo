package com.prakriti.finaldemo;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.prakriti.finaldemo.Dbhelper.DbHelper;


public class SignUpPage extends AppCompatActivity {
    EditText first_name,middle_name,last_name,address,contact, email, username, password,confirmpassword;
    Button register;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    DbHelper dbHelper;
    String sfirstname, smiddlename, slastname,saddress, susername,  spassword, sconfirmpassword, semail, scontact;
    // String aname, ausername,  apassword, aconfirmpassword, aemail, acontact;
    TextInputLayout inputLayoutname, inputLayoutusername, inputLayoutpassword,
            inputLayoutemail, inputLayoutcontact,inputLayoutaddress;
    TextInputLayout inputLayoutconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_sign);
        first_name = (EditText) findViewById(R.id.signupfirstname);
        middle_name = (EditText) findViewById(R.id.signupmiddlename);
        last_name = (EditText) findViewById(R.id.signuplastname);
        address = (EditText) findViewById(R.id.signupAddress);
        contact = (EditText) findViewById(R.id.signupContact);
        email = (EditText) findViewById(R.id.signupemail);
        username = (EditText) findViewById(R.id.signupUsername);
        password = (EditText) findViewById(R.id.singupPassword);
        dbHelper = new DbHelper(SignUpPage.this);
        username = (EditText) findViewById(R.id.signupUsername);
        password = (EditText) findViewById(R.id.singupPassword);
        confirmpassword = (EditText) findViewById(R.id.singupconfirmPassword);
        contact = (EditText) findViewById(R.id.signupContact);
        email = (EditText) findViewById(R.id.signupemail);
        register = (Button) findViewById(R.id.btnRegister);
   /*     inputLayoutusername = (TextInputLayout) findViewById(R.id.inputlayout_username);
        inputLayoutpassword = (TextInputLayout) findViewById(R.id.inputlayout_password);
        inputLayoutcontact = (TextInputLayout) findViewById(R.id.inputlayout_Contact);
        inputLayoutaddress = (TextInputLayout) findViewById(R.id.inputlayout_address);
        inputLayoutconfirm = (TextInputLayout) findViewById(R.id.inputlayout_confirmpassword);
        inputLayoutemail = (TextInputLayout) findViewById(R.id.inputlayout_email);*/

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfirstname = first_name.getText().toString();
                smiddlename = middle_name.getText().toString();
                slastname = last_name.getText().toString();
                saddress = address.getText().toString();
                scontact = contact.getText().toString();
                semail = email.getText().toString();
                susername = username.getText().toString();
                spassword = password.getText().toString();




                if (sfirstname.equals("") ||confirmpassword.getText().toString().equals("") ||slastname.equals("") ||sfirstname.equals("")
                        || saddress.equals("")
                        || spassword.equals("")|| semail.equals("")|| scontact.equals("")) {

                    Toast.makeText(getApplicationContext(), "Field Vaccant",
                            Toast.LENGTH_LONG).show();

                }
                else if(!semail.matches(emailPattern)){
                    Toast.makeText(SignUpPage.this, "Invalid Password", Toast.LENGTH_SHORT).show();

                }
                else if(!confirmpassword.getText().toString().equals(password.getText().toString())){
                    Toast.makeText(SignUpPage.this, "Password doesn't match", Toast.LENGTH_SHORT).show();

                }
                else if(scontact.length() != 10){
                    Toast.makeText(SignUpPage.this, "Invalid Contact", Toast.LENGTH_SHORT).show();
                }

                else if(sfirstname.length()<=4 && username.length() <=4){
                    Toast.makeText(SignUpPage.this, "Username and Name most contain more than " +
                            "4 letter ", Toast.LENGTH_SHORT).show();
                }
                else {


                    ContentValues cv = new ContentValues();
                    cv.put("first_name", sfirstname);
                    cv.put("middle_name", smiddlename);
                    cv.put("last_name", slastname);
                    cv.put("address", saddress);
                    cv.put("username", susername);
                    cv.put("password", spassword);
                    cv.put("email", semail);
                    cv.put("contact", scontact);

                    dbHelper.insertuserinfo(cv);

                    //  Toast.makeText(SignUpPage.this, "sname", Toast.LENGTH_SHORT).show();

                    Toast.makeText(getApplicationContext(),
                            "Account Successfully Created ", Toast.LENGTH_LONG)
                            .show();
                    Intent i = new Intent(SignUpPage.this,
                            LoginPage.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        dbHelper.close();
    }
}





