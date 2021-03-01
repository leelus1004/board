package g.g.d.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// 게시판 글 작성 화면
public class BoardWrite extends AppCompatActivity {

    private Button btn_write; // 작성 완료 버튼
    private Button btn_back; // 게시판 목록으로 돌아가는 버튼
    private EditText bsubject, bname, bcontent; // 컬럼 목록

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write);
        // 앱 아이콘
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_gogoda_foreground);

        btn_write = findViewById(R.id.btn_write);
        btn_back = findViewById(R.id.btn_back);
        bsubject = findViewById(R.id.bsubject);
        bname = findViewById(R.id.bname);
        bcontent = findViewById(R.id.bcontent);

        // 작성 후 게시글 리스트 이동 버튼
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Toast.makeText(getApplicationContext(), "작성 완료", Toast.LENGTH_SHORT).show();
                    String result;
                    String subject = bsubject.getText().toString();
                    String name = bname.getText().toString();
                    String content = bcontent.getText().toString();

                    System.out.println("subject >>> : " + subject);
                    System.out.println("name >>> : " + name);
                    System.out.println("content >>> : " + content);

                    RegisterActivity task = new RegisterActivity();
                    // execute 명령어를 통해 AsyncTastk 실행
                    // 클래스.execute(인자).get() 을 하면 결과가 자동으로 들어간다.
                    result = task.execute(subject, name, content).get();
                    System.out.println("result >>> : " + result);
                }catch (Exception e){
                    Log.i("DBTEST", "..........ERROR.........");
                }
                // 화면 전환
                Intent intent = new Intent(BoardWrite.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 작성 취소 후 게시글 리스트 이동 버튼
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoardWrite.this, MainActivity.class);
                Toast.makeText(getApplicationContext(), "작성 취소", Toast.LENGTH_SHORT).show();
                startActivity(intent); // 액티비티 이동
            }
        });
    }
}