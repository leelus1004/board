package g.g.d.board;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import g.g.d.board.model.Board;
import g.g.d.board.view.retrieve.boardlist.BoardListView;

public class TestActivity extends AppCompatActivity {
    private BoardListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        listView = findViewById(R.id.board_list);

        // 1. Board Data를 만든다.
        ArrayList<Board> list = new ArrayList();
        list.add(new Board("1", " 박재혁", "A", null, "3", "20/12/08"));
        list.add(new Board("2", "황영석", "BB", null, "6", "20/12/09"));
        list.add(new Board("3", "박보검", "CCC", null, "52", "20/12/12"));
        // 2. 만들어진 Board Data를 listView에 넣는다.
        listView.set(list);
    }
}

