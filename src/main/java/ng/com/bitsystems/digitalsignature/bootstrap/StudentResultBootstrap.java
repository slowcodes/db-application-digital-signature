package ng.com.bitsystems.digitalsignature.bootstrap;

import lombok.extern.slf4j.Slf4j;
import ng.com.bitsystems.digitalsignature.model.*;
import ng.com.bitsystems.digitalsignature.repository.FacultiesRepository;
import ng.com.bitsystems.digitalsignature.services.PrivateKeyService;
import ng.com.bitsystems.digitalsignature.services.UsersService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class StudentResultBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private FacultiesRepository facultiesRepository;
    private PrivateKeyService privateKeyService;
    private UsersService usersService;

    public StudentResultBootstrap(FacultiesRepository facultiesRepository,
                                  UsersService usersService,
                                  PrivateKeyService privateKeyService) {
        this.facultiesRepository = facultiesRepository;
        this.privateKeyService= privateKeyService;
        this.usersService = usersService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        PrivateKeys privateKeys = new PrivateKeys();
        privateKeys.setPassphrase("2019/2020coskey");
        privateKeys.setUsers(usersService.findByID(Long.valueOf(1)));
        privateKeys.setPrivateKey("94023irkw45u22qjr853u09jmfO90T4");
        privateKeys.setCreatedAt(LocalDate.now());
        privateKeyService.add(privateKeys);
        Set<Faculties> faculties = new HashSet<>();

        Faculties sciences = Faculties.builder().faculty("Sciences").build();
        Faculties art = Faculties.builder().faculty("Arts").build();

        Set<Departments> departments = new HashSet<>();
        Departments mathematics =Departments.builder().department("Mathematics").faculty(sciences).build();

        mathematics.getStudents().add(Students.builder()
                .firstName("Kabiru")
                .lastName("Mohammed")
                .matricNumber("2002/190921")
                .sex("Male")
                .departments(mathematics)
                .build());
        mathematics.getStudents().add(Students.builder()
                .firstName("Saidu")
                .lastName("Kaita")
                .matricNumber("2002/190922")
                .sex("Male")
                .departments(mathematics)
                .build());
        mathematics.getStudents().add(Students.builder()
                .firstName("Fatima")
                .lastName("Mohammed")
                .matricNumber("2002/190923")
                .sex("Female")
                .departments(mathematics)
                .build());
        mathematics.getStudents().add(Students.builder()
                .firstName("Aisha")
                .lastName("Jonah")
                .matricNumber("2002/190924")
                .sex("Male")
                .departments(mathematics)
                .build());

        Set<Courses> mathematicsCourses = new HashSet<>();
        //First Year - First Semester Computer Science Course
        mathematicsCourses.add(Courses.builder()
                .courseCode("CSC 101")
                .courseTitle("Introduction to Computer Science")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 101")
                .courseTitle("General Studies I")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 102")
                .courseTitle("Use of English Language")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 101")
                .courseTitle("Introduction to Mathematical Methods")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 121")
                .courseTitle("Diffrential Equations")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("STA 101")
                .courseTitle("Infrential Statistics I")
                .credits(2)
                .serviceDepartment(mathematics).build());

        //First Year - Second Semester Computer Science Course
        mathematicsCourses.add(Courses.builder()
                .courseCode("CSC 207")
                .courseTitle("Introduction to Computer Science")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 201")
                .courseTitle("General Studies I")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 202")
                .courseTitle("Use of English Language")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 201")
                .courseTitle("Introduction to Mathematical Methods")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 221")
                .courseTitle("Diffrential Equations")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("STA 211")
                .courseTitle("Infrential Statistics I")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematics.setCourses(mathematicsCourses);

        //Second Year - First Semester Computer Science Course
        mathematicsCourses.add(Courses.builder()
                .courseCode("CSC 271")
                .courseTitle("Introduction to Computer Science")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 201")
                .courseTitle("General Studies I")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 202")
                .courseTitle("Use of English Language")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 201")
                .courseTitle("Introduction to Mathematical Methods")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 221")
                .courseTitle("Diffrential Equations")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("STA 201")
                .courseTitle("Infrential Statistics I")
                .credits(2)
                .serviceDepartment(mathematics).build());

        //Second Year - Second Semester Computer Science Course
        mathematicsCourses.add(Courses.builder()
                .courseCode("CSC 211")
                .courseTitle("Introduction to Computer Science")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 261")
                .courseTitle("General Studies I")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 212")
                .courseTitle("Use of English Language")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 201")
                .courseTitle("Introduction to Mathematical Methods")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 221")
                .courseTitle("Diffrential Equations")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("STA 211")
                .courseTitle("Infrential Statistics I")
                .credits(2)
                .serviceDepartment(mathematics).build());

        //Third Year - First Semester Computer Science Course
        mathematicsCourses.add(Courses.builder()
                .courseCode("CSC 391")
                .courseTitle("Introduction to Computer Science")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 304")
                .courseTitle("General Studies I")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 362")
                .courseTitle("Use of English Language")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 395")
                .courseTitle("Introduction to Mathematical Methods")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 371")
                .courseTitle("Diffrential Equations")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("STA 341")
                .courseTitle("Infrential Statistics I")
                .credits(2)
                .serviceDepartment(mathematics).build());

        //Third Year - Second Semester Computer Science Course
        mathematicsCourses.add(Courses.builder()
                .courseCode("CSC 301")
                .courseTitle("Introduction to Computer Science")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 341")
                .courseTitle("General Studies I")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 338")
                .courseTitle("Use of English Language")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 395")
                .courseTitle("Introduction to Mathematical Methods")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 383")
                .courseTitle("Diffrential Equations")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("STA 351")
                .courseTitle("Infrential Statistics I")
                .credits(2)
                .serviceDepartment(mathematics).build());

        //Fourth Year - First Semester Computer Science Course
        mathematicsCourses.add(Courses.builder()
                .courseCode("CSC 418")
                .courseTitle("Introduction to Computer Science")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 421")
                .courseTitle("General Studies I")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 429")
                .courseTitle("Use of English Language")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 472")
                .courseTitle("Introduction to Mathematical Methods")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 418")
                .courseTitle("Diffrential Equations")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("STA 425")
                .courseTitle("Infrential Statistics I")
                .credits(2)
                .serviceDepartment(mathematics).build());

        //Fourth Year - Second Semester Computer Science Course
        mathematicsCourses.add(Courses.builder()
                .courseCode("CSC 401")
                .courseTitle("Introduction to Computer Science")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 402")
                .courseTitle("General Studies I")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("GS 403")
                .courseTitle("Use of English Language")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 441")
                .courseTitle("Introduction to Mathematical Methods")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("MTH 421")
                .courseTitle("Diffrential Equations")
                .credits(2)
                .serviceDepartment(mathematics).build());
        mathematicsCourses.add(Courses.builder()
                .courseCode("STA 411")
                .courseTitle("Infrential Statistics I")
                .credits(2)
                .serviceDepartment(mathematics).build());

        departments.add(mathematics);
        departments.add(Departments.builder().department("Statistics").faculty(sciences).build());
        departments.add(Departments.builder().department("Geology").faculty(sciences).build());
        departments.add(Departments.builder().department("Physics & Astronomy").faculty(sciences).build());

        sciences.setDepartments(departments);
        faculties.add(sciences);
        faculties.add(art);

        facultiesRepository.saveAll(faculties);
    }
}
