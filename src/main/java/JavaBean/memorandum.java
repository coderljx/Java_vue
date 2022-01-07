package JavaBean;

public class memorandum {
   private  int id;
   private String title;
   private  String content;

    public memorandum(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public memorandum() {
    }

    @Override
    public String toString() {
        return  "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
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
}
