package com.MG.Spring_Boot_REST.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class JobPost {

//    @Id
//    private int PostId;
//    private String PostProfile;
//    private String PostDesc;
//    private Integer ReqExperience;
//    private List<String> PostTechStack;
//
//
//    public JobPost(int PostId, String PostProfile, String PostDesc, int ReqExperience, List<String> PostTechStack) {
//        this.PostId = PostId;
//        this.PostProfile = PostProfile;
//        this.PostDesc = PostDesc;
//        this.ReqExperience = ReqExperience;
//        this.PostTechStack = PostTechStack;
//    }

    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    private List<String> postTechStack;

    public JobPost(int postId, String postProfile, String postDesc, int reqExperience, List<String> postTechStack) {
        this.postId = postId;
        this.postProfile = postProfile;
        this.postDesc = postDesc;
        this.reqExperience = reqExperience;
        this.postTechStack = postTechStack;
    }
}
