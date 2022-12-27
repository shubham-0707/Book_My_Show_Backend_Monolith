package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //Auto-generated

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "release_date", columnDefinition = "DATE", nullable = false)
    private LocalDate releaseDate;


    //Connecting the other table
    //Since this is the parent (how did we come to know : its having mappedBy and cascade )
    //child table : its having @JoinColumn Annotation
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ShowEntity> shows;
}