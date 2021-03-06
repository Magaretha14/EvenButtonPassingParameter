package com.example.sampleconstraintlayoutevenbutton;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //membuat komdisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar){
            //method untuk memanggil activity "Daftar Activity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        //return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnlogin dengan componen button pada layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                if (nama.equals("admin@mail.com") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_LONG).show();

                    //Membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukkan value dari variabel nama dengan kunci "a"
                    // dan dimasukkan ke dalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variabel password dengan kunci "b"
                    // dan dimasukkan ke dalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke ActivityKedua
                    Intent i = new Intent(getApplicationContext(), ActivityKedua.class);

                    i.putExtras(b);

                    startActivity(i);
                }
                else if(nama.equals("admin@mail.com") && password.equals(password)){
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_LONG).show();
                }
                else if(nama.equals(nama) && password.equals("123")){
                    Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Email dan Password Salah", Toast.LENGTH_LONG).show();
                }

            }


        });

    }

}