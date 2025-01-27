package com.projeto.projeto.service;

import com.projeto.projeto.dto.LeiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LeisService {

    private final LeisModel model;
    private final LeisRepository leisRepository;

    public LeisService(LeisModel model, LeisRepository leisRepository) {
        this.model = model;
        this.leisRepository = leisRepository;
    }

    public void salvar(LeiDTO leiDTO){
        if(leiDTO.date() != null && leiDTO.descricao() != null
        && leiDTO.nome() != null && leiDTO.numero() != null){
            var novaLei = new LeisModel();
            novaLei.setNome(leiDTO.nome());
            novaLei.setNumero(leiDTO.numero());
            novaLei.setDescricao(leiDTO.descricao());
            novaLei.setDaate(leiDTO.date());
            leisRepository.save(novaLei);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        v

    }

}
