package com.softaria.quiz.model.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.softaria.quiz.model.BaseEntity;

import java.io.IOException;

public class BaseEntitySerializer extends JsonSerializer<BaseEntity> {

    @Override
    public void serialize(BaseEntity value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        if (value != null) {
            generator.writeStartObject();
            generator.writeNumberField(BaseEntity.ID, value.getId());
            generator.writeEndObject();
        }
    }
}