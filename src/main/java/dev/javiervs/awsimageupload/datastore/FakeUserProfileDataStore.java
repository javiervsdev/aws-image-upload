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
            new UserProfile(UUID.randomUUID(), "janet"),
            new UserProfile(UUID.randomUUID(), "antonio")
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
