package g.g.d.board;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class BoardSelectAll extends AppCompatActivity {

    private ListView listView;          // 리스트뷰
    private EditText editSearch;        // 검색어입력
    private ListViewAdapter adapter;    // 리스트뷰에 연결할 어댑터
    private Button btn_move;            // 게시글 작성 이동 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_selectall);
        // 앱 아이콘 : gogoda.png
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_gogoda_foreground);

        // Adapter 생성
        BoardJsonTask task = new BoardJsonTask();
        try {
            ArrayList<ListViewItem> result = task.execute().get();
            adapter = new ListViewAdapter(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 리스트 뷰 참조 및 Adapter 담기
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // 이벤트 처리 : onCreate() 함수 내에서 클릭 이벤트 처리
        // 위에서 생성한 listView에 클릭 이벤트 핸들러 정의
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                Intent intent  = new Intent(BoardSelectAll.this, RboardActivity.class);

               // get item
//                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);
//
//                String bfile = item.getBfile();
//                String bsubject = item.getBsubject();
//                String bname = item.getBname();
//                String binsertdate = item.getBinsertdate();
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();

        // 검색(EditText) 변경 이벤트 처리
        editSearch = (EditText)findViewById(R.id.editSerach);
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString();
                // 필터링 텍스트 작업을 보이지 않게 하기
                ((ListViewAdapter)listView.getAdapter()).getFilter().filter(filterText);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        // btn_move : 버튼 클릭시 게시글 작성 페이지로 이동
        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoardSelectAll.this, BoardWrite.class);
                startActivity(intent); // 액티비티 이동
            }
        });
    }
}
