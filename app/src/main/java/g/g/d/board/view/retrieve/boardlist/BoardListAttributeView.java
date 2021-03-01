package g.g.d.board.view.retrieve.boardlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import g.g.d.board.R;

public class BoardListAttributeView extends ConstraintLayout {
    private View view;

    public BoardListAttributeView(@NonNull Context context) {
        super(context);
        view = LayoutInflater.from(context).inflate(R.layout.view_boardlist_attribute, this, false);
        this.addView(view);
    }

    public BoardListAttributeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.view_boardlist_attribute, this, false);
        this.addView(view);
    }

    public BoardListAttributeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = LayoutInflater.from(context).inflate(R.layout.view_boardlist_attribute, this, false);
        this.addView(view);
    }

    public BoardListAttributeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        view = LayoutInflater.from(context).inflate(R.layout.view_boardlist_attribute, this, false);
        this.addView(view);
    }
}
