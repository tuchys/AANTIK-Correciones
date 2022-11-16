<template>
    <div class="playground">
      <svg class="links-layer">
        <template v-for="link in fullLinks">
          <Link :key="`${link.from}.${link.to}`" :item="link"></Link>
        </template>
      </svg>
      <template v-for="node in nodes">
        <Node
          :key="node.id"
          :x.sync="node.x"
          :y.sync="node.y"
          :width="node.width"
          :height="node.height"
          :texto="node.texto"
          :clientes="node.clientes"
        ></Node>
      </template>

    </div>
  </template>
  
  <script>
  import Node from "./Node";
  import Link from "./Link";
  //import { addEvent } from "../utils";
  
  export default {
    name: "Playground",
    components: {
      Node,
      Link
    },
    props: {
      nodes: {
        type: Array,
        default() {
          return [];
        }
      },
      links: {
        type: Array,
        default() {
          return [];
        }
      }
    },
    computed: {
      fullLinks() {
        return this.links.map(link => {
          return {
            ...link,
            fromNode: this.findNode(link.from),
            toNode: this.findNode(link.to)
          };
        });
      }
    },
    methods: {
      findNode(id) {
        return this.nodes.find(it => it.id === id);
      }
    }
  };
  </script>
  
  <style scoped>
  .playground {
    margin-top: 50px;
  }
  .links-layer {
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
  }
  </style>
  