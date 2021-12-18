package vn.edu.stu.doangk.phe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vn.edu.stu.doangk.AboutActivity;
import vn.edu.stu.doangk.MainActivity;
import vn.edu.stu.doangk.QuanLyActivity;
import vn.edu.stu.doangk.R;
import vn.edu.stu.doangk.model.Phe;


public class PheActivity extends AppCompatActivity{
    private EditText ma,ten;
    private Button them,sua,xoa;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuAbout:
                Intent intent = new Intent(PheActivity.this, AboutActivity.class);
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
        setContentView(R.layout.activity_phe);

        ma = findViewById(R.id.edtMa);
        ten = findViewById(R.id.edtTen);
        them = findViewById(R.id.btnThem);
        sua = findViewById(R.id.btnSua);
        xoa = findViewById(R.id.btnXoa);

        Intent intent = getIntent();
        int position = intent.getIntExtra("vitri",0);
        Phe phe = QuanLyActivity.listPhe.get(position);
        showThongTin(phe);

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapb = ten.getText().toString();
                QuanLyActivity.listPhe.add(new Phe(mapb));
                Toast.makeText(PheActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phe.setTenphe(ten.getText().toString());
                QuanLyActivity.listPhe.set(position,phe);
                Toast.makeText(PheActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
            }
        });

        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuanLyActivity.listPhe.remove(position);
                finish();
            }
        });
    }

    private void showThongTin(Phe phongBan){
        ma.setText(phongBan.getMa().toString());
        ten.setText(phongBan.getTenphe());
    }
}
