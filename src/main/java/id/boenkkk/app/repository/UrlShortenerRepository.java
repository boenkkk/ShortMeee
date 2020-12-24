package id.boenkkk.app.repository;

import id.boenkkk.app.model.UrlShortener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlShortenerRepository extends JpaRepository<UrlShortener, Long> {

    List<UrlShortener> findByHash(String hash);

}
