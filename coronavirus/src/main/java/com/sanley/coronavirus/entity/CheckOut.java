package com.sanley.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author: bonbon
 * @Date: 2021/4/15 12:44
 */
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class CheckOut {
    private int baseId;
    private String name;
    private String currentPosition;
    private Double bodyTemperature;
    private String healthState;
    private String isToHighArea;
    private String isTouch;
    private String remarks;
    private Date checkOutDate;
    private Base base;
}
