package g.g.d.board;

// 게시판 목록 리스트 뷰 아이템
public class ListViewItem {

    private String bfile;
    private String bsubject;
    private String bname;
    private String binsertdate;

    public ListViewItem() {
    }

    public ListViewItem(String bfile, String bsubject, String bname ,String binsertdate) {
        this.bfile = bfile;
        this.bsubject = bsubject;
        this.bname = bname;
        this.binsertdate = binsertdate;
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

    public String getBinsertdate() { return binsertdate; }

    public void setBinsertdate(String binsertdate) { this.binsertdate = binsertdate; }

}
