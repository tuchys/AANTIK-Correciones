<template>

    <div class="node" ref="node" :style="computedStyle">
     <template v-if="clientes.nombre != ''">
      {{texto}}
      <b-table  sticky-header striped hover :items="clientes" :fields="fields" head-variant="light">    
      </b-table>
      </template>
      <template v-if="clientes.nombre == ''">
        <br>
       <b> {{texto}}</b>
      </template>
    </div>
  </template>
  
<script>
  //import { addEvent } from "../utils";
import { string } from 'yup';

  
  export default {
    props: {
      x: Number,
      y: Number,
      width: Number,
      height: Number,
      parent: Object,
      texto: String,
      clientes:Array[ {nombre: String,
                 producto: String,contacto: String}]
    },
    data() {
      return {
        dragging: false,
        initialX: 0,
        initialY: 0,
        offsetX: 0,
        offsetY: 0,
        textot:null,
        cliente: [
          {nombret: null, producto: null,contacto: null}],
        items: [
          { nombre: 'America solidaria ', producto: 'Macdonald', contacto: '10/10/22'},
          { nombre: 'Apoyo', producto: 'Macdonald', contacto: '10/10/22' },
          { nombre: 'notica', producto: 'Macdonald', contacto: '01/10/22' }
        ],
        fields: [
          { key: "nombre" ,label:"Entidad"},
          { key: "producto" },
          { key: "contacto" }
        ]
      };
    },
    computed: {
      computedStyle() {
        return {
          left: `${this.initialX}px`,
          top: `${this.initialY}px`,
          width: `${this.width}px`,
          height: `${this.height}px`,
        };
      }
    },
    created() {
      this.initialX = this.x;
      this.initialY = this.y;
    },
    mounted() {
      const nodeEl = this.$refs.node;
   //   this.cancelDragStart = addEvent(nodeEl, "mousedown", this.onDragStart);
     // this.cancelDragEnd = addEvent(nodeEl, "mouseup", this.onDragEnd);
      //this.cancelDragging = addEvent(nodeEl, "mousemove", this.onDragging);
      // this.cancelLeave = addEvent(nodeEl, "mouseleave", this.onLeave);
    },
    beforeDestroy() {
      // const nodeEl = this.refs.node
      this.cancelDragStart && this.cancelDragStart();
      this.cancelDragEnd && this.cancelDragEnd();
      this.cancelDragging && this.cancelDragging();
    },
    methods: {
      onLeave() {
        if (this.dragging) {
          this.dragging = false;
        }
      },
      onDragStart(ev) {
        if (this.dragging) {
          return;
        }
        this.dragging = true;
        this.offsetX = ev.offsetX;
        this.offsetY = ev.offsetY;
      },
      onDragging(ev) {
        if (!this.dragging) {
          return;
        }
        const movementX = ev.offsetX - this.offsetX;
        const movementY = ev.offsetY - this.offsetY;
        this.initialX = this.initialX + movementX;
        this.initialY = this.initialY + movementY;
        this.textot = this.textot + ev.textot;
        this.cliente = this.cliente + ev.cliente;
        this.$emit("update:x", this.initialX);
        this.$emit("update:y", this.initialY);
        console.log('texto'+ev.texto)
      },
      onDragEnd(ev) {
        if (ev.stopPropagation) {
          ev.stopPropagation();
        }
        if (ev.preventDefault) {
          ev.preventDefault();
        }
        if (!this.dragging) {
          return;
        }
        this.dragging = false;
        this.offsetX = 0;
        this.offsetY = 0;
      }
    }
  };
  </script>
  
  <style lang='css' scoped>
  .node {
    position: absolute;
    background: #fff;
    border: 3px solid  #2C5698;
    font: italic;
  }
  </style>