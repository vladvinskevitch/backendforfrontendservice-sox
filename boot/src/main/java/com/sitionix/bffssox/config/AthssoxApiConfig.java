package com.sitionix.bffssox.config;

import com.app_afesox.bffssox.client.api.UserApi;
import com.app_afesox.bffssox.client.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AthssoxApiConfig {

    @Value("${api.rest.athssox.base-path}")
    private String baseUrl;

    @Autowired
    Environment env;

    //@Configuration properties погуглити і зробити через це

    @Bean("athssoxClient")
    public ApiClient athssoxClient(){

        final ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(env.getProperty("${api.rest.athssox.base-path}"));
        return apiClient;
    }

    @Bean
    public UserApi userApi(@Qualifier("athssoxClient") ApiClient apiClient){
        return  new UserApi(apiClient);
    }




    //    @Configuration
//    public class AthssoxApiConfig {
//
//        @Primary
//        @Bean("athssoxClient")
//        public ApiClient athssoxClient() {
//            final ApiClient apiClient = new ApiClient();
//            apiClient.setBasePath("localhiadskjghaflsk");
//            return apiClient;
//        }
//
//        @Bean
//        public UserApi userApi(@Qualifier("athssoxClient") ApiClient apiClient) {
//            return new UserApi(apiClient);
//        }
//
//    }
}
