package by.voting.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AllSaveDto {

    private String questionName;
    private List<String> variantsName = new ArrayList<>();
}
