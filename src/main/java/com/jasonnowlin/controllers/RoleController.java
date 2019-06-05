package com.jasonnowlin.controllers;

import com.jasonnowlin.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PutMapping("/roles/{personId}/{movieId}")
    public void assign(@PathVariable Long personId, @PathVariable Long movieId) {
        roleService.assign(personId, movieId);
    }

    @DeleteMapping("/roles/{personId}/{movieId}")
    public void unassign(@PathVariable Long personId, @PathVariable Long movieId) {
        roleService.unassign(personId, movieId);
    }
}
