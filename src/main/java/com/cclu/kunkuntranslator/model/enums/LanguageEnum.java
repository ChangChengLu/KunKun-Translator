package com.cclu.kunkuntranslator.model.enums;

import com.cclu.kunkuntranslator.model.common.ErrorCode;
import com.cclu.kunkuntranslator.exception.BusinessException;

/**
 * @author ChangCheng Lu
 * @date 2023/6/8 12:34
 */
public enum LanguageEnum {
    /**
     * kunkun=哎呦,你干嘛,鸡你太美,鸡
     * ghost=我是一个特别固执的人,泰裤啦,如果你也和我一样,鸡
     */
    KUNKUN("哎呦","你干嘛","鸡你太美","厉不厉害你坤哥"),
    GHOST("我是一个特别固执的人","泰裤啦","如果你也和我一样","我从来不会在意别人跟我说什么");

    private String word01;

    private String word02;

    private String word03;

    private String word04;

    LanguageEnum(String word01, String word02, String word03, String word04) {
        this.word01 = word01;
        this.word02 = word02;
        this.word03 = word03;
        this.word04 = word04;
    }

    public static LanguageEnum getLanguage(String str) {
        if (str == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        if ("kun".equals(str)) {
            return LanguageEnum.KUNKUN;
        } else if ("ghost".equals(str)) {
            return LanguageEnum.GHOST;
        } else {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
    }

    public String getWord01() {
        return word01;
    }

    public void setWord01(String word01) {
        this.word01 = word01;
    }

    public String getWord02() {
        return word02;
    }

    public void setWord02(String word02) {
        this.word02 = word02;
    }

    public String getWord03() {
        return word03;
    }

    public void setWord03(String word03) {
        this.word03 = word03;
    }

    public String getWord04() {
        return word04;
    }

    public void setWord04(String word04) {
        this.word04 = word04;
    }
}
