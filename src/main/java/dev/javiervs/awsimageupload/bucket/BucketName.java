package dev.javiervs.awsimageupload.bucket;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BucketName {
    PROFILE_IMAGE("javiervs-image-upload");

    private final String bucketName;
}
