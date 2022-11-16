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
      <form @submit.prevent="handleSubmit">
        <header class="headerse">Restabelecer contraseña</header>
        <div class="form-group">
          <label for="username">Contraseña:</label>
          <input v-validate="'required'" type="password" class="form-control" v-model="password" placeholder="Contraseña"/>
          <div
            v-if="errors.has('password')"
            class="alert alert-danger"
            role="alert"
          >Contraseña es requerida!</div>
        </div>
        <div class="form-group">
          <label for="username">Confirmar contraseña:</label>
          <input v-validate="'required'" type="password" class="form-control" v-model="passwordConfirm" placeholder="Confirmar contraseña"/>
          <div
            v-if="errors.has('password')"
            class="alert alert-danger"
            role="alert"
          >Contraseña es requerida!</div>
        </div>
        <div v-if="this.password != this.passwordConfirm" class="alert alert-danger" role="alert" >Contraseñas no son exactas!</div>
        <div class="form-group">
          <button class="btn btn-primary btn-block" :disabled="loading" margin="10px">
            <span v-show="loading" class="spinner-border spinner-border-sm"></span>
            <span>Enviar</span>
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
import axios from "axios";
export default {
    name: 'Restabelecer',
    data(){
        return {
        password:"",
        passwordConfirm:"",
        message:"",
        loading: false,
        }
    },
    methods:{
       async handleSubmit(){
        this.loading = true;
        const response = await axios.post("http://localhost:8080/user/reset",{
            password: this.password,
            passwordConfirm: this.passwordConfirm,
            token: this.$route.params.token
        }).then((data)=>{
          this.message = data.data.message;
          this.loading = false;
         },
         error => {
              this.loading = false;
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
            })
        console.log(response)
        this.$router.push('/login2');
        }
    }
}

</script>
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
  margin: 0 auto 3px;
  display: inside;
  object-fit: scale-down;
  -moz-border-radius: 60%;
  -webkit-border-radius: 80%;
  border-radius: 80%;
}
.headerse{
    text-align: center;
    font-size: 20px;
    padding: 10px;
    
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

</style>
