package org.nava.navabudspring.ServisLayer;

import org.nava.navabudspring.Entity.ClientDate;
import org.nava.navabudspring.Repositori.ClientRepositoriImp;
import org.nava.navabudspring.RepositoriJpa.ClientRepositoriJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceLayer {

    @Autowired
    private ClientRepositoriJPA clientRepositoriJPA;
    private ClientRepositoriImp clientRepositoriImp;

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
