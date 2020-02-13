<template>
  <div class="container">
    <div>
      <h1>Registration</h1>
    </div>
    <b-form>
      <b-form-group
        id="input-group-1"
        label="Email address:"
        label-for="input-1"
        description="It's your login ID"
      >
        <b-form-input
          id="input-1"
          v-model="user.email"
          type="email"
          placeholder="Enter email"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Your Name:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="user.name"
          placeholder="Enter name"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Password:" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="user.password"
          type="password"
          placeholder="Enter Password"
        ></b-form-input>
      </b-form-group>
    </b-form>
    <b-button variant="outline-primary" @click="submit">Submit</b-button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      user: {
        name: "",
        email: "",
        password: "",
        userType: "user"
      }
    };
  },
  methods: {
    submit() {
      console.log("click!");
      console.log(this.user);
      axios
        .post("/api/users", this.user)
        .then(res => {
          console.log(res);
          alert("회원가입에 성공했습니다.!");
        })
        .catch(err => {
          console.error(err);
        });
    }
  }
};
</script>

<style scoped>
.container {
  width: 700px;
}
</style>
