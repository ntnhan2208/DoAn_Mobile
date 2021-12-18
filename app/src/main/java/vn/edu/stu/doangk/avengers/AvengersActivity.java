package vn.edu.stu.doangk.avengers;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;



import vn.edu.stu.doangk.AboutActivity;

import vn.edu.stu.doangk.QuanLyActivity;
import vn.edu.stu.doangk.R;
import vn.edu.stu.doangk.model.Avenger;

public class AvengersActivity extends AppCompatActivity {
    private TextView ma, ten, phe, vukhi, sucmanh;
    private Button edit;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuAbout:
                Intent intent = new Intent(AvengersActivity.this, AboutActivity.class);
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
        setContentView(R.layout.activity_avengers);

        ma = findViewById(R.id.txtMa);
        ten = findViewById(R.id.txtTen);
        phe = findViewById(R.id.txtPhe);
        vukhi = findViewById(R.id.txtVuKhi);
        sucmanh = findViewById(R.id.txtSucManh);
        edit = findViewById(R.id.btnEdit);



        Intent intent = getIntent();
        int position = intent.getIntExtra("vitri", 0);
        Avenger avenger = QuanLyActivity.listAven.get(position);
        showThongTin(avenger);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AvengersActivity.this,EditAvengersActivity.class);
                intent.putExtra("vitri",position);
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
