import React from "react";
import Login from "../components_user/Login";
const Welcome = () => {
  
  var user = Login.resuser;
    return (

      <div className="Welcome">
        <h1>Welcome {user} to Save-Money</h1>
      </div>
    );
  };
  
  export default Welcome;
  