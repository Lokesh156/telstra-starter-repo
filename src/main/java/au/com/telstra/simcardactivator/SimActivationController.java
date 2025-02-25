package au.com.telstra.simcardactivator;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sim")
public class  SimActivationController {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String ACTUATOR_URL="http://localhost:8444/actuate";

    @PostMapping("/activate")
    public String activateSim(@RequestBody SimDetails simDetails){
        String iccid = simDetails.getIccid();
        Map<String,String> actuatorPayload= new HashMap<>();
        actuatorPayload.put("iccid",iccid);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String,String>> entity = new HttpEntity<>(actuatorPayload,headers);
        try{
            ResponseEntity<Map> response=restTemplate.exchange(ACTUATOR_URL,
                    HttpMethod.POST,
                    entity,
                    Map.class);
            boolean success= (boolean) response.getBody().get("success");
            if (success)
            {
                return "SIM activation successfully for ICCID: "+iccid;
            }
            else {
                return "SIM activation failed for ICCID: "+iccid;
            }
        } catch (Exception e) {
            return "Error during activation of SIM activation";
        }

    }
}
