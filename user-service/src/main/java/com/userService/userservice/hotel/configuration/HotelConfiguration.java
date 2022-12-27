package com.userService.userservice.hotel.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.userService.userservice.hotel.client.HotelClient;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


@Configuration
public class HotelConfiguration {

    @Bean
    public HotelClient projectClient(
            @Value("${connection.read.timeout.second:60}") final Long timeoutSeconds,
            @Value("${project.base.url}") final String baseUrl) {
        return new Retrofit.Builder().client(okHttpClient).baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(buildDefaultMapper()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(HotelClient.class);
    }

    OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {

                    Request request = chain.request();
                    Response response = chain.proceed(chain.request());
                    int tryCount = 0;
                    while (response.code() != 200 && tryCount < 3) {
                        tryCount++;
                        response.close();
                        response = chain.proceed(request);
                    }
                    return response;
                }
            }).build();

    private ObjectMapper buildDefaultMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }

}