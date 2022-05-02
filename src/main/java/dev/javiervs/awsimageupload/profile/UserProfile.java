package dev.javiervs.awsimageupload.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Optional;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class UserProfile {
    private UUID uuid;
    private String username;
    private String imageLink; // S3 key

    public Optional<String> getImageLink() {
        return Optional.ofNullable(imageLink);
    }
}
