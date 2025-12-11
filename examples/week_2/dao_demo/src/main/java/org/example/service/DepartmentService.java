package org.example.service;

import org.example.repository.DAO.DepartmentDAO;
import org.example.repository.entities.DepartmentEntity;
import org.example.repository.entities.LocationEntity;
import org.example.service.interfaces.ServiceInterface;
import org.example.service.model.Department;
import org.example.service.model.Location;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentService implements ServiceInterface<DepartmentEntity, Department> {

    private DepartmentDAO departmentDAO = new DepartmentDAO();

    @Override
    public Integer createEntity(DepartmentEntity entity) {
        try{
            Integer newId = departmentDAO.create(entity);
            return newId;
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Optional<DepartmentEntity> getEntityById(Integer id) {
        try{
            Optional<DepartmentEntity> departmentEntity = departmentDAO.findById(id);
            if(departmentEntity.isEmpty()){
                throw new RuntimeException("Department not found");
            }

            return departmentEntity;
        }catch(SQLException | RuntimeException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<DepartmentEntity> getAllEntities() {
        try{
            List<DepartmentEntity> departmentEntities = departmentDAO.findAll();
            return departmentEntities;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public DepartmentEntity updateEntity(Integer id, DepartmentEntity newEntity) {
        return null;
    }

    @Override
    public boolean deleteEntity(Integer id) {
        return false;
    }

    @Override
    public Optional<Department> convertEntityToModel(DepartmentEntity entity) {

        Department department = new Department();
        department.setId(entity.getId());
        department.setDepartment(entity.getDepartment());

        return Optional.of(department);
    }

    @Override
    public Optional<Department> getModelById(Integer id) {
        Optional<DepartmentEntity> departmentEntity = getEntityById(id);
        try{
            if(departmentEntity.isPresent()){
                Optional<Department> department = convertEntityToModel(departmentEntity.get());
                if(department.isPresent()){
                    return department;
                }else{
                    throw new RuntimeException("DepartmentEntity conversion failed");
                }
            }else{
                throw new RuntimeException("DepartmentEntity not found");
            }

        }catch(RuntimeException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Department> getModelByDepartmentName(String departmentName) {
        Optional<DepartmentEntity> departmentEntity = getEntityByDepartmentName(departmentName);
        try{
            if(departmentEntity.isPresent()){
                Optional<Department> department = convertEntityToModel(departmentEntity.get());
                if(department.isPresent()){
                    return department;
                }else{
                    throw new RuntimeException("DepartmentEntity conversion failed");
                }
            }else{
                throw new RuntimeException("DepartmentEntity not found");
            }
        }catch(RuntimeException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<DepartmentEntity> getEntityByDepartmentName(String departmentName) {
        try{
            Optional<DepartmentEntity> departmentEntity = departmentDAO.findByDepartmentName(departmentName);
            return departmentEntity;
        }catch (SQLException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public List<Department> getAllModels() {
        List<DepartmentEntity> departmentEntities = getAllEntities();
        List<Department> departments = new ArrayList<>();
        for(DepartmentEntity departmentEntity : departmentEntities){
            Optional<Department> department = convertEntityToModel(departmentEntity);
            if(department.isPresent()){
                departments.add(department.get());
            }
        }
        return departments;
    }
}
