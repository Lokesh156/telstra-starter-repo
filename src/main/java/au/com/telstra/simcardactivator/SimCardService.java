package au.com.telstra.simcardactivator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SimCardService {

    @Autowired
     SimCardRepository simCardRepository;

    public void activateSim(SimCard simCard){
        simCardRepository.save(simCard);
    }

    public Optional<SimCard> getSimCardById(Long id){
      return  simCardRepository.findById(id);
    }

    public List<SimCard> getSimCards(){
        return simCardRepository.findAll();
    }

    public void deleteSimCard(Long id){
        simCardRepository.deleteById(id);
    }

}
