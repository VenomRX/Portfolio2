package com.Mark1_Jobportal.jobportal.services;

import com.Mark1_Jobportal.jobportal.entity.UsersType;
import com.Mark1_Jobportal.jobportal.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {

    private final UserTypeRepository userTypeRepository;

    public UsersTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public List<UsersType> getAll(){
        return userTypeRepository.findAll();
    }
}
