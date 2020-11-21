package io.pragra.learning.jpademo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TABLE_AUTHORS")
@Data
@ToString
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String company;
    private String institution;
    private Date createDate;
    private Date updateDate;
    private StatusEnum status;

    public Author(String name, String company, String institution, Date createDate, Date updateDate, StatusEnum status) {
        this.name = name;
        this.company = company;
        this.institution = institution;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }
}
