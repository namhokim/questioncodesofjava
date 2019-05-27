package com.example.springboot.sandbox.me;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class ItemDate {
    private Integer id;
    private String name;
    private String createBy;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone="Asia/Seoul")
    private Date createAt;

    public ItemDate(Integer id, String name, String createBy, Date createAt) {
        this.id = id;
        this.name = name;
        this.createBy = createBy;
        this.createAt = createAt;
    }
}

class GsonDateConverter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    private static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT);
        return src == null ? null : new JsonPrimitive(simpleDateFormat.format(src));
    }

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        try {
            return json == null ? null : simpleDateFormat.parse(json.getAsString());
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }
}
