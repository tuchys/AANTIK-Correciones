<template>
    <div class="header">
    <!--Content before waves-->
    <div class="inner-header flex">
      <!--Just the logo.. Don't mind this-->
      <path
        fill="#FFFFFF"
        stroke="#000000"
        stroke-width="10"
        stroke-miterlimit="10"
        d="M57,283"
      />
      <g>
        <path
          fill="#fff"
          d="M250.4,0.8C112.7,0.8,1,112.4,1,250.2c0,137.7,111.7,249.4,249.4,249.4c137.7,0,249.4-111.7,249.4-249.4
C499.8,112.4,388.1,0.8,250.4,0.8z M383.8,326.3c-62,0-101.4-14.1-117.6-46.3c-17.1-34.1-2.3-75.4,13.2-104.1
c-22.4,3-38.4,9.2-47.8,18.3c-11.2,10.9-13.6,26.7-16.3,45c-3.1,20.8-6.6,44.4-25.3,62.4c-19.8,19.1-51.6,26.9-100.2,24.6l1.8-39.7		c35.9,1.6,59.7-2.9,70.8-13.6c8.9-8.6,11.1-22.9,13.5-39.6c6.3-42,14.8-99.4,141.4-99.4h41L333,166c-12.6,16-45.4,68.2-31.2,96.2	c9.2,18.3,41.5,25.6,91.2,24.2l1.1,39.8C390.5,326.2,387.1,326.3,383.8,326.3z"
        />
      </g>
    </div>
  <div class="col-md-12">
    <div class="card card-container">
      <img id="profile-img" src="../assets/puj.png" class="profile-img-card" />
      <form name="form" @submit.prevent="handleLogin">
        <div class="form-group">
          <label for="username">Usuario:</label>
          <input
            v-model="user.username"
            v-validate="'required'"
            type="text"
            class="form-control"
            name="username"
            placeholder="ejemplo@javeriana.edu.co"
          />
          <div
            v-if="errors.has('username')"
            class="alert alert-danger"
            role="alert"
          >Usuario es requerido!</div>
        </div>
        <div class="form-group">
          <label for="password">Contraseña:</label>
          <input
            v-model="user.password"
            v-validate="'required'"
            type="password"
            class="form-control"
            name="password"
            placeholder="Contraseña"
          />
          <p class="forgot-password text-right mt-2 mb-4">
                <router-link to="/user/recuperaPswrd">¿Olvidó su contraseña?</router-link>
            </p>
          <div
            v-if="errors.has('password')"
            class="alert alert-danger"
            role="alert"
          >Contraseña es requerida!</div>
        </div>
        <div class="form-group">
          <button class="btn btn-primary btn-block" :disabled="loading" margin="10px">
            <span v-show="loading" class="spinner-border spinner-border-sm"></span>
            <span>Login</span>
          </button>
        </div>
        <div class="form-group">
          <div v-if="message" class="alert alert-danger" role="alert">{{message}}</div>
        </div>
      </form>
    </div>
  </div>
  <!--Waves Container-->
  <div>
      <svg
        class="waves"
        xmlns="http://www.w3.org/2000/svg"
        xmlns:xlink="http://www.w3.org/1999/xlink"
        viewBox="0 24 150 28"
        preserveAspectRatio="none"
        shape-rendering="auto"
      >
        <defs>
          <path
            id="gentle-wave"
            d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z"
          />
        </defs>
        <g class="parallax">
          <use
            xlink:href="#gentle-wave"
            x="48"
            y="0"
            fill="rgba(255,255,255,0.7"
          />
          <use
            xlink:href="#gentle-wave"
            x="48"
            y="3"
            fill="rgba(255,255,255,0.5)"
          />
          <use
            xlink:href="#gentle-wave"
            x="48"
            y="5"
            fill="rgba(255,255,255,0.3)"
          />
          <use xlink:href="#gentle-wave" x="48" y="7" fill="#fff" />
        </g>
      </svg>
    </div>
    <!--Waves end-->
  </div>
  <!--Header ends-->
  <!--Content ends-->
