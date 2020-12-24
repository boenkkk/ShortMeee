package id.boenkkk.app.controller;

import id.boenkkk.app.model.UrlShortener;
import id.boenkkk.app.repository.UrlShortenerRepository;
import id.boenkkk.app.util.DateTimeUtil;
import id.boenkkk.app.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    @Autowired
    UrlShortenerRepository urlShortenerRepository;

    @GetMapping("/short")
    public ResponseEntity<List<UrlShortener>> getUrlShortener(@RequestParam(required = false) String hash) {
        try {
            List<UrlShortener> urlShorteners = new ArrayList<UrlShortener>();

            if (hash == null) {
                urlShortenerRepository.findAll().forEach(urlShorteners::add);
            } else {
                urlShortenerRepository.findByHash(hash).forEach(urlShorteners::add);
            }

            if (urlShorteners.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            urlShorteners.forEach(System.out::println);

            return new ResponseEntity<>(urlShorteners, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/short")
    public ResponseEntity<UrlShortener> createUrlShortener(@RequestBody UrlShortener urlShortener) {
        try {
            urlShortener.setHash(new StringUtil().generateString());
            urlShortener.setCreated_date(new DateTimeUtil().getDate());
            urlShortener.setCreated_time(new DateTimeUtil().getTime());
            urlShortener.setUsername("user");

            UrlShortener _urlShortener = urlShortenerRepository
                    .save(
                            new UrlShortener(
                                    urlShortener.getHash(),
                                    urlShortener.getUrl(),
                                    urlShortener.getUsername(),
                                    urlShortener.getCreated_date(),
                                    urlShortener.getCreated_time()
                            )
                    );

            return new ResponseEntity<>(_urlShortener, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
