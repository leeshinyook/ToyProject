<template>
  <div class="container">
    <div class="title">
      <h1>Board</h1>
    </div>
    <div v-if="!write_board">
      <b-table striped hover :items="boardList"></b-table>
    </div>
    <div>
      <b-button v-if="!write_board" @click="writeBoard"
        >Write Comment!</b-button
      >
    </div>
    <!-- end of BoardList -->
    <div v-if="write_board">
      <div>
        <b-form-input v-model="board.title" placeholder="Title"></b-form-input>
        <b-form-input
          v-model="board.subTitle"
          placeholder="subTitle"
        ></b-form-input>
        <b-form-group label="Select BoardType">
          <b-form-radio-group
            v-model="board.boardType"
            :options="options"
            plain
            name="plain-inline"
          ></b-form-radio-group>
        </b-form-group>
        <b-form-textarea
          id="textarea-state"
          v-model="board.content"
          :state="board.content.length >= 10"
          placeholder="Enter at least 10 characters"
          rows="3"
        ></b-form-textarea>
        <b-button @click="write">Write!</b-button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  created() {
    axios
      .get("api/boards")
      .then(res => {
        res.data.forEach(board => {
          delete board.id;
          delete board.content;
          delete board.boardType;
          this.boardList.push(board);
        });
      })
      .catch(err => {
        console.error(err);
      });
  },
  data() {
    return {
      boardList: [],
      options: [
        { text: "Free", value: "free" },
        { text: "Notice", value: "notice" }
      ],
      write_board: false,
      board: {
        title: "",
        subTitle: "",
        content: "",
        boardType: "free"
      }
    };
  },
  methods: {
    writeBoard() {
      console.log("click!");
      this.write_board = true;
    }, // 게시판 글 쓰기
    write() {
      axios
        .post("/api/boards", this.board)
        .then(() => {
          location.reload();
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
  width: 1200px;
}
</style>
