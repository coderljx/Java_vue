package JavaBean;

import java.sql.Date;

public class blogs {
    private int id;
    private String title;
    private String content;
    private String imgLink;
    private int uid;
    private Date time;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgLink='" + imgLink + '\'' +
                ", uid=" + uid +
                ", time=" + time +
                '}';
    }

    public blogs(int id, String title, String content, String imgLink, int uid, Date time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imgLink = imgLink;
        this.uid = uid;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
