package duck.overload.openai.client;

import duck.overload.openai.service.OpenAIService;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@AllArgsConstructor
public class OpenAIClient {

    private String apiKey;

    public OpenAIService createService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();

                    Request requestBuilder = request.newBuilder()
                            .header("Authorization", "Bearer " + apiKey)
                            .method(request.method(), request.body())
                            .build();

                    return chain.proceed(requestBuilder);
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openai.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(OpenAIService.class);
    }

}
