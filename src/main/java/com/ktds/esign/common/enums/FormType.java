package com.ktds.esign.common.enums;

import com.ktds.esign.common.enums.converter.EnumConverter;
import com.ktds.esign.common.enums.converter.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum FormType implements IEnum<String> {
    FIXED("FIXED", "고정양식"),
    COMMON("COMMON", "공통양식"),
    PERSONAL("PERSONAL", "개인양식");

    private String code; // db_code
    private String desc; // db_description

    // code -> ENUM TYPE
    public static FormType getTypeFromCode(String val) {
        return Arrays.stream(values()).filter(e -> e.getCode().equals(val)).findAny().orElse(null);
    }

    // desc -> ENUM TYPE
    public static FormType getTypeFromDesc(String val) {
        return Arrays.stream(values()).filter(e -> e.getDesc().equals(val)).findAny().orElse(null);
    }

    // ENUM TYPE -> code
    public static String getCodeFromType(FormType type) {
        return Optional.ofNullable(type).isPresent() ? type.getCode() : null;
    }

    // ENUM TYPE -> desc
    public static String getDescFromType(FormType type) {
        return Optional.ofNullable(type).isPresent() ? type.getDesc() : null;
    }

    public static class Converter extends EnumConverter<FormType, String> {
        public Converter() {
            super(FormType.class);
        }
    }
}
