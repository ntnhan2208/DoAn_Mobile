package vn.edu.stu.doangk.avengers;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import vn.edu.stu.doangk.AboutActivity;
import vn.edu.stu.doangk.QuanLyActivity;
import vn.edu.stu.doangk.R;

public class DanhSachAvengersActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AvengersAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuAbout:
                Intent intent = new Intent(DanhSachAvengersActivity.this, AboutActivity.class);
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
        setContentView(R.layout.activity_dsavengers);

        recyclerView = findViewById(R.id.lstDSAven);

        showDanhSach();


    }

    @Override
    protected void onResume() {
        super.onResume();
        showDanhSach();
    }

    private void showDanhSach(){
        adapter = new AvengersAdapter(this, QuanLyActivity.listAven);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
