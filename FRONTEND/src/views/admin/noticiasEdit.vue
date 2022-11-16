<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap/dist/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet" href="https://unpkg.com/bootstrap-vue@2.21.2/dist/bootstrap-vue.min.css" />
<script src="https://unpkg.com/vue@2.6.2/dist/vue.min.js"></script>
<script src="https://unpkg.com/bootstrap-vue@2.21.2/dist/bootstrap-vue.min.js"></script>



<template>
  <b-container class="bv-example-row">
    <div class="home">
      <img alt="Vue logo" src="@/assets/escudoPUJ.png" width="20%" height="10%" >
  
      <hr width=100% color=#e3b82a  size=50   noshade="noshade">
      <hr width=100%  color=#fff size=50   noshade="noshade">
      <hr width=100%  color=#2C5698  size=50   noshade="noshade">
      <div class="texto">
      <h1><br>Editor de Noticias</h1>
      </div>
    </div>

    <!--<pre class="mt-3 mb-0">{{ items }}</pre>-->

    <div v-for= "(item, index) in items" :key="item"><div>

      <b-card bg-variant="light" border-variant="secondary">
      <template #header>
        <h6 class="mb-0"> </h6>
      </template>
      <h4><b><v-card-title v-text="item.titulo"/></b></h4>
      <b-card-text>
        <h6><b>Fecha:</b></h6> <v-card-text v-text="item.fecha"/><br><br>
        <div>
        <v-card-text v-text="item.noticiaa"/><br><br>
      </div>
        Fuente: <i><v-card-text v-text="item.fuente"/></i>
        </b-card-text>
        
        <b-button @click="notiDelete(item, index, item.id)" variant="primary">Eliminar</b-button>

      <template #footer>
        Estudiante encargado: <v-card-text v-text="item.encargado"/>
      </template>
    </b-card>

    </div>
    <br>
    </div>
     
      <b-col></b-col>
  
  </b-container>
  </template>
  
  <script>

