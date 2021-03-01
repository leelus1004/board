package g.g.d.board.view.retrieve.boardlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import g.g.d.board.R;
import g.g.d.board.model.Board;

public class BoardListView extends ConstraintLayout {
    private View view;
    private RecyclerView table;

    private void initialize(@NonNull Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.view_boardlist, this, false);
        this.addView(view);
        table = view.findViewById(R.id.board_table);
    }

    public BoardListView(@NonNull Context context) {
        super(context);
        initialize(context);
    }

    public BoardListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public BoardListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    public BoardListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context);
    }

    public void set(ArrayList<Board> boardSet)
    {
        //1. Recycler View가 보이는 방식을 LinearLayout처럼 보이게 만든다.
        // ListView, BoardView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        table.setLayoutManager(linearLayoutManager);

        // 2. Adapter를 만든다.
        BoardListViewAdapter boardListViewAdapter = new BoardListViewAdapter(boardSet);
        table.setAdapter(boardListViewAdapter);
        table.getAdapter().notifyDataSetChanged();
    }

}
