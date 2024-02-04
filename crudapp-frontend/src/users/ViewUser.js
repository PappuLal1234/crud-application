import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewUser() {
    const [user, setUser] = useState({
        id: "",
        name: "",
        email: "",
        gender: "",
        status: "",
    });
    const { id } = useParams();
    useEffect(() => {
        loadUser();
    }, []);

    const loadUser = async () => {
        const result = await axios.get(`http://localhost:6215/api/users/${id}`);
        setUser(result.data);
    };
    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'> User Information</h2>
                    <div className='card'>
                        <div className='card-header'>
                            <ul className='list-group list-group-flush'>
                                <li className='list-group-item'>
                                    <b>UserId :</b>
                                    {user.id}
                                </li>
                                <li className='list-group-item'>
                                    <b>User Name :</b>
                                    {user.name}
                                </li>
                                <li className='list-group-item'>
                                    <b>User Email :</b>
                                    {user.email}
                                </li>
                                <li className='list-group-item'>
                                    <b>User Gender :</b>
                                    {user.gender}
                                </li>
                                <li className='list-group-item'>
                                    <b>User IsActive :</b>
                                    {user.status}
                                </li>


                            </ul>
                        </div>
                    </div>
                    <Link className='btn btn-primary mt-2 ' to={"/"}>Back to HomePage</Link>
                </div>
            </div>
        </div>
    )
}
