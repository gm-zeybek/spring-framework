package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.service.ProjectService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImp(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        super();
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDTO> findAll() {
        return projectRepository.findAll().stream().map(projectMapper::convertDTO).collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO projectDTO) {


        Project projectEntity = projectMapper.convertEntity(projectDTO);
        projectRepository.save(projectEntity);
    }

    @Override
    public ProjectDTO findById(Long source) {
       Project project = projectRepository.findById(source).get();
       return projectMapper.convertDTO(project);
    }

    @Override
    public void deleteById(String projectcode) {
        Project project = projectRepository.findProjectByProjectCode(projectcode);
        project.setIsDeleted(true);
        projectRepository.save(project);
    }

    @Override
    public void complete(ProjectDTO byId) {

    }


}
