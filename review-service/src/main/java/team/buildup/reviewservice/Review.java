package team.buildup.reviewservice;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@SuppressWarnings("JpaDataSourceORMInspection")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@AllArgsConstructor
public class Review {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content")
    private String content;


}
