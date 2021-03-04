package g.g.d.board.model;

import android.graphics.Bitmap;

public class Board {

    public String bnum;
    public String writer;
    public String title;
    public Bitmap photo;
    public String hit;
    public String insertdate;

    public Board() {}

    public Board(String bnum, String writer, String title,
                 Bitmap photo, String hit, String insertdate) {
        this.bnum = bnum;
        this.writer = writer;
        this.title = title;
        this.photo = photo;
        this.hit = hit;
        this.insertdate = insertdate;
    }
}
