package com.cclu.kunkuntranslator.controller;

import com.cclu.kunkuntranslator.model.common.BaseResponse;
import com.cclu.kunkuntranslator.model.dto.DecryptDto;
import com.cclu.kunkuntranslator.model.dto.EncryptDto;
import com.cclu.kunkuntranslator.service.DecryptService;
import com.cclu.kunkuntranslator.service.EncryptService;
import com.cclu.kunkuntranslator.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ChangCheng Lu
 * @date 2023/6/8 12:40
 */
@RestController
@RequestMapping("/kun")
public class KunKunTranslatorController {

    @Resource
    private DecryptService decryptService;

    @Resource
    private EncryptService encryptService;

    @PostMapping("/encrypt")
    public BaseResponse<String> encrypt(EncryptDto encryptDto) {
        String text = encryptDto.getText();
        String languageType = encryptDto.getLanguageType();

        String result = encryptService.textToKunLanguage(languageType, text);

        return ResultUtils.success(result);
    }

    @PostMapping("/decrypt")
    public BaseResponse<String> decrypt(DecryptDto decryptDto) {
        String languageType = decryptDto.getLanguageType();
        String kunText = decryptDto.getKunText();

        String result = decryptService.kunLanguageToText(languageType, kunText);

        return ResultUtils.success(result);
    }

}
