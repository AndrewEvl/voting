package by.voting.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class AllSaveDto {

    private Set<String> variant = new HashSet<>();
    private String votingName;

}
