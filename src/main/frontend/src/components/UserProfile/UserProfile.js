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

    return userProfiles.map(({uuid, username}) => {
        return (
            <div key={uuid} className={'user-profile'}>
                <h1>{username}</h1>
                <p>{uuid}</p>
                <DropZone/>
            </div>
        )
    })
}