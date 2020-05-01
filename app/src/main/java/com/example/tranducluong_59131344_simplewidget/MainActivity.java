package com.example.tranducluong_59131344_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText editHoten,editNgaysinh,editText3;
    RadioGroup rdgGioiTinh;
    CheckBox cbXP,cbNN,cbdiCF,cbHOME,cbNA;
    Button buttonXN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Addview();
        AddEnvent();
    }

    private void Addview()
    {
        editHoten = findViewById(R.id.editHoten);
        editNgaysinh = findViewById(R.id.editNgaysinh);
        editText3 = findViewById(R.id.editText3);
        rdgGioiTinh= findViewById(R.id.rdgGioiTinh);
        cbXP=findViewById(R.id.cbXP);
        cbNN = findViewById(R.id.cbNN);
        cbHOME=findViewById(R.id.cbHOME);
        cbNA=findViewById(R.id.cbNA);
        cbdiCF=findViewById(R.id.cbdiCF);
        buttonXN=findViewById(R.id.buttonXN);
    }

    private void AddEnvent()
    {
        buttonXN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                xacnhan();
            }
        });
    }
    private void xacnhan()
    {
        String Ketqua = "";
        Ketqua = "Họ tên: " + editHoten.getText() +"\n" + "Ngày sinh: " +editNgaysinh.getText() + "\n";
        switch (rdgGioiTinh.getCheckedRadioButtonId())
        {
            case R.id.rbNam: Ketqua += "Giới tính: " + "Nam" + "\n" + "Sở thích: ";break;
            case R.id.rbNu: Ketqua += "Giới tính: " + "Nữ" + "\n" + "Sở thích: ";break;

        }

        Ketqua += HDCheckBox();
        Toast.makeText(MainActivity.this, Ketqua, Toast.LENGTH_SHORT).show();
    }
    private String HDCheckBox()
    {
        String Ketqua="";
        CheckBox [] arrCb = new CheckBox[]{cbXP, cbNN,cbdiCF, cbHOME, cbNA};
        for(int i = 0; i < arrCb.length; i++)
        {
            if(arrCb[i].isChecked())
            {
                Ketqua += arrCb[i].getText().toString() + "; ";
            }
        }

        Ketqua += editText3.getText();
        return Ketqua;
    }
}