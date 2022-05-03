import axios from "axios";
import {useCallback} from "react";
import {useDropzone} from "react-dropzone";

export default function DropZone({userProfileUuid}) {

    const onDrop = useCallback(acceptedFiles => {
        const formData = new FormData();
        formData.append('file', acceptedFiles[0]);
        axios.post(`http://localhost:8080/api/v1/user-profile/${userProfileUuid}/image/upload`,
            formData,
            {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            }
        ).then(response => {
            console.log(response);
        }).catch(error => {
            console.log(error);
        });
    }, []);

    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

    return (
        <div {...getRootProps()}>
            <input {...getInputProps()}/>
            {
                isDragActive ?
                    <p>Drop the image here ...</p> :
                    <p>Drag 'n' drop profile image, or click to select profile image</p>
            }
        </div>
    )
}