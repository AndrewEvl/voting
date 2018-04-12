package by.voting.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Table(name = "questions")
public class Question extends BaseEntity {
    @Column(name = "questions_name")
    private String question;
    @OneToMany(mappedBy = "question")
    private List<Variant> variant = new ArrayList<>();
}
