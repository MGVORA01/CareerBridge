package com.MG.Spring_Boot_REST.controller;

import com.MG.Spring_Boot_REST.model.JobPost;
import com.MG.Spring_Boot_REST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {

    @Autowired
    public JobService service;

    @GetMapping("/jobPosts")
    public List<JobPost> getalljobs()
    {
        return service.getAllJobs();
    }

    @GetMapping("/jobPost/{JobId}")
    public JobPost getpost(@PathVariable int JobId)
    {
        return service.getjob(JobId);
    }

    @PostMapping("/jobPost")
    public JobPost addjob(@RequestBody JobPost jobPost)
    {
        service.addJobPost(jobPost);
        return service.getjob(jobPost.getPostId());
    }

    @PutMapping("/jobPost")
    public JobPost updatejob(@RequestBody JobPost jobPost)
    {
        service.updatejob(jobPost);
        return service.getjob(jobPost.getPostId());
    }

    @DeleteMapping("/jobPost/{PostId}")
    public String deletejob(@PathVariable int PostId)
    {
        service.deletejob(PostId);
        return "Delete Complete!!";
    }

    @GetMapping("/load")
    public void loaddata()
    {
        service.load();
    }

    @GetMapping("/jobPosts/keyword/{keyword}")
    public List<JobPost> getpostbykeyword(@PathVariable("keyword") String keyword)
    {
        return service.search(keyword);
    }
}
