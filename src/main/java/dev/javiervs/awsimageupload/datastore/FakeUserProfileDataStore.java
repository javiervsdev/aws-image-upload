package dev.javiervs.awsimageupload.datastore;

import dev.javiervs.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {
    private static final List<UserProfile> USER_PROFILES = List.of(
            UserProfile.builder()
                    .uuid(UUID.randomUUID())
                    .username("janet")
                    .build(),
            UserProfile.builder()
                    .uuid(UUID.randomUUID())
                    .username("antonio")
                    .build()
    );

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
