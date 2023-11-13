package com.cydeo.entity;

import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import lombok.*;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@Data
@Where(clause = "is_deleted=false")
@AllArgsConstructor
public class Project extends BaseEntity {

    @NotNull
    private String projectName;
    private String projectCode;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "manager_name")
    private User assignedManager;

    @DateTimeFormat(pattern = "yy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private LocalDate endDate;

    private String projectDetail;
    @Enumerated(EnumType.STRING)

    private Status projectStatus;
    private int completeTaskCounts;
    private int unfinishedTaskCounts;

    public Project(String projectName, String projectCode, User assignedManager, LocalDate startDate, LocalDate endDate, String projectDetail, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignedManager = assignedManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetail = projectDetail;
        this.projectStatus = projectStatus;
    }
}
