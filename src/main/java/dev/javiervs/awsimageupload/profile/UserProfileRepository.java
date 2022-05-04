package dev.javiervs.awsimageupload.profile;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserProfileRepository {
    List<UserProfile> getUserProfiles();

    Optional<UserProfile> findByUuid(UUID uuid);
}