</template>
<script>
import User from "@/components/user";
export default {
  name: 'Login',
  data() {
    return {
      user: new User('', ''),
      loading: false,
      message: ''
    };
  },computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  created() {
   /* if (this.loggedIn) {
      this.$router.push('/foro');
      this.$store.dispatch(logout);
    }*/
  },
  methods: {
    handleLogin() {
      this.loading = true;
      console.log(this.user.username)
      this.$validator.validateAll().then(isValid => {
        if (!isValid) {
          this.loading = false;
          return;
        }
        console.log(this.user.username)
        if (this.user.username && this.user.password) {
          this.$store.dispatch('auth/login', this.user).then(
            (data) => {  
              if(data.roles == "ROLE_STUDIANTE" ){
              this.$router.push('/studentHome');}
              if(data.roles == "ROLE_ADMIN" ){
              this.$router.push('/adminHome');}
              if(data.roles == "ROLE_ORGANIZACION" ){
              this.$router.push('/orgSocHome');}
              if(data.roles == "ROLE_EMP" ){
              this.$router.push('/HomeEmp');}
              if(data.roles == "ROLE_COORDINADOR" ){
              this.$router.push('/CoordHome');}
              if(data.roles == "ROLE_DOCENTE" ){
              this.$router.push('/HomeDoc');}
              if(data.roles == "ROLE_PREINSCRITO" ){
              this.$router.push('/preinscHome');}
            },
            error => {
              this.loading = false;
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
            }
          );
        }
      });
    }
  }
};
</script>
<style scoped>
label {
  display: block;
  margin-top: 10px;
}
.card-container.card {
  max-width: 350px !important;
  padding: 40px 40px;
}
.card {
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 10px;
  align-content: center;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  border-radius: 25px;
  text-align: left;
}
.profile-img-card {
  width: 200px;
  height: 200px;
  margin: 0 auto 20px;
  display: inside;
  object-fit: scale-down;
  -moz-border-radius: 60%;
  -webkit-border-radius: 80%;
  border-radius: 80%;
}
@import url(//fonts.googleapis.com/css?family=Lato:300:400);

body {
  padding: 0px;
}

h1 {
  font-family: 'Lato', sans-serif;
  letter-spacing: 2px;
  font-size:48px;
}

.header {
  position:relative;
  text-align:left;
  background: linear-gradient(60deg, rgba(84,58,183,1) 0%, rgba(0,172,193,1) 100%);
  /*color:white;*/
}

.inner-header {
  width:100%;
  height:20%;
  margin: 0;
  padding: 0;
}

.flex { /*Flexbox for containers*/
  display: flex;
  justify-content: left;
  align-items: left;
  text-align: center;
  
}

.waves {
  position:relative;
  width: 100%;
  height:20vw;
  margin-bottom:0; /*Fix for safari gap*/
  min-height:100px;
  max-height:200px;
}

.content {
  position:relative;
  height:20rem;
  text-align:center;
}

/* Animation */

.parallax > use {
  animation: move-forever 25s cubic-bezier(.55,.5,.45,.5)     infinite;
}
.parallax > use:nth-child(1) {
  animation-delay: -2s;
  animation-duration: 7s;
}
.parallax > use:nth-child(2) {
  animation-delay: -3s;
  animation-duration: 10s;
}
.parallax > use:nth-child(3) {
  animation-delay: -4s;
  animation-duration: 13s;
}
.parallax > use:nth-child(4) {
  animation-delay: -5s;
  animation-duration: 20s;
}
@keyframes move-forever {
  0% {
   transform: translate3d(-90px,0,0);
  }
  100% { 
    transform: translate3d(85px,0,0);
  }
}
@media(min-width: 100vw){
  .header{
    width: 100vw;
    left: 50%;
    transform: translateX(-50%);
  }
}
</style>