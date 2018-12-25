package com.zty.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guru implements Serializable {
    @Id
    private String id;
    private String charma;  //法号
    private String head_pic;
    private String status;
}
