package dev.javiervs.awsimageupload.profile;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository {
    List<UserProfile> getUserProfiles();
}
