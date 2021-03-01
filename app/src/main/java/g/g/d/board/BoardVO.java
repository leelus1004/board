package g.g.d.board;

// 게시판 글 정보를 하나의 클래스에 담기 위한 선언
public class BoardVO {

    String bsubject;
    String bname;
    String bcontent;

    public BoardVO() {}

    public BoardVO(String bsubject, String bname, String bcontent) {
        this.bsubject = bsubject;
        this.bname = bname;
        this.bcontent = bcontent;
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

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }
}
