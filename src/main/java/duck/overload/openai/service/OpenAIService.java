package duck.overload.openai.service;

import duck.overload.openai.model.OpenAIRequest;
import duck.overload.openai.model.OpenAIResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OpenAIService {
    @Headers({
            "Content-Type: application/json"
    })
    @POST("v1/chat/completions")
    Call<OpenAIResponse> textGenerate(@Body OpenAIRequest request);
}
