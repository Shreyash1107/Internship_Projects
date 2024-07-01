package org.service;

import org.model.Departmentmodel;
import org.repository.Departmentrepository;
public class Departmentservice 
{
    Departmentrepository drepo = new Departmentrepository();
     public boolean isDepartmentAdded(Departmentmodel dm)
     {
        return drepo.isDepartmentAdded(dm);
     }
}
