package com.example.boardprac.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Criteria {
    private final Integer pageNum;
    private final Integer amount;
    private String type;
    private String keyword;

    public Criteria() {
     this(1, 10);
    }

    public String[] getTypes(){
        return type == null ? new String[]{} : type.split("");
    }
}
