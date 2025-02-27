package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/sim")
public class  SimActivationController {

//    private final RestTemplate restTemplate = new RestTemplate();
//    private final String ACTUATOR_URL="";
//
//    @PostMapping("/activate")
//    public String activateSim(@RequestBody SimCard simDetails){
//        String iccid = simDetails.getIccid();
//        Map<String,String> actuatorPayload= new HashMap<>();
//        actuatorPayload.put("iccid",iccid);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Map<String,String>> entity = new HttpEntity<>(actuatorPayload,headers);
//        try{
//            ResponseEntity<Map> response=restTemplate.exchange(ACTUATOR_URL,
//                    HttpMethod.POST,
//                    entity,
//                    Map.class);
//            boolean success= (boolean) response.getBody().get("success");
//            if (success)
//            {
//                return "SIM activation successfully for ICCID: "+iccid;
//            }
//            else {
//                return "SIM activation failed for ICCID: "+iccid;
//            }
//        } catch (Exception e) {
//            return "Error during activation of SIM activation";
//        }
//
//    }

    private final SimCardActuationHandler simCardActuationHandler;
    @Autowired
    SimCardService simCardService;

    public SimActivationController (SimCardActuationHandler simCardActuationHandler){
        this.simCardActuationHandler=simCardActuationHandler;
    }

    @PostMapping("/activate")
    public ResponseEntity<String> activateSim(@RequestBody SimCard simCard) {
        var actuationResult= simCardActuationHandler.actuate(simCard);
        System.out.println(actuationResult.isSuccess());
        if(actuationResult.isSuccess()){
            simCard.setActive(true);
            simCardService.activateSim(simCard);
            return ResponseEntity.ok("Sim activation was successful");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sim activation was failed");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<SimCard>> getSimCardByid(@PathVariable Long id){
        Optional<SimCard> simCard= simCardService.getSimCardById(id);
        if(simCard.isPresent()){
            return ResponseEntity.ok(simCard);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
