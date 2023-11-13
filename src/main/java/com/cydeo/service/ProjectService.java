package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> findAll();

    void save(ProjectDTO project);

    ProjectDTO findById(Long source);

    void deleteById(String projectcode);

    void complete(ProjectDTO byId);
}
