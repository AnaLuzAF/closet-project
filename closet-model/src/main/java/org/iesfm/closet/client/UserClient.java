package org.iesfm.closet.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class UserClient implements UsersApi {

    private RestTemplate restTemplate;
    private String host;

    public UserClient(
            RestTemplate restTemplate,
            @Value("${book.api}") String host) {
        this.restTemplate = restTemplate;
        this.host = host;
    }

    // COSAS DE REST TEMPLATE QUE NO SABEMOS AUN

    /*
    @Override
    public void insert(Book book) {
        restTemplate.postForObject(host + "/books", book, Void.class);
    }

    @Override
    public List<Book> getBooks(Boolean available, Integer year) {
        HashMap<String, Object> params = new HashMap<>();
        if (available != null) {
            params.put("available", available);
        }
        if (year != null) {
            params.put("year", year);
        }
        Book[] books = restTemplate.getForObject(host + "/books", Book[].class, params);
        return List.of(books);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        Book[] books = restTemplate.getForObject(URLEncoder.encode(host + "/author/" + author, StandardCharsets.UTF_8), Book[].class);

        return List.of(books);
    }
     */
}
