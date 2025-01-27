package com.projeto.projeto.service;

import com.projeto.projeto.dto.LeiDTO;
import com.projeto.projeto.model.LeisModel;
import com.projeto.projeto.repository.LeisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class LeisService {

    private LeisRepository leisRepository;
    private LeisModel leisModel;

    public LeisService(LeisRepository leisRepository, LeisModel leisModel) {
        this.leisRepository = leisRepository;
        this.leisModel = leisModel;
    }

    public LeisModel salvar(LeiDTO leiDTO){
        if(leiDTO.date() != null && leiDTO.descricao() != null
        && leiDTO.nome() != null && leiDTO.numero() != null){
            var novaLei = new LeisModel();
            novaLei.setNome(leiDTO.nome());
            novaLei.setNumero(leiDTO.numero());
            novaLei.setDescricao(leiDTO.descricao());
            novaLei.setDate(leiDTO.date());
            leisRepository.save(novaLei);
            return novaLei;

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public void autalizar(Long id, LeiDTO leiDTO){
        var encontrarLei = leisRepository.findById(id);
        if(encontrarLei.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            var lei = encontrarLei.get();
            if(leiDTO.date() != null){
                lei.setDate(leiDTO.date());
            }
            if(leiDTO.nome() != null){
                lei.setDescricao(leiDTO.descricao());
            }
            if(leiDTO.numero() != null){
                lei.setNumero(leiDTO.numero());
            }
            if(leiDTO.descricao() != null){
                lei.setDescricao(leiDTO.descricao());
            }
            leisRepository.save(lei);
        }
    }

    public void deletar(Long id){
        var encontrarLei = leisRepository.findById(id);
        if(encontrarLei.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            leisRepository.deleteById(id);
        }
    }

    public List<LeisModel> listarLeis(){
        var encontrarLeis = leisRepository.findAll();
        return encontrarLeis;
    }

    public LeisModel encontrarId(Long id){
        var encontrarLei = leisRepository.findById(id);
        if(encontrarLei.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        return encontrarLei.get();
    }

}
