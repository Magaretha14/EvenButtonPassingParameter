package com.example.sampleconstraintlayoutevenbutton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity{
    //Deklarasi variabel dengan tipe data editText
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;

    //Deklarasi variabel dengan tipe data floating Action Button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        //Menghubungkan variabel edtNama dengan componen Textview pada layout
        edtNama = findViewById(R.id.edNama);

        //Menghubungkan variabel edtAlamat dengan componen Textview pada layout
        edtAlamat = findViewById(R.id.edAlamat);

        //Menghubungkan variabel edtEmail dengan componen Textview pada layout
        edtEmail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edtPassword dengan componen Textview pada layout
        edtPassword = findViewById(R.id.edPass);

        //Menghubungkan variabel edtrepass dengan componen Textview pada layout
        edtrepass = findViewById(R.id.edrepass);

        fab = findViewById(R.id.fabSimpan);

        //Membuat method untuk event dari floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat kondisi untuk mengecek apakah EditText kosong atau tidak
                if(edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Snackbar.make(view,"Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    //Membuat kondisi untuk mengecek apakah isi dari EditText password dan EditText repassword
                    //sama atau tidak
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        //Menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(DaftarActivity.this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();

                        //Method untuk kembali ke activity Main
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        //Menampilkan pesan bahwa isi dari EditText password dan EditText repassword tidak sama
                        Snackbar.make(view, "Password dan Repassword harus sama!", Snackbar.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
