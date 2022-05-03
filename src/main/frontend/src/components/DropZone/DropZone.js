import {useCallback} from "react";
import {useDropzone} from "react-dropzone";

export default function DropZone () {
    const onDrop = useCallback(acceptedFiles => {
        console.log(acceptedFiles);
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