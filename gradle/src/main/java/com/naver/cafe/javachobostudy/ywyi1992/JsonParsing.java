package com.naver.cafe.javachobostudy.ywyi1992;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsonParsing {
    private Object obj;
    private final StringBuffer JSON;
    private final Set<String> target = new HashSet<String>();
    private List<Object> parsingList;
    private String oldTarget;
    private String newTarget;

    public JsonParsing() {
        JSON = new StringBuffer();
    }

    public String parsingList(final List<Object> list) throws Exception {
        if (list.size() > 0) {
            parsingList = list;
            return parsingSetting();
        }
        JSON.append("회원을 조회할수 없습니다.");
        return JSON.toString();
    }

    private String parsingSetting() throws Exception {
        JSON.append("{");
        oldTarget = parsingList.get(0).getClass().getSimpleName().toLowerCase();
        for (int i = 0; i < parsingList.size(); i++) {
            obj = parsingList.get(i);
            parsingStart();
        }
        String parsingValue = parsingEnd();
        resetJSON();
        return parsingValue;
    }

    private void parsingStart() throws Exception {
        newTarget = obj.getClass().getSimpleName().toLowerCase();
        this.target.add(newTarget);
        commaDelete();
        JSON.append("},");
    }

    private void commaDelete() throws Exception {
        if (!oldTarget.equals(newTarget)) {
            JSON.delete(JSON.lastIndexOf(","), JSON.lastIndexOf(",") + 1);
            JSON.append("],");
            oldTarget = newTarget;
        }

        targetAppendJSON();
    }

    private void targetAppendJSON() throws Exception {
        if (JSON.indexOf(newTarget) < 0) {
            JSON.append("\"");
            JSON.append(newTarget);
            JSON.append("\":");
            JSON.append("[");
        }
        JSON.append("{");
        getElements(obj.getClass());
    }

    private void getElements(Class<?> c) throws Exception {
        List<String> realField = new ArrayList<String>();
        final Field[] f = c.getDeclaredFields();
        realField = getRealField(f);
        int j = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i].getName().equals(realField.get(j))) {
                typeSwith(typeExtract(f[i].getType().toString()), f[i]);
                j++;
                if (i == f.length - 1) {
                    break;
                }
                JSON.append(",");
            }
        }
    }

    private List<String> getRealField(final Field[] fields) {
        List<String> fieldList = new ArrayList<String>();
        for (Field f : fields) {
            if (!f.getName().equalsIgnoreCase("serialversionuid")) {
                fieldList.add(f.getName());
            }
        }
        return fieldList;
    }

    private String typeExtract(String type) throws Exception {
        return type.contains(".") ? type.substring(type.lastIndexOf('.') + 1) : type;
    }

    private void typeSwith(String type, Field f) throws Exception {
        Object not_a_string = null;
        f.setAccessible(true);
        switch (type.toLowerCase()) {
            case "object":
                objectParsing(f);
                break;
            case "char":
                charParsing(f);
                break;
            case "string":
                appendText(f, (String) f.get(obj));
                break;
            case "int":
                not_a_string = f.getInt(obj);
                break;
            case "long":
                not_a_string = f.getLong(obj);
                break;
            case "byte":
                not_a_string = f.getByte(obj);
                break;
            case "short":
                not_a_string = f.getShort(obj);
                break;
            case "boolean":
                not_a_string = f.getBoolean(obj);
                break;
        }

        if (not_a_string != null) {
            appendNotAString(f, not_a_string);
        }
    }

    private void objectParsing(Field f) throws Exception {
        String type = typeExtract(f.get(obj).getClass().getTypeName());
        Object value = f.get(obj);
        switch (type.toLowerCase()) {
            case "long":
            case "integer":
            case "byte":
            case "short":
                appendNotAString(f, value);
                break;
            case "character":
                appendText(f, String.valueOf(value));
                break;
            case "string":
                appendText(f, (String) value);
                break;
            case "boolean":
                appendNotAString(f, value);
                break;
        }
    }

    private void charParsing(Field f) throws Exception {
        f.setAccessible(true);
        MemberUtility mu = new MemberUtility();
        String value = null;
        if (obj instanceof MemberDTO) {
            switch (f.getName()) {
                case "m_gender":
                    value = mu.getGender(f.getChar(obj));
                    break;
                case "m_grant":
                    value = mu.getGrant(f.getChar(obj));
                    break;
            }
        }
        appendText(f, value);
    }

    private void appendKey(Field key) {
        JSON.append("\"");
        JSON.append(key.getName());
        JSON.append("\":");
    }

    private void appendNotAString(Field f, Object value) {
        appendKey(f);
        JSON.append(value);
    }

    private void appendText(Field f, String value) throws Exception {
        if (value == null) {
            appendNotAString(f, value);
            return;
        }
        appendKey(f);
        JSON.append("\"");
        JSON.append(value);
        JSON.append("\"");
    }

    private String parsingEnd() {
        JSON.delete(JSON.lastIndexOf(","), JSON.lastIndexOf(",") + 1);
        JSON.append("]}");
        return JSON.toString();
    }

    private void resetJSON() throws Exception {
        JSON.delete(0, JSON.length());
    }
}
