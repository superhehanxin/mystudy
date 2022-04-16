package com.hhx.java18newfeature;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author he
 * @date 2022/2/19
 * @description:
 * @packagename: com.hhx.java18newfeature
 */
@Data
@Accessors(chain = true)
public class User {
    String name;
    String phone;
    Address address;
}
