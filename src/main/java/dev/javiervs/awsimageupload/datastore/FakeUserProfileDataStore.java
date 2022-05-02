package dev.javiervs.awsimageupload.datastore;

import dev.javiervs.awsimageupload.profile.UserProfile;
import dev.javiervs.awsimageupload.profile.UserProfileRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore implements UserProfileRepository {
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

    @Override
    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
