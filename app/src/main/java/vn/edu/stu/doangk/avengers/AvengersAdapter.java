package vn.edu.stu.doangk.avengers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.stu.doangk.R;
import vn.edu.stu.doangk.model.Avenger;

public class AvengersAdapter extends RecyclerView.Adapter<AvengersAdapter.ViewHoldel> {
    private Context context;
    private List<Avenger> listAven;

    public AvengersAdapter(Context context, List<Avenger> listNhanVien) {
        this.context = context;
        this.listAven = listNhanVien;
    }

    @NonNull
    @Override
    public ViewHoldel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_chitietavenger,parent,false);
        return new ViewHoldel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldel holder, @SuppressLint("RecyclerView") int position) {
        Avenger avenger = listAven.get(position);
        holder.onbind(avenger);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AvengersActivity.class);
                intent.putExtra("vitri",position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAven.size();
    }

    public class ViewHoldel extends RecyclerView.ViewHolder{
        private TextView ma;
        private TextView ten;
        private TextView phe;
        private ImageView anh;

        public ViewHoldel(@NonNull View itemView) {
            super(itemView);

            ma = itemView.findViewById(R.id.txtMa);
            ten = itemView.findViewById(R.id.txtTen);
            phe = itemView.findViewById(R.id.txtPhe);
            anh = itemView.findViewById(R.id.imgAvatar);

        }

        public void onbind(Avenger avenger){
            ma.setText(avenger.getId().toString());
            ten.setText(avenger.getTen());
            phe.setText(avenger.getPhe().getTenphe());
            anh.setBackgroundResource(R.drawable.ic_baseline_person_24);
        }
    }

}
