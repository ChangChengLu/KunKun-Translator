package com.cclu.kunkuntranslator.service;

import com.cclu.kunkuntranslator.model.enums.LanguageEnum;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.cclu.kunkuntranslator.model.common.LanguageConst.DICT;

/**
 * @author ChangCheng Lu
 * @date 2023/6/8 12:25
 */
@Service
public class DecryptService {
    public static String binaryToString(String str) {
        Matcher matcher = Pattern.compile("([01]{8})+").matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            byte[] data = new byte[matcher.group().length() / 8];
            for (int i = 0; i < data.length; i++) {
                data[i] = (byte) Integer.parseInt(matcher.group().substring(i * 8, (i + 1) * 8), 2);
            }
            sb.append(new String(data, StandardCharsets.UTF_16LE));
        }
        return sb.toString();
    }

    public String kunLanguageToText(String languageType, String kunText) {
        StringBuilder result = new StringBuilder();
        LanguageEnum language = LanguageEnum.getLanguage(languageType);
        String[] split = kunText.split("~");
        for (String tmp : split) {
            if (tmp.equals(String.valueOf(language.getWord01()))) {
                result.append(DICT[0]);
            } else if (tmp.equals(String.valueOf(language.getWord02()))) {
                result.append(DICT[1]);
            } else if (tmp.equals(String.valueOf(language.getWord03()))) {
                result.append(DICT[2]);
            } else if (tmp.equals(String.valueOf(language.getWord04()))) {
                result.append(DICT[3]);
            }
        }

        return binaryToString(result.toString());
    }
}
