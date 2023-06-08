package com.cclu.kunkuntranslator;

import com.cclu.kunkuntranslator.service.DecryptService;
import com.cclu.kunkuntranslator.service.EncryptService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author ChangCheng Lu
 * @date 2023/6/8 12:31
 */
@SpringBootTest
public class CryptTest {

    @Resource
    EncryptService encryptService;

    @Resource
    DecryptService decryptService;

    public static final String languageType = "kun";


    @Test
    public void kunTest() {
        String text = "鸡你太美";
        String kunText = encryptService.textToKunLanguage(languageType, text);
        String reText = decryptService.kunLanguageToText(languageType, kunText);
        System.out.println("kunText: " + kunText);
        System.out.println("Recovery Text: " + reText);
    }

}
