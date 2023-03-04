package com.example.formationreact.service;

import com.example.formationreact.domain.dto.NemoCreationDto;
import com.example.formationreact.domain.model.Nemo;
import com.example.formationreact.domain.model.Status;
import com.example.formationreact.domain.repository.NemoRepository;
import com.example.formationreact.exception.NemoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NemoService {

    private static final String NEMO_NOT_FOUND = "Nemo not found";
    private final NemoRepository nemoRepository;

    public Nemo createNemo(NemoCreationDto nemoCreationDto) {
        return nemoRepository.save(Nemo.builder()
                .lastName(nemoCreationDto.getLastName())
                .firstName(nemoCreationDto.getFirstName())
                .email(nemoCreationDto.getEmail())
                .status(Status.ACTIF)
                .createdAt(new Date())
                .build());
    }

    public void suspendNemo(Long id) {
        Nemo nemo = getANemo(id);
        nemo.setStatus(Status.SUSPENDU);
        nemoRepository.save(nemo);
    }

    public void activateNemo(Long id) {
        Nemo nemo = getANemo(id);
        nemo.setStatus(Status.ACTIF);
        nemoRepository.save(nemo);
    }

    public void deleteNemo(Long id) {
        if(!nemoRepository.existsById(id)) {
            throw new NemoNotFoundException(NEMO_NOT_FOUND, id);
        }
        nemoRepository.deleteById(id);
    }

    public Nemo updateNemo(Long id, NemoCreationDto nemoCreationDto) {
        Nemo nemo = getANemo(id);
        nemo.setFirstName(nemoCreationDto.getFirstName());
        nemo.setLastName(nemoCreationDto.getLastName());
        nemo.setEmail(nemoCreationDto.getEmail());
        return nemoRepository.save(nemo);
    }

    public Nemo getANemo(Long id) {
        Nemo nemo = nemoRepository.findById(id).orElse(null);
        if (nemo == null) {
            throw new NemoNotFoundException(NEMO_NOT_FOUND, id);
        }
        return nemo;
    }

    public List<Nemo> getAllNemos() {
        return nemoRepository.findAllByOrderByIdDesc();
    }

}
