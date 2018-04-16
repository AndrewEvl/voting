package by.voting.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Table(name = "questions")
public class Question extends BaseEntity {
    @Column(name = "questions_name")
    private String question;
    @Column(name = "status")
    private Status status;
    @OneToMany(mappedBy = "question")
    private List<Variant> variant = new ArrayList<>();
}
