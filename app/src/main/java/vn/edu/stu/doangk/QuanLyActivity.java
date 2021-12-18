package vn.edu.stu.doangk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import vn.edu.stu.doangk.R;

import java.util.ArrayList;
import java.util.List;

import vn.edu.stu.doangk.avengers.DanhSachAvengersActivity;
import vn.edu.stu.doangk.model.Avenger;
import vn.edu.stu.doangk.model.Phe;
import vn.edu.stu.doangk.phe.DanhSachPheActivity;

public class QuanLyActivity extends Activity {
    public static List<Avenger> listAven = new ArrayList<>();
    public static List<Phe> listPhe = new ArrayList<>();
    private Button qlav, qlp;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuAbout:
                Intent intent = new Intent(QuanLyActivity.this, AboutActivity.class);
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
        setContentView(R.layout.activity_quanly);

        qlav = findViewById(R.id.btnQuanLyNguoi);
        qlp = findViewById(R.id.btnQuanLyPhe);

        creatData();

        qlav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLyActivity.this, DanhSachAvengersActivity.class);
                startActivity(intent);
            }
        });

        qlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLyActivity.this, DanhSachPheActivity.class);
                startActivity(intent);
            }
        });
    }

    private void creatData() {

        listPhe.add(new Phe("Đội Xanh"));
        listPhe.add(new Phe("Đội Đỏ"));


        listAven.add(new Avenger(1, "Captain America", null, listPhe.get(0), "Khiên", "Siêu chiến binh"));
        listAven.add(new Avenger(2, "Iron Man", null, listPhe.get(1), "Giáp", "Giàu, thông minh"));
        listAven.add(new Avenger(3, "Spider Man", null, listPhe.get(1), "Tơ nhện", "Sức mạnh nhện"));
        listAven.add(new Avenger(4, "Winter Soldier", null, listPhe.get(0), "Tay sắt", "Siêu chiến binh"));
    }
}
