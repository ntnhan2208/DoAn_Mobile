package vn.edu.stu.doangk.phe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.stu.doangk.AboutActivity;
import vn.edu.stu.doangk.MainActivity;
import vn.edu.stu.doangk.QuanLyActivity;
import vn.edu.stu.doangk.R;

public class DanhSachPheActivity extends AppCompatActivity {
    private ListView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuAbout:
                Intent intent = new Intent(DanhSachPheActivity.this, AboutActivity.class);
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
        setContentView(R.layout.activity_dsphe);

        recyclerView = findViewById(R.id.lstDSPhe);

        showDanhSach();
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(DanhSachPheActivity.this,PheActivity.class);
                intent.putExtra("vitri",position);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showDanhSach();
    }

    public void showDanhSach(){
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, QuanLyActivity.listPhe);
        recyclerView.setAdapter(adapter);

    }
}
