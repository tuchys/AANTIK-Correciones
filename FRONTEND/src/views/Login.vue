<template>
  <b-container padding-right= 0px padding-left="0px">   
    <b-row>
    <b-col>    
    </b-col>
    <b-col>
     <div class="vue-tempalte">
        <img alt="Vue logo" src="../assets/escudoPUJ.png" width="100%" height="25%"/>
        <form>
            <h3 class="titulo">AANTIK</h3>
            <h3>Inicio de sesión</h3>
            <div class="form-group">
                <label>Correo electronico</label>
                <input v-model="persona.username" type="email" class="form-control form-control-lg"/>
            </div>
            <div class="form-group">
                <label>Contraseña</label>
                <input v-model="persona.password" type="password" class="form-control form-control-lg" />
            </div>
            <button type="submit" class="btn btn-dark btn-lg btn-block" @click="save(persona)">
            Ingresar</button>
            <p class="forgot-password text-right mt-2 mb-4">
                <router-link to="/recuperarPassword">Olvidó su contraseña?</router-link>
            </p>
        </form>
    </div>
    </b-col>
    
    <b-col>
    </b-col>
  </b-row>
  <footer>
  <hr width=100%  color=#e3b82a  size=50   noshade="noshade">
  <hr width=100%  color=#fff size=50   noshade="noshade">
  <hr width=100%  color=#2C5698  size=50   noshade="noshade">

  </footer>
  </b-container>
</template>



<script>
import LoginService from "../service/LoginService";
export default {
  name: "CrudApp",
  data() {
    return{
      persona: {
        username: null,
        password: null
      }
    };
  },
  loginService: null,
  created() {
    this.loginService = new LoginService();
  },
  methods: {
    async save() {
      var data = {
        username: this.persona.username,
        password: this.persona.password,

      };
      try {

        let self = this;
        await this.loginService.save(this.persona)
        .then(function(response) {
          console.log(response.data);
          if (response.data==1)
          self.$router.push({name:'studentHome' })
          if (response.data==2)
          self.$router.push({name:'adminHome' })
          if (response.data==3)
          self.$router.push({name:'orgSocHome' })
          if (response.data==4)
          self.$router.push({name:'HomeEmp' })
          if (response.data==5)
          self.$router.push({name:'CoordHome' })
          if (response.data==6)
          self.$router.push({name:'HomeDoc' })
          if (response.data==7)
          self.$router.push({name:'preinscHome' })
        }).catch(function(error) {
          console.log(error);
        });

        //.then(response => this.$router.push("/about"))
        //.catch(error => this.$router.push("/login"));
      } catch (error) {
        console.log(error);
      }
    },
      print() {
        console.log("Esto es un método"+this.persona.email);
      }
  }  
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
hr {
  height: 25px;
  margin-top: 0px;
  margin-bottom: 0px;
}
.container, .container-sm {
  max-width: 100%;
}
.row {
    display: flex;
    flex-wrap: wrap;
    margin-right: 15%;
    margin-left: 15%;
}
.container, .container-fluid, .container-sm, .container-md, .container-lg, .container-xl {
    padding-top: 35px;
}
footer {
      position: absolute;
      bottom: 0;
      width: 98%;
      height: 80px;
      color: white;
  }
.titulo{
  font-family: times;
  color: #2C5698 ;
  font-style: bold;
  font-size: 30pt;
}
.btn-block {
    display: block;
    width: 30%;
}
.btn{
    cursor: pointer;
    margin-bottom: 50px;
    margin-top: 20px;    
    margin-left: 20%;
}
</style>
