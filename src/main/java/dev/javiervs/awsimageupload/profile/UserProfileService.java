package dev.javiervs.awsimageupload.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserProfileService(UserProfileRepository userProfileRepository) {

    public List<UserProfile> getUserProfiles() {
        return userProfileRepository.getUserProfiles();
    }
}
