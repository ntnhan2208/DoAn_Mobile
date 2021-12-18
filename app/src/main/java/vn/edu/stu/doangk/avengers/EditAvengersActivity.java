package vn.edu.stu.doangk.avengers;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.stu.doangk.AboutActivity;
import vn.edu.stu.doangk.MainActivity;
import vn.edu.stu.doangk.QuanLyActivity;
import vn.edu.stu.doangk.R;
import vn.edu.stu.doangk.model.Avenger;
import vn.edu.stu.doangk.model.Phe;

public class EditAvengersActivity extends AppCompatActivity {
    private EditText ma, ten, phe, vukhi, sucmanh;
    private Button them, sua, xoa;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuAbout:
                Intent intent = new Intent(EditAvengersActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.menuExit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editavengers);

        ma = findViewById(R.id.edtMa);
        ten = findViewById(R.id.edtTen);
        phe = findViewById(R.id.edtPhe);
        vukhi = findViewById(R.id.edtVuKhi);
        sucmanh = findViewById(R.id.edtSucManh);
        them = findViewById(R.id.btnThem);
        sua = findViewById(R.id.btnSua);
        xoa = findViewById(R.id.btnXoa);


        Intent intent = getIntent();
        int position = intent.getIntExtra("vitri", 0);
        Avenger avenger = QuanLyActivity.listAven.get(position);
        showThongTin(avenger);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer id = Integer.parseInt(ma.getText().toString());
                String tenav = ten.getText().toString();
                Phe p = null;
                boolean ck = false;
                for (int i = 0; i < QuanLyActivity.listPhe.size(); i++) {
                    Phe pheav = QuanLyActivity.listPhe.get(i);
                    if (pheav.getTenphe().equals(phe.getText().toString())) {
                        p = pheav;
                        ck = true;
                        break;
                    }
                }
                if (!ck) {
                    p = new Phe(phe.getText().toString());
                    QuanLyActivity.listPhe.add(p);
                }
                String vukhiav = vukhi.getText().toString();
                String sucmanhav = sucmanh.getText().toString();
                QuanLyActivity.listAven.add(new Avenger(id, tenav, null, p, vukhiav, sucmanhav));
                Toast.makeText(EditAvengersActivity.this, "Thêm thành công!!!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(EditAvengersActivity.this,DanhSachAvengersActivity.class);
                startActivity(intent);
            }
        });

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avenger.setTen(ten.getText().toString());
                boolean ck = false;
                for (int i = 0; i < QuanLyActivity.listPhe.size(); i++) {
                    Phe pheav = QuanLyActivity.listPhe.get(i);
                    if (pheav.getTenphe().equals(phe.getText().toString())) {
                        avenger.setPhe(pheav);
                        ck = true;
                        break;
                    }
                }
                if (!ck) {
                    Phe p = new Phe(phe.getText().toString());
                    QuanLyActivity.listPhe.add(p);
                    avenger.setPhe(p);
                }
                avenger.setVukhi(vukhi.getText().toString());
                avenger.setSucmanh(sucmanh.getText().toString());
                QuanLyActivity.listAven.set(position, avenger);
                Toast.makeText(EditAvengersActivity.this, "Sửa thành công!!!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(EditAvengersActivity.this,DanhSachAvengersActivity.class);
                startActivity(intent);
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuanLyActivity.listAven.remove(position);
                finish();
                Intent intent=new Intent(EditAvengersActivity.this,DanhSachAvengersActivity.class);
                startActivity(intent);
            }

        });
    }

    private void showThongTin(Avenger avenger) {
        ma.setText(avenger.getId().toString());
        ten.setText(avenger.getTen());
        phe.setText(avenger.getPhe().getTenphe());
        vukhi.setText(avenger.getVukhi());
        sucmanh.setText(avenger.getSucmanh());
    }
}
