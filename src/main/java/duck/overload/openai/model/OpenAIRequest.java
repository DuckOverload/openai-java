package duck.overload.openai.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class OpenAIRequest {

    private String model = "gpt-4";
    private List<Message> messages;
    private int max_tokens = 100;

}