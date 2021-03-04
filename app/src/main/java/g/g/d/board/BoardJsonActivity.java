package g.g.d.board;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BoardJsonActivity extends AsyncTask<String, Void, String> {

    String sendMsg, receiveMsg;

    // jsp 연결
    protected String doInBackground(String... strings){
        System.out.println("BoardJsonActivity doInBackground >>>>>>>>>>>>>>>>>>>");
        try {
            String str;
            URL url = new URL("http://221.149.207.103:8080/board/boardList2.ggd");
            // URL url = new URL("http://59.5.230.72:8080/testVue/board/androidDB.jsp");
            System.out.println("url >>> : " + url);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("POST");
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");

            // insert 한 데이터
//            sendMsg = "bsubject=" + strings[0] + "&bname=" + strings[1] + "&bcontent=" + strings[2]
            //                  + "&bpw=" + strings[3];
            sendMsg = "";

            osw.write(sendMsg);
            System.out.println(sendMsg);
            osw.flush();

            if (conn.getResponseCode() == conn.HTTP_OK){
                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuffer buffer = new StringBuffer();

                while ((str=reader.readLine()) !=null){
                    buffer.append(str);
                }

                receiveMsg = buffer.toString();
                System.out.println(" >>>>>>>>>>>>>> : " + receiveMsg);
            }else{
                // 통신 실패
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return receiveMsg;
    }
}
