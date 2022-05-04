package dev.javiervs.awsimageupload.profile;

import dev.javiervs.awsimageupload.bucket.BucketName;
import dev.javiervs.awsimageupload.filestore.FileStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final FileStore fileStore;
    private final UserProfileRepository userProfileRepository;
    public static final String PREFIX_IMAGE_MEDIA_TYPE = "image/";

    public List<UserProfile> getUserProfiles() {
        return userProfileRepository.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {

        isEmptyFile(file);

        isImageFile(file);

        UserProfile userProfile = userProfileRepository.findByUuid(userProfileId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("User profile with id %s does not exist", userProfileId)));

        try {
            fileStore.save(
                    getImagePath(userProfileId),
                    getImageName(userProfileId, file.getOriginalFilename()),
                    getOptionalMetadata(file),
                    file.getInputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void isImageFile(MultipartFile file) {
        if (file.getContentType() == null
                || !file.getContentType().startsWith(PREFIX_IMAGE_MEDIA_TYPE)) {
            throw new IllegalArgumentException("File must be an image");
        }
    }

    private void isEmptyFile(MultipartFile file) {
        if (file == null || file.getSize() == 0) {
            throw new IllegalArgumentException("File cannot be empty");
        }
    }

    private String getImageName(UUID userProfileId, String filename) {
        return String.format("%s-%s", userProfileId, filename);
    }

    private String getImagePath(UUID userProfileId) {
        return String.format("%s/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                userProfileId);
    }

    private Optional<Map<String, String>> getOptionalMetadata(MultipartFile file) {
        return Optional.of(
                Map.of("Content-Type", file.getContentType(),
                        "Content-Length", String.valueOf(file.getSize()))
        );
    }
}
