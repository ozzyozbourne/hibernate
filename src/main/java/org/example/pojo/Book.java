package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Book {

    private String isbn;
    private String name;
    private Publisher publisher;
    private List<Chapter> chapters;


}
