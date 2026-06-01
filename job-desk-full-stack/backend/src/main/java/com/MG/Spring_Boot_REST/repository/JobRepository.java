package com.MG.Spring_Boot_REST.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MG.Spring_Boot_REST.model.JobPost;
@Repository
public interface JobRepository extends JpaRepository<JobPost , Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String Postprofile , String Postdesc);
}



//old method -----------------------------------------------------------------------------------------------

//@Repository
//public class JobRepository {
//
//    // arrayList to store store JobPost objects
//    List<JobPost> jobs = new ArrayList<>(List.of(
//            new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3, List.of("HTML", "CSS", "JavaScript", "React")),
//            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4, List.of("Python", "Machine Learning", "Data Analysis")),
//            new JobPost(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5, List.of("Networking", "Cisco", "Routing", "Switching")),
//            new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3, List.of("iOS Development", "Android Development", "Mobile App"))
//    ));
//
//
//    // method to return all JobPosts
//    public List<JobPost> getAllJobs() {
//        return jobs;
//    }
//
//    // method to save a job post object into arrayList
//    public void addJobPost(JobPost job) {
//        jobs.add(job);
//    }
//
//    public JobPost getjob(int JobId) {
//        for(JobPost job : jobs)
//        {
//            if(job.getPostId() == JobId)
//            {
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public void updatejob(JobPost jobPost) {
//        for(JobPost job : jobs)
//        {
//            if(job.getPostId() == jobPost.getPostId())
//            {
//                job.setPostProfile(jobPost.getPostProfile());
//                job.setPostDesc(jobPost.getPostDesc());
//                job.setReqExperience(jobPost.getReqExperience());
//                job.setPostTechStack(jobPost.getPostTechStack());
//            }
//        }
//    }
//
//    public void deletejob(int postId) {
//        for(JobPost job : jobs)
//        {
//            if(job.getPostId() == postId)
//            {
//                jobs.remove(postId);
//            }
//        }
//    }
//}
