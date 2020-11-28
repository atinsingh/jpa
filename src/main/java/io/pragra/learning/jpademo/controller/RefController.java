package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.RefData;
import io.pragra.learning.jpademo.repo.RefDataRepo;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RefController {
    private RefDataRepo refDataRepo;

    public RefController(RefDataRepo refDataRepo) {
        this.refDataRepo = refDataRepo;
    }


    @GetMapping("/api/ref")
    public List<RefData> getRefData() {
        return this.refDataRepo.findAll();
    }
}
