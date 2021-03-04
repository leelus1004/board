package g.g.d.board;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;

import androidx.annotation.RequiresApi;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

// 게시판 목록 리스트 뷰 아이템
public class ListViewItem {

    private String bsubject;
    private String bname;
    private String binsertdate;
    private String bfile;
    private Bitmap file;

    public ListViewItem() {
    }

    // Server에서 받을 떄 만듬.
    public ListViewItem(String bfile, String bsubject, String bname ,String binsertdate) {
        this.bsubject = bsubject;
        this.bname = bname;
        this.binsertdate = binsertdate;
        this.bfile = bfile;
        try {
            // Server에서 Bitmap을 바로 받아올 수 있길래 여기로 옮김
            file = Picasso.get()
                    .load("http://221.149.207.103:8080/uploadStorage/" + bfile)
                    .get();
        } catch(Exception e)
        {
            e.printStackTrace();
        };
    }


    // Server에서 받을 떄 만듬.
    public ListViewItem(JSONObject object)
    {
        try {
            this.bsubject = object.getString("bsubject");
            this.bname = object.getString("bname");
            this.binsertdate = object.getString("binsertdate");
            this.bfile = object.getString("bfile");
            try {
                // Server에서 Bitmap을 바로 받아올 수 있길래 여기로 옮김
                if (!this.bfile.equals("null")) {
                    file = Picasso.get()
                            .load("http://221.149.207.103:8080/uploadStorage/" + bfile)
                            .get();
                }
            } catch(Exception e)
            {
                e.printStackTrace();
            };
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public Bitmap getFile() {
        return file;
    }
    public String getBfile() {
        return bfile;
    }
    public String getBsubject() {
        return bsubject;
    }
    public String getBname() {
        return bname;
    }
    public String getBinsertdate() { return binsertdate; }

}
