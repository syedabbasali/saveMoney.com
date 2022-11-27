import { Password } from "@mui/icons-material";
import axios from "axios";
const saveMoneyApi = axios.create({
  // baseURL: "http://3.89.142.209:8080",
  baseURL: "http://localhost:8080",
});


export const registerShop = (username, password, shop_type) => {
  return saveMoneyApi
    .post(`/registershop`, { username, password, shop_type })
    .then((res) => {
      console.log(res.data, "<<<in api");
      return res.data;
    });
  }
  
  export const getshop = (username, password) => {
      return saveMoneyApi
        .get(`/shop/get_shop/username=${username}/password=${password}`, { username ,password})
        .then((res) =>{

          return res.data;
      });
    };
