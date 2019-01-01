package com.zty.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Album")
public class TotalAlbum implements Serializable {
    private String thumbnail;
    private String title;
    private String author;
    @Transient
    private String type = "1";
    private String set_count;
    private Date create_date;
}
