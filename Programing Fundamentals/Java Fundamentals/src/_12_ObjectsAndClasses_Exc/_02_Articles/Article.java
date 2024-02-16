package _12_ObjectsAndClasses_Exc._02_Articles;

public class Article {

    private String title;
    private String content;
    private String author;

    public Article (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getArticle() {
        return String.format("%s - %s: %s",
                this.title,
                this.content,
                this.author);
    }

    public void changeAuthor(String author) {
        this.author = author;
    }

    public void edit(String content) {
        this.content = content;
    }

    public void rename(String title) {
        this.title = title;
    }
}
