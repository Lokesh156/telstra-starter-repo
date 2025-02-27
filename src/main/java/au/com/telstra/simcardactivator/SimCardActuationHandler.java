package au.com.telstra.simcardactivator;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SimCardActuationHandler {
private final RestTemplate restTemplate;
private final String actuatorUrl;

 public SimCardActuationHandler(RestTemplateBuilder builder)
 {
    this.restTemplate=builder.build();
    this.actuatorUrl="http://localhost:8444/actuate";
 }

 public ActuationResult actuate(SimCard simCard){
     return restTemplate.postForObject(actuatorUrl,simCard, ActuationResult.class);
 }

}
