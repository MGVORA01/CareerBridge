package com.MG.Spring_Boot_REST.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MG.Spring_Boot_REST.model.JobPost;
import com.MG.Spring_Boot_REST.repository.JobRepository;


@Service
public class JobService {
    @Autowired
    public JobRepository repo;

    //method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    // method to add a jobPost
    public void addJobPost(JobPost jobPost) {
        repo.save(jobPost);
    }

    public JobPost getjob(int jobId) {
        return repo.findById(jobId).orElse(new JobPost());
    }

    public void updatejob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deletejob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {

        List<JobPost> jobs = new ArrayList<>(List.of(
            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3, List.of("HTML", "CSS", "JavaScript", "React")),
            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4, List.of("Python", "Machine Learning", "Data Analysis")),
            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5, List.of("Networking", "Cisco", "Routing", "Switching")),
            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3, List.of("iOS Development", "Android Development", "Mobile App"))
    ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
       return repo.findByPostProfileContainingOrPostDescContaining(keyword , keyword);
    }
}
