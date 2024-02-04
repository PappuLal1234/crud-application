import axios from 'axios'
import { Button } from 'bootstrap'
import React, { useEffect, useState } from 'react'
import { useNavigate,Link, useParams } from 'react-router-dom'

export default function EditUser() {
    let navigate = useNavigate();
    const{id1}=useParams();
    const [user, setUser] = useState({
        id: "",
        name: "",
        email: "",
        password: "",
        gender: "",
        status: ""
    })

    const { id, name, email, password, gender, status } = user;
    const onInputChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value })
    }
    useEffect(()=>{
        loadUser()
    },[]);

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.put(`http://localhost:6215/api/users/${id}`, user)
        navigate("/");
    }
    const loadUser=async()=>{
        const result=await axios.get(`http://localhost:6215/api/users/${id}`)
        setUser(result.data)
    }
    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'>Edit User</h2>
                    <form onSubmit={(e) => onSubmit(e)}>
                        <div className='mb-3'>
                            <label htmlFor='id' className='form-label'>
                                User Id :
                            </label>
                            <input type={"text"} className='form-conrol mx-2' placeholder='Enter your userid' name="id" value={id}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='name' className='form-label'>
                                Name :
                            </label>
                            <input type={"text"} className='form-conrol mx-2' placeholder='Enter your name' name="name" value={name}
                                onChange={(e) => onInputChange(e)} />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='email' className='form-label'>
                                Email :
                            </label>
                            <input type={"text"} className='form-conrol mx-2' placeholder='Enter your email' name="email" value={email}
                                onChange={(e) => onInputChange(e)} />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='password' className='form-label'>
                                Password :
                            </label>
                            <input type={"text"} className='form-conrol mx-2' placeholder='Enter your password' name="password" value={password}
                                onChange={(e) => onInputChange(e)} />
                        </div>

                        <div className='mb-3'>
                            <label htmlFor='gender' className='form-label'>
                                Gender :
                            </label>
                            <input type={"text"} className='form-conrol mx-2' placeholder='Enter your Gender' name="gender" value={gender}
                                onChange={(e) => onInputChange(e)} />
                        </div>
                        <div className='mb-3'>
                            <label htmlFor='status' className='form-label'>
                                Active :
                            </label>
                            <input type={"text"} className='form-conrol mx-2' placeholder='Enter your Activeness' name="status" value={status}
                                onChange={(e) => onInputChange(e)} />
                        </div>

                        <button type="submit" className='btn btn-outline-primary mx-2'>Submit</button>

                        <Link className='btn btn-outline-danger mx-2' to="/">Cancel</Link>
                    </form>
                </div>

            </div>
        </div>
    )
}
