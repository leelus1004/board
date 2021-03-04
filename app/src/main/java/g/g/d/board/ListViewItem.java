package g.g.d.board;

import android.graphics.drawable.Drawable;

public class BoardItemVO {

    private String bfile;
    private String bsubject;
    private String bname;

    public BoardItemVO() {
    }

    public BoardItemVO(String bfile, String bsubject, String bname) {
        this.bfile = bfile;
        this.bsubject = bsubject;
        this.bname = bname;
    }

    public String getBfile() {
        return bfile;
    }

    public void setBfile(String bfile) {
        this.bfile = bfile;
    }

    public String getBsubject() {
        return bsubject;
    }

    public void setBsubject(String bsubject) {
        this.bsubject = bsubject;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

}
