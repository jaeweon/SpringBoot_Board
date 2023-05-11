package com.example.boardprac.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Criteria {
    private int pageNum;
    private int amount;
}
