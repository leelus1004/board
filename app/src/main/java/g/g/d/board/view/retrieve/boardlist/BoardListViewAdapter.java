package g.g.d.board.view.retrieve.boardlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import g.g.d.board.R;
import g.g.d.board.model.Board;

public class BoardListViewAdapter extends RecyclerView.Adapter<BoardListViewAdapter.Holder> {
    ArrayList<Board> boardSet;
    public BoardListViewAdapter(ArrayList<Board> boardSet)
    {
        this.boardSet = boardSet;
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView bnum;
        TextView title;
        TextView writer;
        ImageView photo;
        TextView hit;
        TextView insertdate;
        public Holder(@NonNull View itemView) {
            super(itemView);
            bnum = itemView.findViewById(R.id.item_bnum);
            title = itemView.findViewById(R.id.item_title);
            writer = itemView.findViewById(R.id.item_writer);
            photo = itemView.findViewById(R.id.item_photo);
            hit = itemView.findViewById(R.id.item_hit);
            insertdate = itemView.findViewById(R.id.item_insertdate);
        }
    }

    @NonNull @Override public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_boardlist_item, parent, false);
        return new Holder(view);
    }
    @Override public void onBindViewHolder(@NonNull Holder holder, int position)
    {
        Board item = boardSet.get(position);
        holder.bnum.setText(item.bnum);
        holder.title.setText(item.title);
        holder.writer.setText(item.writer);
        holder.photo.setImageBitmap(item.photo);
        holder.hit.setText(item.hit);
        holder.insertdate.setText(item.insertdate);
    }
    @Override public int getItemCount()
    {
        return boardSet.size();
    }
}

