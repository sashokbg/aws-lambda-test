package fr.ddf.aws.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldHandler implements RequestHandler<ApiMessage, HelloResponse> {

    @Override
    public HelloResponse handleRequest(ApiMessage input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Loading handler for hello message");

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            HelloMessage message = objectMapper.readValue(input.getBody(), HelloMessage.class);
            String formattedString = String.format("{ \"message\": \"Hello to you %s, you are %d years old \"}", message.getName(), message.getAge());
            return new HelloResponse(formattedString, headers, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