import axios from "axios";
export default {

  name: 'noticias',

  data() {

    
    
    return {
      items: {

        titulo: null,

        noticiaa: null,

        encargado: null,

        fuente: null,

        fecha: null,


} ,

      fields: [
        {
          key: "titulo",
        },
        {
          key: "noticiaa",
        },
        {
          key: "fuente",
        },
        {
          key: "fecha",
        },
        {
          key: "encargado",
        },
        
      ],

        show: true
      }
    },
  mounted() {

axios.get("http://localhost:8080/api/notiEdit").then(

(response) => {

this.items= response.data;
console.log(this.items)
}
);
},
  methods: {

    notiDelete: function (item, index, id){
      this.items.splice(index,1);
      axios.post("http://localhost:8080/api/notiDelete",{
          id         
        });

    },

      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.pregunta = ''


        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },

    handleInput(value, data) {},
  },
};


  
  /*
  export default {
    name: 'noticias',
    props: {
      msg: String
    },
     components: {
    },
    methods: {
      modalId(i) {
      return 'modal' + i;
    },
      search() {
        
      }
    },
    data() {
        return {
          items: [
            { id:'1',
            Titulo: 'Cambios en beneficios tributarios para las empresas con la nueva reforma tributaria', 
            Resumen: 'La Dirección de Impuestos y Aduanas Nacionales DIAN controlaba el registro y seguimiento de las solicitudes de deducción a impuestos determinada en la reforma tributaria del 2016 realizada por el gobierno del expresidente Juan Manuel Santos “Deducción por donaciones a entidades no contribuyentes y entidades sin animo de lucro. Hasta el 30% de renta líquida.” (DIAN,2016) Esto hacía referencia a la posibilidad de deducir el valor de la donación del impuesto a la renta. Es decir, las donaciones disminuían la renta líquida por lo que se pagaba un menor impuesto. “Las donaciones que se realicen a las ESAL pertenecientes al régimen tributario especial, así como a las entidades señaladas en los artículos 22 y 23 del ET, dan lugar a descuentos en la declaración del impuesto sobre la renta; estos equivalen al 25 % del valor donado en el respectivo año gravable.” (ESAL | Requisitos para solicitar descuento tributario por donaciones, 2019) Por otro lado, el artículo 256 del ET señalaba que las personas que realizan inversiones en proyectos calificados por el Consejo Nacional de Beneficios Tributarios en Ciencia y Tecnología en Innovación –CNBT– como de investigación, desarrollo tecnológico o innovación tendrían derecho a descontar de su impuesto de renta a cargo el 25 % del valor invertido en dicho proyecto en el período gravable en que se realizó la inversión.', 
            Fuente: 'ESAL | Requisitos para solicitar descuento tributario por donaciones. (2019). BFK. Recuperado 7 de septiembre de 2022, de https://bkf.com.co/esal-descuento-tributario-por-donaciones/#:~:text=Las%20donaciones%20que%20se%20realicen,en%20el%20respectivo%20a%C3%B1o%20gravable.', 
            Fecha: '12 agosto 2022', 
            Estudiante: 'Daniel 1',},
            { id:'2',
              Titulo: 'El Ministerio TIC abre nuevas inscripciones para que familias de estrato 1 y 2 accedan al Internet fijo del programa Hogares Conectados', 
            Resumen: 'El Ministerio de Tecnologías de la Información y las Comunicaciones (MinTIC), en su compromiso de poner la conectividad al alcance de todos los colombianos. El 23 de septiembre de 2022 publica el formulario de preinscripción. El propósito es que familias de estrato 1 y 2, de 21 departamentos, puedan acceder al beneficio de Internet fijo a bajo costo del programa Hogares Conectados. En total, serán 72.000 nuevos hogares de bajos recursos los que se beneficiarán con conectividad hasta el próximo 31 de diciembre de 2022. Las conexiones que se llevarán a cabo hasta el próximo mes de noviembre, estarán a cargo del operador Claro, a través del programa Hogares Conectados brindando servicio de Internet fijo con tarifas sociales, $8.613 para estrato 1, y de $19.074 para estrato 2. Entre los requisitos para poder acceder al beneficio están, vivir en estrato 1, y no haber tenido el servicio de Internet fijo en, por lo menos, los últimos seis meses. Los interesados, podrán preinscribirse diligenciando el formulario en el siguiente link, el cual estará vigente hasta el próximo mes de noviembre de 2022: https://bit.ly/3Uyzyhv', 
            Fuente: ' (El Ministerio TIC Abre Nuevas Inscripciones Para Que Familias de Estrato 1 y 2 Accedan al Internet Fijo Del Programa Hogares Conectados, n.d.) ', 
            Fecha: '23 de septiembre de 2022', 
            Estudiante: 'Daniel 2',},
            { id:'3',
              Titulo: 'Personas con discapacidad no pagarían peajes', 
            Resumen: 'La noticia nos habla de un beneficio para las personas con discapacidades al no tener que pagar peajes. Esto es debido al grupo de congresistas del partido comunes ya que presentaron un proyecto de ley con este fin. El proyecto busca eximir de las leyes 105/93 a las personas con discapacidades. Lo anterior permitiendo el costo del peaje gratis en todo el territorio nacional, contando con los entes a cargo del Estado, entes privados o los concesionados. (Jurídico, 2022) El proyecto cuenta con dos especificaciones de grupos poblacionales que pueden acceder a este beneficio. El primero siendo las personas que sea dueñas de un vehículo automotor que este adaptado especialmente para ellos y las personas sin discapacidades propietarias de un vehículo y estén a cargo o respondan económicamente por una o varias personas con discapacidad. Solo se debe registrar un vehículo ante el ministerio de trasporte el cual será único permitido para acceder al beneficio y deberá estar libre de multas y al día en el pago de impuestos. Por último, cabe recalcar que quienes estén a cargo de una persona con discapacidades pueden acceder al beneficio solo si se encuentra presente el segundo mencionado. (Jurídico, 2022)', 
            Fuente: 'Pagina web ámbito jurídico', 
            Fecha: '23/09/2022', 
            Estudiante: 'Daniel 3',},
           ]
        }      
    }
  }*/
  </script>
  
  <style scoped>
  
    hr {
      height: 25px;
      margin-top: 0px;
      margin-bottom: 0px;
    }
    img {
      margin-bottom:35px;
      margin-top:30px;
    }
    p {
      text-align: left;
      margin-top: 5%;
      margin-left: 12%;
      margin-right: 12%;
    }
    b-row.entidad{
      text-align: left;
      color: aqua;
      margin-top: 5%;
      margin-left: 12%;
      margin-right: 12%;
    }
  </style>
    
  