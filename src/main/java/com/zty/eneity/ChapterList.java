package com.zty.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Chapter")
public class ChapterList implements Serializable {
    private String title;
    private String download_url;
    private String size;
    private String duration;
}
