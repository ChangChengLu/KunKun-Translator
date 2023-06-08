package com.cclu.kunkuntranslator.service;

import com.cclu.kunkuntranslator.model.enums.LanguageEnum;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

import static com.cclu.kunkuntranslator.model.common.LanguageConst.DICT;
import static com.cclu.kunkuntranslator.model.common.LanguageConst.SPLIT;

/**
 * @author ChangCheng Lu
 * @date 2023/6/8 12:25
 */
@Service
public class EncryptService {
    private String stringToBinary(String str) {
        byte[] data = str.getBytes(StandardCharsets.UTF_16LE);
        StringBuilder sb = new StringBuilder(data.length * 8);
        for (byte item : data) {
            sb.append(String.format("%8s", Integer.toBinaryString(item & 0xFF)).replace(' ', '0'));
        }
        return sb.toString();
    }

    public String textToKunLanguage(String languageType, String text) {
        String binary = stringToBinary(text);
        StringBuilder r = new StringBuilder();
        LanguageEnum languageEnum = LanguageEnum.getLanguage(languageType);
        String tmp;

        for (int i = 0; i < binary.length(); i += 2) {
            tmp = binary.substring(i, i + 2);
            if (tmp.equals(DICT[0])) {
                r.append(languageEnum.getWord01());
            } else if (tmp.equals(DICT[1])) {
                r.append(languageEnum.getWord02());
            } else if (tmp.equals(DICT[2])) {
                r.append(languageEnum.getWord03());
            } else if (tmp.equals(DICT[3])) {
                r.append(languageEnum.getWord04());
            }
            r.append(SPLIT);
        }

        return r.toString();
    }
}
