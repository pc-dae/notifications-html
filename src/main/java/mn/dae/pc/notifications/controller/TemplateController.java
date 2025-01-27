package mn.dae.pc.notifications.controller;

import mn.dae.pc.notifications.dto.request.TemplateRequestDTO;
import mn.dae.pc.notifications.entity.TemplateEntity;
import mn.dae.pc.notifications.service.TemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/template")
public class TemplateController {

    private static final Logger log = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private TemplateService templateService;

    @GetMapping
    public List<TemplateEntity> findAll(@RequestHeader("tenant-id") String tenantId) {
        return templateService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TemplateEntity> findById(@PathVariable UUID templateId, @RequestHeader("tenant-id") String tenantId) {
        return templateService.findById(templateId, tenantId);
    }

    // create a template
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public TemplateEntity create(@RequestBody TemplateRequestDTO template, @RequestHeader("tenant-id") String tenantId) {
        return templateService.save(template, tenantId);
    }

    // update a infra
    @PutMapping
    public TemplateEntity update(@RequestBody Infra infra, @RequestHeader("tenant-id") String tenantId) {
        return infraService.save(infra);
    }

    @PatchMapping("/{id}")
    public Infra update(@PathVariable UUID templateId, @RequestBody TemplateRequestDTO template, @RequestHeader("tenant-id") String tenantId) {
        Optional<Infra> existing;
        existing = infraService.findById(id);
        if (!existing.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );
        }
        Infra e = existing.get();
        log.debug("Existing: {}", existing);
        log.debug("Update: {}", infra);
        e.setFields(infra);
        return infraService.save(e);
    }


    // delete a infra
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        infraService.deleteById(id);
    }

    @GetMapping("/find/{type}/{name}")
    public List<Infra> findByTypeAndName(@PathVariable String type, @PathVariable String name) {
        return infraService.findByTypeAndName(type, name);
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping("/")
    public void createTemplate(String templateId, @RequestBody TemplateEntity template) {
        templateService.createTemplate(template);
    }
}



