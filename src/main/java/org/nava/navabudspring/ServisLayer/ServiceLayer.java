package org.nava.navabudspring.ServisLayer;

import org.nava.navabudspring.Entity.ClientDate;
import org.nava.navabudspring.Repositori.ClientRepositoriImp;
import org.nava.navabudspring.RepositoriJpa.ClientRepositoriJPA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceLayer {

    private final ClientRepositoriJPA clientRepositoriJPA;
    private final ClientRepositoriImp clientRepositoriImp;

    public ServiceLayer(ClientRepositoriJPA clientRepositoriJPA,
                        ClientRepositoriImp clientRepositoriImp) {
        this.clientRepositoriJPA = clientRepositoriJPA;
        this.clientRepositoriImp = clientRepositoriImp;
    }
    public ClientDate findById(Long id) {
        return clientRepositoriJPA.findById(id).orElse(null);
    }
    public List<ClientDate> findAll() {
        return clientRepositoriJPA.findAll();
    }
    public List<ClientDate> findByAnswerFalse() {return clientRepositoriJPA.findByAnswerFalse();}
    @Transactional
    public void setAnswerTrue(ClientDate client) {
        client.setAnswer(true);
        clientRepositoriJPA.save(client);
    }
    @Transactional
    public void addClient(ClientDate client) {
        clientRepositoriJPA.save(client);
    }
    @Transactional
    public void updateClient(ClientDate client) {
        clientRepositoriJPA.save(client);
    }
    @Transactional
    public void deleteClient(ClientDate client) {
        clientRepositoriJPA.delete(client);
    }
    

}
