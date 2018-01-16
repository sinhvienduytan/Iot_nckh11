package com.example.pc.iot_nckh;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 9/11/2017.
 */

public class Dangky extends AppCompatActivity{
    EditText edttaikhoan,edtmatkhau;
    Button btndangky,btnnhaplai;
    TextView txtquaylaidangnhap;
    database database2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.dangky);
        edttaikhoan =(EditText)findViewById(R.id.edtUsernamedangky);
        edtmatkhau = (EditText)findViewById(R.id.edtMatkhaudangky);
        btndangky = (Button)findViewById(R.id.btndangky);
        btnnhaplai = (Button)findViewById(R.id.btnxoa);
        txtquaylaidangnhap = (TextView)findViewById(R.id.txtSignup11);
       // Cursor1();
        String taikhoan = edttaikhoan.getText().toString();
        String matkhau = edtmatkhau.getText().toString();


        //------tao database-----//
        database2 = new database(this, "qltaikhoan",null,1);
        //-----tao bang taikhoan---//
        database2.QueryData("CREATE TABLE IF NOT EXISTS TaiKhoan(Id INTEGER PRIMARY KEY AUTOINCREMENT, TaiKhoan VARCHAR(200),MatKhau VARCHAR(200))");
      //  database2.QueryData("INSERT INTO TaiKhoan VALUES(null,'"+taikhoan+"','"+matkhau+"')");
       // database2.QueryData("INSERT INTO TaiKhoan VALUES(null,'nguyendangkhoa','khoa')");
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = edttaikhoan.getText().toString();
                String matkhau = edtmatkhau.getText().toString();
                if(taikhoan.equals("")){
                    Toast.makeText(Dangky.this, "vui lòng nhập tài khoản cần đăng ký", Toast.LENGTH_SHORT).show();
               }else {
                    database2.QueryData("INSERT INTO TaiKhoan VALUES(null,'"+taikhoan+"','"+matkhau+"')");
                    Toast.makeText(Dangky.this, "Chúc mừng bạn đã đăng ký thành công tài khoản", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnnhaplai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttaikhoan.setText("");
                edtmatkhau.setText("");
                edttaikhoan.requestFocus();
            }
        });
        txtquaylaidangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent();
            }
        });
    }
    public void intent()
    {
        Intent intent1 = new Intent(this,Giaodien.class);
        startActivity(intent1);
    }
    public void Cursor1(){
        Cursor datataikhoan = database2.GetData("SELECT * FROM TaiKhoan");
        while (datataikhoan.moveToNext()){
            String taikhoan1 = datataikhoan.getString(1);
            String matkhau1 = datataikhoan.getString(2);
            Toast.makeText(Dangky.this,"tai khoan : "+ taikhoan1 + "  mat khau : "+matkhau1, Toast.LENGTH_SHORT).show();
        }
    }
}
