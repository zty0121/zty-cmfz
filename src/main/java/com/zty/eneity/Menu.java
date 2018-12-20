package com.zty.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    private String id;
    private String title;
    private String iconcls;
    private String url;
    private String parent_id;
    private List<Menu> menuList;
}
