<template>
    <b-container>  
        <div>
          <sidebar-menu-akahon 
          />
        </div> 
    <b-row>
      <b-col>
      <br><br>
      <h3>Crea tu Post</h3>
      <br><br>
      <div>
        <b-form @submit="onSubmit" @reset="onReset">
  
          <b-form-group class="label" id="input-group-1" label="Autor:" label-for="input-1" >     
            <b-form-input
              id="input-1"
              :placeholder="encargado"
              disabled
            ></b-form-input>
          </b-form-group>
  
          <b-form-group class="label" id="input-group-1" label="Contenido:" label-for="input-2">     
            <textarea class="inputArea" v-model="Commenttext" type="text" placeholder=" Que esta en tu mente..." ref="com"></textarea>
          </b-form-group>
          <b-button class="btns" type="submit" variant="primary">Guardar</b-button>
        </b-form>
        <div class="form-group">
          <div v-if="this.responses" class="alert alert-success" role="alert">{{this.responses.message}}</div>
        </div>

        <br>
      </div>
    </b-col>
        <b-col>
          
        </b-col>
      </b-row>
    </b-container>  
  </template>
  
  <script>
  import axios from 'axios';
  import SidebarMenuAkahon from "@/components/SideBarEmpren.vue"
  import AuthService from "@/service/auth.service"
    export default {
      data() {
        return {
          encargado: AuthService.getUser(),
          postBody:null,
          responses:null
        }
      },
      components: {
      SidebarMenuAkahon,
      },
      methods: {
        onSubmit() {
          axios.post("http://localhost:8080/crear",{
            postedby: AuthService.getUser(),
            postBody: this.Commenttext,
          }).then((response)=>{
            this.responses=response.data;
            this.Commenttext="";
          })
          console.log(this.responses)
          
        },
        onReset(event) {
          event.preventDefault()
          // Reset our form values
          this.Commenttext="";
          // Trick to reset/clear native browser form validation state
          this.show = false
          this.$nextTick(() => {
            this.show = true
          })
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
.label{
    text-align: left;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
  .inputArea{
    width: 100%;
    border-radius: 0.25em;
    height: 100px;
  }
  .btns{
    margin-right: 5px;
  }
  .form-group{
    margin-top: 5px;
  }
  </style>
  
  
  