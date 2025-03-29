package duck.overload.openai.model;

import lombok.Getter;

import java.util.List;

@Getter
public class OpenAIResponse {

    private List<Choice> messages;

    @Getter
    public static class Choice {

        private Message message;

    }

}
