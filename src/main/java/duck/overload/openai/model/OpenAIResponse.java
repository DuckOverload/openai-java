package duck.overload.openai.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OpenAIResponse {

    private String id;
    private String object;
    private long created;
    private List<Choice> choices;
    private Usage usage;

    public String getFirstMessageContent() {
        if (choices != null && !choices.isEmpty() && choices.get(0).getMessage() != null) {
            return choices.get(0).getMessage().getContent();
        }
        return null;
    }

    @Getter
    @Setter
    public static class Choice {

        private String role;
        private Message message;

    }

    @Getter
    @Setter
    public static class Usage {

        private int prompt_tokens;
        private int completion_tokens;
        private int total_tokens;

    }

}