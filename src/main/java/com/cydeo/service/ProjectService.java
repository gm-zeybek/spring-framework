package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> listAllProjects();
    ProjectDTO getByProjectCode(Long source);

    void save(ProjectDTO dto);

    void update(ProjectDTO dto);

    void deleteById(String projectcode);

    void complete(ProjectDTO byId);
}
