package com.cydeo.bootstrap;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Arrays;


@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;


    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        System.out.println("-----------Region Start-------------");
//        System.out.println("regions find by country= "+regionRepository.findByCountry("Canada"));
//        System.out.println("regions find by country without duplicate= "+regionRepository.findDistinctByCountry("Canada"));
//        System.out.println("regions find by containing united in country = "+regionRepository.findRegionByCountryContainingIgnoreCase("united"));
//        // findCountryContaining also gives same result
//        System.out.println("regions find by findRegionByCountryContainingIgnoreCaseOrderByCountry = " + regionRepository.findRegionByCountryContainingIgnoreCaseOrderByRegion("united"));
//        System.out.println("regions find by findTop2RegionByCountryContainsIgnoreCase = " + regionRepository.findTop2RegionByCountry("Canada"));
//        System.out.println("-----------Region End-------------");
//        System.out.println("-----------Department start----------");
//        System.out.println("department find by findByDepartment = " + departmentRepository.findByDepartment("Toys") );
//        System.out.println("department find by findByDivision = " + departmentRepository.findByDivision("Health") );
//        System.out.println("department find by findByDivisionIs = " + departmentRepository.findByDivisionIs("Health") );
//        System.out.println("department find by findByDivisionEquals = " + departmentRepository.findByDivisionEquals("Health") );
//        System.out.println("department find by findDistinctTop3ByDivisionContaining = " + departmentRepository.findDistinctTop3ByDivisionContaining("Hea") );
//        System.out.println("-----------Department end----------");
//        System.out.println("-----------Employee start ----------");
//        System.out.println("employee find by find employee by contains email = "+ employeeRepository.findByEmail("btrow5@technorati.com"));
//        System.out.println("employee find findByFirstNameAndLastNameOrEmailExists " + employeeRepository.findByFirstNameAndLastNameOrEmail("Nickey","Pointon",""));
//        System.out.println("employee find findByEmailNot" + employeeRepository.findByEmailNot("btrow5@technorati.com"));
//        System.out.println("employee find findByLastNameStartsWith" + employeeRepository.findByLastNameStartsWith("Poin"));
//        System.out.println("employee find findByLastNameStartsWith" + employeeRepository.findEmployeeBySalaryGreaterThan(100000));
//        System.out.println("employee find findEmployeeBySalaryLessThan" + employeeRepository.findEmployeeBySalaryLessThanEqual(100000));
//
////        System.out.println(employeeRepository.findEmployeeBySalaryGreaterThanEqualOOrderBySalary(10000));
//        System.out.println(employeeRepository.findDistinctTop3BySalaryIsLessThanEqual(100000));
//        System.out.println(employeeRepository.findEmployeeByEmailIsNull());
//        System.out.println(employeeRepository.findEmployeeDetails());
//        System.out.println(employeeRepository.getEmployeeSalary());
//        System.out.println(employeeRepository.getEmployeeDetails("btrow5@technorati.com"));
//        System.out.println(employeeRepository.getEmployeeDetails("btrow5@technorati.com",134501));

//        System.out.println("-----------Employee end ----------");
//        courseRepository.findCourseByCategory("Spring").forEach(System.out::println);
//        courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);
//        System.out.println(courseRepository.existsCourseByName("Spring"));
//        System.out.println(courseRepository.countByCategory("Spring"));
//        System.out.println(courseRepository.findByNameStartingWith("Scalable"));

//        System.out.println(courseRepository.streamByCategory("Spring"));
//        System.out.println(employeeRepository.findEmployeeSalaryNotEqual(10000));
//        employeeRepository.findEmployeeByFirstNameLike("F%").forEach(System.out::println);
//        employeeRepository.findEmployeeBySalaryBetween(90000,100000).forEach(System.out::println);
//        employeeRepository.findEmployeesByEmailIsNull().forEach(System.out::println);
//        System.out.println("-------------");
//        employeeRepository.findEmployeesByEmailIsNOTNull().forEach(System.out::println);
//        employeeRepository.getEmployeeOrdeOrderBySalary().forEach(System.out::println);
//        departmentRepository.getDepartmentDivision(Arrays.asList("Outdoors", "Kids", "Health", "Hardware")).forEach(System.out::println);
//        employeeRepository.readEmployeeDetailsBySalary(134501).forEach(System.out::println);
//        employeeRepository.getEmployeeSalary(134501).forEach(System.out::println);
//        courseRepository.findAllCoursesByCategoryAndRatingMoreThan("Spring",4).forEach(System.out::println);
//        employeeRepository.updateEmployeeJPQL(1);
//        departmentRepository.findDepartmentByDivision("Electronics").forEach(System.out::println);
        departmentRepository.findDepartmentByContainDivision("Electronics").forEach(System.out::println);
    }


}
