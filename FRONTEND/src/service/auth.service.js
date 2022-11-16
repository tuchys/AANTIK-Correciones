import axios from "axios";

const API_URL = "http://localhost:8080/aut/";
class AuthService {
  async login(user) {
    const response = await axios
      .post(API_URL + "login2", {
        username: user.username,
        password: user.password,
      });
    if (response.data.accessToken) {
      localStorage.setItem('user', JSON.stringify(response.data));
    }
    return response.data;
  }
  getUser(){
    var user = JSON.parse(localStorage.getItem('user'));
    return user.username.split("@")[0]
  }
  getCorreo(){
    var user = JSON.parse(localStorage.getItem('user'));
    return user.username
  }
  logout() {
    localStorage.removeItem('user');
  }
  register(user) {
    return axios.post(API_URL + "signup", {
      username: user.username,
      password: user.password,
    });
  }
}
export default new AuthService();