package com.cclu.kunkuntranslator.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ChangCheng Lu
 * @date 2023/6/8 13:14
 */
@Data
public class EncryptDto implements Serializable {

    private String languageType;

    private String text;

}
