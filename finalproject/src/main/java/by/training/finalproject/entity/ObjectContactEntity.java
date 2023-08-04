package by.training.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ObjectContactEntity {

    private long id;
    private String address;
    private String email;
    private String phone;
    private long maintenanceObjectId;
}

