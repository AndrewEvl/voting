package by.voting.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@Table(name = "variants")
public class Variant extends BaseEntity {

    @Column(name = "variants_name")
    private String variant;
    @Column(name = "people_like")
    private Long peopleLike;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
