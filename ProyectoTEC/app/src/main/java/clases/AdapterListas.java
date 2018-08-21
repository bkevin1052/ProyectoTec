package clases;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.proyectotec.kevin.proyectotec.R;

import java.util.List;

public class AdapterListas extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull

    Context context;
    List<List> listas;
    List<String> nombrelistas;

    public AdapterListas(Context context,List<List> listas,List<String> nombrelistas)
    {
        this.context = context;
        this.listas = listas;
        this.nombrelistas = nombrelistas;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.costume_row,parent, false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((Item)holder).checkBox.setText(nombrelistas.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return listas.size();
    }

    public class Item extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        public Item(@NonNull View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.item);
        }
    }
}
