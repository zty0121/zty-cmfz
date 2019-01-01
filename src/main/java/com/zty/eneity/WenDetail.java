package com.zty.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "album")
public class WenDetail implements Serializable {
    private String thumbnail;
    private String title;
    private String score;
    private String author;
    private String broadcast;
    private String set_count;
    private String brief;
    private Date create_date;
}
