package smkn4bdg.radhika.com.tugasdatabase.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import smkn4bdg.radhika.com.tugasdatabase.R;

/**
 * Created by root on 27/01/17.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private List<MainModel> mData = new ArrayList<>();
    private MainInterface vm;


    public MainAdapter(List<MainModel> data, MainInterface vm) {
        this.mData = data;
        this.vm = vm;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.etName.setText(mData.get(position).getNama());
        holder.etUmur.setText(mData.get(position).getUmur());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.onDeleteClick(mData.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView etName, etUmur;
        Button btnDelete;
        public ViewHolder(View v) {
            super(v);
            etName = (TextView)v.findViewById(R.id.row_name);
            etUmur = (TextView)v.findViewById(R.id.row_umur);
            btnDelete = (Button) v.findViewById(R.id.btnDelete);
        }
    }
}
