package id.boenkkk.app;

import id.boenkkk.app.model.UrlShortener;
import id.boenkkk.app.repository.UrlShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class ShortMeeeApplication {

    @Autowired
    UrlShortenerRepository urlShortenerRepository;

    public static void main(String[] args) {
        SpringApplication.run(ShortMeeeApplication.class, args);
        System.out.println("App Run.");
    }

    @GetMapping("")
    public String hello(){
        System.out.println("Backend Running.");
        return "Backend Running.";
    }

    @GetMapping("/{hash}")
    public ResponseEntity<List<UrlShortener>> getUrlShortenerByHash(@PathVariable("hash") String hash) {
        List<UrlShortener> urlShorteners = new ArrayList();
        urlShortenerRepository.findByHash(hash).forEach(urlShorteners::add);

        if (!urlShorteners.isEmpty()) {
            UrlShortener urlShortenerData = urlShorteners.get(0);
            urlShortenerData.setHit(urlShortenerData.getHit()+1);
            urlShortenerRepository.save(urlShortenerData);

            String url = urlShorteners.get(0).getUrl();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(url));
            return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
