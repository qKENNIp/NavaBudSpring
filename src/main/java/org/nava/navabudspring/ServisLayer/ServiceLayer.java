package org.nava.navabudspring.ServisLayer;

import org.nava.navabudspring.Repositori.ClientRepositoriImp;
import org.nava.navabudspring.RepositoriJpa.ClientRepositoriJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
