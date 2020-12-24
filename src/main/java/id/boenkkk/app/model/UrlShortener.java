package id.boenkkk.app.model;

import javax.persistence.*;

@Entity
@Table(name="url_shortener")
public class UrlShortener {

    @Id
    @Column(name = "hash", unique = true, length = 6, nullable = false)
    private String hash;

    @Lob
    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Column(name = "created_date", length = 8, nullable = false)
    private String created_date;

    @Column(name = "created_time", length = 6, nullable = false)
    private String created_time;

    public UrlShortener() {

    }

    public UrlShortener(String hash, String url, String username, String created_date, String created_time) {
        this.hash = hash;
        this.url = url;
        this.username = username;
        this.created_date = created_date;
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "UrlShortenerModel{" +
                " hash='" + hash + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", created_date='" + created_date + '\'' +
                '}';
    }



    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

}
