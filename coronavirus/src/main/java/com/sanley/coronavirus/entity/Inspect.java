package com.sanley.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Inspect implements Serializable {
    private int testId;
    private int baseId;
    private Date testDate;
    private String ctTest;
    private String nuTest;

}
