package hehaorui.dataimport;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gym_news")
public class News {
    @Id
    @Field("newsid")
    private Long id;

    @Column(name = "news_date")
    @Field("newsdate")
    private String date;

    @Column(name = "writer")
    @Field("newswirter")
    private String writer;

    @Column(name = "image_url")
    @Field("newsurl")
    private String url;

    @Column(name="title")
    @Field("newswriter")
    private String title;

    @Column(name="content")
    @Field("content")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String toString(){
        return "news{" +
                "id=" + id +
                ", date=" + date +
                ", writer='" + writer + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title +'\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
