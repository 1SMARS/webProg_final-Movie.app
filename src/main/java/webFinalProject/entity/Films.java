package webFinalProject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Films {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String url;
    private String description;
    private Integer releaseDate;
}

