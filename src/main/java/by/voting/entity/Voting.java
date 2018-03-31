package by.voting.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@Table(name = "voting")
public class Voting extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "voting")
    private Set<Vote> votes = new HashSet<>();
}
