import ProfileForm from './ProfileForm';
import classes from './UserProfile.module.css';
import { useState, useEffect, useRef, useContext } from 'react';
import { useHistory } from 'react-router-dom';
import ItemUpload from './itemUpload';

const UserProfile = () => {

  const ref = useRef(null);
  const {tableau} = window;

  const  url="https://public.tableau.com/views/saveMoneyDashboard/Dashboard1"

  const options = {
    device: "desktop",
  }

  function initViz() {
    new tableau.Viz(ref.current, url, options);
  }

  useEffect(() => {
    initViz();
  },[])

  const [isChangePassword, setisChangePassword] = useState(false);
  const [profile, setProfile] = useState([]);

  useEffect(() => {
    const items = JSON.parse(localStorage.getItem('userProfile'));
    if (items) {
      setProfile(items);
    }
  }, []);
  
  const ChangePassword = () => {
    setisChangePassword(true);
  }

  const returnProfile = () => {
    setisChangePassword(false);
  }
  
  return (
    
    <section className={classes.profile}>

      <h1>Your User Profile</h1>
      {!isChangePassword && (
        <section className={classes.auth}>
          <h2>Shop Details</h2>
          <div className={classes.displayFlex}>
            <div>
              <p><b>Username</b>: &nbsp;&nbsp; {profile.username}</p>
              <p><b>Shop Name</b>: &nbsp;&nbsp; {profile.shop_name}</p>
              <p><b>Shop Type</b>: &nbsp;&nbsp; {profile.shop_type}</p>
              <p><b>Shop Status</b>: &nbsp;&nbsp; {profile.shop_status}</p>
              <br></br>
              </div>
            <div>
              <p><b>Shop Address</b>: &nbsp;&nbsp; {profile.shop_address}</p>
              <p><b>Shop Postcode</b>: &nbsp;&nbsp; {profile.shop_postcode}</p>
              <p><b>Shop Latitude</b>: &nbsp;&nbsp; {profile.shop_latitude}</p>
              <p><b>Shop Longitude</b>: &nbsp;&nbsp; {profile.shop_longitude}</p>
              <p><b>Shop Crowd</b>: &nbsp;&nbsp; {profile.shop_crowd}</p>
            </div>
          </div>
          <hr style={{margin: "20px"}}></hr>
          <ItemUpload />
        </section>
      )}
      {!isChangePassword && (
        <div className={classes.action}>
          <button onClick={ChangePassword}>Change Password</button>
        </div>
      )}
      {isChangePassword && (
        <ProfileForm />
      )}
      {isChangePassword && (
        
          <button
            type='button'
            className={classes.toggle}
            onClick={returnProfile}
            >
            Return to Profile
          </button>
        
      )}
      
      <br />
      <hr />
        <div>
          <div ref={ref}></div>
        </div>

      
      
    </section>
   
  );
};

export default UserProfile;
