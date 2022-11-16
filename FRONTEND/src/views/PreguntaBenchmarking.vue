<template>
<div>
    <div class="header">
    <img alt="Vue logo" src="../assets/escudoPUJ.png" width="20%" height="25%" left/>
    <header>Benchmarking</header>
    </div>
    <form>
        <div class="form-group">
          <label for="exampleInputEmail1">#1 ¿El personal encargado en esta área de la organización realiza inversiones financieras a largo plazo?</label>
          <input type="answer" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <div class="form-group">
          <label for="exampleInputPassword1">#2 ¿El personal encargado en esta área de la organización, invierte en la retención de talento humano?  </label>
          <input type="answer" class="form-control" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>

</div>     
</template>
<script>

</script>
<style scoped>
.label {
  display: inline-block;
  margin-bottom: .5rem;
}
*, ::after, ::before {
  box-sizing: border-box;
}
.form-group {
  font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans","Liberation Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #212529;
  text-align: left;
  margin-left: 50px;
  margin-top: 50px;
}
.form-control{
    width: 60px;
    margin-left: 60;
}

.header {
  padding: 60px;
  text-align: center;
  background: #1548A8;;
  color: white;
  font-size: 30px;
}
</style>