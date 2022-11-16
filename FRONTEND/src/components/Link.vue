<template>
    <g class="link" v-if="shouldRender">
      <path :d="path" class="link-ghost"/>
      <path :d="path" class="link-path"/>
    </g>
  </template>
  
  <script>
  export default {
    name: "Link",
    props: {
      item: Object
    },
    computed: {
      shouldRender() {
        return this.item && this.item.fromNode && this.item.toNode;
      },
      path() {
        const { fromNode, toNode } = this.item;
        const [startX, startY] = this.round(fromNode);
        const [endX, endY] = this.round(toNode);
        const start = `${startX}, ${startY}`;
        const end = `${endX}, ${endY}`;
        const ctrl = `${endX}, ${startY}`;
        return `M ${start} Q ${ctrl}, ${end}`;
      }
    },
    methods: {
      round(node) {
        return [
          Math.floor(node.x + node.width / 2),
          Math.floor(node.y + node.height / 2)
        ];
      }
    }
  };
  </script>
  
  <style scoped>
  .link {
    pointer-events: stroke;
  }
  .link-path {
    stroke: #dae1e7;
    stroke-width: 0.25rem;
    pointer-events: stroke;
    fill: transparent;
    cursor: pointer;
    user-select: none;
  }
  .link-ghost {
    pointer-events: stroke;
    stroke: transparent;
    stroke-width: 1.2rem;
    fill: transparent;
    cursor: pointer;
  }
  </style>
  