package by.training.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkResultEntity {
    private long id;
    private String comment;
    private Date commentDate;
    private Long employeeTypeId;
}
