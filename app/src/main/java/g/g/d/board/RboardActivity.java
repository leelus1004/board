package g.g.d.board;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class RboardActivity extends AppCompatActivity {

    private Button btn_list; // 게시판 목록으로 돌아가는 버튼
    private Button rb_input;  // 댓글 작성 버튼
    private Intent intent;
    private TextView bnum;   // 게시글 상세 목록의 글번호
    private TextView bname;  // 작성자
    private TextView binsertdate; // 게시글 등록일자
    private TextView bsubject;    // 글 제목
    private TextView bcontent;    // 글 내용
    private ImageView bfile;      // 사진
    private EditText rbname, rbcontent;  // 댓글 작성자, 내용
    private ListView rboard_listView; // 댓글 리스트 뷰
    private RboardAdapter adapter;    // 댓글 리스트 뷰 어댑터

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rboard);
        // 앱 아이콘 : gogoda.png
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_gogoda_foreground);


        // Adapter 생성
        adapter = new RboardAdapter();

        // 리스트뷰 참조 및 Adapter 담기
        rboard_listView = (ListView) findViewById(R.id.rboard_listView);
        rboard_listView.setAdapter(adapter);

        // 댓글 첫 번째 아이템 추가
       adapter.addItem("황영석","오늘은기분이정말정말좋습니다", "2020/01/01");
        /*
        // 게시판 댓글 (작성자, 내용, 작성일)
        // BoardJsonActivity task = new BoardJsonActivity();
        RboardJsonActivity task = new RboardJsonActivity();
        try {
            String result = "";
            result = task.execute().get();
            System.out.println("result >>> : " + result);
            JSONObject json = new JSONObject(result.toString());
            System.out.println(json);
            JSONArray jArray = json.getJSONArray("rboard");

            for(int i = 0; i< jArray.length(); i++){
                JSONObject obj = jArray.getJSONObject(i);
                String rbname = obj.getString("rbname");
                String rbcontent = obj.getString("rbcontent");
                String rbdate = obj.getString("rbdate");
                System.out.println("rbdate >>>>>>>>>>>>>>>>>>> : " + rbdate);
                adapter.addItem(rbname, rbcontent, rbdate);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // 댓글 : 작성버튼 누르면 리스트뷰에 추가
        rb_input = findViewById(R.id.rb_input);
        rb_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Toast.makeText(getApplicationContext(), "작성 완료", Toast.LENGTH_SHORT).show();
                    String result;
                    String name = rbname.getText().toString();
                    String content = rbcontent.getText().toString();

                    System.out.println("name >>> : " + name);
                    System.out.println("content >>> : " + content);

                    RboardRegister task = new RboardRegister();
                    result = task.execute(name, content).get();
                    System.out.println("result >>> : " + result);
                }catch(Exception e){
                    Log.i("DBTEST", "..........ERROR.........");
                }
            }
        });
        */
        // 게시판 목록으로 돌아가는 버튼
        btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RboardActivity.this, BoardSelectAll.class);
                startActivity(intent);
                finish();
            }
        });
    }
}