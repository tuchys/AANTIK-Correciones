<template>
  <div>
    <b-editable-table striped hoverw
      bordered
      class="editable-table"
      v-model="users"
      :fields="fields"
      @input-change="handleInput"
    >
      <template #cell(isActive)="data">
        <span v-if="data.value">Yes</span>
        <span v-else>No</span>
      </template>
      <template #cell(Editar)="row">
              <router-link to="/preEdit">
              <b-button class="mr-2">Editar
              </b-button></router-link>
            </template>
    </b-editable-table>
    <pre>
      {{ users }}
    </pre>
  </div>
</template>

<script>
import BEditableTable from "bootstrap-vue-editable-table";
import axios from "axios";
export default {
  components: {
    BEditableTable,
  },
  data() {
    return {
      users: {

id: null,

nombre: null,

Delete: null,


} ,
      fields: [
        {
          key: "id",
          label: "Id",
          type: "text",
          editable: true,
          placeholder: "Enter ID",
          class: "id",
        },
        {
          key: "nombre",
          label: "Nombre",
          type: "text",
          editable: true,
          placeholder: "Enter name...",
          class: "nombre",
        },
        {
          key: "Delete",
          label: "Delete",
          type: "text",
          editable: true,
          placeholder: "Enter name...",
          class: "nombre",
        },
      ],
    };
  },
  mounted() {

axios.get("http://localhost:8080/api/gesStu").then(

(response) => {

this.users= response.data;

}

);
},
  methods: {
    handleInput(value, data) {},
  },
};
</script>

<style>
table.editable-table {
  margin: auto;
}

table.editable-table td {
  vertical-align: middle;
}

.editable-table .data-cell {
  padding: 8px;
  vertical-align: middle;
}

.editable-table .custom-checkbox {
  width: 50px;
}

.name-col {
  width: 120px;
}

.department-col {
  width: 150px;
}

.age-col {
  width: 100px;
}

.date-col {
  width: 200px;
}

.is-active-col {
  width: 100px;
}
</style>