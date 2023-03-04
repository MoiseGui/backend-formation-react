package com.example.formationreact.api;

import com.example.formationreact.domain.dto.NemoCreationDto;
import com.example.formationreact.domain.model.Nemo;
import com.example.formationreact.service.NemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/nemos")
@CrossOrigin(origins = "*")
@Tag(name = "Nemos Management", description = "Nemos API")
public class NemoController {

    private final NemoService nemoService;

    @Operation(summary = "Get all nemos")
    @GetMapping
    public List<Nemo> getAllNemos() {
        return nemoService.getAllNemos();
    }

    @Operation(summary = "Get a nemo by id")
    @GetMapping("/{id}")
    public Nemo getNemo(Long id) {
        return nemoService.getANemo(id);
    }

    @Operation(summary = "Create a nemo")
    @PostMapping
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json"))
    public Nemo createANemo(@RequestBody NemoCreationDto nemoCreationDto) {
        return nemoService.createNemo(nemoCreationDto);
    }

    @Operation(summary = "Suspend a nemo by id")
    @PutMapping("/suspend/{id}")
    public void suspendANemo(@PathVariable Long id) {
        nemoService.suspendNemo(id);
    }

    @Operation(summary = "Activate a nemo by id")
    @PutMapping("/activate/{id}")
    public void activateANemo(@PathVariable Long id) {
        nemoService.activateNemo(id);
    }

    @Operation(summary = "Delete a nemo by id")
    @DeleteMapping("/{id}")
    public void deleteANemo(@PathVariable Long id) {
        nemoService.deleteNemo(id);
    }

    @Operation(summary = "Update a nemo by id")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json"))
    @PutMapping("/{id}")
    public Nemo updateNemo(Long id, @RequestBody NemoCreationDto nemoCreationDto) {
        return nemoService.updateNemo(id, nemoCreationDto);
    }
}
