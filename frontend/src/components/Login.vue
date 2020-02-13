<template>
  <div class="container">
    <br>
    <div><h1>LOGIN</h1></div>
    <br>
    <div>
    <b-form-group
      id="fieldset-horizontal"
      label-cols-sm="4"
      label-cols-lg="2"
      description="Let us know your ID"
      label="ID"
      label-for="input-horizontal"
    >
    <b-form-input id="input-horizontal" v-model="user.email"></b-form-input>
    </b-form-group>
    <b-form-group
      id="fieldset-horizontal"
      label-cols-sm="4"
      label-cols-lg="2"
      description="Let us know your password."
      label="Password"
      label-for="input-horizontal"
    >
      <b-form-input id="input-horizontal" type="password" v-model="user.password"></b-form-input>
    </b-form-group>
    </div>
    <div>
      <b-button variant="outline-primary" @click="login" @keyup.enter="login">LOGIN</b-button>
    </div>
    <br>
    <div>
      <b-alert v-if=errMsg show variant="danger">{{errMsg}}</b-alert>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: "Login",
  data() {
    return {
      user: {
        email: '',
        password: '',
        userType: 'user',
      },
      errMsg: ''
    }
  },
  methods: {
    login() {
      axios.post("/api/login", this.user)
      .then((res) => {
        console.log(res)
        
      })
      .catch(err => {
        if(err.response.status === 404) {
          this.errMsg = "아이디와 비밀번호가 일치하지 않습니다!"
        }
        console.error(err)
      })
    }
  }
};
</script>
<style scoped>
.container {
  width: 500px;
}
</style>
