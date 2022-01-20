package com.example.androidqu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PosActivity extends AppCompatActivity {
    private EditText edtnamapel, edtnamabar, edtjumlahbel, edtharga, edtuangbay;
    private TextView txtnamapel;
    private TextView txtnamabar;
    private TextView txtjumlahbel;
    private TextView txtharga;
    private TextView txtuangbay;
    private TextView txtbonus;
    private TextView txttotalbelanja;
    private TextView txtuangkembali;
    private TextView txtketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos);

        getSupportActionBar().setTitle("Point Of $ale");

        edtnamapel = (EditText) findViewById(R.id.namapembeli);
//        edtnamabar = (EditText) findViewById(R.id.namabarang);
        edtjumlahbel = (EditText) findViewById(R.id.jumlahpembelian);
        edtharga = (EditText) findViewById(R.id.harga);
        edtuangbay = (EditText) findViewById(R.id.uangbayar);
        Button btnproses = (Button) findViewById(R.id.btnproses);
        Button btnhapus = (Button) findViewById(R.id.tombol2);
        Button btnexit = (Button) findViewById(R.id.tombol3);
        txtnamapel = (TextView) findViewById(R.id.namapembeli);
//        txtnamabar = (TextView) findViewById(R.id.namabarang);
        txtjumlahbel = (TextView) findViewById(R.id.jumlahpembelian);
        txtharga = (TextView) findViewById(R.id.harga);
        txtuangbay = (TextView) findViewById(R.id.uangbayar);
        txtbonus = (TextView) findViewById(R.id.bonus);
        txttotalbelanja = (TextView) findViewById(R.id.totalbelanja);
        txtuangkembali = (TextView) findViewById(R.id.uangkembali);
        txtketerangan = (TextView) findViewById(R.id.keterangan);

        //memberikan action pada tombol proses

        btnproses.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String namapelanggan = edtnamapel.getText().toString().trim();
                String namabarang = edtnamabar.getText().toString().trim();
                String jumlahbeli = edtjumlahbel.getText().toString().trim();
                String harga = edtharga.getText().toString().trim();
                String uangbayar = edtuangbay.getText().toString().trim();

                double jb = Double.parseDouble(jumlahbeli);
                double h = Double.parseDouble(harga);
                double ub = Double.parseDouble(uangbayar);
                double total = (jb * h);
                txttotalbelanja.setText("Total Belanja : " + total);

                //pemberian if dan else untuk aturan pemberian bonus

                if (total >=200000){
                    txtbonus.setText("Bonus : Mouse");
                } else if (total >=50000){
                    txtbonus.setText("Bonus : Keyboard");
                } else  if (total >=40000){
                    txtbonus.setText("Bonus : Harddisk");
                } else {
                    txtbonus.setText("Bonus : Tidak Ada Bonus");
                }
                double uangkembalian = (ub - total);

                if (ub < total){
                    txtketerangan.setText("Keterangan : uang bayar kurang Rp " + (-uangkembalian));
                    txtuangkembali.setText("Uang Kembali : Rp 0" );
                }else{
                    txtketerangan.setText("Keterangan : Tunggu Kembalian");
                    txtuangkembali.setText("Uang Kembali : " + uangkembalian);
                }


                //memberikan action pada tombol reset data
            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                txtnamapel.setText(" ");
                txtnamabar.setText(" ");
                txttotalbelanja.setText(" Total Belanja : Rp 0");
                txtharga.setText(" ");
                txtuangbay.setText(" ");
                txtuangkembali.setText("Uang Kembali : Rp 0");
                txtbonus.setText("Bonus : - ");
                txtjumlahbel.setText(" ");
                txtketerangan.setText("Keterangan : - ");

                Toast.makeText(getApplicationContext(),"Data sudah direset", Toast.LENGTH_LONG).show();

                // memberikan action pada tombol keluar
            }
        });
        btnexit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                moveTaskToBack(true);
            }
        });
    }

    public void resetData(View view) {
        startActivity(new Intent(PosActivity.this, PosActivity.class));
    }
}