package com.softaria.quiz.model.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.softaria.quiz.model.AnswerStatus;
import com.softaria.quiz.utils.EnumUtils;

import java.io.IOException;

public class AnswerStatusDeserializer extends JsonDeserializer<AnswerStatus> {

    @Override
    public AnswerStatus deserialize(JsonParser parser, DeserializationContext context) throws IOException {

        return EnumUtils.getEnum(parser.getValueAsLong(), AnswerStatus.class);
    }
}
