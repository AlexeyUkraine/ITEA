package com.hibernate;

/**
 * Created by alexey.savchuk on 04.04.2016.
 */
import java.util.ArrayList;
import java.util.List;

import com.dao.ProgrammerDao;
import com.dao.ProjectDao;
import org.hibernate.Session;

import com.model.Project;
import com.model.Programmer;

public class Run {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Programmer programmer1 = new Programmer("Alexey", "Savchuk");
        Programmer programmer2 = new Programmer("David", "Ushakov");
        Programmer programmer3 = new Programmer("Andrey", "Paukov");

        Project project = new Project("ITEA");
        List<Programmer> allProgrammers = new ArrayList<Programmer>();

        programmer1.setProject(project);
        programmer2.setProject(project);
        programmer3.setProject(project);

        allProgrammers.add(programmer1);
        allProgrammers.add(programmer2);
        allProgrammers.add(programmer3);

        project.setProgrammers(allProgrammers);
        ////////////////////////////////////////////////////////////

        ProgrammerDao progrDao = new ProgrammerDao();

        ProjectDao projDao = new ProjectDao();

       long prId=   projDao.saveProject(project);  //saving project


        List<Programmer> programmers = progrDao.getAllProgrammers();

        for (Programmer p : programmers) {
            System.out.println("Programmer Details : " + p);
            System.out.println("Student project details: "
                    + p.getProject()+" id= "+p.getId());
        }


        projDao.deleteProject(prId);


//       progrDao.updateProgrammer(28L, "Dmitriy", "Kamanets");
//        progrDao.deleteProgrammer(29L);

    }

}
