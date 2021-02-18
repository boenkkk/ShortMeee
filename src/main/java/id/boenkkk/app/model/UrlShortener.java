package id.boenkkk.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="url_shortener")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UrlShortener {

    @Id
    @Column(name = "hash", unique = true, nullable = false)
    private String hash;

    @Lob
    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "hit", nullable = false, columnDefinition = "int default 0")
    private int hit;

    @Column(name = "created_date", length = 8, nullable = false)
    private String created_date;

    @Column(name = "created_time", length = 6, nullable = false)
    private String created_time;

    @Override
    public String toString() {
        return "UrlShortener{" +
                "hash='" + hash + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", hit=" + hit +
                ", created_date='" + created_date + '\'' +
                ", created_time='" + created_time + '\'' +
                '}';
    }

}
