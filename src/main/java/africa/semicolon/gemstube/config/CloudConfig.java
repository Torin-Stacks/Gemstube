package africa.semicolon.gemstube.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CloudConfig {

    @Value("${cloud.cloud.name}")
    private String cloudName;
    @Value("${cloud.api.secret}")
    private String apiSecret;

    @Value("${cloud.api.key}")
    private String apiKey;

    @Bean
    public Cloudinary cloudinary(){
//        log.info("{}  {}  {}", cloudName, apiKey, apiSecret);

        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name",cloudName,
                        "api_key",apiKey,
                        "api_secret", apiSecret,
                        "secure", true)
        );

    }
}
