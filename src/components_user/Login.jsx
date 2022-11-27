import React from "react";
import {Navigate} from 'react-router-dom';
import { useRef, useState, useEffect } from "react";
import  { Redirect } from 'react-router-dom'
import { getshop } from "../utils/api";
import {Link, useNavigate} from 'react-router-dom';

const Login = () => {
  const userRef = useRef();
  const errRef = useRef();

  var resdata;

  const [user, setUser] = useState("");
  const[statuss, setStatuss] = useState("");
  const [pwd, setPwd] = useState("");
  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    userRef.current.focus();
  }, []);

  useEffect(() => {
    setErrMsg("");
  }, [user, pwd]);

  const handleSubmit = async (e) => {
  
    e.preventDefault();
    getshop(user ,pwd)
      .then((res) => { 
        // console.log(res.username)
        resdata = res;
        setSuccess(true);
        console.log(res);
       
      })
      .catch((err) => {

        if (!err.response) {
          
          setErrMsg("No Server Response");
        } 
        else {
      
          setErrMsg("Login Failed");
        }
        errRef.current.focus();
      });
    setUser("");
    setPwd("");
    console.log(statuss);
    return resdata;
    
  };
  return (
    <>
      {success ? (
        <section>
          <h1>Success!</h1>
          <p>
            <a href="#">Sign In</a>
          </p>
          <Navigate to='/welcome'  />//Navigate

          {/* <Link>
          to={{
            pathname: "/welcome",
          state: user // your data array of objects
            }}
          </Link>
      */}
        


        </section>
      ) : (
    <div>
      <p
        ref={errRef}
        className={errMsg ? "errmsg" : "offscreen"}
        aria-live="assertive"
      >
        {errMsg}
      </p>
      <h1>Sign In</h1>
      <form onSubmit={handleSubmit}>
        <label>Username:</label>
        <input
          type="text"
          id="username"
          ref={userRef}
          onChange={(e) => setUser(e.target.value)}
          value={user}
          required
        />
        <label>Password:</label>
        <input
          type="password"
          id="password"
          onChange={(e) => setPwd(e.target.value)}
          value={pwd}
          required
        />
        <button>Sign In</button>
      </form>
      <p>
        Need an Account? <br />
        <span className="line">
          <a href="#">Sign Up</a>
          
        </span>
        
      </p>
    </div>
      )
}
</>
      );
}
export default Login;
