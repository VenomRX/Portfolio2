package com.Mark1_Jobportal.jobportal.services;


import com.Mark1_Jobportal.jobportal.entity.JobSeekerProfile;
import com.Mark1_Jobportal.jobportal.entity.RecruiterProfile;
import com.Mark1_Jobportal.jobportal.entity.Users;
import com.Mark1_Jobportal.jobportal.repository.JobSeekerProfileRepository;
import com.Mark1_Jobportal.jobportal.repository.RecruiterProfileRepository;
import com.Mark1_Jobportal.jobportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersService {

    private UserRepository userRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    public UsersService(UserRepository userRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository) {
        this.userRepository = userRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Users addNewUser(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));

        Users savedUsers=userRepository.save(users);
        System.out.println("This is id");
        int userTypeId=users.getUserTypeId().getUserTypeId();
        System.out.println(userTypeId);
        if(userTypeId==1){
            recruiterProfileRepository.save(new RecruiterProfile(savedUsers));
        }else{
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUsers));
        }
        return savedUsers;
    }

    public Optional<Users> getUserByEmail(String email){
          return userRepository.findByEmail(email);
    }
}
