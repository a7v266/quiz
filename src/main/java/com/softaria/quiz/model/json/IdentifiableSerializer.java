package com.softaria.quiz.model.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.softaria.quiz.model.Identifiable;

import java.io.IOException;

public class IdentifiableSerializer extends JsonSerializer<Identifiable> {

    @Override
    public void serialize(Identifiable value, JsonGenerator generator, SerializerProvider serializers) throws IOException {
        if (value != null) {
            generator.writeNumber(value.getId());
        }
    }
}