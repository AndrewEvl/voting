package by.voting.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "voting")
@NoArgsConstructor
@Table(name = "variant")
public class Vote extends BaseEntity {

    @Column(name = "variant_name")
    private String variant;
    @Column(name = "vote_people")
    private Long like;
    @ManyToOne
    @JoinColumn(name = "voting_id")
    private Voting voting;
}
