<template>
    <b-container>  
         <div>
            <sidebar-menu-akahon 
            />
          </div> 
      <b-row>
        <b-col>
          <p>
          <br>
          <br>
            <h2>Diagnóstico de madurez</h2>
          </p>
          <br>
          <h3>Favor responder</h3>
          <br>
          <br>

          <div>
            <li v-for='item in dg'>
            <h4>{{ item.pregunta }}</h4>
                <template v-if="item.automatica == true">
                <div v-for="item2 of item.rub" :key="item2.rubrica " class="container" >
                    
                    <label
                        class="label"
                    >
                        <input
                        type="radio"
                        :name="item.codigo"
                        :value="item2.cuanti"
                        v-model="item.codigo"
                        />
                    </label>
                    {{ item2.rubrica  }}
                <i :ref="actualizaCod(item2.codigoP)"/>
                </div>
                <i :ref="actualiza(item.codigo)"/>
                </template>
                <template v-if="item.automatica == false">
                    <b-form inline>
                        <b-form-textarea
                        id="textarea"
                        v-model="item.var"
                        placeholder="Ingrese su respuesta..."
                        rows="3"
                        max-rows="6"
                        ></b-form-textarea>
                    </b-form>
                <i :ref="actualizaCodTex(item.var,item.codigo)"/>
                </template>
            </li>
           
            </div>
            <button type="submit" class="btn btn-dark btn-lg btn-block" @click="enviar(dgR)">
            Enviar</button>
        </b-col>
      </b-row>
    </b-container>   
</template>
  
<script>
import SidebarMenuAkahon from "@/components/SideBarCoord.vue"
import dgvService from "@/service/diagnosticoService";
import AuthService from "@/service/auth.service"

export default {
//name: 'estudiantesCord2',
    props: {
        msg: String
    },
        components: {
        SidebarMenuAkahon,
    },
    data() {
        return{
            dg:[ {
                id: null,
                codigo: null,
                pregunta: null,
                insump: null,
                automatica: null,
                rub: []
            } ], 
            form:{
                puntajeN:null,
                puntajeS:null,
                codigo:null
            }           
        };
    },
    dgR: [{}],
    codigoAc:null,
    dgvService: null,
    created() {
        this.dgvService = new dgvService();
        this.dgR= [{}];
        this.getAll();
    },
    methods: {
        getAll() {
        this.dgvService.getAllDgv().then(data => {
            this.dg = data.data;
            console.log("gj-----");
            console.log("key-----",typeof data.headers);
        });
        console.log("gj-----");
        },
        print() {
            console.log("DATOS-----",this.dg.codigo);
            console.log("DATOS-----",this.dg.rub);
        },
        actualiza(cuanti) {
            if(cuanti != undefined && cuanti >0){
                console.log("VALOR-----",cuanti,"codigo",this.codigoAc);
                this.getVal(cuanti);
                
            }
        },
        enviar() {

            for(let i=0; i<this.dgR.length; i++) {
                console.log("Enviando ",this.dgR[i].valorN,this.dgR[i].codigoP)
            
            try {
                this.dgvService.save(this.dgR[i]
                ,AuthService.getCorreo())
                .then(function(response) {
                        console.log(response.data);
                    }).catch(function(error) {
                        console.log(error);
                    });
            } catch (error) {
            console.log(error);
            }
        }
        },
        print(vard,valo){
            console.log("imprime cod",vard,"--",valo);
        },
        getVal(cuanti){           
            let valida="false";
            if(this.dgR == null){
                let aux={valorN:cuanti,codigoP:this.codigoAc}
                this.dgR.push(aux) 
            }
            for(let i=0; i<this.dgR.length; i++) {
                 if(this.dgR[i].codigoP === this.codigoAc){
                    this.dgR[i].valorN=cuanti
                    this.dgR[i].codigoP=this.codigoAc
                    valida="true";
                    console.log(`Actualiza ${i} is ${this.dgR[i].codigoP}`,"val ",this.dgR[i].valorN);              
                    console.log("encontredo",valida)
                    break;
                }
            }
            if(valida == "false"){
                console.log("debe agregar")
                let aux={valorN:cuanti,codigoP:this.codigoAc}
                this.dgR.push(aux)               
            }
        },
        actualizaCod(code){
            this.codigoAc=code;
            console.log("codigo actual",this.codigoAc)
        },
        actualizaCodTex(text,code){
            this.codigoAc=code;
            //console.log("codigo actual",this.codigoAc," con texto",text)

            let valida="false";
            if(this.dgR == null){
                let aux={codigoP:code,valorS:text}
                this.dgR.push(aux) 
            }
            for(let i=0; i<this.dgR.length; i++) {
                 if(this.dgR[i].codigoP === code){
                    this.dgR[i].valorS=text
                    this.dgR[i].codigoP=code
                    valida="true";
                    console.log(`Actualiza ${i} is ${this.dgR[i].codigoP}`,"val ",this.dgR[i].valorS);              
                    console.log("encontredo",valida)
                    break;
                }
            }
            if(valida == "false"){
                console.log("debe agregar")
                let aux={valorS:text,codigoP:code}
                this.dgR.push(aux)               
            }
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
li{
display: block;
margin: 25px 10px;
text-align: left;
}
.form-inline .form-control {
    display: inline-block;
    width: 63%;
    vertical-align: middle;
}
.btn-block {
    display: block;
    width: 30%;
    margin-left: 20%;
}
.btn:not(:disabled):not(.disabled) {
    margin-top: 80px;
    cursor: pointer;
    margin-bottom: 100px;
}
</style>
