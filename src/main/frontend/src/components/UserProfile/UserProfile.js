import axios from "axios";
import React, {useEffect, useState} from "react";
import DropZone from "../DropZone/DropZone";
import './UserProfile.css';

export default function UserProfiles() {

    const [userProfiles, setUserProfiles] = useState([]);

    const fetchUserProfiles = () => {
        axios.get("http://localhost:8080/api/v1/user-profile")
            .then(({data}) => {
                setUserProfiles(data)
            })
            .catch(error => {
                console.log(error)
            })
    }

    useEffect(() => {
        fetchUserProfiles()
    }, [])

    return userProfiles.map(({uuid, username, imageLink}) => {
        return (
            <div key={uuid} className={'user-profile'}>
                {imageLink && <img src={`http://localhost:8080/api/v1/user-profile/${uuid}/image/download`} alt={username}/>}
                <h1>{username}</h1>
                <p>{uuid}</p>
                <DropZone userProfileUuid={uuid}/>
            </div>
        )
    })
}