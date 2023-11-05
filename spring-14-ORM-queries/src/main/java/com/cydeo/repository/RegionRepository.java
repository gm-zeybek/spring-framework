package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

    // REQUIREMENTS
    // display all regions in Canada
    List<Region> findByCountry(String country);
    // display all regions in Canada without duplicate
    List<Region> findDistinctByCountry(String country);

    // display all regions with country name includes 'United'
    List<Region> findRegionByCountryContainingIgnoreCase(String country);

    // display all regions with country name includes 'united' in order
    List<Region> findRegionByCountryContainingIgnoreCaseOrderByRegion(String country);

    // display top two regions in Canada
    List<Region> findTop2RegionByCountry(String country); // top2
    //
}
