package dev.javiervs.awsimageupload.datastore;

import dev.javiervs.awsimageupload.profile.UserProfile;
import dev.javiervs.awsimageupload.profile.UserProfileRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore implements UserProfileRepository {
    private static final List<UserProfile> USER_PROFILES = List.of(
            new UserProfile(UUID.fromString("b58bfb83-a371-49cf-8aed-0cba1e257741"), "janet"),
            new UserProfile(UUID.fromString("d3ecee26-aa04-4243-9c6a-b941f9adf36d"), "antonio")
    );

    @Override
    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }

    @Override
    public Optional<UserProfile> findByUuid(UUID uuid) {
        return USER_PROFILES.stream()
                .filter(userProfile -> userProfile.getUuid().equals(uuid))
                .findFirst();
    }
}
